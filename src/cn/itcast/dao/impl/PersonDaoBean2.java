package cn.itcast.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.dao.PersonDao;

@Repository("personDao")
public class PersonDaoBean2 implements PersonDao {
	public void add(){
		System.out.println("执行PersonDaoBean2中的add()方法");
	}
}
