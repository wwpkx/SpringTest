package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

public class PersonServiceBean2 implements PersonService {
	public void init(){
		System.out.println("��ʼ��");
	}
	public PersonServiceBean2(){
		System.out.println("�ұ�ʵ������");
	}
	public void save(){
		System.out.println("����save()����");
	}
	
	public void destory(){
		System.out.println("�رմ򿪵���Դ");
	}
}