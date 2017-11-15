/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class daoChiTietPhieuNhap {
    private static daoChiTietPhieuNhap instance;

    public static daoChiTietPhieuNhap getInstance() {
        if(instance==null)instance=new daoChiTietPhieuNhap();
        return instance;
    }

    public daoChiTietPhieuNhap() {
    }
    
    public ArrayList<ChiTietPhieuNhap> getListChiTietPhieuNhap()
    {
        ArrayList<ChiTietPhieuNhap> result = new ArrayList<>();
        String query="SELECT * FROM `chi_tiet_phieu_nhap`";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new ChiTietPhieuNhap(rs.getInt("id_ctpn"),rs.getInt("so_tien_lo"),rs.getInt("so_luong_lo"),rs.getInt("id_nguon_cc"),rs.getInt("id_phieu_nhap")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public boolean insertChiTietPhieuNhap(int so_tien_lo, int so_luong_lo, int id_nguon_cc, int id_phieu_nhap) {
        String query = "INSERT INTO `San_pham`(`ten_sp`, `hinh_anh`, `id_exist`, `id_loai_sp`) VALUES ('%"+ten_sp+"%','%"+hinh_anh.toString()+"%','%"+id_exist+"%','%"+id_loai_sp+"%')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
        // bug
    }
}
