package com.BancoLALR.springboot.app.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.InitBinder;

import com.BancoLALR.springboot.app.dao.ICuentaDao;
import com.BancoLALR.springboot.app.dao.ITarjetaDao;
import com.BancoLALR.springboot.app.editors.CuentaPropertyEditor;
import com.BancoLALR.springboot.app.entity.Cuenta;
import com.BancoLALR.springboot.app.entity.Tarjeta;
import com.BancoLALR.springboot.app.repository.TarjetaRepository;

@Controller
@RequestMapping ("/tarjeta")
public class TarjetaController {
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@SuppressWarnings("unused")
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@Autowired
	private CuentaPropertyEditor cuentaEditor;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Cuenta.class,"cuenta", cuentaEditor);
	}
	
	@GetMapping
	@RequestMapping (value = "/lista-tarjetas", method = RequestMethod.GET)
	public String TarjetaLista (Model model) {
		
		model.addAttribute("titulo", "lista de tarjetas");
		model.addAttribute("tarjetas", tarjetaDao.findAll());
		return "lista";	
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value ="/formtarjeta")
	public String crear (Map<String, Object> model) {
		Tarjeta tarjeta = new Tarjeta();
		List<Cuenta> listaCuentas = cuentaDao.findAll();
		model.put("tarjeta", tarjeta);
		model.put("titulo", "Llenar los datos de la tarjeta");
		return "formtarjeta";
		}
	
	@RequestMapping (value = "/formtarjeta/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String,Object> model) {
		Tarjeta tarjeta = null;
		
		if(id>0)
			tarjeta = tarjetaDao.findOne(id);
		else
			return "redirect:/index";
		
		model.put("tarjeta", tarjeta);
		model.put("titulo", "Editar tarjeta");
		
		return  "formtarjeta";
	}
	
	@RequestMapping (value = "/formtarjeta", method = RequestMethod.POST)
	public String save(@Valid Tarjeta tarjeta, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Llene correctamente los campos");
			model.addAttribute("result", result.hasErrors());
			model.addAttribute("mensaje", "Error al enviar los datos, favor de escribir correctamente");
			return "formtarjeta";
		}
		else
		{
			model.addAttribute("result", false);
		}
		
		model.addAttribute("titulo", "Formulario de tarjeta");
		model.addAttribute("mensaje", "Se envio correctamenta el mensaje");
		
		try {
			tarjetaDao.save(tarjeta);
		}
		catch (Exception e) {
			e.printStackTrace();
			flash.addFlashAttribute("mensaje", e.getMessage());
		}
		
		status.setComplete();
		
		return "redirect:index";
	}
	
	@RequestMapping (value = "/eliminar/{id}")
	public String delete(@PathVariable (value = "id") Long id, Map<String, Object> model) {
		
		if(id > 0)
			tarjetaDao.delete(id);
		
		return "redirect:index";	
	}
}
