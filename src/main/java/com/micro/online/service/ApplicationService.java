package com.micro.online.service;


import java.io.IOException;
import java.util.List;


import com.micro.online.model.Application;
 
 
public interface ApplicationService {
 
	
	
		List<Application> getAllApplicationsDetails();
 
		Application find(int id);
 
		
		 
		public List<Application> getAllApplication();
		Application updateApplication(Application application);
 
		boolean deleteApplication(int id);

		Application regApplication(Application application) throws IOException;

		void updateApplication(int applicationId, String status);

//		List<String> findApplicationById(int userId);
		
		
		
	}
