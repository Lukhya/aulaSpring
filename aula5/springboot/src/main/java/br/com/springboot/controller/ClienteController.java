package br.com.springboot.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springboot.bo.ClienteBO;
import br.com.springboot.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteBO clienteBO;
//tema 1	
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("cliente", new Cliente());
		return new ModelAndView("/cliente/formulario", model);
		//para testar formulario sem bootstrap utilizar /cliente/formulario1
	}
//tema2	
	@RequestMapping(value = "", method=RequestMethod.POST)
	public String salva(@ModelAttribute Cliente cliente) {
		
		clienteBO.insere(cliente);
		return "/cliente/formulario";
	//para testar formulario sem bootstrap utilizar /cliente/formulario1
			
	}
//tema 4	
	@RequestMapping(value = "", method=RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("clientes", clienteBO.listaTodos());
		return new ModelAndView("/cliente/lista", model);		
	}
//tema 4	
	@RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
		try {
			model.addAttribute("cliente", clienteBO.pesquisaPeloId(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("/cliente/formulario", model);
	}
//tema 4	
	@RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
	public String inativa(@PathVariable("id") Long id, RedirectAttributes attr) {
		System.out.println(id);
		try {
			Cliente cliente = clienteBO.pesquisaPeloId(id); 
			clienteBO.inativa(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/clientes";
	}
//tema 4	
	@RequestMapping(value = "/ativa/{id}", method = RequestMethod.GET)
	public String ativa(@PathVariable("id") Long id, RedirectAttributes attr) {
		System.out.println(id);
		try {
			Cliente cliente = clienteBO.pesquisaPeloId(id); 
			clienteBO.ativa(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/clientes";
	}
}
