package com.tavant.accountrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "account")
@Table(name = "account")
public class Account 
{
	@Id
	private String accountNumber;
	private String accountType;
	private String firstName;
	private String lastName;
	private float balance;
}