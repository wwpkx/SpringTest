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
		System.out.println("����getPersonName()����");
		return "xxx";
	}

	public void save(String name) {
//		throw new RuntimeException("�Ұ�����");
		System.out.println("����save()����");
	}

	public void update(String name, Integer personid) {
		System.out.println("����update()����");
	}

}
