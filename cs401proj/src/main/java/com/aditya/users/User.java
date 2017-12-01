/**
 * 
 */
package com.aditya.users;

/**
 * @author Aditya Kulkarni
 * This class defines all the users of the application.
 */
public class User {
	private String name;
	private String password;
	private AllUsers users;
	
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AllUsers getUsers() {
		return users;
	}

	public void setUsers(AllUsers users) {
		this.users = users;
	}
}
