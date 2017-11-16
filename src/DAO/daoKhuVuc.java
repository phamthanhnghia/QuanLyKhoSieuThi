/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuVuc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoKhuVuc {
    private static daoKhuVuc instance;

    public static daoKhuVuc getInstance() {
        if(instance==null)instance=new daoKhuVuc();
        return instance;
    }

    //
    public ArrayList<KhuVuc> getListKhuVuc()
    {
        ArrayList<KhuVuc> result = new ArrayList<>();
        String query="select * from Khu_vuc";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new KhuVuc(rs.getInt("id_khu_vuc"),rs.getString("ten_khu_vuc"),rs.getString("vi_tri"),rs.getInt("id_exist"),rs.getInt("id_loai_kho")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
     public KhuVuc getIDKhuVuc(String tenkhuvuc)
    {
        KhuVuc result = null;
        String query="select *from khu_vuc where ten_khu_vuc = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(tenkhuvuc);
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new KhuVuc(rs.getInt("id_khu_vuc"),rs.getString("ten_khu_vuc"),rs.getString("vi_tri"),rs.getInt("id_exist"),rs.getInt("id_loai_kho")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
     
}
