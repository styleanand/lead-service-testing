package com.vw.lead.service.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
    private Long id;	
	 
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    private String race;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String countryCode;
    private String contactPhone;
    private String contactEmail;    
    private String comments;

	
}

