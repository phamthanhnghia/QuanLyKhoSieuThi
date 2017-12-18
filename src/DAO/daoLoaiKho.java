/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.*;
import DAO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Dinh Tien
 */
public class daoLoaiKho {
    private static daoLoaiKho instance;

    public static daoLoaiKho getInstance() {
        if (instance == null) {
            instance = new daoLoaiKho();
        }
        return instance;
    }

    public daoLoaiKho() {
    }
    public ArrayList<LoaiKho> getListLoaiKho() {
        ArrayList<LoaiKho> result = new ArrayList<>();
        String query = "select * from loai_kho where `id_exist`=1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new LoaiKho(rs.getInt("id_loai_kho"),
                rs.getString("ten_loai_kho"),
                rs.getInt("id_exist")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex); 
        }

        return result;
    }
    public LoaiKho getLoaiKho(int id_loai_kho) {
        LoaiKho result = new LoaiKho();
        String query = "select * from loai_kho where `id_exist`=1 and `id_loai_kho` ="+ id_loai_kho;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result=new LoaiKho(rs.getInt("id_loai_kho"),
                rs.getString("ten_loai_kho"),
                rs.getInt("id_exist"));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex); 
        }

        return result;
    }
    public LoaiKho getLoaiKho(String ten_loai_kho) {
        LoaiKho result = new LoaiKho();
        String query = "select * from loai_kho where `id_exist`=1 and `ten_loai_kho` ='"+ ten_loai_kho+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result=new LoaiKho(rs.getInt("id_loai_kho"),
                rs.getString("ten_loai_kho"),
                rs.getInt("id_exist"));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex); 
        }

        return result;
    }
    
}
