spring test
spring生成对象时，使用的是不带参数的构造函数(默认的)。如果有带参数的构造函数时，最好同时定义一个不带任何参数的构造函数

使用:
1.src\beans.xml
2.解析beans.xml(解析bean标签或者注解)，生成ApplicationContext(也就是spring容器)
3.调用bean的方法

依赖注入：
手工装配
	1.property(setting)
	2.constructor-arg
	3.@Autowired @Resource(推荐)
	4.spring2.5引入了组件自动扫描机制(解决了配置文件太大的问题)
自动装配(不建议使用)

工程结构：
----------------控制反转(Inversion of Control ,IoC)----------------
beans.xml--SpringTest
	注入原理
	三种实例化bean的方式
	Bean的作用域：单例 和 用到时初始化
	初始化 和 销毁
	注入依赖对象(property or constructor)
	集合类型的装配
beans-annotation.xml--SpringAnnotationTest
	注解--手工装配(@Autowired @Resource(推荐))、自动装配
beans-scan.xml--SpringAnnotationScanTest
	注解--组件自动扫描机制
junit.test.itcast
	控制反转的实现原理
----------------面向切面(AOP)----------------	