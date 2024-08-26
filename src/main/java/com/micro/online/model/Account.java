package com.micro.online.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String firstname;
    private String lastname;
    private LocalDate DateofBirth;
    private String Address;
    private int Phonenumber;
    private String Emailid;
    private String Accounttype;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Long id, User user, String firstname, String lastname, LocalDate dateofBirth, String address,
			int phonenumber, String emailid, String accounttype) {
		super();
		this.id = id;
		this.user = user;
		this.firstname = firstname;
		this.lastname = lastname;
		this.DateofBirth = dateofBirth;
		this.Address = address;
		this.Phonenumber = phonenumber;
		this.Emailid = emailid;
		this.Accounttype = accounttype;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public LocalDate getDateofBirth() {
		return DateofBirth;
	}
	public void setDateofBirth(LocalDate dateofBirth) {
		DateofBirth = dateofBirth;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		Phonenumber = phonenumber;
	}
	public String getEmailid() {
		return Emailid;
	}
	public void setEmailid(String emailid) {
		Emailid = emailid;
	}
	public String getAccounttype() {
		return Accounttype;
	}
	public void setAccounttype(String accounttype) {
		Accounttype = accounttype;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", DateofBirth=" + DateofBirth + ", Address=" + Address + ", Phonenumber=" + Phonenumber
				+ ", Emailid=" + Emailid + ", Accounttype=" + Accounttype + "]";
	}
	

}