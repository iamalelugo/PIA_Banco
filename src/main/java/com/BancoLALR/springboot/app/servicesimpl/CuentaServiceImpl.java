package com.BancoLALR.springboot.app.servicesimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BancoLALR.springboot.app.entity.Cuenta;
import com.BancoLALR.springboot.app.services.ICuentaService;

@Service
public class CuentaServiceImpl implements ICuentaService {
	
	private List<Cuenta> lista;
	
	public CuentaServiceImpl() {
		
	}
	
	@Override
	public Cuenta getById(Long id, List<Cuenta> lista) {
		this.lista = lista;
		Cuenta cuentaResult = null;
		
		for(Cuenta cuenta : this.lista) {
			if(id == cuenta.getId()) {
				cuentaResult = cuenta;
				
			}
			
		}
		return cuentaResult;
	}

}
