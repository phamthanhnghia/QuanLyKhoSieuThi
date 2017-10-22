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
    public ArrayList<NguonCungCap> getListNguonCungCap()
    {
        ArrayList<NguonCungCap> result = new ArrayList<>();
        String query="select *from Nguon_cc";
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
    public ArrayList<NguonCungCap> FindListNguonCungCap(String ValToSearch)
    {
        ArrayList<NguonCungCap> NguonCungCapList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `Nguon_cc` WHERE CONCAT(`id_nguon_cc`, `ten_nha_cc`,`ten_dai_dien`,`sdt`,`dia_chi`) LIKE '%"+ValToSearch+"%'";
        try{
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);          
            NguonCungCap Nguon;
            
            while(rs.next())
            {
                Nguon = new NguonCungCap(
                                rs.getInt("id_nguon_cc"),
                                rs.getString("ten_nha_cc"),
                                rs.getString("ten_dai_dien"),
                                rs.getString("sdt"),
                                rs.getString("dia_chi"),
                                rs.getString("email"),
                                rs.getInt("id_exist"),
                                rs.getBytes("hinh_anh")
                                );
                NguonCungCapList.add(Nguon);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return NguonCungCapList;
    }
}
