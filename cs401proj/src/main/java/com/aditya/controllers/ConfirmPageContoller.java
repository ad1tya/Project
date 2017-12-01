/**
 * 
 */
package com.aditya.controllers;

import org.apache.log4j.Logger;

import com.aditya.coupans.Coupon;
import com.aditya.db.AtlasCouponDocument;
import com.aditya.list.AllCoupons;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * @author Aditya Kulkarni
 *
 */
public class ConfirmPageContoller implements Controller {
	private static Logger logger = Logger.getLogger(ConfirmPageContoller.class);
	@FXML
	private Label calc;
	@FXML
	private Pane pane;
	@FXML
	private Button button;
	private boolean flag = true;

	/**
	 * 
	 */
	public ConfirmPageContoller() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	public void initialize() {
	}

	@FXML
	public void mouseHover() {
		pane.setOnMouseMoved(null);
		Coupon c = AllCoupons.getInstance().getSelected();
		if(c == null) return;
		
		float total_price = (c.getPrice() - (c.getPrice() * (c.getDiscount() / 100)));
		logger.info("Total price of selected coupon: " + total_price);
		String calculation = "Price: " + c.getPrice() + "\n" + "Discount: " + c.getDiscount() + "\n"
				+ "--------------------------\n" + "Total :" + total_price;
		calc.setText(calculation);
	}

	@FXML
	public void confirmButtonClicked() {
		if (flag) {
			logger.info("Purchase Confirmed. Changing status for the coupon.");
			AllCoupons.getInstance().getSelected().setStatus("Used");
			AtlasCouponDocument.getInstance().modify(AllCoupons.getInstance().getSelected());
			logger.info("Coupon modify.");
			SceneController.getInstance().setScene("final");
		} else {
			logger.info("Coupon already sold.");
			SceneController.getInstance().setScene("main");
		}
	}

	public void printError() {
		calc.setText("Coupon already \n sold.");
		button.setText("Home");
		flag = false;
	}
}
