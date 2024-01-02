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
public class forgotPasswordController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField newPassword;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UpdateDatabase(MouseEvent event) throws IOException {
        var dao = new AkunDAO();
        dao.forgotPassword(email.getText(),username.getText(), newPassword.getText());
        NewFXMain.akun = dao.login(username.getText(), newPassword.getText());
        if (NewFXMain.akun != null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acces Succes");
            alert.setContentText("Password successfully changed");
            alert.show();
            NewFXMain.setRoot("Login");
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acces failed");
            alert.setContentText("Password failed to change");
            alert.show();
        }
    }

    @FXML
    private void moveToLogin(MouseEvent event) throws IOException {
        NewFXMain.setRoot("Login");
    }
    
}
