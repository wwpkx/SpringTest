package junit.test;


import org.junit.BeforeClass;
import org.junit.Test;

import cn.itcast.aop.CGlibProxyFactory;
import cn.itcast.aop.JDKProxyFactory;
import cn.itcast.service.PersonService2;
import cn.itcast.service.impl.PersonServiceBean8;

public class AOPTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test public void proxyTest(){
		JDKProxyFactory factory = new JDKProxyFactory();
		PersonService2 service = (PersonService2) factory.createProxyIntance(new PersonServiceBean8("xxx"));
		service.save("888");
	}
	
	@Test public void proxyTest2(){
		CGlibProxyFactory factory = new CGlibProxyFactory();
		PersonServiceBean8 service = (PersonServiceBean8) factory.createProxyIntance(new PersonServiceBean8("xxx"));
		service.save("999");
	}
}
