package com.BancoLALR.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BancoLALR.springboot.app.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta,Serializable> {

}
