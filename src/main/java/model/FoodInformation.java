package model;



//import java.util.HashMap;
//import java.util.Map;
import database.Database;
import java.util.Random;

public class FoodInformation {
    private char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    private StringBuilder stringBuilder = new StringBuilder();
    private Random random = new Random();
    private String kupon;
    
    public FoodInformation() {
        for (int length = 0; length < 10; length++){
            Character character = chars[random.nextInt(chars.length)];
            stringBuilder.append(character);
        }
        this.kupon = stringBuilder.toString();
        stringBuilder.delete(0,5);
    }

    public String getKupon() {
        return kupon;
    }
    
//    public void saveFoodInformation(){
//        try{
//            String query = "INSERT INTO `tbl_information`" + "(`kupon_map`)" + " VALUES ('"+ this.getKupon() +"')";
//            System.out.println(query);
//            this.db.st.execute(query);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//   }
       
//    private Map<Integer, String> kuponMap;
//
//    public FoodInformation() {
//        kuponMap = new HashMap<>();
//    }
//
//    public void berikanKupon(Donasi donasi, String kupon) {
//        int idDonasi = donasi.getIdDonasi();
//        kuponMap.put(idDonasi, kupon);
//    }
//
//    public String getKupon(int idDonasi) {
//        return kuponMap.get(idDonasi);
//    }


}
