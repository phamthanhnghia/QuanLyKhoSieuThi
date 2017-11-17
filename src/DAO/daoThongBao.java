/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoThongBao {
     private static daoThongBao instance;

    public static daoThongBao getInstance() {
        if(instance==null)instance=new daoThongBao();
        return instance;
    }

    public daoThongBao() {
    }
    
    public ArrayList<ThongBao> getListThongBao()
    {
        ArrayList<ThongBao> result = new ArrayList<>();
        String query="select * from Thong_bao";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new ThongBao(rs.getInt("id_thong_bao"),
                    rs.getString("noi_dung"),
                    rs.getString("thoi_gian"),
                    rs.getInt("id_exist")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public boolean insertThongBao(String noi_dung, String thoi_gian,int id_exist) {
        String query = "INSERT INTO `Thong_bao` (`id_thong_bao`, `noi_dung`, `thoi_gian`, `id_exist`) VALUES (NULL, '"+noi_dung+"', '"+thoi_gian+"', '"+id_exist+"')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

   
}
