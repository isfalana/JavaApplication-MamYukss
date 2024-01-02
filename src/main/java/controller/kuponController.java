/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import database.FoodInformationDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.NewFXMain;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class kuponController implements Initializable {

    @FXML
    private Text kuponUser;
    @FXML
    private Text kodeKupon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        var dao = new FoodInformationDAO();
        NewFXMain.kupon = dao.getKupon(NewFXMain.akun);
    }    

    @FXML
    private void moveToHome(MouseEvent event) throws IOException {
        NewFXMain.setRoot("home");
    }

    @FXML
    private void tampilakanKode(MouseEvent event) {
        if (NewFXMain.kupon != null) {
            kodeKupon.setText(NewFXMain.kupon.getKupon());
        } else {
            var alert = new Alert(Alert.AlertType.INFORMATION, "Awokawok, gak punya kupon");
            alert.show();
        }
    }

    @FXML
    private void moveToUser(MouseEvent event) throws IOException {
        NewFXMain.setRoot("user");
    }

    @FXML
    private void moveToDonasi(MouseEvent event) throws IOException {
        NewFXMain.setRoot("donasi");
    }

    @FXML
    private void moveToRecipe(MouseEvent event) throws IOException {
        NewFXMain.setRoot("recipe");
    }

    @FXML
    private void moveToFoodInformation(MouseEvent event) throws IOException {
        NewFXMain.setRoot("foodInformation");
    }
    
}
