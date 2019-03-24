package com.codetreatise.controller;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.Writer;
import java.awt.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.codetreatise.config.StageManager;
import com.codetreatise.logging.ExceptionWriter;
import com.codetreatise.service.UserService;
import com.codetreatise.view.FxmlView;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;

import javafx.scene.input.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Controller
public class LoginController implements Initializable {

	@Autowired
	private UserService userService;

	private KeyEvent myEvent;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Button exitButton;

	@FXML
	private Label loginStatus;

	@FXML
	private ImageView usernameImage;

	@FXML
	private ImageView passwordImage;

	@FXML
	private Button btnLogin;

	@FXML
	public void handleLogin() throws SecurityException, IOException {

		if (userService.authenticate(getUsername(), getPassword())) {
//			System.out.println("BOOOM---- INSIDE if cc");
			stageManager.switchScene(FxmlView.APP);
		} else {
//			System.out.println("BOOOM---- INSIDE else failed");
			loginStatus.setText("Login failed");
		}

	}

	@FXML
	public void handleExit() {
		Stage primaryStage = (Stage) exitButton.getScene().getWindow();
		exitButton.setOnAction(actionEvent -> primaryStage.close());
	}

	@FXML
	public void usernameClicked() {
		usernameImage.setImage(new Image("images/ic_account_circle_blue_700_24dp.png"));
	}

	@FXML
	public void passwordClicked() {
		passwordImage.setImage(new Image("images/ic_vpn_key_blue_700_24dp.png"));
	}

	private String getUsername() {
		return username.getText();
	}

	private String getPassword() {
		return password.getText();
	}

	@FXML
	private void setAllInitFunctionalities() {
		System.out.println("inside initialize >>>>>>>>>>>>>>>>");
		System.out.println("inside setUserText >>>>>>>>>>>>>>>>");

		username.setOnKeyPressed((myEvent) -> {
			try {
				checkKeyPressed(myEvent);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		password.setOnKeyPressed((myEvent) -> {
			try {
				checkKeyPressed(myEvent);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		btnLogin.setOnKeyPressed((myEvent) -> {
			try {
				checkKeyPressed(myEvent);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		exitButton.setOnKeyPressed((myEvent) -> {
			try {
				checkKeyPressed(myEvent);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

//		btnLogin.setFocusTraversable(false);
//		exitButton.setFocusTraversable(false);
		System.out.println("username.isFocused() >>>>>" + username.isFocused());
		System.out.println("password.isFocused() >>>>>" + password.isFocused());
		System.out.println("btnLogin.isFocused() >>>>>" + btnLogin.isFocused());
		System.out.println("exitButton.isFocused() >>>>>" + exitButton.isFocused());
		System.out.println("After setUserText >>>>>>>>>>>>>>>>");
	}

	@FXML
	public void checkKeyPressed(javafx.scene.input.KeyEvent myEvent2) throws InterruptedException {

		System.out.println("inside setUsernameClickListener >>>>>>>>>>>>>>>>");
		KeyCode keycode = myEvent2.getCode();
		// char charTyped = myEvent2.getCharacter().charAt(0);

		System.out.println("intKeyCode >>>>>" + keycode);
		System.out.println("username.isFocused() >>>>>" + username.isFocused());
		System.out.println("password.isFocused() >>>>>" + password.isFocused());
		System.out.println("btnLogin.isFocused() >>>>>" + btnLogin.isFocused());
		System.out.println("exitButton.isFocused() >>>>>" + exitButton.isFocused());

		if ((keycode == KeyCode.TAB) && (username.isFocused() == true)) {
			System.out.println("BEFORE--username.isFocused-- INSIDE KEY_TYPED EVENT");
			System.out.println("NOW Password textField.isFocused-- INSIDE KEY_TYPED EVENT");
			password.requestFocus();
			wait();

		} else if ((keycode == KeyCode.TAB) && (password.isFocused() == true)) {
			System.out.println("BEFORE--password.isFocused-- INSIDE KEY_TYPED EVENT");
			System.out.println("NOW Exit button.isFocused-- INSIDE KEY_TYPED EVENT");
			btnLogin.requestFocus();
			wait();
		}

		else if ((keycode == KeyCode.TAB) && (btnLogin.isFocused() == true)) {
			System.out.println("BEFORE-Login-button.isFocused-- INSIDE KEY_TYPED EVENT");
			System.out.println("NOW Exit button.isFocused-- INSIDE KEY_TYPED EVENT");
			exitButton.requestFocus();
			wait();
		}

		else if ((keycode == KeyCode.ENTER) && (btnLogin.isFocused() == true)) {
			System.out.println("BEFORE-Login-button.isFocused-- INSIDE KEY_TYPED EVENT");
			System.out.println("NOW Exit button.isFocused-- INSIDE KEY_TYPED EVENT");
                    try {
                        handleLogin();
                    } catch (SecurityException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}

		else if ((keycode == KeyCode.TAB) && (exitButton.isFocused() == true)) {
			System.out.println("BEFORE--Exit button.isFocused-- INSIDE KEY_TYPED EVENT");
			System.out.println("NOW username textField.isFocused-- INSIDE KEY_TYPED EVENT");
			username.requestFocus();
			wait();
		} 

		else if ((keycode == KeyCode.ENTER) && (exitButton.isFocused() == true)) {
			System.out.println("BEFORE--Exit button.isFocused-- INSIDE KEY_TYPED EVENT");
			System.out.println("NOW username textField.isFocused-- INSIDE KEY_TYPED EVENT");
			handleExit();
		} else {
			System.out.println("NOW DOING NOTHING");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setAllInitFunctionalities();
	}
}
