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
import model.Akun;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class RegisterController implements Initializable {

    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private TextField nama;
    @FXML
    private TextField noTelepon;
    @FXML
    private TextField alamat;
    @FXML
    private TextField username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pindahLogin(MouseEvent event) throws IOException {
        NewFXMain.setRoot("Login");
    }

    private void pindahForgotPassword(MouseEvent event) throws IOException {
        NewFXMain.setRoot("forgotPassword");
    }

    @FXML
    private void moveToLogin(MouseEvent event) throws IOException{
            var dao = new AkunDAO();
            NewFXMain.akun = new Akun();
        if (nama.getText().equals("") || email.getText().equals("") 
                || noTelepon.getText().equals("") || alamat.getText().equals("") 
                || username.getText().equals("") || password.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register failed");
            alert.setContentText("Columns can't be empty");
            alert.show();
            NewFXMain.setRoot("register");
        }else{
            NewFXMain.akun.setNama(nama.getText());
            NewFXMain.akun.setEmail(email.getText());
            NewFXMain.akun.setNoTelepon(noTelepon.getText());
            NewFXMain.akun.setAlamat(alamat.getText());
            NewFXMain.akun.setUsername(username.getText());
            NewFXMain.akun.setPassword(password.getText());
            dao.save(NewFXMain.akun);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Succes");
            alert.setContentText("Your account has been created");
            alert.show();
            NewFXMain.setRoot("Login"); 
        }
    }
    
}
