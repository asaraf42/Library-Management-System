package com.app.dto;

public class UserDTO {

	private String name;
	private String password;
	private long mobileno;
	private String email;
	
	public UserDTO(String name,String password,long mobileno,String email)
	{
		this.name=name;
		this.password=password;
		this.mobileno=mobileno;
		this.email=email;
	}
	
	public UserDTO() {}

	public String getName()
	{
		return name;
	}
	public String getPassword()
	{
		return password;
	}
	public long getMbno()
	{
		return mobileno;
	}
	public String getEmail()
	{
		return email;
	}
	
	public void  setName(String name)
	{
		this.name=name;
	}
	public void  setPassword(String password)
	{
		this.password=password;
	}
	public void setMbno(long mobileno)
	{
		this.mobileno=mobileno;
	}
	public void setEmail(String Email)
	{
		this.email=email;
	}
	
}
