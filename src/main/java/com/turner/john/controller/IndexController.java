package com.turner.john.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.turner.john.beans.Order;
import com.turner.john.beans.Product;
import com.turner.john.beans.User;
import com.turner.john.beans.UserRole;
import com.turner.john.repository.OrderRepository;
import com.turner.john.repository.ProductRepository;
import com.turner.john.repository.UserRepository;
import com.turner.john.repository.UserRoleRepository;

@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserRoleRepository userRoleRepo;
	@Autowired
	private OrderRepository orderRepo;
	
	//Index Mapping
	@GetMapping("")
	public String index(Model model) {
		return "index";
	}

	//Home mapping adding product attributes
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("products", productRepo.findAll());
		return "home";
	}
	
	//Product mapping adding Id number and product attributes
	@GetMapping("/product/{id}")
	public String product(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product_detail";
	}
	//Product edit mapping
	@GetMapping("/product/{id}/edit")
	public String productEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product_edit";
	}
	
	//Product mapping saving the edits that were made
	@PostMapping("/product/{id}/edit")
	public String productEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Product product,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product_edit";
		} else {
			productRepo.save(product);
			return "redirect:/product/" + product.getId();
		}

	}
	//Product mapping allowing the deletion of products if need be
	@GetMapping("/product/{id}/delete")
	public String productDelete(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Product p = productRepo.findOne(id);
		model.addAttribute("product", p);
		return "product_delete";
	}
	//Product mapping saving the deletion of the product
	@PostMapping("/product/{id}/delete")
	public String productDeleteSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Product product,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product_delete";
		} else {
			productRepo.delete(product);
			return "redirect:/home";
		}

	}
	//Product mapping for creating a new product and adding attributes
	@GetMapping("/product/create")
	public String productCreate(Model model) {
		model.addAttribute(new Product());
		return "product_create";
	}
	//Product mapping saving the creation of the new product
	@PostMapping("/product/create")
	public String productCreateSave(@ModelAttribute @Valid Product product,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("product", product);
			return "product_create";
		} else {
			productRepo.save(product);
			return "redirect:/home";
		}

	}
	//User mapping adding attributes
	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "users";
	}
	//User mapping adding ID's and User attributes
	@GetMapping("/user/{id}")
	public String user(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		User u = userRepo.findOne(id);
		model.addAttribute("user", u);
		return "user_detail";
	}
	//User mapping allowing editing of the Users
	@GetMapping("/user/{id}/edit")
	public String userEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		User u = userRepo.findOne(id);
		model.addAttribute("user", u);
		return "user_edit";
	}
	//user mapping saving the edits made to the user
	@PostMapping("/user/{id}/edit")
	public String userEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid User user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "user_edit";
		} else {
			userRepo.save(user);
			return "redirect:/user/" + user.getId();
		}

	}
	//User mapping allowing the deletion of a user
	@GetMapping("/user/{id}/delete")
	public String userDelete(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		User u = userRepo.findOne(id);
		model.addAttribute("user", u);
		return "user_delete";
	}
	//User mapping saving the deletion of the user
	@PostMapping("/user/{id}/delete")
	public String userDeleteSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid User user,
			BindingResult result, Model model) {

			userRepo.delete(user);
			return "redirect:/users";
	}
	//User mapping allowing the creation of a new user and adding their attributes
	@GetMapping("/user/create")
	public String userCreate(Model model) {
		model.addAttribute(new User());
		return "user_create";
	}
	//User mapping saving the creation of a new user
	@PostMapping("/user/create")
	public String userCreateSave(@ModelAttribute @Valid User user,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "user_create";
		} else {
			userRepo.save(user);
			UserRole ur = new UserRole(user.getId());
			userRoleRepo.save(ur);
			return "redirect:/users";
		}

	}
	//Mapping to get to login page
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	//Mapping the sumbission of the login and returning to index
	@PostMapping("/login")
	public String loginSubmit() {
		return "index";
	}
	//Mapping to signup page and adding the attributes to the user
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute(new User());
		return "signup";
	}
	//Mapping saving the new user that was created
	@PostMapping("signup")
	public String signupSave(@ModelAttribute @Valid User user,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "signup";
		} else {
			userRepo.save(user);
			UserRole ur = new UserRole(user.getId());
			userRoleRepo.save(ur);
			return "redirect:/";
		}

	}
	//Order mapping getting the attributes for the order
	@GetMapping("/orders")
	public String orders(Model model) throws SQLException {
		model.addAttribute("orders", orderRepo.findAll());
		return "orders";
	}
	//Order mapping getting the ID and attributes for the order
	@GetMapping("/order/{id}")
	public String order(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Order o = orderRepo.findOne(id);
		model.addAttribute("order", o);
		return "order_detail";
	}
	//Order mapping allowing the editing of the order properties and ID
	@GetMapping("/order/{id}/edit")
	public String orderEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Order o = orderRepo.findOne(id);
		model.addAttribute("order", o);
		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("products", productRepo.findAll());
		return "order_edit";
	}
	//Order mapping saving the edits of the order created
	@PostMapping("/order/{id}/edit")
	public String orderEditSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Order order,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("order", order);
			return "order_edit";
		} else {
			orderRepo.save(order);
			return "redirect:/order/" + order.getId();
		}

	}
	//Product mapping getting the page to delete the order
	@GetMapping("/order/{id}/delete")
	public String orderDelete(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);
		Order o = orderRepo.findOne(id);
		model.addAttribute("order", o);
		return "order_delete";
	}
	//Product mapping saving the deletion of an order
	@PostMapping("/order/{id}/delete")
	public String orderDeleteSave(@PathVariable(name = "id") long id, @ModelAttribute @Valid Order order,
			BindingResult result, Model model) {

			orderRepo.delete(order);
			return "redirect:/orders";
	}
	//Order mapping getting the page to create new orders
	@GetMapping("/order/create")
	public String orderCreate(Model model) {

		model.addAttribute(new Order(new Product(), new User()));
		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("products", productRepo.findAll());
		return "order_create";
	}
	//Order mapping saving the creation of a new order
	@PostMapping("/order/create")
	public String orderCreateSave(@ModelAttribute @Valid Order order,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("order", order);
			return "order_create";
		} else {
			orderRepo.save(order);
			
			return "redirect:/orders";
		}

	}
}