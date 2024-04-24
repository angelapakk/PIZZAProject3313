package com.example.pizzasystemv001;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class SignupController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @FXML
    private Button backToLogin;

    //----------------- Header Anchorpane scene changes -------------------------------------------------
    @FXML //Switches to the Main Menu scene when "Home" button is clicked
    public void loadPizzaIntro(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Pizza-Intro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    @FXML //Switches to the login scene when go back to login button is clicked
    public void loadLogin(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    @FXML //Switches to the Purchase scene when "My cart" button is clicked
    public void switchToPurchase(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Purchase.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMenu(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Pizza-Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    } //Switches straight to the pizza menu after you login


    //----------------- Allows for user to register their information-------------------------------------\
    @FXML
    private TextField userFirstName;
    @FXML
    private TextField userLastName;
    @FXML
    private TextField userPhoneNumber;
    @FXML
    private TextField userPassword;
    @FXML
    private Button registerUser;

    public void userRegister(ActionEvent event){
        String stringUserFirstName = userFirstName.getText();
        String stringUserLastName = userLastName.getText();
        String stringUserPhoneNumber = userPhoneNumber.getText();
        String stringUserPassword = userPassword.getText();
    }
}
