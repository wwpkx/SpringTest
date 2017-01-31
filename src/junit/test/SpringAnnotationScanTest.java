package junit.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.dao.impl.PersonDaoBean2;
import cn.itcast.service.PersonService;

public class SpringAnnotationScanTest {
	/**
	 * 通过在classpath自动扫描方式把组件纳入spring容器中管理
	 * 4个注解（如果不指定名字，则为类名第一个字母小写）：
	 * @Service用于标注业务层组件
	 * @Controller用于标注控制层组件（如struts中的action）
	 * @Repository用于标注数据访问组件，即DAO组件
	 * @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注
	 */
	@Test public void testAnnotation(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scan.xml");
		
		//如果不指定名字，则为类名第一个字母小写
		//PersonService personService = (PersonService)ctx.getBean("personServiceBean7");
		PersonService personService = (PersonService)ctx.getBean("personService");
		System.out.println(personService);
		
		PersonDaoBean2 personDaoBean2 = (PersonDaoBean2)ctx.getBean("personDao");
		System.out.println(personDaoBean2);
		
		personService.save();
		
		ctx.close();
	}
}
