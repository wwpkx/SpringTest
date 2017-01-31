package junit.test;

import junit.test.itcast.ItcastClassPathXMLApplicationContext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.service.PersonService;
import cn.itcast.service.impl.PersonServiceBean4;

public class SpringTest {
	/**
	 * Spring���� ʹ�÷���
	 * ע�⣺���ܻῴ���ܶ������Ĵ�ӡ�����磺�ұ���ʼ���ˡ��������Ϊ������ʼ����ʱ��Ĭ�ϻ�����еĵ�����ʼ��
	 */
	@Test 
	public void hello(){
		//ʵ����Spring����
		//ApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{��d:\\beans.xml��});
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		//��spring�����еõ�bean
		PersonService personService = (PersonService)ctx.getBean("personService");
		
		//����bean�ķ���
		personService.save();
	}
	
	/**
	 * ��������Spring����ע���ԭ��
	 */
	@Test 
	public void testItcast(){
		ItcastClassPathXMLApplicationContext ctx = new ItcastClassPathXMLApplicationContext("beans.xml");
		PersonService personService = (PersonService)ctx.getBean("personService");
		personService.save();
	}
	
	/**
	 * ����ʵ����bean�ķ�ʽ
	 */
	@Test 
	public void testInstance(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService1 = (PersonService)ctx.getBean("personService1");
		PersonService personService2 = (PersonService)ctx.getBean("personService2");
		PersonService personService3 = (PersonService)ctx.getBean("personService3");
		personService1.save();
		personService2.save();
		personService3.save();
	}
	
	/**
	 * Bean�������򣺵��� �� �õ�ʱ��ʼ��
	 */
	@Test public void testScope(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("new ClassPathXmlApplicationContext");
		System.out.println();
		
		//singleton or prototype 
		PersonService personService41 = (PersonService)ctx.getBean("personService4");
		PersonService personService42 = (PersonService)ctx.getBean("personService4");
		System.out.println(personService41==personService42);
		System.out.println();
		
		PersonService personService51 = (PersonService)ctx.getBean("personService5");
		PersonService personService52 = (PersonService)ctx.getBean("personService5");
		System.out.println(personService51==personService52);
		System.out.println();
	}
	
	/**
	 * ��ʼ�� �� ����
	 */
	@Test public void testInitAndDestroy(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("new ClassPathXmlApplicationContext");
		System.out.println();

		//lazy-init
		//init-method or destroy-method
		PersonService personService6 = (PersonService)ctx.getBean("personService6");
		
		//�ر�spring��������ʱdestroy-method�ͻ�ִ��
		ctx.close();	
	}
	
	/**
	 * ע����������set or constructor��
	 * 1.setע�루��ã�
	 * 2.constructor-argע��
	 */
	@Test 
	public void testInjectObject(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService7 = (PersonService)ctx.getBean("personService7");
		PersonService personService71 = (PersonService)ctx.getBean("personService71");
		PersonService personService8 = (PersonService)ctx.getBean("personService8");
		personService7.save();
		personService71.save();
		personService8.save();
	}
	
	/**
	 * �������͵�װ��
	 */
	@Test 
	public void testCollect(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonServiceBean4 personService = (PersonServiceBean4)ctx.getBean("personService9");
		System.out.println("========set===========");
		for(String value : personService.getSets()){
			System.out.println(value);
		}
		System.out.println("========list===========");
		for(String value : personService.getLists()){
			System.out.println(value);
		}
		System.out.println("========properties===========");
		for(Object key : personService.getProperties().keySet()){
			System.out.println(key+"="+ personService.getProperties().getProperty((String)key));
		}
		System.out.println("========map===========");
		for(String key : personService.getMaps().keySet()){
			System.out.println(key+"="+ personService.getMaps().get(key));
		}
		ctx.close();
	}

}
