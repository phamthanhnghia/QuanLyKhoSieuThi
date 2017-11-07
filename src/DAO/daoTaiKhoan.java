/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Dinh Tien
 */
public class daoTaiKhoan {
     private static daoTaiKhoan instance;

    public static daoTaiKhoan getInstance() {
        if(instance==null)instance=new daoTaiKhoan();
        return instance;
    }

    public daoTaiKhoan() {
    }
    public ArrayList<TaiKhoan> getListTaiKhoan()
    {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        String query="select *from Tai_khoan";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new TaiKhoan(rs.getInt("id_tk"),
                    rs.getString("ten_tai_khoan"),
                    rs.getString("mat_khau"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_nv"),
                    rs.getInt("loai")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public boolean KiemTraDangNhap(String User, String Pass)
    {
        ArrayList<Object> arr = new ArrayList<>();
        String query="SELECT * FROM `Tai_khoan` WHERE ten_tai_khoan='"+User+"' and mat_khau='"+Pass+"'";
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            return true;
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
                return false;
    }
    
    public TaiKhoan getTaiKhoan(String User, String Pass){
        TaiKhoan result = null;
        String query="SELECT * FROM `Tai_khoan` WHERE ten_tai_khoan='"+User+"' and mat_khau='"+Pass+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new TaiKhoan(rs.getInt("id_tk"),
                    rs.getString("ten_tai_khoan"),
                    rs.getString("mat_khau"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_nv"),
                    rs.getInt("loai")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public TaiKhoan getTaiKhoan(int id_nhanvien){
        TaiKhoan result = null;
        String query="SELECT * FROM `Tai_khoan` WHERE id_tk='"+id_nhanvien+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new TaiKhoan(rs.getInt("id_tk"),
                    rs.getString("ten_tai_khoan"),
                    rs.getString("mat_khau"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_nv"),
                    rs.getInt("loai")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
}
