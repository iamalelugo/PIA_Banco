package com.BancoLALR.springboot.app.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.BancoLALR.springboot.app.dao.ITarjetaDao;
import com.BancoLALR.springboot.app.entity.Tarjeta;
import com.BancoLALR.springboot.app.repository.TarjetaRepository;

public class TarjetaDaoImpl implements ITarjetaDao {
	
	@SuppressWarnings("unused")
	@Autowired
	private TarjetaRepository tarejetaRepository;
	
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional (readOnly = true)
	public List<Tarjeta> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Tarjera").getResultList();
	}

	@Override
	@Transactional
	public void save(Tarjeta tarjeta) {
		
		if(tarjeta != null && tarjeta.getId()>0) {
			em.merge(tarjeta);
		}
		else
			em.persist(tarjeta);
	}

	@Override
	public Tarjeta findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Tarjeta.class, id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
	}

}


