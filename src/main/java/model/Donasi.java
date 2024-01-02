package model;



import database.Database;
import model.Akun;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


    public class Donasi {

        public static enum KategoriDonasi {
            Sembako,
            Uang,
            MakananMinumanSiapSaji,
        }
        private char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        private StringBuilder stringBuilder = new StringBuilder();
        private Random random = new Random();
        private String idDonasi;
        private LocalDate tanggalDonasi;
        private String pengirimDonasi;
        private int jumlahDonasi;
        private boolean statusDonasi = false;
        private KategoriDonasi kategoriDonasi;
        private String alamat;
        private Database db;
//        private ArrayList<Donasi> daftarDonasi;
//        Donasi[] daftarDonasi = new Donasi[999999999];

    public Donasi(String idDonasi, LocalDate tanggalDonasi, String pengirimDonasi, int jumlahDonasi, boolean statusDonasi, KategoriDonasi kategoriDonasi, String alamat) {
        this.idDonasi = idDonasi;
        this.tanggalDonasi = tanggalDonasi;
        this.pengirimDonasi = pengirimDonasi;
        this.jumlahDonasi = jumlahDonasi;
        this.statusDonasi = statusDonasi;
        this.kategoriDonasi = kategoriDonasi;
//        this.daftarDonasi = new ArrayList<Donasi>();
        this.alamat = alamat;
    }
    
    

    public Donasi(String idDonasi, LocalDate tanggalDonasi, int jumlahDonasi, boolean statusDonasi, KategoriDonasi kategoriDonasi, String alamat) {
        this.idDonasi = idDonasi;
        this.tanggalDonasi = tanggalDonasi;
        this.jumlahDonasi = jumlahDonasi;
        this.statusDonasi = statusDonasi;
        this.kategoriDonasi = kategoriDonasi;
        this.alamat = alamat;
    }
    public Donasi(){
        
    }

    public Donasi(Database db) {
        this.db = db;
        for (int length = 0; length < 5; length++){
            Character character = chars[random.nextInt(chars.length)];
            stringBuilder.append(character);
        }
        this.idDonasi = stringBuilder.toString();
        stringBuilder.delete(0,5);
        
        this.tanggalDonasi = LocalDate.now();
    }

    public LocalDate getTanggalDonasi() {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return tanggalDonasi;
    }

    public String getIdDonasi() {
        return idDonasi;
    }

    public String getPengirimDonasi() {
        return pengirimDonasi;
    }

    public int getJumlahDonasi() {
        return jumlahDonasi;
    }

    public String getStatusDonasi() {
        return statusDonasi ? "true" : "false";
    }

//    public KategoriDonasi getKategoriDonasi() {
//        return kategoriDonasi;
//    }

    public String getAlamat() {
        return alamat;
    }

//    public ArrayList<Donasi> getDaftarDonasi() {
//        return daftarDonasi;
//    }

    public void setPengirimDonasi(String pengirimDonasi) {
        this.pengirimDonasi = pengirimDonasi;
    }

    public void setStatusDonasi(boolean statusDonasi) {
        this.statusDonasi = statusDonasi;
    }

    public void setJumlahDonasi(int jumlahDonasi) {
        this.jumlahDonasi = jumlahDonasi;
    }

    public void setKategoriDonasi(KategoriDonasi kategoriDonasi) {
        this.kategoriDonasi = kategoriDonasi;
    }
    
    public void setKategoriDonasi(String kategoriDonasi) {
        switch (kategoriDonasi) {
            case "Sembako":
                this.kategoriDonasi = KategoriDonasi.Sembako;
                break;
            case "Uang":
                this.kategoriDonasi = KategoriDonasi.Uang;
                break;
            default:
                this.kategoriDonasi = KategoriDonasi.MakananMinumanSiapSaji;
        }
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setTanggalDonasi() {
        LocalDate tanggalDonasi = LocalDate.now();
        this.tanggalDonasi = tanggalDonasi;
    }
    
    public void setSelesai() {
        this.statusDonasi = true;
    }
    
    public String getSelesai() {
        if (this.statusDonasi) {
            return "Berhasil";
        }
        
        return "Belum Berhasil";
    }
    
    public String getKategoriDonasi() {
        switch (kategoriDonasi) {
            case MakananMinumanSiapSaji -> {
                return "Makanan & Minuman Siap Saji";
                }
            case Sembako -> {
                return "Sembako";
                }
            case Uang -> {
                return "Uang";
                }
        }
        return null;
    }
    
    

    
//    public void saveDonasi() {
//        try {
//            String query = "INSERT INTO `tbldonasi` "
//                + "(`id_Donasi`, `tanggal_donasi`, `pengirim_donasi`, `jumlah_donasi`, `status_donasi`, `kategori_donasi`, `alamat`) "
//                + "VALUES ('" + 
//                this.idDonasi + "', '"+ 
//                this.tanggalDonasi +"', '"+ 
//                this.pengirimDonasi.getUsername()+"', '"+ 
//                this.jumlahDonasi +"', '"+ this.getSelesai() +"', '"+ 
//                this.getKategoriDonasi() +"', '"+ 
//                this.getAlamat() +"')";
//            System.out.println(query);
//            this.db.st.execute(query);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//            this.db.st.executeUpdate("INSERT INTO tbldonasi (id_Donasi, tanggal_donasi, pengirim_donasi, jumlah_donasi, status_donasi, alamat) VALUES ('', date '2000-10-10', '', 'Selesai', 'Uang', 'Anu')");

    public void setIdDonasi(String idDonasi) {
        this.idDonasi = idDonasi;
    }
    
    public void setTanggalDonasi(java.sql.Date tanggal) {
        this.tanggalDonasi = tanggal.toLocalDate();
    }
    
    
    }

//    private static List<Donasi> daftarDonasi = new ArrayList<>();
//    
//    private int idDonasi;
//    private Date tanggalDonasi;
//    private String pengirimDonasi;
//    private long jumlahDonasi;
//    private String statusDonasi;
//    private String kategoriDonasi;
//    private String alamat;
//    private boolean simpanDonasi;
//
//    public Donasi(int idDonasi, String pengirimDonasi, long jumlahDonasi, String kategoriDonasi, String alamat) {
//        this.idDonasi = idDonasi;
//        this.tanggalDonasi = new Date();
//        this.pengirimDonasi = pengirimDonasi;
//        this.jumlahDonasi = jumlahDonasi;
//        this.statusDonasi = "Belum Selesai";
//        this.kategoriDonasi = kategoriDonasi;
//        this.alamat = alamat;
//        this.simpanDonasi = false;
//    }
//
//    public void tambahDonasiKeAkun(Akun akun) {
//        akun.tambahDonasi((int) jumlahDonasi);
//    }
//

//
//    
//    public void tampilkanInformasiDonasi() {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        System.out.println("ID Donasi: " + idDonasi);
//        System.out.println("Tanggal Donasi: " + sdf.format(tanggalDonasi));
//        System.out.println("Pengirim Donasi: " + pengirimDonasi);
//        System.out.println("Jumlah Donasi: " + jumlahDonasi);
//        System.out.println("Status Donasi: " + statusDonasi);
//        System.out.println("Kategori Donasi: " + kategoriDonasi);
//        System.out.println("Alamat: " + alamat);
//    }
//
//    public void simpanDonasi() {
//        simpanDonasi = true;
//    }
//
//    public void batalSimpanDonasi() {
//        simpanDonasi = false;
//    }
//
//    public boolean isDonasiDisimpan() {
//        return simpanDonasi;
//    }
//
//    int getIdDonasi() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

//}
