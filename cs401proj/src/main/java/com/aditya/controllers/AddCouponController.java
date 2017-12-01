/**
 * 
 */
package com.aditya.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.log4j.Logger;

import com.aditya.coupans.Coupon;
import com.aditya.db.AtlasCouponDocument;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * @author Aditya Kulkarni
 * Add Coupon Controller.
 */
public class AddCouponController implements Controller {
	private static Logger logger = Logger.getLogger(AddCouponController.class);
	String pattern = "yyyy-MM-dd";
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
	@FXML
	ComboBox<String> comboBox;
	@FXML
	TextField nameText;
	@FXML
	TextField providerText;
	@FXML
	TextField priceText;
	@FXML
	TextField DiscountText;
	@FXML
	DatePicker ExpiryText;

	/**
	 * 
	 */
	public AddCouponController() {
		// TODO Auto-generated constructor stub

	}
	
	@FXML
	public void initialize() {
		//ExpiryText.setPromptText(pattern.toLowerCase());
	}

	@FXML
	public void comboBoxClicked() {
		logger.info("ComboBox clicked.");
		comboBox.setItems(FXCollections.observableArrayList("Active", "Sold", "Expired"));
		comboBox.getSelectionModel().select(0);
	}

	@SuppressWarnings("deprecation")
	@FXML
	public void addButtonClicked() {
		logger.info("Add Button clicked.");
		if (!nameText.getText().equals("")) {
			Coupon newCoupon = new Coupon();
			newCoupon.setProvider(providerText.getText());
			newCoupon.setName(nameText.getText());
			newCoupon.setDiscount(Float.parseFloat(DiscountText.getText()));
			newCoupon.setPrice(Float.parseFloat(priceText.getText()));
			newCoupon.setStatus(comboBox.getSelectionModel().getSelectedItem());
			LocalDate local = ExpiryText.getValue();
			newCoupon.setExp(new Date(local.getYear(), local.getMonth().getValue(), local.getDayOfMonth()));
			
			logger.info("Adding coupon to cluster: " + newCoupon.toString());
			
			AtlasCouponDocument doc = AtlasCouponDocument.getInstance();
			doc.insert(newCoupon);
		}
	}

}
