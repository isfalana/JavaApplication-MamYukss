/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import database.DonasiDAO;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.NewFXMain;
import model.Donasi;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class foodInformationController implements Initializable {

    @FXML
    private TableView<Donasi> tabel;
    @FXML
    private TableColumn<Donasi, LocalDate> kolomTanggal;
    @FXML
    private TableColumn<Donasi, String> kolomPengirim;
    @FXML
    private TableColumn<Donasi, Integer> kolomJumlah;
    @FXML
    private TableColumn<Donasi, Donasi.KategoriDonasi> kolomKategori;
    @FXML
    private TableColumn<Donasi, String> kolomAlamat;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        var dao = new DonasiDAO();
        ObservableList<Donasi> tabelObj = FXCollections.observableArrayList();
        tabel.setItems(tabelObj);
        tabelObj.addAll(dao.getAll());
        kolomTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggalDonasi"));
        kolomAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        kolomJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlahDonasi"));
        kolomKategori.setCellValueFactory(new PropertyValueFactory<>("kategoriDonasi"));
        kolomPengirim.setCellValueFactory(new PropertyValueFactory<>("pengirimDonasi"));
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

    private void moveToFoodInformation(MouseEvent event) throws IOException {
        NewFXMain.setRoot("foodInformation");
    }

    @FXML
    private void moveToDonasi(MouseEvent event) throws IOException {
        NewFXMain.setRoot("donasi");
    }

    private void moveToLogin(MouseEvent event) throws IOException {
        NewFXMain.setRoot("Login");
    }

    @FXML
    private void UpdateDatabase(MouseEvent event) throws IOException {
        NewFXMain.setRoot("emergency");
                
    }
    
}
