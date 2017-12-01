/**
 * 
 */
package com.aditya.controllers;

import org.apache.log4j.Logger;

import com.aditya.coupans.Coupon;
import com.aditya.list.AllCoupons;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

/**
 * @author Aditya Kulkarni
 *
 */
public class SearchPageController implements Controller {
	private static Logger logger = Logger.getLogger(SearchPageController.class);
	// private String comboSelection = "name";
	@FXML
	private ComboBox<String> comboBox;
	@FXML
	TextField searchText;
	@FXML
	private TableView<Coupon> tableView;
	@FXML
	private TableColumn<Coupon, String> name;
	@FXML
	private TableColumn<Coupon, String> provider;
	@FXML
	private TableColumn<Coupon, String> price;
	@FXML
	private TableColumn<Coupon, String> discount;
	@FXML
	private TableColumn<Coupon, String> expdate;
	@FXML
	private TableColumn<Coupon, String> status;
	@FXML
	Button purchase;
	private AllCoupons allcoupons;

	/**
	 * 
	 */
	public SearchPageController() {
		// TODO Auto-generated constructor stub
		 allcoupons = AllCoupons.getInstance();

	}

	@FXML
	public void comboClicked() {
		logger.info("ComboBox clicked.");
		comboBox.setItems(FXCollections.observableArrayList("Select", "Name", "Status", "Provider", "Price Less Than",
				"Price Greater Than"));
	}

	@SuppressWarnings("unchecked")
	
	public void displayBy(Coupon all[]) {
		logger.info("Search Button clicked.");
		// if (!searchText.getText().equals("")) {
		// Coupon[] all = allcoupons.getCouponthroughName(searchText.getText());
		if (all.length > 0)
			purchase.setDisable(false);
		ObservableList<Coupon> row = FXCollections.observableArrayList();
		for (int i = 0; i < all.length; i++) {
			row.add(all[i]);
		}
		name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Coupon, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Coupon, String> param) {
				// TODO Auto-generated method stub
				if (param.getValue() == null)
					return new SimpleStringProperty();

				return new SimpleStringProperty(param.getValue().getName());
			}
		});
		provider.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Coupon, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Coupon, String> param) {
						// TODO Auto-generated method stub
						return new SimpleStringProperty(param.getValue().getProvider());
					}
				});
		price.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Coupon, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Coupon, String> param) {
						// TODO Auto-generated method stub
						return new SimpleStringProperty(Float.toString(param.getValue().getPrice()));
					}
				});
		discount.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Coupon, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Coupon, String> param) {
						// TODO Auto-generated method stub
						return new SimpleStringProperty(Float.toString(param.getValue().getDiscount()));
					}
				});
		expdate.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Coupon, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Coupon, String> param) {
						// TODO Auto-generated method stub
						return new SimpleStringProperty(param.getValue().getExp().toString());
					}
				});

		status.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Coupon, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Coupon, String> param) {
						// TODO Auto-generated method stub
						if (param.getValue().getStatus() == null) {
							return new SimpleStringProperty();
						}
						return new SimpleStringProperty(param.getValue().getStatus());
					}
				});
		logger.info("Adding " + all.length + " rows in the table.");
		tableView.setItems(row);
		tableView.getColumns().setAll(name, provider, price, discount, expdate, status);
		// }
	}


	@FXML
	public void searchButtonClicked() {
		if(comboBox.getSelectionModel().getSelectedItem().equals("Name")) {
			Coupon[] all = allcoupons.getCouponthroughName(searchText.getText());
			displayBy(all);
		} else if(comboBox.getSelectionModel().getSelectedItem().equals("Status")) {
			Coupon[] all = allcoupons.getCouponthroughStatus(searchText.getText());
			displayBy(all);
		} else if(comboBox.getSelectionModel().getSelectedItem().equals("Provider")) {
			Coupon[] all = allcoupons.getCouponthroughProvider(searchText.getText());
			displayBy(all);
		} else if(comboBox.getSelectionModel().getSelectedItem().equals("Price Less Than")) {
			Coupon[] all = allcoupons.getCouponthroughPriceLess(searchText.getText());
			displayBy(all);
		} else if(comboBox.getSelectionModel().getSelectedItem().equals("Price Greater Than")) {
			Coupon[] all = allcoupons.getCouponthroughPriceGreater(searchText.getText());
			displayBy(all);
		}
	}

	public void purchasedButtonClicked() {
		if (tableView.getSelectionModel().getSelectedItem().getStatus().equalsIgnoreCase("Active")) {
			logger.info("Purchase Button clicked.");
			AllCoupons.getInstance().setSelected(tableView.getSelectionModel().getSelectedItem());
			SceneController.getInstance().setScene("confirm");
		} else {
			ConfirmPageContoller c = (ConfirmPageContoller) SceneController.getInstance().getController("confirm");
			c.printError();
			SceneController.getInstance().setScene("confirm");

		}
	}

	@FXML
	public void initialize() {

		purchase.setDisable(true);
	}
}
