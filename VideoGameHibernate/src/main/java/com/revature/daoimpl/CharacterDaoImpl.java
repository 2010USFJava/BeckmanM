package com.revature.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.dao.CharacterDao;
import com.revature.util.HibernateUtil;

public class CharacterDaoImpl implements CharacterDao {

	public List<Character> findAll() {
		Session s = HibernateUtil.getSesstion();
		Query q = s.createQuery("from characters", Character.class);
		
		return (List<Character>) q.getResultList();
	}

	public Character findById(int id) {
		Session s = HibernateUtil.getSesstion();

		return s.get(Character.class, id);
	}

	public Character findByName(String name) {
		Session s = HibernateUtil.getSesstion();
		Query q = s.createQuery("from characters c where c.charName = :c_name", Character.class);

		q.setParameter("c_name", name);

		Character myC = (Character) q.getSingleResult();

		return myC;
	}

	public Character findByMotto(String motto) {
		Session s = HibernateUtil.getSesstion();
		Query q = s.createQuery("from characters c where c.charMotto = :c_motto", Character.class);

		q.setParameter("c_motto", motto);

		Character myC = (Character) q.getSingleResult();

		return myC;
	}

	public void insert(Character c) {
		Session s = HibernateUtil.getSesstion();
		s.save(c);
	}

	public void update(Character c) {
		Session s = HibernateUtil.getSesstion();
		s.merge(c);
	}

	public void delete(Character c) {
		Session s = HibernateUtil.getSesstion();
		s.delete(c);
	}

}
