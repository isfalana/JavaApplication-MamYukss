/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import database.DonasiDAO;
import database.EmergencyFoodDAO;
import database.FoodInformationDAO;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.NewFXMain;
import model.Donasi;
import model.EmergencyFood;
import model.FoodInformation;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class emergencyController implements Initializable {

    @FXML
    private TextField nama;
    @FXML
    private ChoiceBox<String> kategori;
    
    private String[] kategoriDonasi = {"Sembako","Uang","Makanan & Minuman Siap Saji"};
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
     * Initializes the controller class
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nama.setText(NewFXMain.akun.getNama());
        // TODO
        kategori.getItems().addAll(kategoriDonasi);
        kategori.getSelectionModel().select(0);
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
    private void UpdateDatabase(MouseEvent event) throws IOException {
        var dao = new EmergencyFoodDAO();
        NewFXMain.emergency = new EmergencyFood();
        if (nama.getText().equals("") 
                || kategori.getSelectionModel().getSelectedItem().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pull Donation failed");
            alert.setContentText("Columns can't be empty");
            alert.show();
            NewFXMain.setRoot("emergency");
        }else{
            NewFXMain.emergency.setPenerimaDonasi(nama.getText());
            NewFXMain.emergency.setTanggalPermintaan();
            NewFXMain.emergency.setKategoriPermintaan(kategori.getSelectionModel().getSelectedItem());
            
            dao.save(NewFXMain.emergency);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pull donation Succes");
            alert.setContentText("Form has been inputed");
            alert.show();
            var dao2 = new FoodInformationDAO();
            var kupon = new FoodInformation();
            dao2.saveFoodInformation(kupon, NewFXMain.akun);
            NewFXMain.setRoot("kupon");
        }
    }

    @FXML
    private void moveToDonasi(MouseEvent event) throws IOException {
        NewFXMain.setRoot("donasi");
    }




    
}
