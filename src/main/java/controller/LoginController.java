/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import database.AkunDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.NewFXMain;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void pindahRegister(MouseEvent event) throws IOException {
        NewFXMain.setRoot("register");
    }

    @FXML
    private void pindahForgotPassword(MouseEvent event) throws IOException {
        NewFXMain.setRoot("forgotPassword");
    }

    @FXML
    private void moveToHome(MouseEvent event) throws IOException {
        var dao = new AkunDAO();
        NewFXMain.akun = dao.login(username.getText(), password.getText());
        if (NewFXMain.akun != null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Succes");
            alert.setContentText("You've successfully signed in");
            alert.show();
            NewFXMain.setRoot("home");
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login failed");
            alert.setContentText("Your username and password are incorrect");
            alert.show();
        }
        
    }
    
}
