/**
 * 
 */
package com.aditya.controllers;

import java.util.Collections;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.aditya.comparator.DiscountComparator;
import com.aditya.comparator.FinalComparator;
import com.aditya.comparator.NameComparator;
import com.aditya.comparator.PriceComparator;
import com.aditya.comparator.StatusComparator;
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
import javafx.util.Callback;

/**
 * @author Pravin Kulkarni
 *
 */
public class ListAllPageController implements Controller {
	private static Logger logger = Logger.getLogger(ListAllPageController.class);
	private LinkedList<Coupon> listLocal;
	@FXML
	Button purchase;
	@FXML
	ComboBox<String> combo1;
	@FXML
	ComboBox<String> combo2;
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

	/**
	 * 
	 */
	public ListAllPageController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	public void initialize() {
		combo1.setItems(FXCollections.observableArrayList("Name", "Status", "Price", "Discount", "Final Price"));
		combo2.setItems(FXCollections.observableArrayList("Low to High", "High to Low"));
		combo1.getSelectionModel().select(0);
		combo2.getSelectionModel().select(0);
		purchase.setDisable(true);
		listLocal = new LinkedList<>();
		com.aditya.list.LinkedList<Coupon> o = AllCoupons.getInstance().getList();
		listLocal = new LinkedList<>();
		for (int i = 0; i < o.getCount(); i++) {
			listLocal.add(o.get(i));
		}
		combo1.setOnAction((event) -> {
			sort();

		});

		combo2.setOnAction((event) -> {
			sort();
		});
	}

	public void sort() {
		if (combo1.getSelectionModel().getSelectedItem().equals("Name")) {
			if (combo2.getSelectionModel().getSelectedItem().equals("Low to High")) {
				Collections.sort(listLocal, new NameComparator());
				populate();
			} else {
				Collections.sort(listLocal, Collections.reverseOrder(new NameComparator()));
				populate();
			}
		} else if (combo1.getSelectionModel().getSelectedItem().equals("Status")) {
			if (combo2.getSelectionModel().getSelectedItem().equals("Low to High")) {
				Collections.sort(listLocal, new StatusComparator());
				populate();
			} else {
				Collections.sort(listLocal, Collections.reverseOrder(new StatusComparator()));
				populate();
			}
		}
		if (combo1.getSelectionModel().getSelectedItem().equals("Price")) {
			if (combo2.getSelectionModel().getSelectedItem().equals("Low to High")) {
				Collections.sort(listLocal, new PriceComparator());
				populate();
			} else {
				Collections.sort(listLocal, Collections.reverseOrder(new PriceComparator()));
				populate();
			}
		}
		if (combo1.getSelectionModel().getSelectedItem().equals("Discount")) {
			if (combo2.getSelectionModel().getSelectedItem().equals("Low to High")) {
				Collections.sort(listLocal, new DiscountComparator());
				populate();
			} else {
				Collections.sort(listLocal, Collections.reverseOrder(new DiscountComparator()));
				populate();
			}
		}
		if (combo1.getSelectionModel().getSelectedItem().equals("Final Price")) {
			if (combo2.getSelectionModel().getSelectedItem().equals("Low to High")) {
				Collections.sort(listLocal, new FinalComparator());
				populate();
			} else {
				Collections.sort(listLocal, Collections.reverseOrder(new FinalComparator()));
				populate();
			}
		}
	}

	public void populate() {
		logger.info("Populate the table");
		Coupon[] all = listLocal.toArray(new Coupon[listLocal.size()]);// AllCoupons.getInstance().getAllCoupon();
		addDataToTable(all);
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

}
