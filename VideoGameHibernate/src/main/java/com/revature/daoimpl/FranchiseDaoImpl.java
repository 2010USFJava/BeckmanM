package com.revature.daoimpl;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.revature.dao.FranchiseDao;
import com.revature.models.Franchise;
import com.revature.util.HibernateUtil;

public class FranchiseDaoImpl implements FranchiseDao{

	public List<Franchise> findAll() {
		Session s = HibernateUtil.getSesstion();
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Franchise> query = builder.createQuery(Franchise.class);
		
		Root<Franchise> root = query.from(Franchise.class);
		
		query.select(root);	
		
		return  s.createQuery(query).getResultList();
	}

	public Franchise findById(int id) {
		Session s = HibernateUtil.getSesstion();

		return s.get(Franchise.class, id);
	}

	public Franchise findByName(String name) {
		Session s = HibernateUtil.getSesstion();
		
		return s.get(Franchise.class, name);
	}

	public Franchise findByConsole(String console) {
		Session s = HibernateUtil.getSesstion();
		
		return s.get(Franchise.class, console);
	}

	public void insert(Franchise franny) {
		Session s = HibernateUtil.getSesstion();
		s.save(franny);
		
	}

	public void update(Franchise franny) {
		Session s = HibernateUtil.getSesstion();
		s.merge(franny);
	}

	public void delete(Franchise franny) {
		Session s = HibernateUtil.getSesstion();
		s.delete(franny);
	}

}
