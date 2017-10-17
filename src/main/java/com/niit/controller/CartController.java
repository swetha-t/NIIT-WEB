package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.Product;


@Controller
public class CartController {

	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	

	 @RequestMapping(value="cart",  method=RequestMethod.GET)
	 public String showCartPage(@ModelAttribute("id")Cart cart,Model model){
		 
		model.addAttribute("cart", new Cart());
		System.out.println("Inside Index Mapping");
		return "Cart";
	}
	
    @RequestMapping(value="addToCart/{id}")
    public String addProductToCart(@PathVariable("id") int id, HttpSession session,Model model,RedirectAttributes attributes)
    {
    	int userId = (Integer) session.getAttribute("userid");
    	int q=1;
    	if (cartDAO.getitem(id, userId) != null) {
			Cart item = cartDAO.getitem(id, userId);
			
			item.setProductQuantity(item.getProductQuantity() + q);
			
			Product p = productDAO.getProductById(id);
			
			System.out.println(item);
			item.setProductPrice(p.getPrice());
			item.setSubTotal(item.getProductQuantity() *p.getPrice());
			cartDAO.saveProductToCart(item);
			attributes.addFlashAttribute("ExistingMessage",  p.getName() +"is already exist");
	
			return "redirect:/";
		} else {
			Cart item = new Cart();
			Product p = productDAO.getProductById(id);
			item.setProductid(p.getId());
			item.setProductName(p.getName());
			item.setUserId(userId);
			item.setProductQuantity(q);
			item.setStatus("C");
			item.setSubTotal(q * p.getPrice());
			item.setProductPrice(p.getPrice());
			cartDAO.saveProductToCart(item);
			attributes.addFlashAttribute("SuccessMessage", "Item"+p.getName()+" has been deleted Successfully");
			return "redirect:/";
		}
    	
    }




    @RequestMapping("viewcart")
	public String viewCart(Model model, HttpSession session) {
    	
		//int userId = (Integer) session.getAttribute("userid");
		model.addAttribute("CartList", cartDAO.listCart());
		 if(cartDAO.cartsize((Integer) session.getAttribute("userid"))!=0){
			
			model.addAttribute("CartPrice", cartDAO.CartPrice((Integer) session.getAttribute("userid")));
		} else {
			model.addAttribute("EmptyCart", "true");
		}
		model.addAttribute("IfViewCartClicked", "true");
	//	model.addAttribute("HideOthers", "true");
		return "CartPage";
	}



	@RequestMapping("editCart/{cartid}")
	public String editorder(@PathVariable("cartid") int cartid, @RequestParam("quantity") int q, HttpSession session) {
	
		//int userId = (Integer) session.getAttribute("userid");
		Cart cart = cartDAO.editCartById(cartid);
		Product p = productDAO.getProductById(cart.getProductid());
		cart.setProductQuantity(q);
		//cart.setProductPrice(q * p.getPrice());
		cart.setSubTotal(q * p.getPrice());
		cartDAO.saveProductToCart(cart);
		session.setAttribute("cartsize", cartDAO.cartsize((Integer) session.getAttribute("userid")));
		return "redirect:/viewcart";
	}
    
    
    
    
@RequestMapping(value="removeCart/{id}")
public String deleteorder(@PathVariable("id") int id, HttpSession session) {
	cartDAO.removeCartById(id);
	session.setAttribute("cartsize", cartDAO.cartsize((Integer) session.getAttribute("userid")));
	return "redirect:/viewcart";
}


@RequestMapping("continue_shopping")
public String continueshopping()
{
return "redirect:/";	

}


}
