/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.NguonCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dinh Tien
 */
public class daoNguonCungCap {
    private static daoNguonCungCap instance;
    public static daoNguonCungCap getInstance() {
        if(instance==null)instance=new daoNguonCungCap();
        return instance;
    }

    public daoNguonCungCap() {
    }
    //
    public ArrayList<NguonCungCap> getDanhSachNguonCungCap()
    {
        ArrayList<NguonCungCap> result = new ArrayList<>();
        String query="select *from nguon_cc";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new NguonCungCap(rs.getInt("id_nguon_cc"),
                    rs.getString("ten_nha_cc"),
                    rs.getString("ten_dai_dien"),
                    rs.getString("sdt"),
                    rs.getString("dia_chi"),
                    rs.getString("email"),
                    rs.getInt("id_exist"),
                    rs.getBytes("hinh_anh")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
}
