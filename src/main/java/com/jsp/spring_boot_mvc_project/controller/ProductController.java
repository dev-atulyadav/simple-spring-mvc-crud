package com.jsp.spring_boot_mvc_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_boot_mvc_project.dao.ProductDao;
import com.jsp.spring_boot_mvc_project.dto.Product;

/**
 * @author Atul
 */
@Controller
public class ProductController {

	@Autowired
	private ProductDao dao;
	
	@RequestMapping(value = "/")
	public ModelAndView getDate() {
		ModelAndView andView = new ModelAndView("product-register.jsp");
		andView.addObject("product", new Product());
		return andView;
	}
	@RequestMapping(value = "/registerProduct")
	public ModelAndView saveProductController(Product product) {
		dao.saveProductDao(product);
		return new ModelAndView("/");
	}
	@RequestMapping(value = "/getAllProduct")
	public ModelAndView getAllProductController() {
		List<Product> products = dao.getAllProduct();
		return new ModelAndView("display.jsp").addObject("products", products);
	}
	@RequestMapping(value = "/getProduct")
	public ModelAndView getProductById(int id) {
		Product product = dao.updateProductById(dao.getProdutById(id));
		return new ModelAndView("update.jsp").addObject(product);
	}
	@RequestMapping(value = "/update")
	public ModelAndView updateProductById(Product product) {
		dao.updateProductById(product);
		return new ModelAndView("/getAllProduct");
	}
	@RequestMapping(value = "/delete")
	public ModelAndView deleteProductById(int id) {
		dao.deleteProductById(id);
		return new ModelAndView("/getAllProduct");
	}
}
