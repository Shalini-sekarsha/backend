package com.micro.online.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Scheme")
public class Scheme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schemeID;
	private String schemeName;
	private String schemeDescription;
	public int getSchemeID() {
		return schemeID;
	}
	public void setSchemeID(int schemeID) {
		this.schemeID = schemeID;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getSchemeDescription() {
		return schemeDescription;
	}
	public void setSchemeDescription(String schemeDescription) {
		this.schemeDescription = schemeDescription;
	}
	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Scheme(int schemeID, String schemeName, String schemeDescription) {
		super();
		this.schemeID = schemeID;
		this.schemeName = schemeName;
		this.schemeDescription = schemeDescription;
	}
	@Override
	public String toString() {
		return "Scheme [schemeID=" + schemeID + ", schemeName=" + schemeName + ", schemeDescription="
				+ schemeDescription + "]";
	}
	
}
