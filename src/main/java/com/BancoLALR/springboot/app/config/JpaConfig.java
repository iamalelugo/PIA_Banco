package com.BancoLALR.springboot.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.BancoLALR.springboot.app.dao.ICuentaDao;
import com.BancoLALR.springboot.app.dao.ITarjetaDao;
import com.BancoLALR.springboot.app.daoimpl.CuentaDaoImpl;
import com.BancoLALR.springboot.app.daoimpl.TarjetaDaoImpl;

@Configuration
@EnableJpaRepositories(basePackages = "com.BancoLALR.springboot.app.repository")
public class JpaConfig {
	
	@Bean("tarjetaDao")
	public ITarjetaDao tarjetaDao() {
		return new TarjetaDaoImpl();
	}
	
	@Bean("cuentaDao")
	public ICuentaDao cuentaDao() {
		return new CuentaDaoImpl();
	}
}
