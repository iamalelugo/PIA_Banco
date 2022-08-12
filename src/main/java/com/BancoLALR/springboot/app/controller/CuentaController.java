package com.BancoLALR.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.BancoLALR.springboot.app.dao.ICuentaDao;
import com.BancoLALR.springboot.app.entity.Cuenta;
import com.BancoLALR.springboot.app.repository.CuentaRepository;

public class CuentaController {
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@SuppressWarnings("unused")
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@GetMapping
	@RequestMapping (value = "/lista-cuentas", method = RequestMethod.GET)
	public String TarjetaLista (Model model) {
		
		model.addAttribute("titulo", "lista de cuentas");
		model.addAttribute("cuentas", cuentaDao.findAll());
		return "lista-cuentas";	
	}
	
	@RequestMapping(value ="/formcuenta")
	public String crear (Map<String, Object> model) {
		Cuenta cuenta = new Cuenta();
		model.put("cuenta", cuenta);
		model.put("titulo", "Llenar los datos de la cuenta");
		return "formcuenta";
		}
	
	@RequestMapping (value = "/formcuenta/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String,Object> model) {
		Cuenta cuenta = null;
		
		if(id>0) {
			cuenta = cuentaDao.findOne(id);
		}
		
		else {
			return "redirect:/index";
		}
		
		model.put("cuenta", cuenta);
		model.put("titulo", "Editar cuenta");
		
		return  "formcuenta";
	}
	
	@RequestMapping (value = "/formcuenta", method = RequestMethod.POST)
	public String save(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de cuenta");
			return "formcuenta";
		}
		
		cuentaDao.save(cuenta);
		status.setComplete();
		
		return "redirect:index";
	}
	
	@RequestMapping (value = "/eliminar/{id}")
	public String delete(@PathVariable (value = "id") Long id, Map<String, Object> model) {
		
		if(id > 0)
			cuentaDao.delete(id);
		
		return "redirect:index";	
	}
}
