package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "franchise")

@Data @AllArgsConstructor @NoArgsConstructor
public class Franchise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String franName;
	
	@Column(name = "console", nullable = false)
	private String daConsole;
	
	@OneToMany(mappedBy = "characters", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
	private List<Character> listOfChars;

}
