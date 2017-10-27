package com.niit.controller;

import java.util.List;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CardDAO;
import com.niit.dao.CartDAO;
import com.niit.dao.CheckOutDAO;
import com.niit.dao.OrderDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Card;



@Controller
public class CheckOutController {

	@Autowired
	CheckOutDAO checkOutDAO;
	
/*	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	MailService mailService;
	*/
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	CardDAO cardDAO;
	
	@RequestMapping("checkOut")
	public String CheckoutPage(@ModelAttribute ("card") Card card,@PathVariable("userid") int userid, Model model){
		model.addAttribute("total", checkOutDAO.getTotal(userid));
		return "payment";
		
	}

		
	@RequestMapping(value="/invoice",method=RequestMethod.POST)
	public String InvoicePage(@ModelAttribute ("card") Card card, HttpSession session, Model model){
		/*if(result.hasErrors()){
			return "CheckOut";
		}
*/		int charges=99;
		int userId = (Integer) session.getAttribute("userid");
		cartDAO.getCartByStatus(userId);
		card.setCard_userid(userId);
		cardDAO.saveCard(card);
		orderDAO.OrderDetails();
		
	   	
		model.addAttribute("user", userDAO.getUserById(userId));
    	model.addAttribute("cd", cartDAO.getCartById(userId));
    	model.addAttribute("total",checkOutDAO.getTotal(userId));
		model.addAttribute("cod", charges);
		cartDAO.deleteCartbyUserId(userId);
		return "invoice";
	
	
	}
	
	@RequestMapping(value="/CodInvoice",method=RequestMethod.POST)
	public String CodInvoicePage(@ModelAttribute ("card") Card card,HttpSession session, Model model){
		int charges=99;
		
		int userId = (Integer) session.getAttribute("userid");
		cartDAO.getCartByStatus(userId);
		/*mailService.sendEmail(userId);*/
	
		orderDAO.OrderDetails();
		
		
		
		model.addAttribute("user", userDAO.getUserById(userId));
    	model.addAttribute("cd", cartDAO.getCartById(userId));
    	/*cart.setGrandTotal(checkOutDAO.getTotal(userId)+"99");
    	*/model.addAttribute("total",checkOutDAO.getTotal(userId));
   
		model.addAttribute("cod", charges);
		cartDAO.deleteCartbyUserId(userId);
		return "invoice";
	
	
	}

	
}