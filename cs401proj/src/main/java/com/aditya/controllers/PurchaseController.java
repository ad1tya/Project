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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * @author Pravin Kulkarni
 *
 */
public class PurchaseController implements Controller {

	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(PurchaseController.class);
	@FXML
	Button purchase;
	@FXML
	private TableView<Coupon> tableView;
	@FXML
	TableColumn<Coupon, String> name;
	@FXML
	TableColumn<Coupon, String> provider;
	@FXML
	TableColumn<Coupon, String> price;
	@FXML
	TableColumn<Coupon, String> discount;
	@FXML
	TableColumn<Coupon, String> expdate;
	@FXML
	TableColumn<Coupon, String> status;
	@FXML
	TableColumn<Coupon, String> finalprice;

	public PurchaseController() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public void addDataToTable(Coupon[] all) {
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

		finalprice.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Coupon, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<Coupon, String> param) {
						// TODO Auto-generated method stub
						Coupon c = param.getValue();
						float total_price = (c.getPrice() - (c.getPrice() * (c.getDiscount() / 100)));
						return new SimpleStringProperty(Float.toString(total_price));
					}
				});
		tableView.setItems(row);
		tableView.getColumns().setAll(name, provider, price, discount, expdate, status, finalprice);
	}
	
	@FXML
	public void purchasedButtonClicked() {
		logger.info("Purchase Button clicked.");
		AllCoupons.getInstance().setSelected(tableView.getSelectionModel().getSelectedItem());
		SceneController.getInstance().setScene("confirm");
	}
}
