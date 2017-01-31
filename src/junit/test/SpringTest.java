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
	 * Spring容器 使用方法
	 * 注意：可能会看到很多其他的打印，比如：我被初始化了。这个是因为容器初始化的时候，默认会把所有的单例初始化
	 */
	@Test 
	public void hello(){
		//实例化Spring容器
		//ApplicationContext ctx = new FileSystemXmlApplicationContext(new String[]{“d:\\beans.xml“});
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		//从spring容器中得到bean
		PersonService personService = (PersonService)ctx.getBean("personService");
		
		//调用bean的方法
		personService.save();
	}
	
	/**
	 * 编码剖析Spring依赖注入的原理
	 */
	@Test 
	public void testItcast(){
		ItcastClassPathXMLApplicationContext ctx = new ItcastClassPathXMLApplicationContext("beans.xml");
		PersonService personService = (PersonService)ctx.getBean("personService");
		personService.save();
	}
	
	/**
	 * 三种实例化bean的方式
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
	 * Bean的作用域：单例 和 用到时初始化
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
	 * 初始化 和 销毁
	 */
	@Test public void testInitAndDestroy(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("new ClassPathXmlApplicationContext");
		System.out.println();

		//lazy-init
		//init-method or destroy-method
		PersonService personService6 = (PersonService)ctx.getBean("personService6");
		
		//关闭spring容器，此时destroy-method就会执行
		ctx.close();	
	}
	
	/**
	 * 注入依赖对象（set or constructor）
	 * 1.set注入（最常用）
	 * 2.constructor-arg注入
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
	 * 集合类型的装配
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
