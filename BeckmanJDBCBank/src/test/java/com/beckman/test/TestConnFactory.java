package com.beckman.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.beckman.util.ConnFactory;

public class TestConnFactory {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public static ConnFactory cf;
	private Connection conn;

	@Test
	public void getInstanceTest() throws SQLException {
		cf.getInstance();
		String result = conn.getSchema();
		
		
	}


}
