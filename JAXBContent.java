package com.producer.consumer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "StudentRoot")
@XmlType(propOrder = {"name", "age"})
public class JAXBContent {
	
	private String name;
	private int age;
	private String id;

	
	@XmlElement(name="stdname")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="sage")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@XmlAttribute(name="ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "JAXBContent [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
}
