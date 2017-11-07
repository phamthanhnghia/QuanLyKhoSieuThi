/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoPhieuNhap {
    private static daoPhieuNhap instance;

    public static daoPhieuNhap getInstance() {
        if(instance==null)instance=new daoPhieuNhap();
        return instance;
    }
    // 
    public ArrayList<PhieuNhap> getListPhieuNhap(){
        ArrayList<PhieuNhap> result = new ArrayList<>();
        String query="select *from Phieu_nhap";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new PhieuNhap(rs.getInt("id_phieu_nhap"),rs.getString("thoi_gian"),rs.getString("ghi_chu"),rs.getInt("id_exist"),rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public boolean insertPhieuNhap(String thoi_gian, String ghi_chu, int id_exist, int id_nv) {
        String query = "INSERT INTO `Phieu_nhap`(`thoi_gian`, `ghi_chu`, `id_exist`, `id_nv`) VALUES ('"+thoi_gian+"','"+ghi_chu+"','"+id_exist+"','"+id_nv+"')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public PhieuNhap getPhieuNhap(String thoi_gian, String ghi_chu, int id_nv){
        PhieuNhap result = null;
        String query="select * from Phieu_nhap where thoi_gian ='"+thoi_gian+"' ghi_chu='"+ghi_chu+"' id_nv='"+id_nv+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new PhieuNhap(rs.getInt("id_phieu_nhap"),rs.getString("thoi_gian"),rs.getString("ghi_chu"),rs.getInt("id_exist"),rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
}
