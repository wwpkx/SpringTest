package cn.itcast.aop;

import java.lang.reflect.Method;

import cn.itcast.service.impl.PersonServiceBean8;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxyFactory implements MethodInterceptor{
	private Object targetObject;
	
	public Object createProxyIntance(Object targetObject){
		this.targetObject = targetObject;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.targetObject.getClass());//·Çfinal
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy  methodProxy) throws Throwable {
		PersonServiceBean8 bean = (PersonServiceBean8) this.targetObject;
		Object result = null;
		if(bean.getUser()!=null){
			result = methodProxy.invoke(targetObject, args);
		}
		return result;
	}
}
