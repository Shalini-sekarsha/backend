package com.micro.online.controller;

import java.io.IOException;


import java.time.LocalDate;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.micro.online.model.Application;
import com.micro.online.service.ApplicationService;
import com.micro.online.service.UserService;

 
 
@RestController
@CrossOrigin("*")
@RequestMapping("/application")
public class ApplicationController {
 
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private UserService userService;
	
//	@PostMapping("/createApplication")
//    public Application regApplication(@RequestBody Application application) throws IOException {
//        return applicationService.regApplication(application);
	@PostMapping("/createApplication") 
	public ResponseEntity<String> submitApplication( 	
			@RequestParam("userImage") MultipartFile userImage, 
			@RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName, 
			@RequestParam("dob") String dob,
			@RequestParam("address") String address,
			@RequestParam("phoneNumber") String phoneNumber, 
			@RequestParam("emailId") String emailId,
			@RequestParam("aadharImage") MultipartFile aadharImage,
			@RequestParam("accountType") String accountType) 
	{ 
		try
	{ 
		Application application = new Application(); 
		application.setUserImage(userImage.getBytes());
		application.setFirstName(firstName);
		application.setLastName(lastName);
		application.setDob(LocalDate.parse(dob)); 
		application.setAddress(address); 
		application.setPhoneNumber(phoneNumber) ;
		application.setEmailId(emailId); 
		application.setAadharImage(aadharImage.getBytes());
		application.setAccountType(accountType); 
		application.setStatus("pending");
		applicationService.regApplication(application); 
		return ResponseEntity.ok("Application submitted successfully!"); 
		}
		catch
		(IOException e) 
		{
			e.printStackTrace();
		return ResponseEntity.status(500).body("Failed to upload files.");
		}
		}
	
	@GetMapping("/all")
	public List<Application> getApplication() {
		return applicationService.getAllApplication();

	}
 
	
	@GetMapping("/GetApplicationId/{id}")
	public Application find(@PathVariable("id") int id) {
		return applicationService.find(id);
	}
// @GetMapping("/GetApplicationId/{userId}")
// public List<String> userfindUserId(@PathVariable("userId")int userId){
//	 return applicationService.findApplicationById(userId);
// }
	@PutMapping("/doApplicationDetailsUpdate")
	public Application updateApplication(@RequestBody Application application) {
		return applicationService.updateApplication(application);
	}
	@PostMapping("/updateStatus")
	public ResponseEntity<?> UpdateStatus(@RequestParam int applicationId, @RequestParam String status) {

		try {
			applicationService.updateApplication(applicationId, status);
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("failed");
		}

	}

	@DeleteMapping("/deleteApplication/{id}")
	public boolean deleteApplications(@PathVariable("id") int id) {
		return applicationService.deleteApplication(id);
 
	}
}
