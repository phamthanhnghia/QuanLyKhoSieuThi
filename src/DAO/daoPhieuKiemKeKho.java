/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuKiemKeKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoPhieuKiemKeKho {
    private static daoPhieuKiemKeKho instance;

    public static daoPhieuKiemKeKho getInstance() {
        if(instance==null)instance=new daoPhieuKiemKeKho();
        return instance;
    }

    //
    public ArrayList<PhieuKiemKeKho> getListPhieuKiemKeKho()
    {
        ArrayList<PhieuKiemKeKho> result = new ArrayList<>();
        String query="select * from Phieu_kiem_ke_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new PhieuKiemKeKho(rs.getInt("id_kk_kho"),rs.getInt("sl_hao_mon"),rs.getTimestamp("thoi_gian"),rs.getInt("id_kho"),rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
}
