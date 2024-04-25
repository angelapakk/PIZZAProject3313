package com.example.pizzasystemv001;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class PurchaseController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    @FXML
    private TextArea taPurchaseSummary;
    @FXML
    private Label lblTotalPrice;
    SharedData sharedData = SharedData.getInstance();
    @FXML
    public void initialize() {
        Purchase.addOrder(Order.getOrders());
        double price = 0.00;
        for(int i = 1; i<=Order.getOrders().size(); i++){
            if(Purchase.getOrder(i).getPizza() == null && Purchase.getOrder(i).getDrink() != null){
                taPurchaseSummary.appendText("- Order Number: " + Purchase.getOrder(i).getOrderId() +  " Drink: " + Purchase.getOrder(i).getDrink().getBrand() + " Size: " + Purchase.getOrder(i).getDrink().getSize() + " Quantity: " + Purchase.getOrder(i).getDrink().getQuantity() + " Price: " + Purchase.getOrder(i).getDrink().getPrice() + "\n\n");
                price+= Purchase.getOrder(i).getDrink().getPrice() * Purchase.getOrder(i).getDrink().getQuantity();
            } else if(Purchase.getOrder(i).getDrink() == null && Purchase.getOrder(i).getPizza() != null){
                taPurchaseSummary.appendText("- Order Number: " + Purchase.getOrder(i).getOrderId()  + " Pizza: " + Purchase.getOrder(i).getPizza().getType() + " With " + Purchase.getOrder(i).getPizza().getToppings()+" Size: " + Purchase.getOrder(i).getPizza().getSize() + " Quantity: " + Purchase.getOrder(i).getPizza().getQuantity() + " Price: " + Purchase.getOrder(i).getPizza().getPrice() + "\n\n");
                price+= Purchase.getOrder(i).getPizza().getPrice() * Purchase.getOrder(i).getPizza().getQuantity();
            } else {
                taPurchaseSummary.appendText("Please Create an Order First!");
            }
        }
        sharedData.setSharedText(taPurchaseSummary.getText());
        lblTotalPrice.setText("Total Price: $" + price);
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
    @FXML //Switches to the login scene when go back to login button is clicked
    public void loadLogin(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("Login.fxml"));
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
    public void switchToMenu(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("Pizza-Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    } //Switches straight to the pizza menu after you login
    public void switchToReceipt(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(PizzaApplication.class.getResource("Receipt.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    } //Switches to receipt

}
