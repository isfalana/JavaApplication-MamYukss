package database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author HP
 */

import model.Akun;
import java.sql.*;
import java.util.Locale;


public class AkunDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private PreparedStatement stmt;
    private String query;
    
    public AkunDAO()
    {
        url = "jdbc:mysql://localhost:3306/mamyukss";
        uname = "root";
        pass = "";
        this.setConnection();
    }
    
    private void setConnection(){
        try{
            con = DriverManager.getConnection(url, uname, pass);
        } catch(SQLException ex) {
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }
    
    public void save(Akun akun){
        setConnection();
        try{
            query = "INSERT INTO tblakun VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s')";
            query = String.format(
            query,
              akun.getIdAkun(),
              akun.getUsername(),
              akun.getPassword(),
              akun.getEmail(),
              akun.getNama(),
              akun.getAlamat(),
              akun.getNoTelepon());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Berhasil menambah data!");
        } catch(SQLException ex){
            System.err.print("Error inserting data: " + ex.getMessage());
            System.exit(1);
        }
    }
    
    public Akun login(String username, String password){
        setConnection();
        Akun akun = null;
        try {
            query = "SELECT * FROM tblakun WHERE username = '%s' AND password = '%s'";
            query = String.format(
                    query,
                    username,
                    password);
            var rs = con.prepareStatement(query).executeQuery();
            if (rs.next()) {
                var idAkun = rs.getInt("idAkun");
                var email = rs.getString("Email");
                var nama = rs.getString("Nama");
                var alamat = rs.getString("Alamat");
                var noTelp = rs.getString("noTelepon");
                
                akun = new Akun(idAkun, username, password, email, nama, alamat, noTelp);
            }
            System.out.println("Berhasil menampilkan data");
        } catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
        return akun;
    }
    
    public void forgotPassword(String email, String username, String password){
        setConnection();
        try {
            query = "UPDATE tblakun SET `Password` = '%s' WHERE Email = '%s' AND Username = '%s'";
            query = String.format(query,password,email,username);
            con.prepareStatement(query).executeUpdate();
            System.out.println("Berhasil update data");
        } catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public void updateAkun(Akun akun){
        try{
            query = "UPDATE tblakun SET Username = '%s', Password = '%s', Email = '%s', Nama = '%s', Alamat = '%s', noTelepon = '%s' WHERE tblakun.idAkun = '%d'";
            query = String.format(
            query,
                    akun.getUsername(),
                    akun.getPassword(),
                    akun.getEmail(),
                    akun.getNama(),
                    akun.getAlamat(),
                    akun.getNoTelepon(),
                    akun.getIdAkun());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Berhasil mengupdate data!");
        }catch(SQLException ex) {
            System.err.print("Error insering data: " + ex.getMessage());
            System.exit(1);
        }
    }
    public boolean deleteAkunById(int idAkun) {
        String query = "DELETE FROM tblakun WHERE idAkun = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, idAkun);

            int rowsDeleted = preparedStatement.executeUpdate();

            // Jika ada baris yang terhapus, mengembalikan true
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void selectAkun(Akun akun){
        try {
            query = "SELECT * FROM tblakun WHERE idAkun = %d";
            query = String.format(
                    query,
                    akun.getIdAkun());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Berhasil menampilkan data");
        } catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
}
    //    public void saveAkun(String username, String password, String email, String nama, String alamat, String jenisKelamin, String noTelepon) {
//    // Assuming you have a Connection object named 'connection' already established.
//    Database db = new Database();
////    Connection connection = db.connection();
//
//    try {
//        String query = "INSERT INTO `tblakun` " +
//                "(`Id_Akun`, `Username`, `Password`, `Email`, `Nama`, `Alamat`, `Jenis_Kelamin`, `No_telepon`) " +
//                "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//        // Set the parameter values using the provided method arguments
//        preparedStatement.setString(1, username);
//        preparedStatement.setString(2, password);
//        preparedStatement.setString(3, email);
//        preparedStatement.setString(4, nama);
//        preparedStatement.setString(5, alamat);
//        preparedStatement.setString(6, jenisKelamin);
//        preparedStatement.setString(7, noTelepon);
//
//        // Execute the INSERT statement
//        int rowsInserted = preparedStatement.executeUpdate();
//
//        if (rowsInserted > 0) {
//            System.out.println("A new Akun was saved successfully.");
//        } else {
//            System.out.println("Failed to save the Akun.");
//        }
//
//        // Close the PreparedStatement
//        preparedStatement.close();
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//        // Handle any SQL-related exceptions here.
//    }
//}
