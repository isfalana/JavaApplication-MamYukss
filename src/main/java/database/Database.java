package database;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
         // ini untuk mendefinisikan koneksi database kita
        private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        private static final String url = "jdbc:mysql://localhost:3306/mamyukss";
        private static final String USER = "root";
        private static final String PASS = "";

  // ini untuk instansiasi object dari class DriverManager dan Connection
        public static Connection connect;
        public static Statement statement;
        public static ResultSet resultData;

        // ini adalah method static connection
        public static void connection()
        {
        // method untuk melakukan koneksi ke database
        try {
        // registrasi driver yang akan dipakai
        Class.forName(JDBC_DRIVER);

        // buat koneksi ke database
        connect = DriverManager.getConnection(url, USER, PASS);
            System.out.println("sukses");

        } catch (Exception e) {
        // kalo ada error saat koneksi
        // maka tampilkan errornya
        e.printStackTrace();
        }

        
}
}