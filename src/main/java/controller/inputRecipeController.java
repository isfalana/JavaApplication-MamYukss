/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import database.ResepDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.NewFXMain;
import model.ResepMakanan;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class inputRecipeController implements Initializable {

    @FXML
    private TextField nama;
    @FXML
    private Text myLabel;
    private TextArea alamat;
    @FXML
    private Text myLabel1;
    @FXML
    private TextArea equipment;
    @FXML
    private TextArea ingredients;
    @FXML
    private TextArea steps;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void moveToHome(MouseEvent event) throws IOException {
        NewFXMain.setRoot("home");
    }

    @FXML
    private void moveToUser(MouseEvent event) throws IOException {
        NewFXMain.setRoot("user");
    }

    @FXML
    private void moveToDonasi(MouseEvent event) throws IOException{
        NewFXMain.setRoot("donasi");
    }

    @FXML
    private void moveToFoodInformation(MouseEvent event) throws IOException{
        NewFXMain.setRoot("foodInformation");
    }

    @FXML
    private void moveToEmergency(MouseEvent event) throws IOException{
        NewFXMain.setRoot("emergency");
    }

    @FXML
    private void UpdateDatabase(MouseEvent event) throws IOException {
        var dao = new ResepDAO();
        NewFXMain.resep = new ResepMakanan();
        if (nama.getText().equals("") || ingredients.getText().equals("") 
                || equipment.getText().equals("") || steps.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Send Donation failed");
            alert.setContentText("Columns can't be empty");
            alert.show();
            NewFXMain.setRoot("recipe");
            
        }else{
            NewFXMain.resep.setNamaMakanan(nama.getText());
            NewFXMain.resep.setDaftarBahan(ingredients.getText());
            NewFXMain.resep.setDaftarAlat(equipment.getText());
            NewFXMain.resep.setLangkahLangkah(steps.getText());
                        
            dao.saveResepMakanan(NewFXMain.resep);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Donation Succes");
            alert.setContentText("Donation has been inputed");
            alert.show();
            NewFXMain.setRoot("donasi");
        }
    }
    
}
