package com.BancoLALR.springboot.app.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.BancoLALR.springboot.app.entity.Tarjeta;

@Component
public interface ITarjetaDao {
	
	public List<Tarjeta> findAll();
	
	public void save(Tarjeta tarjeta);
	
	public Tarjeta findOne(Long id);
	
	public void delete(Long id);
	
}
