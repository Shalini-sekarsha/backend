package com.micro.online.repoimpl;




import jakarta.persistence.EntityManager;
 

import jakarta.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.micro.online.model.Application;
import com.micro.online.repository.ApplicationRepo;

import java.util.List;
 
@Repository
public class ApplicationRepoImpl implements ApplicationRepo {
 
	@Autowired
	EntityManager entityMan;
 
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Application> getApplicationDetails() {
//		return entityMan.createQuery("from Application").getResultList();
//	}
 
	public Application findById(int id) {
		return entityMan.find(Application.class, id);
	}
 
	public Application regApplication(Application application) {
		
		entityMan.persist(application);
		return application;
	}
 
 

	
	public Application updateApplications(Application application) {
	    try {
	        // Fetch existing policy from the database
	    	Application existingApplication = entityMan.find(Application.class, application.getId());
 
	        if (existingApplication != null) {
	            // Update fields of the existing policy
	            existingApplication.setFirstName(application.getFirstName());
	            existingApplication.setLastName(application.getLastName());
	            existingApplication.setDob(application.getDob());
	            existingApplication.setAddress(application.getAddress());
	            existingApplication.setPhoneNumber(application.getPhoneNumber());
	            existingApplication.setEmailId(application.getEmailId());
	            existingApplication.setAccountType(application.getAccountType());
	            entityMan.merge(existingApplication);
	            return existingApplication;
	        } else {
	            return null;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	@Override
	public List<Application> findAll() {
		String hql="from Application";
		Query query=entityMan.createQuery(hql);
		
		return query.getResultList();
	}
	@Override
	public boolean deleteApplications(int id) {
		Query query = entityMan.createQuery("DELETE Application p WHERE p.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		return true;
	}

//	@Override
//	public List<String> userFindApplicationById(int userId) {
//		Query query=entityMan.createQuery("From Application a Where a.user.userId=:userId");
//		query.setParameter("userId", userId);
//		return query.getResultList();
//	}

	
	

	


	
}
 
