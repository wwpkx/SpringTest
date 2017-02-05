package cn.itcast.service;

public interface PersonService2 {
	public void save(String name);
	public void update(String name, Integer personid);
	public String getPersonName(Integer personid);
}
