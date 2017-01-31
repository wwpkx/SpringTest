package cn.itcast.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.itcast.dao.PersonDao;
import cn.itcast.service.PersonService;

public class PersonServiceBean5 implements PersonService {
	@Resource 
//	@Autowired @Qualifier("personDao")
	private PersonDao personDao;
	private String name;	
	
	//@Autowired注解
	//可以标注在字段或属性的setter方法上
	//按类型装配依赖对象，默认情况下它要求依赖对象必须存在
	//如果允许null值，可以设置它required属性为false。
	//如果我们想使用按名称装配，可以结合@Qualifier注解一起使用（只能应用在属性上）。
	
	//@Resource 
	//可以标注在字段或属性的setter方法上
	//@Resource默认按名称装配，当找不到与名称匹配的bean才会按类型装配
	//一旦指定了name属性，就只能按名称装配
//	@Resource 
//	@Resource(name="personDao")	//一旦指定了name属性，就只能按名称装配
//	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public PersonServiceBean5(){}
	
	public PersonServiceBean5(PersonDao personDao, String name) {
		this.personDao = personDao;
		this.name = name;
	}

	public void save(){
		//System.out.println(name);
		personDao.add();
	}
}
