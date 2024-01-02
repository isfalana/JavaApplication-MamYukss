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
import javafx.scene.text.Text;
import main.NewFXMain;
import model.Donasi;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class donasiKuController implements Initializable {

    @FXML
    private Text namaUser;
    @FXML
    private TableView<Donasi> tabelDonasiKu;
    @FXML
    private TableColumn<Donasi, LocalDate> tanggalDonasiKu;
    @FXML
    private TableColumn<Donasi, Integer> jumlahDonasiKu;
    @FXML
    private TableColumn<Donasi, Donasi.KategoriDonasi> kategoriDonasiKu;
    @FXML
    private TableColumn<Donasi, String> alamatDonasiKu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        namaUser.setText(NewFXMain.akun.getNama());
        
        var dao = new DonasiDAO();
        ObservableList<Donasi> tabelObj = FXCollections.observableArrayList();
        tabelDonasiKu.setItems(tabelObj);
        tabelObj.addAll(dao.getAll(NewFXMain.akun));
        tanggalDonasiKu.setCellValueFactory(new PropertyValueFactory<>("tanggalDonasi"));
        alamatDonasiKu.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        jumlahDonasiKu.setCellValueFactory(new PropertyValueFactory<>("jumlahDonasi"));
        kategoriDonasiKu.setCellValueFactory(new PropertyValueFactory<>("kategoriDonasi"));
        
    }    

    @FXML
    private void moveToUser(MouseEvent event) throws IOException {
        NewFXMain.setRoot("user");
    }

    @FXML
    private void moveToHome(MouseEvent event) throws IOException {
        NewFXMain.setRoot("home");
    }

    @FXML
    private void moveToRecipe(MouseEvent event) throws IOException {
        NewFXMain.setRoot("recipe");
    }

    @FXML
    private void moveToDonasi(MouseEvent event) throws IOException {
        NewFXMain.setRoot("donasi");
    }

    @FXML
    private void moveToFoodInformation(MouseEvent event) throws IOException {
        NewFXMain.setRoot("foodInformation");
    }

    @FXML
    private void moveToEmergency(MouseEvent event) throws IOException {
        NewFXMain.setRoot("emergency");
    }
    
}
