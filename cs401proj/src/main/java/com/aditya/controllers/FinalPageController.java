/**
 * 
 */
package com.aditya.controllers;

import javafx.fxml.FXML;

/**
 * @author Aditya Kulkarni
 *
 */
public class FinalPageController implements Controller{

	/**
	 * 
	 */
	public FinalPageController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	public void homeButtonClicked() {
		SceneController.getInstance().setScene("main");
	}

}
