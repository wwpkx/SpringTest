package junit.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.service.PersonService;

public class SpringAnnotationTest {
	/**
	 * 手动装配
	 */
	@Test public void testAnnotation(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
		PersonService personService = (PersonService)ctx.getBean("personService");
		personService.save();
	}
	
	/**
	 * 自动装配
	 */
	@Test public void testAnnotation2(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
		PersonService personService1 = (PersonService)ctx.getBean("personService1");
		personService1.save();
		
		PersonService personService2 = (PersonService)ctx.getBean("personService2");
		personService2.save();
		
		PersonService personService3 = (PersonService)ctx.getBean("personService3");
		personService3.save();
		
		PersonService personService4 = (PersonService)ctx.getBean("personService4");
		personService4.save();
	}
}
