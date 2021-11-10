package com.example.lucas.bookShelf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.lucas.bookShelf.models.Client;
import com.example.lucas.bookShelf.repositories.ClientRepository;

@Controller
public class ClientController {
	
	@Autowired
	ClientRepository cr;
	
	@RequestMapping("/clientLogin")
	public String clientLogin(){
		return "clients/clientLogin";
	}
	
	@RequestMapping("/clientRegister")
	public String clientRegister(){
		return "clients/clientRegister";
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(value = "/clientLogin", method = RequestMethod.POST)
	public String login(@Valid Client client, Integer cpf, BindingResult result, RedirectAttributes attributes) {
		  if (result.hasErrors()) {
	            attributes.addFlashAttribute("message", "Verifique os campos!");
	            return "redirect:/clientLogin";
	        }

	        Client client1 = cr.findByCpf(cpf);
	        if (client.getCpf().equals(client1)) {
	        	attributes.addFlashAttribute("message", "Usuário encontrado!");
		       	return "redirect:/clientLogin";
	        } else {
	        	attributes.addFlashAttribute("message", "Usuário não cadastrado!");
	        }
	        return "redirect:/clientLogin";
	    }
	
	@RequestMapping(value = "/registerClient", method = RequestMethod.POST)
	public String register(@Valid Client client, Integer cpf, BindingResult result, RedirectAttributes attributes) {
		  if (result.hasErrors()) {
	            attributes.addFlashAttribute("message", "Verifique os campos!");
	            return "redirect:/registerClient";
	        }
		  
		  if (client.getCpf() ==cpf) {
			  attributes.addFlashAttribute("message", "Cpf já cadastrado");
			  return "redirect:/registerClient";
		  }

	        cr.save(client);
	        attributes.addFlashAttribute("message", "Verifique os campos!");
	        return "redirect:/registerClient";
	    }
/*
	public Integer findCpf(Integer cpf) {
		cr.findByCpf(cpf);
		return cpf;
	}
	*/
}
