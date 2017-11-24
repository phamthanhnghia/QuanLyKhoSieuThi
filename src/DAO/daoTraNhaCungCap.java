/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuTraKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dinh Tien
 */
public class daoTraNhaCungCap {
    private static daoTraNhaCungCap instance;

    public static daoTraNhaCungCap getInstance() {
        if(instance==null)instance=new daoTraNhaCungCap();
        return instance;
    }

    public daoTraNhaCungCap() {
    }
    public  ArrayList<PhieuTraKho> getListTraKho()
    {
         ArrayList<PhieuTraKho> result = new ArrayList<>();
        String query="select * from Phieu_xuat_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new PhieuTraKho(rs.getInt("id_phieu_tra_kho"),
                    rs.getString("thoi_gian_tra"),
                    rs.getInt("sl_san_pham"),
                    rs.getString("hinh_thuc_tra"),
                    rs.getInt("id_lo_sp"),
                    rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
     public PhieuTraKho getTraKho(int id_pt)
    {
        PhieuTraKho result = null;
        String query="SELECT * FROM `Phieu_tra_kho` WHERE id_phieu_tra_kho="+id_pt;
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            
            result = (new PhieuTraKho(rs.getInt("id_phieu_tra_kho"),
                    rs.getString("thoi_gian_tra"),
                    rs.getInt("sl_san_pham"),
                    rs.getString("hinh_thuc_tra"),
                    rs.getInt("id_lo_sp"),
                    rs.getInt("id_nv")));
                    
        }
        else
        {
            result=null;
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
}
