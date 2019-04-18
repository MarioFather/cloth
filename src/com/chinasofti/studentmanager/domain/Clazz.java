package com.chinasofti.studentmanager.domain;

import java.io.Serializable;
import java.util.List;

public class Clazz implements Serializable{
	private int clid;
	private String clname;
	public Clazz() {
		super();
	}
	public Clazz(int clid, String clname) {
		super();
		this.clid = clid;
		this.clname = clname;
	}
	public int getClid() {
		return clid;
	}
	public void setClid(int clid) {
		this.clid = clid;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	
}
