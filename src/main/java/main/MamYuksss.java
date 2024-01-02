package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MamYuksss {
    public static void main(String[] args) {
//        var donasiDAO = new DonasiDAO();
//        String url = "jdbc:mysql://localhost:3306/mamyukss";
//        String username = "root";
//        String password = "";
//        var a1 = new Akun();
//        var a2 = new Akun();
//        a2.setNama("Nadya");
//        a1.setNama("Lana");
//        
//        var d1 = new Donasi();
//        d1.setAlamat("Pwk");
//        d1.setJumlahDonasi(10);
//        d1.setKategoriDonasi(Donasi.KategoriDonasi.Sembako);
//        d1.setPengirimDonasi(a1);
//        d1.setTanggalDonasi();
//        d1.setStatusDonasi(true);
//        
//        donasiDAO.save(d1, a1);
        
        

//        try (Connection connection = DriverManager.getConnection(url, username, password)) {
//            // Gantilah objek akun dengan objek Akun yang sesuai di aplikasi Anda
//            Akun akun = new Akun();
//            akun.setIdAkun(2);  // Ganti dengan ID yang sesuai
//            akun.setUsername("lana");
//            akun.setPassword("gatau");
//            akun.setEmail("new_email");
//            akun.setNama("new_nama");
//            akun.setAlamat("new_alamat");
//            akun.setNoTelepon("new_no_telepon");
//            
//
//            String query = "UPDATE tblakun SET Username=?, Password=?, Email=?, Nama=?, Alamat=?, noTelepon=? WHERE tblakun.idAkun=?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, akun.getUsername());
//                preparedStatement.setString(2, akun.getPassword());
//                preparedStatement.setString(3, akun.getEmail());
//                preparedStatement.setString(4, akun.getNama());
//                preparedStatement.setString(5, akun.getAlamat());
//                preparedStatement.setString(6, akun.getNoTelepon());
//                preparedStatement.setInt(7, akun.getIdAkun());
//
//                int rowsAffected = preparedStatement.executeUpdate();
//                System.out.println("Berhasil mengupdate data! Jumlah baris yang terpengaruh: " + rowsAffected);
//            } catch (SQLException ex) {
//                System.err.print("Error updating data: " + ex.getMessage());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
