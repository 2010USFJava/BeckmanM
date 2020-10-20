package com.revature.driver;

import com.revature.bean.BeanOne;
import com.revature.bean.BeanTwo;

public class Driver {

	public static void main(String[] args) {
	BeanOne bean1 = new BeanOne("Beanie", new BeanTwo("Beans"));
	System.out.println(bean1);
	
	BeanTwo myBean = new BeanTwo("Beanssss");
	System.out.println(myBean);
	}

}
