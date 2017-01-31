package cn.itcast.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.dao.PersonDao;
import cn.itcast.service.PersonService;

@Service("personService")
public class PersonServiceBean7 implements PersonService {
	@Resource 
	private PersonDao personDao;
	
	@PostConstruct
	public void init(){
		System.out.println("��ʼ��");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("������Դ");
	}
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void save(){
		personDao.add();
	}
}
