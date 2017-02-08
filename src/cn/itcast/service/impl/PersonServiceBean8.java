package cn.itcast.service.impl;

import cn.itcast.service.PersonService2;

public class PersonServiceBean8 implements PersonService2{
	private String user = null;
	
	public String getUser() {
		return user;
	}

	public PersonServiceBean8(){}
	
	public PersonServiceBean8(String user){
		this.user = user;
	}

	public String getPersonName(Integer personid) {
		System.out.println("我是getPersonName()方法");
		return "xxx";
	}

	public void save(String name) {
//		throw new RuntimeException("我爱例外");
		System.out.println("我是save()方法");
	}

	public void update(String name, Integer personid) {
		System.out.println("我是update()方法");
	}

}
