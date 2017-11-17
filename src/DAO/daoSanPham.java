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
    public ArrayList<SanPham> getListSanPham()
    {
        ArrayList<SanPham> result = new ArrayList<>();
        String query="select * from San_pham";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new SanPham(rs.getInt("id_sp"),rs.getString("ten_sp"),rs.getBytes("hinh_anh"),rs.getInt("id_exist"),rs.getInt("id_loai_sp")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public ArrayList<SanPham> FindListSanPham(String ValToSearch)
    {
        ArrayList<SanPham> sanphamList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `San_pham` WHERE CONCAT(`id_sp`, `ten_sp`) LIKE '%"+ValToSearch+"%'";
        try{
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);          
            SanPham sanpham;
            
            while(rs.next())
            {
                sanpham = new SanPham(
                                rs.getInt("id_sp"),
                                rs.getString("ten_sp"),
                                rs.getString("hinh_anh").getBytes(),
                                rs.getInt("id_exist"),
                                rs.getInt("id_loai_sp")
                                );
                sanphamList.add(sanpham);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return sanphamList;
    }
    public ArrayList<SanPham> getListSanPhamTheoLoai(int id_loai_sp)
    {
        ArrayList<SanPham> sanphamList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `San_pham` WHERE id_loai_sp ='%"+id_loai_sp+"%'";
        try{
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);          
            SanPham sanpham;
            
            while(rs.next())
            {
                sanpham = new SanPham(
                                rs.getInt("id_sp"),
                                rs.getString("ten_sp"),
                                rs.getString("hinh_anh").getBytes(),
                                rs.getInt("id_exist"),
                                rs.getInt("id_loai_sp")
                                );
                sanphamList.add(sanpham);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return sanphamList;
    }
    public ArrayList<SanPham> getListSanPhamTheoID(String id_sp)
    {
        ArrayList<SanPham> sanphamList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `San_pham` WHERE id_sp ='%"+id_sp+"%'";
        try{
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);          
            SanPham sanpham;
            
            while(rs.next())
            {
                sanpham = new SanPham(
                                rs.getInt("id_sp"),
                                rs.getString("ten_sp"),
                                rs.getString("hinh_anh").getBytes(),
                                rs.getInt("id_exist"),
                                rs.getInt("id_loai_sp")
                                );
                sanphamList.add(sanpham);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return sanphamList;
    }
    public boolean insertSanPham(String ten_sp,byte[] hinh_anh,int id_exist,int id_loai_sp) {
        String query = "INSERT INTO `San_pham`(`ten_sp`, `hinh_anh`, `id_exist`, `id_loai_sp`) VALUES ('%"+ten_sp+"%','%"+hinh_anh.toString()+"%','%"+id_exist+"%','%"+id_loai_sp+"%')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public boolean updateSanPham(int id_sp,String ten_sp,byte[] hinh_anh,int id_exist,int id_loai_sp) {
        String query = "Call USP_updateNhanVien(?,?,?,?,?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(id_sp);
        arr.add(ten_sp);
        arr.add(hinh_anh);
        arr.add(id_exist);
        arr.add(id_loai_sp);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
}
