package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author NT
 */
public class DataProvider {

    private static String url = "jdbc:mysql://localhost:3306/QuanLyKhoSieuThi?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String pass = "root";
    
//    private static String url = "jdbc:mysql://databases-auth.000webhost.com/index.php/id2370592_quanlykhosieuthi?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
//    
//    private static String user = "id2370592_quanlykhosieuthi";
//    private static String pass = "quanlykhosieuthi";

    private Connection conn = null;
    private static DataProvider intance;

    public static DataProvider getIntance() {
        if (intance == null) {
            intance = new DataProvider();
        }
        return intance;
    }
    public Connection getconn()
    {
        return conn;
    }
    
    // xu ly ngoai le khi tuong tac voi csdl 

    public void displayError(SQLException ex) {
        System.out.println(" Error Message:" + ex.getMessage());
        System.out.println(" SQL State:" + ex.getSQLState());
        System.out.println(" Error Code:" + ex.getErrorCode());
    }

    public void open() {// mo ket noi den csdl 
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver 
            DriverManager.registerDriver(driver);// dang ky driver 

            conn = DriverManager.getConnection(url, user, pass);//tao ket noi den co so du lieu 
        } catch (SQLException ex) {// xu ly ngoai le 
            displayError(ex);
        }
    }

    public void close() {// dong ket noi co so du lieu 
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            displayError(ex);
        }
    }

    public Connection getConnect() {
        return conn;
    }
    //tao va thuc thi cac cau lenh sql 
    // cung cap thong tin trich rut tu csdl va cho phep truy xuat tung dong du lieu 

    public ResultSet excuteQuery(String sql, ArrayList<Object> arr) {// danh cho cau lenh select 
        ResultSet rs = null;
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            if (arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {
                    stm.setObject(i + 1, arr.get(i));
                }
            }

            rs = stm.executeQuery();

        } catch (SQLException ex) {
            displayError(ex);
        }
        return rs;
    }

    public int excuteUpdate(String sql, ArrayList<Object> arr) {// danh cho cau lenh secect 
        int rs = 1;
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            if (arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {
                    stm.setObject(i + 1, arr.get(i));
                }
            }
            stm.executeUpdate();
        } catch (SQLException ex) {
            displayError(ex);
            return -1;
        }
        return rs;
    }

    public boolean excute(String sql, ArrayList<Object> arr) {// danh cho cau lenh secect 
        boolean rs = false;
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            if (arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {
                    stm.setObject(i + 1, arr.get(i));
                }
            }

            rs = stm.execute();

        } catch (SQLException ex) {
            displayError(ex);
        }
        this.close();
        return rs;
    }
         public void excuteQuery(String sql) {// danh cho cau lenh secect 
        try {
            PreparedStatement stm;
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();

        } catch (SQLException ex) {
            displayError(ex);
        }
    }
}

