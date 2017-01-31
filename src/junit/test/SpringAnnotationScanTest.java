package junit.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.dao.impl.PersonDaoBean2;
import cn.itcast.service.PersonService;

public class SpringAnnotationScanTest {
	/**
	 * ͨ����classpath�Զ�ɨ�跽ʽ���������spring�����й���
	 * 4��ע�⣨�����ָ�����֣���Ϊ������һ����ĸСд����
	 * @Service���ڱ�עҵ������
	 * @Controller���ڱ�ע���Ʋ��������struts�е�action��
	 * @Repository���ڱ�ע���ݷ����������DAO���
	 * @Component��ָ�������������ù����ʱ�����ǿ���ʹ�����ע����б�ע
	 */
	@Test public void testAnnotation(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scan.xml");
		
		//�����ָ�����֣���Ϊ������һ����ĸСд
		//PersonService personService = (PersonService)ctx.getBean("personServiceBean7");
		PersonService personService = (PersonService)ctx.getBean("personService");
		System.out.println(personService);
		
		PersonDaoBean2 personDaoBean2 = (PersonDaoBean2)ctx.getBean("personDao");
		System.out.println(personDaoBean2);
		
		personService.save();
		
		ctx.close();
	}
}
