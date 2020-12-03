package com.revature.dao;

import java.util.List;

import com.revature.models.Franchise;

public interface FranchiseDao {

	public List<Franchise> findAll();

	public Franchise findById(int id);

	public Franchise findByName(String name);

	public Franchise findByConsole(String console);
	
	public void insert(Franchise franny);
	
	public void update(Franchise franny);
	
	public void delete(Franchise franny);
}
