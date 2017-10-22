/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietLoSanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoChiTietLoSanPham {
    private static daoChiTietLoSanPham instance;

    public static daoChiTietLoSanPham getInstance() {
        if(instance==null)instance=new daoChiTietLoSanPham();
        return instance;
    }

    //
    public ArrayList<ChiTietLoSanPham> getListChiTietLoSanPham()
    {
        ArrayList<ChiTietLoSanPham> result = new ArrayList<>();
        String query="select * from Chi_tiet_lo_sp";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new ChiTietLoSanPham(rs.getInt("id_chi_tiet_sp"),rs.getInt("so_luong_sp"),rs.getInt("so_tien_sp"),rs.getInt("id_lo_sp"),rs.getInt("id_sp")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
}
