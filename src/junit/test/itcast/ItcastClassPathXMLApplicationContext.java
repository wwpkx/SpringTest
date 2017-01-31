package junit.test.itcast;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

/**
 * ���Ǵ��Ͱ�����
 *
 */
public class ItcastClassPathXMLApplicationContext {
	private List<BeanDefinition> beanDefines = new ArrayList<BeanDefinition>();
	private Map<String, Object> sigletons = new HashMap<String, Object>();
	
	public ItcastClassPathXMLApplicationContext(String filename){
		this.readXML(filename);
		this.instanceBeans();
		this.annotationInject();
		this.injectObject();
	}
	/**
	 * ͨ��ע��ʵ��ע����������
	 */
	private void annotationInject() {
		for(String beanName : sigletons.keySet()){
			Object bean = sigletons.get(beanName);
			if(bean!=null){
				try {
					PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
					for(PropertyDescriptor properdesc : ps){
						Method setter = properdesc.getWriteMethod();//��ȡ���Ե�setter����
						if(setter!=null && setter.isAnnotationPresent(ItcastResource.class)){
							ItcastResource resource = setter.getAnnotation(ItcastResource.class);
							Object value = null;
							if(resource.name()!=null && !"".equals(resource.name())){
								value = sigletons.get(resource.name());
							}else{
								value = sigletons.get(properdesc.getName());
								if(value==null){
									for(String key : sigletons.keySet()){
										if(properdesc.getPropertyType().isAssignableFrom(sigletons.get(key).getClass())){
											value = sigletons.get(key);
											break;
										}
									}
								}								
							}
							setter.setAccessible(true);
							setter.invoke(bean, value);//�����ö���ע�뵽����
						}
					}
					Field[] fields = bean.getClass().getDeclaredFields();
					for(Field field : fields){
						if(field.isAnnotationPresent(ItcastResource.class)){
							ItcastResource resource = field.getAnnotation(ItcastResource.class);
							Object value = null;
							if(resource.name()!=null && !"".equals(resource.name())){
								value = sigletons.get(resource.name());
							}else{
								value = sigletons.get(field.getName());
								if(value==null){
									for(String key : sigletons.keySet()){
										if(field.getType().isAssignableFrom(sigletons.get(key).getClass())){
											value = sigletons.get(key);
											break;
										}
									}
								}								
							}
							field.setAccessible(true);//�������private�ֶ�
							field.set(bean, value);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Ϊbean���������ע��ֵ
	 */
	private void injectObject() {
		for(BeanDefinition beanDefinition : beanDefines){
			Object bean = sigletons.get(beanDefinition.getId());
			if(bean!=null){
				try {
					PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
					for(PropertyDefinition propertyDefinition : beanDefinition.getPropertys()){
						for(PropertyDescriptor properdesc : ps){
							if(propertyDefinition.getName().equals(properdesc.getName())){
								Method setter = properdesc.getWriteMethod();//��ȡ���Ե�setter���� ,private
								if(setter!=null){
									Object value = null;
									if(propertyDefinition.getRef()!=null && !"".equals(propertyDefinition.getRef().trim())){
										value = sigletons.get(propertyDefinition.getRef());
									}else{
										value = ConvertUtils.convert(propertyDefinition.getValue(), properdesc.getPropertyType());
									}
									setter.setAccessible(true);
									setter.invoke(bean, value);//�����ö���ע�뵽����
								}
								break;
							}
						}
					}
				} catch (Exception e) {
				}
			}
		}
	}
	/**
	 * ���bean��ʵ����
	 */
	private void instanceBeans() {
		for(BeanDefinition beanDefinition : beanDefines){
			try {
				if(beanDefinition.getClassName()!=null && !"".equals(beanDefinition.getClassName().trim()))
					sigletons.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * ��ȡxml�����ļ�
	 * @param filename
	 */
	private void readXML(String filename) {
	       SAXReader saxReader = new SAXReader();   
	        Document document=null;   
	        try{
	         URL xmlpath = this.getClass().getClassLoader().getResource(filename);
	         document = saxReader.read(xmlpath);
	         Map<String,String> nsMap = new HashMap<String,String>();
	         nsMap.put("ns","http://www.springframework.org/schema/beans");//���������ռ�
	         XPath xsub = document.createXPath("//ns:beans/ns:bean");//����beans/bean��ѯ·��
	         xsub.setNamespaceURIs(nsMap);//���������ռ�
	         List<Element> beans = xsub.selectNodes(document);//��ȡ�ĵ�������bean�ڵ� 
	         for(Element element: beans){
	            String id = element.attributeValue("id");//��ȡid����ֵ
	            String clazz = element.attributeValue("class"); //��ȡclass����ֵ        
	            BeanDefinition beanDefine = new BeanDefinition(id, clazz);
	            XPath propertysub =  element.createXPath("ns:property");
	            propertysub.setNamespaceURIs(nsMap);//���������ռ�
	            List<Element> propertys = propertysub.selectNodes(element);
	            for(Element property : propertys){	            	
	            	String propertyName = property.attributeValue("name");
	            	String propertyref = property.attributeValue("ref");
	            	String propertyValue = property.attributeValue("value");
	            	PropertyDefinition propertyDefinition = new PropertyDefinition(propertyName, propertyref, propertyValue);
	            	beanDefine.getPropertys().add(propertyDefinition);
	            }
	            beanDefines.add(beanDefine);
	         } 
	        }catch(Exception e){   
	            e.printStackTrace();
	        }
	}
	/**
	 * ��ȡbeanʵ��
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName){
		return this.sigletons.get(beanName);
	}
}
