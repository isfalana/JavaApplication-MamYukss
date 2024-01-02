/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import database.ResepDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import model.ResepMakanan;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class recipeController implements Initializable {

    @FXML
    private Text namaUser;
    @FXML
    private TableView<ResepMakanan> tabelResep;
    @FXML
    private TableColumn<ResepMakanan, String> namaMakanan;
    @FXML
    private TableColumn<ResepMakanan, String> daftarBahan;
    @FXML
    private TableColumn<ResepMakanan, String> daftarAlat;
    @FXML
    private TableColumn<ResepMakanan, String> langkahLangkah;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        var dao = new ResepDAO();
        var listResep = dao.getAll();
        ObservableList<ResepMakanan> tabelOb = FXCollections.observableArrayList();
        tabelResep.setItems(tabelOb);
        tabelOb.addAll(listResep);
        namaMakanan.setCellValueFactory(new PropertyValueFactory<>("namaMakanan"));
        daftarBahan.setCellValueFactory(new PropertyValueFactory<>("daftarBahan"));
        daftarAlat.setCellValueFactory(new PropertyValueFactory<>("daftarAlat"));
        langkahLangkah.setCellValueFactory(new PropertyValueFactory<>("langkahLangkah"));
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

    private void moveToRecipe(MouseEvent event) throws IOException {
        NewFXMain.setRoot("recipe");
    }

    @FXML
    private void moveToFoodInformation(MouseEvent event) throws IOException {
        NewFXMain.setRoot("foodInformation");
    }

    @FXML
    private void moveToDonasi(MouseEvent event) throws IOException{
        NewFXMain.setRoot("donasi");
    }

    @FXML
    private void UpdateDatabase(MouseEvent event) throws IOException {
        NewFXMain.setRoot("inputRecipe");
                
    }
    
}
