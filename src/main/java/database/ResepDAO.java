package database;


import model.ResepMakanan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author HP
 */
public class ResepDAO {
    private Connection con;
    private final String u;
    private final String uname;
    private final String pass;
    private PreparedStatement stmt;
    private String query;
    
    public ResepDAO(){
        u = "jdbc:mysql://localhost:3306/mamyukss";
        uname = "root";
        pass = "";
        this.setConnection();
    }
    
    private void setConnection() {
        try{
            System.out.println(con);
            con = DriverManager.getConnection(u, uname, pass);
        } catch(SQLException ex) {
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }
    
    public void saveResepMakanan(ResepMakanan rm){
        setConnection();
        try{
            query = "INSERT INTO tblresep(nama_makanan, daftar_bahan, daftar_alat, langkah_langkah, id_resep) VALUES ('%s', '%s', '%s', '%s', %d)";
            query = String.format(query,
                    rm.getNamaMakanan(),
                    rm.getDaftarBahan(),
                    rm.getDaftarAlat(),
                    rm.getLangkahLangkah(),
                    rm.getIdResepMakanan());
            System.out.println(query);
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data berhasil di input"); 
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public ArrayList<ResepMakanan> getAll(){
        var hasil = new ArrayList<ResepMakanan>();
        try{
            query = "SELECT * FROM tblresep";
            var res = con.prepareStatement(query).executeQuery();
            while (res.next()) {
                    var resep = new ResepMakanan();
                    resep.setNamaMakanan(res.getString("nama_makanan"));
                    resep.setDaftarBahan(res.getString("daftar_bahan"));
                    resep.setDaftarAlat(res.getString("daftar_alat"));
                    resep.setLangkahLangkah(res.getString("langkah_langkah"));
                    hasil.add(resep);
            }
        } catch(SQLException ex){
            System.err.println("Error get Resep " + ex.getMessage());
        }
        return hasil;
    }
    
    public void deleteResepMakanan(ResepMakanan rm){
        try{
            query = "DELETE FROM tblresep WHERE `tblresep`.`id_resep` = %d";
            query = String.format(query,
                    rm.getIdResepMakanan());
            System.out.println(query);
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data berhasil di input");
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public void selectResepMakanan(ResepMakanan rm){
        try{
            query = "SELECT * FROM `tblresep`";
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
