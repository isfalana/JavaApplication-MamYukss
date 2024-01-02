package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Akun;
import model.Donasi;
import model.EmergencyFood;
import model.FoodInformation;
import model.ResepMakanan;

/**
 *
 * @author HP
 */
public class NewFXMain extends Application {
    public static ResepMakanan resep;
    public static EmergencyFood emergency;
    public static Donasi donasi;
    public static Akun akun;
    public static FoodInformation kupon;
    private static Scene scene;
    
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    public static Parent loadFXML(String fxml) throws IOException {
        URL url = new File("src/main/java/view/" + fxml + ".fxml").toURI().toURL();
        return FXMLLoader.load(url);
    }
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
