/**
 * 
 */
package com.aditya.cs401proj;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Aditya Kulkarni
 *
 */
public class SplashScreenLoader extends Preloader {
	private ProgressBar bar;
	Stage stage;

	/**
	 * 
	 */
	public SplashScreenLoader() {
		// TODO Auto-generated constructor stub
	}

	private Scene createPreloaderScene() {
		bar = new ProgressBar();
		BorderPane p = new BorderPane();
		p.setCenter(bar);
		return new Scene(p, 300, 150);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		 this.stage = primaryStage;
		 primaryStage.setScene(createPreloaderScene());
		 primaryStage.show();
	}

	@Override
	public void handleProgressNotification(ProgressNotification pn) {
		bar.setProgress(pn.getProgress());
	}

	@Override
	public void handleStateChangeNotification(StateChangeNotification evt) {
		if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
			stage.hide();
		}
	}

}
