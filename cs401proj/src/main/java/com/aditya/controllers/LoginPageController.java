/**
 * 
 */
package com.aditya.controllers;

import org.apache.log4j.Logger;

import javafx.fxml.FXML;

/**
 * @author Aditya Kulkarni
 * This is the controller for the login page.
 */

public class LoginPageController implements Controller{
	final static Logger logger = Logger.getLogger(LoginPageController.class);

	/**
	 *  
	 */
	public LoginPageController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	public void loginButtonClicked(){
		SceneController.getInstance().setScene("add");
	}
	
	

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
@FXML
public void initialize() {
}

}
