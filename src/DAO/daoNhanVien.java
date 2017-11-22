/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NguonCungCap;
import DTO.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author VIENTHONGA
 */
public class daoNhanVien {
    private static daoNhanVien instance;
    public static daoNhanVien getInstance() {
        if(instance==null)instance=new daoNhanVien();
        return instance;
    }

    public daoNhanVien() {
    }
    //
    public ArrayList<NhanVien> getListNhanVien()
    {
        ArrayList<NhanVien> result = new ArrayList<>();
        String query="select *from nhan_vien";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new NhanVien(rs.getInt("id_nv"),
                    rs.getString("ten_nv"),
                    rs.getString("sdt"),
                    rs.getString("cnmd"),
                    rs.getString("ngay_sinh"),
                    rs.getBytes("hinh_anh"),
                    rs.getInt("id_exist")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
}
