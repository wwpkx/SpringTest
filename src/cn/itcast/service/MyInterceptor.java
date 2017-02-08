package cn.itcast.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/**
 * ����
 *
 */
@Aspect
public class MyInterceptor {
	@Pointcut("execution (* cn.itcast.service.impl.PersonServiceBean8.*(..))")
	private void anyMethod() {}//����һ������㣬anyMethodΪ���������
	
	@Pointcut("execution (* cn.itcast.service.impl.PersonServiceBean8.*(..))")
	private void anyMethod2() {}
	
	@Before("anyMethod2()")
	public void doAccessCheck2() {
		System.out.println("ǰ��֪ͨ2");
	}
	@AfterReturning(pointcut="anyMethod2()")
	public void doAfterReturning() {
		System.out.println("����֪ͨ2");
	}
	
	//ǰ��֪ͨ���Եõ������Ĳ����������ͺ�����㶨���е�����һ��
	//����֪ͨ���Եõ������ķ��ؽ�� 
	@Before("anyMethod() && args(name)")
	public void doAccessCheck(String name) {
		System.out.println("ǰ��֪ͨ:"+ name);
	}
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void doAfterReturning(String result) {
		System.out.println("����֪ͨ:"+ result);
	}
	@After("anyMethod()")
	public void doAfter() {
		System.out.println("����֪ͨ");
	}
	@AfterThrowing(pointcut="anyMethod()",throwing="e")
	public void doAfterThrowing(Exception e) {
		System.out.println("����֪ͨ:"+ e);
	}
	
	//����֪ͨ�Ĳ����ǹ̶�д��������pjp.proceed()��ʾ�÷�����������
	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		//if(){//�ж��û��Ƿ���Ȩ��
		System.out.println("---------���뷽��������֪ͨ��");
		Object result = pjp.proceed();
		System.out.println("---------�˳�����");
		//}
		return result;
	}
	
}
