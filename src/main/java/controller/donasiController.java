/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;


import database.DonasiDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.NewFXMain;
import model.Donasi;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class donasiController implements Initializable {

    @FXML
    private TextField nama;
    @FXML
    private TextField jumlah;
    @FXML
    private TextArea alamat;
    @FXML
    private ChoiceBox<String> kategori;
    
    private String[] kategoriDonasi = {"Sembako","Uang","Makanan & Minuman Siap Saji"};
    @FXML
    private Text myLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nama.setText(NewFXMain.akun.getNama());
        
        // TODO
        kategori.getItems().addAll(kategoriDonasi);
        kategori.getSelectionModel().select(0);
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
    private void moveToEmergency(MouseEvent event) throws IOException {
        NewFXMain.setRoot("emergency");
    }

    @FXML
    private void moveToRecipe(MouseEvent event) throws IOException {
        NewFXMain.setRoot("recipe");
    }

    @FXML
    private void moveToFoodInformation(MouseEvent event) throws IOException {
        NewFXMain.setRoot("foodInformation");
    }

    @FXML
    private void pilihanDonasi(MouseEvent event) {
    }

    @FXML
    private void UpdateDatabase(MouseEvent event) throws IOException {
        var dao = new DonasiDAO();
        NewFXMain.donasi = new Donasi();
        if (nama.getText().equals("") || jumlah.getText().equals("") 
                || alamat.getText().equals("") || kategori.getSelectionModel().getSelectedItem().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Send Donation failed");
            alert.setContentText("Columns can't be empty");
            alert.show();
            NewFXMain.setRoot("home");
        }else{
            NewFXMain.donasi.setPengirimDonasi(nama.getText());
            NewFXMain.donasi.setTanggalDonasi();
            NewFXMain.donasi.setJumlahDonasi(Integer.parseInt(jumlah.getText()));
            NewFXMain.donasi.setAlamat(alamat.getText());
            NewFXMain.donasi.setKategoriDonasi(kategori.getSelectionModel().getSelectedItem());
            
            dao.saveDonasi(NewFXMain.donasi);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Donation Succes");
            alert.setContentText("Donation has been inputed");
            alert.show();
            NewFXMain.setRoot("donasi");
        }
    }
    
}
