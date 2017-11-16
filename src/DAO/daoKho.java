/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Kho;
import DTO.TonKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dinh Tien
 */
public class daoKho {
    private static daoKho instance;

    public static daoKho getInstance() {
        if(instance==null)instance=new daoKho();
        return instance;
    }
    public ArrayList<Kho> getListKho()
    {
        ArrayList<Kho> result = new ArrayList<>();
        String query="select * from Kho";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new Kho(rs.getInt("id_kho"),rs.getInt("sl_san_pham"),rs.getInt("id_lo_sp"),rs.getInt("id_khu_vuc")));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
}
