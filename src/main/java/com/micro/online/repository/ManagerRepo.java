package com.micro.online.repository;



import java.util.List;


import com.micro.online.model.Manager;



 
public interface ManagerRepo {
 
	public Manager newManager(Manager newManager);
 
	public List<Manager> getManagers();
 
	public Manager managerfind(int manId);
 
	public List<Integer> getManagerIdList();
 
	public Manager updateManager(Manager manager);
 
	public Manager ManagerLogin(String manname, String manpassword);
	public Manager findBymanname(String manname);


} 

