package com.revature.dao;

import java.util.List;



public interface CharacterDao {
	
	public List<Character> findAll();

	public Character findById(int id);

	public Character findByName(String name);

	public Character findByMotto(String motto);
	
	public void insert(Character c);
	
	public void update(Character c);
	
	public void delete(Character c);

}
