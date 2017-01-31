package cn.itcast.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import cn.itcast.service.PersonService;

public class PersonServiceBean4 implements PersonService {
	private Set<String> sets = new HashSet<String>();
	private List<String> lists = new ArrayList<String>();
	private Properties properties = new Properties();
	private Map<String, String> maps = new HashMap<String, String>();
	
	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public void save(){
		
	}
}
