package com.example.RESTDATA.restapidata.Stdmodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Student {
    
	@Id
	ObjectId _id;
	String name;
	String dept;
	
	public Student() { }
	
	public Student(ObjectId id, String name, String dept) {
		super();
		this._id = id;
		this.name = name;
		this.dept = dept;
	}
	public String getId() {
		return _id.toHexString();
	}
	public void setId(ObjectId id) {
		this._id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}
