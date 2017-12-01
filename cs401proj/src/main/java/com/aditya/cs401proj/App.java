package com.aditya.cs401proj;

import org.apache.log4j.Logger;

import com.aditya.controllers.AddCouponController;
import com.aditya.controllers.ConfirmPageContoller;
import com.aditya.controllers.FinalPageController;
import com.aditya.controllers.ListAllPageController;
import com.aditya.controllers.LoginPageController;
import com.aditya.controllers.MainPageController;
import com.aditya.controllers.PurchaseController;
import com.aditya.controllers.SceneController;
import com.aditya.controllers.SearchPageController;
import com.aditya.coupans.Coupon;
import com.aditya.db.AtlasCouponDocument;
import com.aditya.list.AllCoupons;
import com.sun.javafx.application.LauncherImpl;

import insidefx.undecorator.Undecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Entry point class for the project!
 *
 */
public class App extends Application {

	private final static Logger logger = Logger.getLogger(App.class);
	private AllCoupons coupons;

	/**
	 * Entry Point of the application.
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("Start of the Project.");
		LauncherImpl.launchApplication(App.class, SplashScreenLoader.class, args);
		//launch(args);
		logger.info("End of the project.");
	}

	/**
	 * JavaFx implementation of the Application.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		populateLinkedList();
		primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResource("images\\A.jpg").toString()));
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		SceneController controller = SceneController.getInstance();
		controller.setStage(primaryStage);
		
		AddCouponController addcon = new AddCouponController();
		ConfirmPageContoller concon = new ConfirmPageContoller();
		FinalPageController fincon = new FinalPageController();
		ListAllPageController liscon = new ListAllPageController();
		LoginPageController logcon = new LoginPageController();
		MainPageController mancon = new MainPageController();
		SearchPageController seacon = new SearchPageController();
		PurchaseController purcon = new PurchaseController();

		logger.info("Adding all Scenes.");
		FXMLLoader loginLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml\\loginPage.fxml"));
		loginLoader.setController(logcon);
		Pane loginPage = loginLoader.load();

		FXMLLoader mainPageLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml\\MainPage.fxml"));
		mainPageLoader.setController(mancon);
		Pane mainPage = mainPageLoader.load();

		FXMLLoader searchPageLoader = new FXMLLoader(
				getClass().getClassLoader().getResource("fxml\\SearchCoupon.fxml"));
		searchPageLoader.setController(seacon);
		Pane searchPage = searchPageLoader.load();

		FXMLLoader addCouponPageLoader = new FXMLLoader(
				getClass().getClassLoader().getResource("fxml\\AddCoupon.fxml"));
		addCouponPageLoader.setController(addcon);
		Pane addPage = addCouponPageLoader.load();
		
		FXMLLoader confirmPageLoader = new FXMLLoader(
				getClass().getClassLoader().getResource("fxml\\ConfirmPage.fxml"));
		confirmPageLoader.setController(concon);
		Pane confirmPage = confirmPageLoader.load();
		
		FXMLLoader finalPageLoader = new FXMLLoader(
				getClass().getClassLoader().getResource("fxml\\FinalPage.fxml"));
		finalPageLoader.setController(fincon);
		Pane finalPage = finalPageLoader.load();
		
		FXMLLoader listPageLoader = new FXMLLoader(
				getClass().getClassLoader().getResource("fxml\\ListAllPage.fxml"));
		listPageLoader.setController(liscon);
		Pane listPage = listPageLoader.load();
		
		FXMLLoader purchasePageLoader = new FXMLLoader(
				getClass().getClassLoader().getResource("fxml\\purchaseCoupon.fxml"));
		purchasePageLoader.setController(purcon);
		Pane purchasePage = purchasePageLoader.load();

		Undecorator undecorate1 = new Undecorator(primaryStage, mainPage);
		undecorate1.getStylesheets().add(getClass().getClassLoader().getResource("css/undecorator.css").toString());
		
		Undecorator undecorate2 = new Undecorator(primaryStage, loginPage);
		undecorate2.getStylesheets().add(getClass().getClassLoader().getResource("css/undecorator.css").toString());
		
		Undecorator undecorate3 = new Undecorator(primaryStage, addPage);
		undecorate3.getStylesheets().add(getClass().getClassLoader().getResource("css/undecorator.css").toString());
		
		Undecorator undecorate4 = new Undecorator(primaryStage, searchPage);
		undecorate4.getStylesheets().add(getClass().getClassLoader().getResource("css/undecorator.css").toString());
		
		Undecorator undecorate5 = new Undecorator(primaryStage, confirmPage);
		undecorate5.getStylesheets().add(getClass().getClassLoader().getResource("css/undecorator.css").toString());
		
		Undecorator undecorate6 = new Undecorator(primaryStage, finalPage);
		undecorate6.getStylesheets().add(getClass().getClassLoader().getResource("css/undecorator.css").toString());
		
		Undecorator undecorate7 = new Undecorator(primaryStage, listPage);
		undecorate7.getStylesheets().add(getClass().getClassLoader().getResource("css/undecorator.css").toString());
		
		Undecorator undecorate8 = new Undecorator(primaryStage, purchasePage);
		undecorate8.getStylesheets().add(getClass().getClassLoader().getResource("css/undecorator.css").toString());
		
		
		Scene sceneLogin = new Scene(undecorate2);
		Scene sceneMain = new Scene(undecorate1);
		Scene scenesearch = new Scene(undecorate4);
		Scene sceneadd = new Scene(undecorate3);
		Scene confirmadd = new Scene(undecorate5);
		Scene finalPurchase = new Scene(undecorate6);
		Scene listAll = new Scene(undecorate7);
		Scene purScene = new Scene(undecorate8);

		controller.addScene("main", sceneMain);
		controller.addScene("login", sceneLogin);
		controller.addScene("search", scenesearch);
		controller.addScene("add", sceneadd);
		controller.addScene("confirm", confirmadd);
		controller.addScene("final", finalPurchase);
		controller.addScene("listall", listAll);
		controller.addScene("purchase", purScene);
		
		controller.setController("main", mancon);
		controller.setController("login", logcon);
		controller.setController("search", seacon);
		controller.setController("add", addcon);
		controller.setController("confirm", concon);
		controller.setController("final", fincon);
		controller.setController("listall", liscon);
		controller.setController("purchase", purcon);

		logger.info("All scene added.");
		controller.setScene("main");
		logger.info("Show the Stage.");
		primaryStage.show();
	}

	private void populateLinkedList() {
		logger.info("Loading all coupons in LinkedList.");
		Coupon[] all = AtlasCouponDocument.getInstance().getAll();
		coupons = AllCoupons.getInstance();
		for (Coupon one : all)
			coupons.addNewCoupon(one);

	}
}
