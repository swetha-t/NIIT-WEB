package com.backend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.DAO.CardDAO;
import com.backend.DAO.CartDAO;
import com.backend.DAO.OrderDAO;
import com.backend.DAO.UserDAO;
import com.backend.model.Card;
import com.backend.model.Checkout;

public class CheckoutController {
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	Checkout checkOutDAO;
	@Autowired
	CardDAO cardDAO;
	
	@RequestMapping("Checkout")
	public String CheckoutPage(@ModelAttribute("card")Card card,Model model)
	{
		//model.addAttribute("total", checkOutDAO.getTotal(userid));
		return "CheckOut";	
	}

		
	@RequestMapping(value="/invoice",method=RequestMethod.POST)
	public String InvoicePage(@ModelAttribute ("card") Card card, HttpSession session, Model model)
	{
		int charges=99;
		int userId = (Integer) session.getAttribute("userid");
		cartDAO.getCartById(userId);
		card.setCard_userid(userId);
		cardDAO.saveCard(card);
		orderDAO.OrderDetails();
		
	   	
		model.addAttribute("user", userDAO.getUserById(userId));
    	model.addAttribute("cd", cartDAO.getCartById(userId));
     	model.addAttribute("total",checkOutDAO.getTotal(userId));
		model.addAttribute("cod", charges);
		cartDAO.removeCartById(userId);
		return "Invoice";
	
	
	}
	
	
	@RequestMapping(value="/CodInvoice",method=RequestMethod.POST)
	public String CodInvoicePage(@ModelAttribute ("card") Card card,HttpSession session, Model model)
	{
		int charges=99;	
		int userId = (Integer) session.getAttribute("userid");
		cartDAO.getCartById(userId);
		orderDAO.OrderDetails();
	
		model.addAttribute("user", userDAO.getUserById(userId));
    	model.addAttribute("cd", cartDAO.getCartById(userId));
    	model.addAttribute("total",checkOutDAO.getTotal(userId));
   
		model.addAttribute("cod", charges);
		cartDAO.removeCartById(userId);
		return "Invoice";
	
	
	}

}

