package database;


import model.FoodInformation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Akun;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author HP
 */
public class FoodInformationDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private PreparedStatement stmt;
    private String query;
    
    public FoodInformationDAO(){
        url = "jdbc:mysql://localhost:3306/mamyukss";
        uname = "root";
        pass = "";
        this.setConnection();
    }
    
    private void setConnection() {
        try{
            con = DriverManager.getConnection(url, uname, pass);
        } catch(SQLException ex) {
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }
    
    public void saveFoodInformation(FoodInformation fi, Akun akun){
        try{
            query = "INSERT INTO tbl_information (kupon_map, idAkun) VALUES ('%s', %d)";
            query = String.format(query, fi.getKupon(), akun.getIdAkun());
            System.out.println(query);
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data berhasil di input"); 
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public FoodInformation getKupon(Akun akun) {
        FoodInformation foodInformation = null;
        try {
            query = "SELECT * FROM tbl_information WHERE idAkun = %d";
            query = String.format(query, akun.getIdAkun());
            System.out.println(query);
            var res = con.prepareStatement(query).executeQuery();
            if (res.next()) {
                foodInformation = new FoodInformation();
            }
        } catch (SQLException e) {
            System.out.println("error getting kupon : " + e.getMessage());
        }
        return foodInformation;
    }
    
    public void selectFoodINformation(FoodInformation fi){
        try{
            query = "SELECT * FROM `tbl_information`";
            System.out.println(query);
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data berhasil di input");
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    
}
