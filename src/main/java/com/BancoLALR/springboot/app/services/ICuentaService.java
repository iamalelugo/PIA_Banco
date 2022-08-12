package com.BancoLALR.springboot.app.services;

import java.util.List;

import com.BancoLALR.springboot.app.entity.Cuenta;

public interface ICuentaService {
	
	public Cuenta getById(Long id, List<Cuenta> lista);
}
