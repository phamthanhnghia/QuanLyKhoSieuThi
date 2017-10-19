/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoSanPham {
    private static daoSanPham instance;

    public static daoSanPham getInstance() {
        if(instance==null)instance=new daoSanPham();
        return instance;
    }

    public daoSanPham() {
    }
    //
    public ArrayList<SanPham> getDanhSachSanPham()
    {
        ArrayList<SanPham> result = new ArrayList<>();
        String query="select *from San_pham";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new SanPham(rs.getInt("id_sp"),rs.getString("ten_sp"),rs.getString("hinh_anh").getBytes(),rs.getInt("id_exist"),rs.getInt("id_loai_sp")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
}
