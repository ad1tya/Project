/**
 * 
 */
package com.aditya.controllers;

import org.apache.log4j.Logger;

import com.aditya.coupans.Coupon;
import com.aditya.list.AllCoupons;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Aditya Kulkarni
 *
 */
public class MainPageController implements Controller {

	@FXML
	private ImageView imageView;
	@FXML
	private Label login;

	private Image image;
	private SceneController controller;

	final static Logger logger = Logger.getLogger(MainPageController.class);

	/**
	 * 
	 */
	public MainPageController() {
		// TODO Auto-generated constructor stub
		logger.info("MainPageController Initialized.");
		controller = SceneController.getInstance();
	}

	@FXML
	public void listButtonClicked() {
		logger.info("List Button Clicked.");
		// SceneController.getInstance().getScene("listall");
		ListAllPageController con = (ListAllPageController) SceneController.getInstance().getController("listall");
		con.populate();
		SceneController.getInstance().setScene("listall");
	}

	@FXML
	public void loginClicked() {
		logger.info("Login link clicked. Changing the scene to LoginPage");
		controller.setScene("login");
	}

	@FXML
	public void searchClicked() {
		logger.info("Search Button clicked. Changing the scene to SearchPage");
		controller.setScene("search");
	}

	@FXML
	public void initialize() {
		image = new Image(getClass().getClassLoader().getResource("images\\couponImage.jpg").toString());
		imageView.setImage(image);
	}

	@FXML
	public void buyClicked() {
		logger.info("Buy Button clicked. Changing the scene to Purchase scene.");
		controller.setScene("purchase");
		PurchaseController p = (PurchaseController) SceneController.getInstance().getController("purchase");
		p.addDataToTable(AllCoupons.getInstance().getCouponthroughStatus("Active"));//getList().toArray(new Coupon[AllCoupons.getInstance().getList().size()]));
	}
}
