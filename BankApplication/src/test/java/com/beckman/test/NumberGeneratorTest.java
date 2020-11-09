package com.beckman.test;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.beckman.users.Customer;

public class NumberGeneratorTest {
	
	static Customer a;
	static Customer c;
	static Set<Integer> b = new HashSet<>();
	
	@Test
	public void test() {
		int num = (int) (Math.random()*100000);
		a = new Customer("a", "A", "aaa", "123", num, 0, 0, false);
		c = new Customer("c", "C", "ccc", "321", 345354, 0, 0, true);
		
		if(b.contains(num)) {
			test();
			}else {
			b.add(num);
			}
	}
	
	

}
