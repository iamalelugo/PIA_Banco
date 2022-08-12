package com.BancoLALR.springboot.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BancoLALR.springboot.app.dao.ICuentaDao;
import com.BancoLALR.springboot.app.repository.CuentaRepository;
import com.BancoLALR.springboot.app.services.ICuentaService;

@Component
public class CuentaPropertyEditor extends PropertyEditorSupport {
	
	@Autowired
	private ICuentaService cuentaService;
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@SuppressWarnings("unused")
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Override
	public void setAsText(String idstr) throws IllegalArgumentException {
		try {
			Long id = Long.parseLong(idstr);
			this.setValue(cuentaService.getById(id, cuentaDao.findAll()));
		}
		catch(Exception e){
			System.out.println("Error al asignar un objeto cuenta a la tarjeta");
		}
	}
	
	
}
