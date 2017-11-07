/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TonKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoTonKho {
    private static daoTonKho instance;

    public static daoTonKho getInstance() {
        if(instance==null)instance=new daoTonKho();
        return instance;
    }
    public ArrayList<TonKho> getListTonKho()
    {
        ArrayList<TonKho> result = new ArrayList<>();
        String query="select * from San_pham";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new TonKho(rs.getInt("id_ton"),rs.getInt("id_lo"),rs.getString("ngay"),rs.getInt("sl_sp"),rs.getInt("id_khu_vuc")));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public boolean insertTonKho(int id_lo, String ngay, int sl_sp, int id_khu_vuc) {
        String query = "INSERT INTO `Ton_kho`(`id_lo`, `ngay`, `sl_sp`, `id_khu_vuc`) VALUES ('"+id_lo+"','"+ngay+"','"+sl_sp+"','"+id_khu_vuc+"')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public boolean updateSoLuongTonKho(int id_lo, String ngay, int sl_sp, int id_khu_vuc) {
        String query = "UPDATE `Ton_kho` SET `sl_sp`= '"+sl_sp+"'  WHERE `id_lo`= '"+id_lo+"' ,`ngay`= '"+ngay+"' ,`id_khu_vuc`= '"+id_khu_vuc+"'";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
}
