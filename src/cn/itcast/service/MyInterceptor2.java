package cn.itcast.service;

import org.aspectj.lang.ProceedingJoinPoint;
/**
 * ����
 *
 */
public class MyInterceptor2 {	
	public void doAccessCheck() {
		System.out.println("ǰ��֪ͨ");
	}

	public void doAfterReturning() {
		System.out.println("����֪ͨ");
	}
	
	public void doAfter() {
		System.out.println("����֪ͨ");
	}
	
	public void doAfterThrowing() {
		System.out.println("����֪ͨ");
	}
	
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-----------���뷽��");
		Object result = pjp.proceed();
		System.out.println("-----------�˳�����");
		return result;
	}
	
}
