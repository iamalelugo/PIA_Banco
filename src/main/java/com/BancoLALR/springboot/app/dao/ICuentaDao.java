package com.BancoLALR.springboot.app.dao;

import java.util.*;

import org.springframework.stereotype.Component;

import com.BancoLALR.springboot.app.entity.Cuenta;

@Component
public interface ICuentaDao {
	
	public List<Cuenta> findAll();
	
	public void save(Cuenta cuenta);
	
	public Cuenta findOne(Long id);
	
	public void delete(Long id);

}
