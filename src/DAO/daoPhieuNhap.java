/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            result.add(new PhieuNhap(rs.getInt("id_phieu_nhap"),rs.getTimestamp("thoi_gian"),rs.getString("ghi_chu"),rs.getInt("id_exist"),rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
}
