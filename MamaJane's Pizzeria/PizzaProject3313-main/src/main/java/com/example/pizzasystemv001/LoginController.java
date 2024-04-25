package com.example.pizzasystemv001;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @FXML //Doesn't allow user to login unless the phonenumber and password are filled
    public void verification(ActionEvent event) throws IOException {
        UserInformation userInformation = new UserInformation();
        System.out.println(userInformation.getPhoneNumber());
        if(userPhoneNumber.getText().equals(userInformation.getPhoneNumber()) && userPassword.getText().equals(userInformation.getPassword())){

            switchToMenu(event);
        } else if (!userPhoneNumber.getText().equals(userInformation.getPhoneNumber()) || !userPassword.getText().equals(userInformation.getPassword())){
            lblWrong.setText("Wrong phone number or password, \nPlease Try Again.");
        }

    }

    public void switchToMenu(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("Pizza-Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    } //Switches straight to the pizza menu after you login

    @FXML //Switches to the Signup scene when "register now" button is clicked
    public void loadSignup(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("Signup.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    //----------------- Header Anchorpane scene changes -------------------------------------------------
    @FXML //Switches to the Main Menu scene when "Home" button is clicked
    public void loadPizzaIntro(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("Pizza-Intro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML //Switches to the Purchase scene when "My cart" button is clicked
    public void switchToPurchase(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("Purchase.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


    //----------------- Allows for user to register their information-------------------------------------
    @FXML
    private TextField userFirstName;
    @FXML
    private TextField userLastName;
    @FXML
    private TextField userPhoneNumber;
    @FXML
    private TextField userPassword;
    @FXML
    private Label lblWrong;
//    public void userRegister(ActionEvent event){
//         stringUserFirstName = userFirstName.getText();
//         stringUserLastName = userLastName.getText();
//         stringUserPhoneNumber = userPhoneNumber.getText();
//         stringUserPassword = userPassword.getText();
//    }

}