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
	
	//@Autowiredע��
	//���Ա�ע���ֶλ����Ե�setter������
	//������װ����������Ĭ���������Ҫ����������������
	//�������nullֵ������������required����Ϊfalse��
	//���������ʹ�ð�����װ�䣬���Խ��@Qualifierע��һ��ʹ�ã�ֻ��Ӧ���������ϣ���
	
	//@Resource 
	//���Ա�ע���ֶλ����Ե�setter������
	//@ResourceĬ�ϰ�����װ�䣬���Ҳ���������ƥ���bean�Żᰴ����װ��
	//һ��ָ����name���ԣ���ֻ�ܰ�����װ��
//	@Resource 
//	@Resource(name="personDao")	//һ��ָ����name���ԣ���ֻ�ܰ�����װ��
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
