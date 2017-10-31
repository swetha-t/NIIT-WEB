package com.backend.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.DAO.CardDAO;
import com.backend.DAO.CartDAO;
import com.backend.DAO.CheckDAO;
import com.backend.DAO.OrderDAO;
import com.backend.DAO.UserDAO;
import com.backend.model.Card;
import com.backend.model.User;

@Controller
public class CheckoutController {
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	CheckDAO checkDAO;
	
	@Autowired
	CardDAO cardDAO;
	 
	User user;
	
	@RequestMapping("CheckOut")
	public String CheckoutPage(@ModelAttribute("card")Card card,Model model)
	{
		//model.addAttribute("total", checkOutDAO.getTotal(userid));
		return "CheckOut";	
	}
	
	
	@RequestMapping(value="/invoice",method=RequestMethod.POST)
	public String InvoicePage(@ModelAttribute ("card") Card card, HttpSession session, Model model)
	{
		int charges=99;
		int userid = (Integer) session.getAttribute("userid");
		cartDAO.getCartById(userid);
		card.setCard_userid(userid);
		cardDAO.saveCard(card);
		orderDAO.OrderDetails();
		
	   	
		model.addAttribute("user", userDAO.getUserById(userid));
    	model.addAttribute("cd", cartDAO.getCartById(userid));
     	model.addAttribute("total",checkDAO.getTotal(userid));
		model.addAttribute("cod", charges);
		cartDAO.removeCartById(userid);
		return "/Invoice";
	
	
	}
	
	
	@RequestMapping(value="/CodInvoice",method=RequestMethod.POST)
	public String CodInvoicePage(@ModelAttribute ("card") Card card,HttpSession session, Model model)
	{
		int charges=99;	
    /* int userid = (Integer) session.getAttribute("userid");*/
		int userid=user.getId();
		cartDAO.getCartById(userid);
		orderDAO.OrderDetails();
	
		model.addAttribute("user", userDAO.getUserById(userid));
    	model.addAttribute("cd", cartDAO.getCartById(userid));
    	model.addAttribute("total",checkDAO.getTotal(userid));
   
		model.addAttribute("cod", charges);
		cartDAO.removeCartById(userid);
		return "Invoice";
	
	
	}

}