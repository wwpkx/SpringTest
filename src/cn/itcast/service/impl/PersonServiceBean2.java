package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

public class PersonServiceBean2 implements PersonService {
	public void init(){
		System.out.println("初始化");
	}
	public PersonServiceBean2(){
		System.out.println("我被实例化了");
	}
	public void save(){
		System.out.println("我是save()方法");
	}
	
	public void destory(){
		System.out.println("关闭打开的资源");
	}
}