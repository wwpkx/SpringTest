package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

public class PersonServiceBean implements PersonService {
	public void save(){
		System.out.println("我是save()方法");
	}
}
