package cn.itcast.service.impl;

import cn.itcast.dao.PersonDao;
import cn.itcast.service.PersonService;

public class PersonServiceBean3 implements PersonService {
	private PersonDao personDao;
	private String name;	
	private Integer id;
	
	public PersonServiceBean3(){}
	
	public PersonServiceBean3(PersonDao personDao, String name) {
		this.personDao = personDao;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public void save(){
		System.out.println("id:"+ id+ ", name:"+ name);
		personDao.add();
	}
}
