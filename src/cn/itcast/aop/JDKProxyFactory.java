package cn.itcast.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.itcast.service.impl.PersonServiceBean8;

public class JDKProxyFactory implements InvocationHandler{
	private Object targetObject;
	
	public Object createProxyIntance(Object targetObject){
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(), 
				this.targetObject.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {//环绕通知
		PersonServiceBean8 bean = (PersonServiceBean8) this.targetObject;
		Object result = null; 
		if(bean.getUser()!=null){
			//..... advice()-->前置通知
			try {
				result = method.invoke(targetObject, args);
				// afteradvice() -->后置通知
			} catch (RuntimeException e) {
				//exceptionadvice()--> 例外通知
			}finally{
				//finallyadvice(); -->最终通知
			}
		}
		return result;
	}

}
