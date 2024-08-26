package com.micro.online.serviceimpl;


import jakarta.transaction.Transactional;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.online.model.Application;
import com.micro.online.repository.ApplicationRepo;
import com.micro.online.service.ApplicationService;

import java.io.IOException;
import java.util.List;
 
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
	
	
	    @Autowired
	    private ApplicationRepo applicationRepo;
 
//		@Override
//		public List<Application> getAllApplicationsDetails() {
//			return applicationRepo.getApplicationDetails();
//		}
 
		@Override
		public Application find(int id) {
			return applicationRepo.findById(id);
		}
 
		@Override
		public Application regApplication(Application application) throws IOException  {
			return applicationRepo.regApplication(application);
		}
 
	
		public Application updateApplication(Application application)   {
			return applicationRepo.updateApplications(application);
		}
 
		@Override
		public boolean deleteApplication(int id) {
			return applicationRepo.deleteApplications(id);
		}

		public void updateApplication(int applicationId,String status) {
			
			boolean flag=true;
			
			try {
				Application application=applicationRepo.findById(applicationId);
				if(application != null) {
					application.setStatus(status);
					applicationRepo.updateApplications(application);
				}
				
			} catch (Exception e) {
				flag=false;
			}

			return;
		}
		public List<Application> getAllApplication(){
			return applicationRepo.findAll();
		}
	@Override
		public List<Application> getAllApplicationsDetails() {
			
			return null;
		}

//	@Override
//	public List<String> findApplicationById(int userId) {
//		return applicationRepo.userFindApplicationById(userId);
//	}

		
		
 
	}