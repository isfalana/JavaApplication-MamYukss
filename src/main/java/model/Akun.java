package model;



import database.Database;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Akun {

    public static enum JenisKelamin {
    Lakilaki,
    Perempuan,
    }
    private int idAkun;
    private String username;
    private String password;
    private String email;
    public String nama;
    private Donasi riwayatDonasi;
    private String alamat;
    private JenisKelamin jenisKelamin;
    private String noTelepon;
    private ResepMakanan resepMakanan;
    private boolean isLoggedIn;
    private Database db = new Database();
    

    public Akun(int idAkun, String username, String password, String email, String nama, Donasi riwayatDonasi, String alamat, JenisKelamin jenisKelamin, String noTelepon, boolean isLoggedIn) {
        this.idAkun = idAkun;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
        this.riwayatDonasi = riwayatDonasi;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.noTelepon = noTelepon;
        this.isLoggedIn = isLoggedIn;
    }

    public Akun( String username, String password, String email, String nama, String alamat, JenisKelamin jenisKelamin, String noTelepon) {
//        this.idAkun = idAkun;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.noTelepon = noTelepon;
    }
        
    public Akun(int idAkun, String username, String password, String email, String nama, String alamat, String noTelepon) {
        this.idAkun = idAkun;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
        this.alamat = alamat;
//        this.jenisKelamin = jenisKelamin;
        this.noTelepon = noTelepon;
    }

    public Akun( String username, String password, String email, String nama, String alamat, String noTelepon) {
//        this.idAkun  = idAkun;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }
    
    public Akun(){
    }

    public Akun(Database db) {
        this.db = db;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public String getNoTelepon() {
        return noTelepon;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJenisKelamin() {
        switch (jenisKelamin) {
            case Lakilaki -> {
                return "Laki-laki";
                }
            case Perempuan -> {
                return "Perempuan";
                }
        }
        return null;
    }
    
    public void setIdAkun(int idAkun){
        this.idAkun = idAkun;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void setNoTelepon(String noTelepon){
        this.noTelepon = noTelepon;
    }
    
   
}
//    public void setJenisKelamin(String jenisKelamin) {
//        this.jenisKelamin = jenisKelamin;
//    }

//    public void setNoTelepon(String noTelepon) {
//        this.noTelepon = noTelepon;
//    }
    
    




//public class Akun {
//    private String username;
//    private String password;
//    private String email;
//    private String nama;
//    private String fotoProfil;
//    private Donasi[] riwayatDonasi;
//    private String alamat;
//    private String jenisKelamin;
//    private String noTelepon;
//    private boolean isLoggedIn;
//    
//    public Akun(String username, String password, String email, String nama, String fotoProfil,
//                String alamat, String jenisKelamin, String noTelepon) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.nama = nama;
//        this.fotoProfil = fotoProfil;
//        this.riwayatDonasi = 0;
//        this.alamat = alamat;
//        this.jenisKelamin = jenisKelamin;
//        this.noTelepon = noTelepon;
//        this.isLoggedIn = false;
//    }
//    
//    public boolean login(String inputUsername, String inputPassword) {
//        if (inputUsername.equals(username) && inputPassword.equals(password)) {
//            isLoggedIn = true;
//            return true;
//        }
//        return false;
//    }
//    
//    public void logout() {
//        isLoggedIn = false;
//    }
//    
//    public Donasi tambahDonasi(long jumlahDonasi, String alamat, String kategori) {
//        //riwayatDonasi += jumlahDonasi;
//        int idDonasi; //ada fungsi yg nantinya mengenerate id
//           
//        Donasi d1 = new Donasi(idDonasi, this, kategori, alamat);
//        riwayatDonasi[0] = d1;
//    }
//    
//    public void gantiPengaturan(String newNama, String newFotoProfil, String newAlamat, String newJenisKelamin, String newNoTelepon) {
//        nama = newNama;
//        fotoProfil = newFotoProfil;
//        alamat = newAlamat;
//        jenisKelamin = newJenisKelamin;
//        noTelepon = newNoTelepon;
//    }
//    
//    public boolean isLoggedIn() {
//        return isLoggedIn;
//    }
//
//    String getUsername() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//}
