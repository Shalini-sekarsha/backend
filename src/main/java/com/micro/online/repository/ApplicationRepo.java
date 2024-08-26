package com.micro.online.repository;
import java.util.List;


import com.micro.online.model.Application;


 
public interface ApplicationRepo {
 
	
	List<Application> findAll();
	public Application findById(int id);
 
	public Application updateApplications(Application application);
 
	public boolean deleteApplications(int id);

	public Application regApplication(Application application);
//	List<String> userFindApplicationById(int userId);


	
	
	
 
	

 
}


