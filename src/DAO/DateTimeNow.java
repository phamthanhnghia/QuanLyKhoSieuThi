/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    private final String _patternDate = "dd-MM-yyyy";
    private final String _patternTime = "HH : mm : ss";
    private final String _patternDateTime = "yyyy/MM/dd HH:mm:ss";
    public  String DateNow =new SimpleDateFormat(_patternDate).format(new Date());
    public  String TimeNow =new SimpleDateFormat(_patternTime).format(new Date());
    public  String Now =new SimpleDateFormat(_patternDateTime).format(new Date());
}
