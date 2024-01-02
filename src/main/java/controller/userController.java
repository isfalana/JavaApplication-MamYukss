/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.NewFXMain;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class userController implements Initializable {

    @FXML
    private Text namaUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        namaUser.setText(NewFXMain.akun.getNama());
    }    

    @FXML
    private void moveToLogin(MouseEvent event) throws IOException{
        NewFXMain.setRoot("Login");
    }

    @FXML
    private void moveToHome(MouseEvent event) throws IOException{
        NewFXMain.setRoot("home");
    }


    @FXML
    private void moveToEmergency(MouseEvent event) throws IOException{
        NewFXMain.setRoot("emergency");
    }

    @FXML
    private void moveToRecipe(MouseEvent event) throws IOException{
        NewFXMain.setRoot("recipe");
    }

    @FXML
    private void moveToFoodInformation(MouseEvent event) throws IOException{
        NewFXMain.setRoot("foodInformation");
    }

    @FXML
    private void moveToDonasi(MouseEvent event) throws IOException{
        NewFXMain.setRoot("donasi");
    }

    @FXML
    private void moveToDonasiKu(MouseEvent event) throws IOException {
        NewFXMain.setRoot("donasiKu");
    }

    @FXML
    private void moveToKupon(MouseEvent event) throws IOException {
        NewFXMain.setRoot("kupon");
    }
    
}
