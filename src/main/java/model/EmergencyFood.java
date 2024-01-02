package model;



import database.Database;
import model.Donasi;
import model.Akun;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EmergencyFood {
            public static enum KategoriPermintaan {
            Sembako,
            Uang,
            MakananMinumanSiapSaji,
        }
    
    private int idPermintaan;
    private LocalDate tanggalPermintaan;
    private KategoriPermintaan kategoriPermintaan;
    private boolean statusPermintaan = true;
    private String penerimaDonasi;
    private List<Donasi> daftarDonasi;
    private Database db;
//    private RoomChat roomChat;

    public EmergencyFood(int idPermintaan, LocalDate tanggalPermintaan, KategoriPermintaan kategoriPermintaan, boolean statusPermintaan, String penerimaDonasi, List<Donasi> daftarDonasi) {
        this.idPermintaan = idPermintaan;
        this.tanggalPermintaan = tanggalPermintaan;
        this.kategoriPermintaan = kategoriPermintaan;
        this.statusPermintaan = statusPermintaan;
        this.penerimaDonasi = penerimaDonasi;
        this.daftarDonasi = daftarDonasi;
    }

    public EmergencyFood(int idPermintaan, LocalDate tanggalPermintaan, KategoriPermintaan kategoriPermintaan, boolean statusPermintaan, String penerimaDonasi) {
        this.idPermintaan = idPermintaan;
        this.tanggalPermintaan = tanggalPermintaan;
        this.kategoriPermintaan = kategoriPermintaan;
        this.statusPermintaan = statusPermintaan;
        this.penerimaDonasi = penerimaDonasi;
    }

    public EmergencyFood(int idPermintaan, KategoriPermintaan kategoriPermintaan, String penerimaDonasi, List<Donasi> daftarDonasi) {
        this.idPermintaan = idPermintaan;
        this.kategoriPermintaan = kategoriPermintaan;
        this.penerimaDonasi = penerimaDonasi;
        this.daftarDonasi = daftarDonasi;
    }

    public EmergencyFood(Database db, KategoriPermintaan kategoriPermintaan, String penerimaDonasi) {
//        this.tanggalPermintaan = tanggalPermintaan;
        this.db = db;
        this.kategoriPermintaan = kategoriPermintaan;
        this.penerimaDonasi = penerimaDonasi;
        
    }

    
    public EmergencyFood() {
    }
    
    
    public EmergencyFood(Database db){
        this.db = db;
        this.tanggalPermintaan = LocalDate.now();
    }
    

    public int getIdPermintaan() {
        return idPermintaan;
    }

    public LocalDate getTanggalPermintaan() {
        this.tanggalPermintaan = LocalDate.now();
        return tanggalPermintaan;
    }
//
//    public KategoriPermintaan getKategoriPermintaan() {
//        return kategoriPermintaan;
//    }

    public boolean getStatusPermintaan() {
        return statusPermintaan;
    }

    public String getPenerimaDonasi() {
        return penerimaDonasi;
    }

    public List<Donasi> getDaftarDonasi() {
        return daftarDonasi;
    }

    public void setIdPermintaan(int idPermintaan) {
        this.idPermintaan = idPermintaan;
    }

    public void setTanggalPermintaan() {
        LocalDate tanggalPermintaan = LocalDate.now();
        this.tanggalPermintaan = tanggalPermintaan;
    }

//    public void setKategoriPermintaan(KategoriPermintaan kategoriPermintaan) {
//        this.kategoriPermintaan = kategoriPermintaan;
//    }
    
    public void setKategoriPermintaan(String kategoriPermintaan) {
        switch (kategoriPermintaan) {
            case "Sembako":
                this.kategoriPermintaan = KategoriPermintaan.Sembako;
                break;
            case "Uang":
                this.kategoriPermintaan = KategoriPermintaan.Uang;
                break;
            default:
                this.kategoriPermintaan = KategoriPermintaan.MakananMinumanSiapSaji;
        }
    }
    

    public void setStatusPermintaan(boolean statusPermintaan) {
        this.statusPermintaan = statusPermintaan;

    }

    public void setPenerimaDonasi(String penerimaDonasi) {
        this.penerimaDonasi = penerimaDonasi;
    }

    public void setDaftarDonasi(List<Donasi> daftarDonasi) {
        this.daftarDonasi = daftarDonasi;
    }
    
    public void setSelesai(){
        statusPermintaan = false;
    }
    
    public String getSelesai() {
        if (this.statusPermintaan) {
            return "berhasil";
        }
        
        return "belum berhasil";
    }

    public String getKategoriPermintaan() {
        switch (kategoriPermintaan) {
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
    
//        public void saveEmergencyFood() {
//        try {
//            String query = "INSERT INTO `tblemergency` "
//                + "(`tanggal_permintaan`, `kategori_permintaan`, `status_permintaan`, `penerima_donasi`) "
//                + "VALUES ('" + 
//                this.getTanggalPermintaan() + "', '"+ 
//                this.getKategoriPermintaan() +"', '"+ 
//                this.getSelesai() +"', '"+ 
//                this.penerimaDonasi.getUsername()   +"')";
//            System.out.println(query);
//            this.db.st.execute(query);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    }

//    public EmergencyFood(int idPermintaan, String kategoriPermintaan, Akun penerimaDonasi) {
//        this.idPermintaan = idPermintaan;
//        this.tanggalPermintaan = new Date();
//        this.kategoriPermintaan = kategoriPermintaan;
//        this.statusPermintaan = "Belum Selesai";
//        this.penerimaDonasi = penerimaDonasi;
//        this.daftarDonasi = new ArrayList<>();
//        this.roomChat = new RoomChat();
//    }
//
//    public void mintaDonasi(double jumlahDonasi, String alamat) {
//        Donasi donasi = new Donasi(generateIdDonasi(), penerimaDonasi.getUsername(), (long) jumlahDonasi, kategoriPermintaan, alamat);
//        donasi.tambahDonasiKeAkun(penerimaDonasi);
//        daftarDonasi.add(donasi);
//    }
//
//    public void setBerhasil() {
//        this.statusPermintaan = "Berhasil";
//    }
//
//    public void setBelumSelesai() {
//        this.statusPermintaan = "Belum Selesai";
//    }
//
//    public void tampilkanDataPermintaan() {
//        System.out.println("ID Permintaan: " + idPermintaan);
//        System.out.println("Tanggal Permintaan: " + tanggalPermintaan);
//        System.out.println("Kategori Permintaan: " + kategoriPermintaan);
//        System.out.println("Penerima Donasi: " + penerimaDonasi.getUsername());
//        System.out.println("Status Permintaan: " + statusPermintaan);
//    }
//
//    private int generateIdDonasi() {
//        return 0;
//    }
//
//    public void mulaiChat() {
//        roomChat.mulaiChat(penerimaDonasi);
//    }
//
//    public void kirimPesan(String pesan) {
//        roomChat.kirimPesan(pesan);
//    }
//
//    private class RoomChat {
//
//        public RoomChat() {
//        }
//
//        public void kirimPesan(String pesan) {
//        }
//
//        public void mulaiChat(Akun penerimaDonasi) {
//        }

//}
