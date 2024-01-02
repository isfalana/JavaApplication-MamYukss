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
import main.NewFXMain;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class homeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void moveToDonasi(MouseEvent event) throws IOException {
        NewFXMain.setRoot("donasi");
    }

    @FXML
    private void moveToUser(MouseEvent event) throws IOException {
        NewFXMain.setRoot("user");
    }

    @FXML
    private void moveToEmergency(MouseEvent event) throws IOException {
        NewFXMain.setRoot("emergency");
    }

    @FXML
    private void moveToRecipe(MouseEvent event) throws IOException {
        NewFXMain.setRoot("recipe");
    }

    @FXML
    private void moveToFoodIformation(MouseEvent event) throws IOException {
        NewFXMain.setRoot("foodInformation");
    }

    @FXML
    private void moveToInputRecipe(MouseEvent event) throws IOException {
        NewFXMain.setRoot("inputRecipe");
    }
    
}
