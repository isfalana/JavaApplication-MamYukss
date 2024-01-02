package database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import model.Donasi;
import model.Akun;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author HP
 */
public class DonasiDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private PreparedStatement stmt;
    private String query;
    
    public DonasiDAO()
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
    
    public void saveDonasi(Donasi donasi){
        try{
            query = "INSERT INTO tbldonasi(id_Donasi, tanggal_donasi, pengirim_donasi, jumlah_donasi, kategori_donasi, alamat) VALUES (%d, '%s', '%s', %d, '%s', '%s')";
            query = String.format(
                    query,
                    donasi.getIdDonasi(),
                    donasi.getTanggalDonasi(),
                    donasi.getPengirimDonasi(),
                    donasi.getJumlahDonasi(),
//                    donasi.getStatusDonasi(),
                    donasi.getKategoriDonasi(),
                    donasi.getAlamat());
            System.out.println(query);
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Data berhasil di input");
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public void deleteDonasi(Donasi donasi){
        try{
            query = "DELETE FROM tbldonasi WHERE id_Donasi = %d";
            query = String.format(query, donasi.getIdDonasi());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Berhasil inserting Data");
        }catch(SQLException ex){
            System.err.print("Error inserting Data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public void selectDonasiById(Donasi donasi){
        try{
            query = "SELECT FROM tbldonasi WHERE id_Donasi = %d";
            query = String.format(query, donasi.getIdDonasi());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Berhasil menampilkan data");
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
    
    public ArrayList<Donasi> getAll(Akun akun){
        var hasilUsername = new ArrayList<Donasi>();
        try{
            query = "SELECT * FROM tbldonasi WHERE pengirim_donasi = '%s'";
            query = String.format(query, akun.getNama());
            var result = con.prepareStatement(query).executeQuery();
            while (result.next()) {
                var selectDonasi = new Donasi();
                selectDonasi.setIdDonasi(result.getString("id_Donasi"));
                selectDonasi.setTanggalDonasi(result.getDate("tanggal_donasi"));
                selectDonasi.setPengirimDonasi(result.getString("pengirim_donasi"));
                selectDonasi.setJumlahDonasi(result.getInt("jumlah_donasi"));
                selectDonasi.setKategoriDonasi(result.getString("kategori_donasi"));
                selectDonasi.setAlamat(result.getString("alamat"));
                hasilUsername.add(selectDonasi);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return hasilUsername;
    }
    
    public ArrayList<Donasi> getAll() {
        var hasil = new ArrayList<Donasi>();
        try {
            query = "SELECT * FROM tbldonasi";
            var res = con.prepareStatement(query).executeQuery();
            while (res.next()) {
                var donasi = new Donasi();
                donasi.setIdDonasi(res.getString("id_Donasi"));
                donasi.setTanggalDonasi(res.getDate("tanggal_donasi"));
                donasi.setPengirimDonasi(res.getString("pengirim_donasi"));
                donasi.setJumlahDonasi(res.getInt("jumlah_donasi"));
                donasi.setKategoriDonasi(res.getString("kategori_donasi"));
                donasi.setAlamat(res.getString("alamat"));
                hasil.add(donasi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasil;
    }
    
    public void updateDonasi(Donasi donasi){
        try{
            query = "UPDATE tbldonasi SET tanggal_donasi = '%s', pengirim_donasi = '%s', jumlah_donasi = %d, status_donasi = %s, kategori_donasi = '%s', `alamat` = '%s' WHERE tbldonasi.id_Donasi = %d";
            query = String.format(query,
                    donasi.getTanggalDonasi(),
                    donasi.getPengirimDonasi(),
                    donasi.getJumlahDonasi(),
                    donasi.getStatusDonasi(),
                    donasi.getKategoriDonasi(),
                    donasi.getAlamat(),
                    donasi.getIdDonasi());
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            System.out.println("Berhasil mengupdate data");
        }catch(SQLException ex){
            System.err.print("Error inserting data" + ex.getMessage());
            System.exit(1);
        }
    }
}
