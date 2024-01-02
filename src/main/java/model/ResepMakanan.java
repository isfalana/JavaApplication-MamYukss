package model;



import database.Database;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ResepMakanan {
    private String namaMakanan;
    private String daftarBahan;
    private String daftarAlat;
    private String langkahLangkah;
//    private BufferedImage gambarMakanan;
//    private double rating;
    private Database db;
    private int idResepMakanan;
    
    public ResepMakanan(int idResepMakanan, String namaMakanan, String daftarBahan, String daftarAlat, String langkahLangkah, Database db) {
        this.idResepMakanan = idResepMakanan;
        this.namaMakanan = namaMakanan;
        this.daftarBahan = daftarBahan;
        this.daftarAlat = daftarAlat;
        this.langkahLangkah = langkahLangkah;
        this.db = db;
    }
    
    public ResepMakanan(){
        
    }

    public int getIdResepMakanan() {
        return idResepMakanan;
    }

    public void setIdResepMakanan(int idResepMakanan) {
        this.idResepMakanan = idResepMakanan;
    }
    

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public String getDaftarBahan() {
        return daftarBahan;
    }

    public void setDaftarBahan(String daftarBahan) {
        this.daftarBahan = daftarBahan;
    }

    public String getDaftarAlat() {
        return daftarAlat;
    }

    public void setDaftarAlat(String daftarAlat) {
        this.daftarAlat = daftarAlat;
    }

    public String getLangkahLangkah() {
        return langkahLangkah;
    }

    public void setLangkahLangkah(String langkahLangkah) {
        this.langkahLangkah = langkahLangkah;
    }
    


//    
//    public ResepMakanan(String namaMakanan, List<String> daftarBahan, List<String> daftarAlat, List<String> langkahLangkah, String gambarMakanan) {
//        this.namaMakanan = namaMakanan;
//        this.daftarBahan = daftarBahan;
//        this.daftarAlat = daftarAlat;
//        this.langkahLangkah = langkahLangkah;
//        this.gambarMakanan = gambarMakanan;
//        this.rating = 0.0; // Awalnya rating diinisialisasi dengan 0
//    }
//    
//    public String getNamaMakanan() {
//        return namaMakanan;
//    }
//
//    public List<String> getDaftarBahan() {
//        return daftarBahan;
//    }
//
//    public List<String> getDaftarAlat() {
//        return daftarAlat;
//    }
//
//    public List<String> getLangkahLangkah() {
//        return langkahLangkah;
//    }
//
//    public String getGambarMakanan() {
//        return gambarMakanan;
//    }
//
//    public double getRating() {
//        return rating;
//    }
//
//    public void beriRating(double rating) {
//        if (rating >= 0.0 && rating <= 5.0) { // Pastikan rating berada dalam rentang 0 hingga 5
//            this.rating = rating;
//        } else {
//            System.out.println("Rating harus berada dalam rentang 0 hingga 5.");
//        }
//    }
//
//    public void tampilkanInformasiResep() {
//        System.out.println("Nama Makanan: " + namaMakanan);
//        System.out.println("Daftar Bahan:");
//        for (String bahan : daftarBahan) {
//            System.out.println("- " + bahan);
//        }
//        System.out.println("Daftar Alat:");
//        for (String alat : daftarAlat) {
//            System.out.println("- " + alat);
//        }
//        System.out.println("Langkah-langkah:");
//        int langkahKe = 1;
//        for (String langkah : langkahLangkah) {
//            System.out.println(langkahKe + ". " + langkah);
//            langkahKe++;
//        }
//        System.out.println("Gambar Makanan: " + gambarMakanan);
//        System.out.println("Rating: " + rating);
//    }

}
