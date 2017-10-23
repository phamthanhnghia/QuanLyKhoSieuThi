/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoSanPham;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoLoSanPham {
    private static daoLoSanPham instance;

    public static daoLoSanPham getInstance() {
        if(instance==null)instance=new daoLoSanPham();
        return instance;
    }
    // 
    public ArrayList<LoSanPham> getDanhSachLoSanPham(){
        ArrayList<LoSanPham> result = new ArrayList<>();
        String query="select * from Lo_san_pham";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new LoSanPham(rs.getInt("id_lo_sp"),rs.getTimestamp("hsd"),rs.getTimestamp("nsx"),rs.getInt("id_exist"),rs.getInt("id_ton_kho"),rs.getInt("id_phieu_nhap")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public boolean insertLoSanPham(Timestamp hsd, Timestamp nsx, int id_exist, int id_ton_kho, int id_phieu_nhap) {
        String query = "INSERT INTO `Lo_san_pham`(`hsd`, `nsx`, `id_exist`, `id_ton_kho`, `id_phieu_nhap`) VALUES ('%"+hsd+"%','%"+nsx+"%','%"+id_exist+"%','%"+id_ton_kho+"%','%"+id_phieu_nhap+"%')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public LoSanPham getLoSanPham(Timestamp hsd, Timestamp nsx, int id_phieu_nhap){
        LoSanPham result = null;
        String query="SELECT * FROM `Lo_san_pham` WHERE hsd='%"+hsd+"%' nsx='%"+nsx+"%' id_phieu_nhap='%"+id_phieu_nhap+"%'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new LoSanPham(rs.getInt("id_lo_sp"),rs.getTimestamp("hsd"),rs.getTimestamp("nsx"),rs.getInt("id_exist"),rs.getInt("id_ton_kho"),rs.getInt("id_phieu_nhap")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
}
