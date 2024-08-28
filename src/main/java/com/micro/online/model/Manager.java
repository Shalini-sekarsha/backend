package com.micro.online.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Manager")
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int manid;
private String manname;
private String manpassword;
public Manager() {
	
	super();
	// TODO Auto-generated constructor stub
}
public Manager(int manid, String manname, String manpassword) {
	super();
	this.manid = manid;
	this.manname = manname;
	this.manpassword = manpassword;
}
public int getManid() {
	return manid;
}
public void setManid(int manid) {
	this.manid = manid;
}
public String getManname() {
	return manname;
}
public void setManname(String manname) {
	this.manname = manname;
}
public String getManpassword() {
	return manpassword;
}
public void setManpassword(String manpassword) {
	this.manpassword = manpassword;
}
@Override
public String toString() {
	return "Manager [manid=" + manid + ", manname=" + manname + ", manpassword=" + manpassword + "]";
}

}
