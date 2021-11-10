package com.example.lucas.bookShelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.lucas.bookShelf.models.Books;
import com.example.lucas.bookShelf.models.Client;
import com.example.lucas.bookShelf.repositories.BookRepository;

@Controller
//@RequestMapping("/")
public class BookController {
	
	@Autowired
	private BookRepository br;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/addBooks")
	public String addBooks() {
		return "books/addBooks";
	}
	
	@RequestMapping(value = "/addBooks", method = RequestMethod.POST)
	public String addBooksSave(Books books, BindingResult result, RedirectAttributes attributes) {
		  if (result.hasErrors()) {
	            attributes.addFlashAttribute("message", "Verifique os campos!");
	            return "redirect:/addBooks";
	        }

	        br.save(books);
	        attributes.addFlashAttribute("message", "Verifique os campos!");
	        return "redirect:/addBooks";
	    }
	
	@RequestMapping("/addBooks2")
    public ModelAndView listBooks() {
        ModelAndView mv = new ModelAndView("index.html");
        Iterable<Books> books = br.findAll();
        mv.addObject("books", books);
        return mv;
    }
	/*
    public ModelAndView listBooks() {
        ModelAndView mv = new ModelAndView("index.html");
        Iterable<Books> books = br.findAll();
        mv.addObject("books", books);
        return mv;
    } 
    */   
}
