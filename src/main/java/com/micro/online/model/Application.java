package com.micro.online.model;
import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(name = "userImage",length = 100000)
   
    private byte[] userImage;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private String phoneNumber;
    private String emailId;
    @Lob
    @Column(name = "aadharImage",length = 100000)
    
    private byte[] aadharImage;
    private String accountType;
    private String status;
    
    @ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;
	public Application() {
		super();
		
	}
	public Application(Long id, byte[] userImage, String firstName, String lastName, LocalDate dob, String address,
			String phoneNumber, String emailId, byte[] aadharImage, String accountType, String status) {
		super();
		this.id = id;
		this.userImage = userImage;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.aadharImage = aadharImage;
		this.accountType = accountType;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getUserImage() {
		return userImage;
	}
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public byte[] getAadharImage() {
		return aadharImage;
	}
	public void setAadharImage(byte[] aadharImage) {
		this.aadharImage = aadharImage;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", userImage=" + Arrays.toString(userImage) + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + ", aadharImage=" + Arrays.toString(aadharImage) + ", accountType="
				+ accountType + ", status=" + status + "]";
	}
		
}