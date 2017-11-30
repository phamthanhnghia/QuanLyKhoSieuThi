/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author nghia
 */
public class DateTimeNow {
    private static DateTimeNow intance;

    public static DateTimeNow getIntance() {
        if (intance == null) {
            intance = new DateTimeNow();
        }
        return intance;
    }
    private final String _patternDate = "yyyy-MM-dd";
    private final String _patternDateView = "dd-MM-yyyy";
    private final String _patternTime = "HH : mm : ss";
    private final String _patternDateTime = "yyyy-MM-dd HH:mm:ss";
    public  String DateNow =new SimpleDateFormat(_patternDate).format(new Date());
    public  String DateView =new SimpleDateFormat(_patternDateView).format(new Date());
    public  String TimeNow =new SimpleDateFormat(_patternTime).format(new Date());
    public  String Now =new SimpleDateFormat(_patternDateTime).format(new Date());
    
    public String FormatDate(String str){
        
        String thang = FormatThang(str.substring(4, 7));
        String ngay = str.substring(8, 10);
        String nam = str.substring(24, 28);
        String fm = nam+"-"+thang+"-"+ngay;
        return fm;
    }
    public String FormatThang(String thang){
        String kq = "";
        switch (thang) {
            case "Jan":  kq = "01";
                     break;
            case "Feb":  kq = "02";
                     break;
            case "Mar":  kq = "03";
                     break;
            case "Apr":  kq = "04";
                     break;
            case "May":  kq = "05";
                     break;
            case "Jun":  kq = "06";
                     break;
            case "Jul":  kq = "07";
                     break;
            case "Aug":  kq = "08";
                     break;
            case "Sep":  kq = "09";
                     break;
            case "Oct":  kq = "10";
                     break;
            case "Nov":  kq = "11";
                     break;
            case "Dec":  kq = "12";
                     break;
        }
        return kq;
    }
    public String RanDomDate(int nam){
        Random rand = new Random();
        int thang = rand.nextInt(12)+1;
        int ngay;
        if(thang != 2){
           ngay = rand.nextInt(30)+1;
        }else{
           ngay = rand.nextInt(28)+1;     
        }
        return nam+"-"+thang+"-"+ngay;
        
    }
}
