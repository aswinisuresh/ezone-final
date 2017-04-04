/*package com.niit.ezone.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ezone.dao.CartDAO;
import com.niit.ezone.dao.ProductDAO;
import com.niit.ezone.model.MyCart;
import com.niit.ezone.model.Product;



@Controller
public class CartController {
	
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private MyCart myCart;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model) {
		
		model.addAttribute("myCart", new MyCart());
		// get the logged-in user id
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");

		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)   auth.getAuthorities();
			authorities.contains("ROLE_USER");
			
		}

		int cartSize = cartDAO.list(loggedInUserid).size();

		if (cartSize == 0) {
			model.addAttribute("errorMessage", "You do not have any products in your Cart");
		} else {
			model.addAttribute("cartList", cartDAO.list(loggedInUserid));
			model.addAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUserid));
			model.addAttribute("displayCart", "true");

		}
		
		return "/home";
	}

	// For add and update myCart both
	@RequestMapping(value = "/myCart/add/{id}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("id") String id) {
		
		// get the product based on product id
		Product product = productDAO.get(id);
		myCart.setPrice(product.getPrice());
		myCart.setProductName(product.getName());
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
		}
		myCart.setId(loggedInId);
		myCart.setStatus('N'); 		

		
		cartDAO.save(myCart);
		
		ModelAndView mv = new ModelAndView("redirect:/home");
		mv.addObject("successMessage", " Successfuly add the product to myCart");
		
		return mv;

	}

	
}
*/