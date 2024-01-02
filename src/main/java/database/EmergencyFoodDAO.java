package database;


import model.EmergencyFood;
import model.Akun;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author HP
 */
public class EmergencyFoodDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private PreparedStatement stmt;
    private String query;
    
    public EmergencyFoodDAO(){
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
    
    public void save(EmergencyFood ef){
        try{
            query = "INSERT INTO tblemergency(id_permintaan, tanggal_permintaan, kategori_permintaan, penerima_donasi) VALUES (%d, '%s', '%s', '%s')";
            query = String.format(query, 
                    ef.getIdPermintaan(),
                    ef.getTanggalPermintaan(),
                    ef.getKategoriPermintaan(),
                    ef.getPenerimaDonasi());
            System.out.println(query);
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data berhasil di input");
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public void deleteEmergencyFood(EmergencyFood ef){
        try{
            query = "DELETE FROM tblemergency WHERE id_permintaan = %d";
            query = String.format(query,
                ef.getIdPermintaan());
            System.out.println(query);
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data berhasil di input");
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public void selectEmergencyFoodById(EmergencyFood ef){
        try{
            query = "SELECT FROM tblemergency WHERE id_permintaan = %d";
            query =String.format(query,
                    ef.getIdPermintaan());
            System.out.println(query);
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data berhasil di input");
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1); 
        }
    }
    
    public void selectEmergencyFood(EmergencyFood ef){
        try{
            query = "SELECT FROM tbldonasi";
            query = String.format(query);
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
