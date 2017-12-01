/**
 * 
 */
package com.aditya.controllers;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Aditya Kulkarni
 *
 */
public class SceneController {
private static HashMap<String, Scene> allScenes;
private static HashMap<String, Controller> allControllers;
private static SceneController instance;
private static Stage stage;
	/**
	 * 
	 */
	private SceneController() {
		// TODO Auto-generated constructor stub
		allScenes = new HashMap<>();
		allControllers = new HashMap<>();
	}
	
	public static synchronized SceneController getInstance() {
		if (instance == null) {
			instance = new SceneController();
		}
		return instance;
	}
	
	public void setStage(Stage stage) {
		SceneController.stage = stage;
	}
	
	public Scene getScene(String key) {
		return allScenes.get(key);
	}
	
	public void setScene(String key) {
		stage.setScene(allScenes.get(key));
	}
	
	public void addScene(String key, Scene scene) {
		allScenes.put(key, scene);
	}
	
	public void setController(String key, Controller value) {
		allControllers.put(key, value);
	}
	
	public Controller getController(String key) {
		return allControllers.get(key);
	}

}
