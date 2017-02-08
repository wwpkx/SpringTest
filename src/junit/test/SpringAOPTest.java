package junit.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.service.PersonService2;

public class SpringAOPTest {

	@Test public void interceptorTest(){
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans-aop.xml");
		PersonService2 personService2 = (PersonService2)cxt.getBean("personService");
		personService2.save("xx");
	}
	
	@Test public void interceptorTest2(){
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans-aop2.xml");
		PersonService2 personService2 = (PersonService2)cxt.getBean("personService");
		personService2.save("xx");
		personService2.getPersonName(5);
	}
}
