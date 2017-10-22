/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoSanPham;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String query="select *from San_pham";
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
}
