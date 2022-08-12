package com.BancoLALR.springboot.app.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BancoLALR.springboot.app.dao.ICuentaDao;
import com.BancoLALR.springboot.app.entity.Cuenta;
import com.BancoLALR.springboot.app.repository.CuentaRepository;

@Service
public class CuentaDaoImpl implements ICuentaDao {
	
	@SuppressWarnings("unused")
	@Autowired
	private CuentaRepository tarejetaRepository;
	
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cuenta").getResultList();
	}

	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		
		if(cuenta != null  && cuenta.getId() > 0) {
			em.merge(cuenta);
		}
		else {
			em.persist(cuenta);
		}
	}

	@Override
	public Cuenta findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Cuenta.class, id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
	}
}
