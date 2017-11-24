/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Kho;
import DTO.LoaiSanPham_jTreeChart;
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
        String query="select * from Kho where sl_san_pham != 0";
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
    public ArrayList<LoaiSanPham_jTreeChart> getListLoaiSanPham_jTreeChart()
    {
        ArrayList<LoaiSanPham_jTreeChart> result = new ArrayList<>();
        String query="SELECT loai_sp.ten_loai_sp , Sum((kho.sl_san_pham*chi_tiet_lo_sp.so_luong_sp)) AS so_luong FROM `kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`lo_san_pham` WHERE kho.id_lo_sp = lo_san_pham.id_lo_sp AND lo_san_pham.id_lo_sp = chi_tiet_lo_sp.id_lo_sp AND chi_tiet_lo_sp.id_sp = san_pham.id_sp AND san_pham.id_loai_sp =loai_sp.id_loai_sp GROUP BY loai_sp.ten_loai_sp ORDER BY so_luong DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new LoaiSanPham_jTreeChart(rs.getString("ten_loai_sp"),rs.getLong("so_luong")));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public boolean insertKho(int sl_sp, int id_lo, int id_khu_vuc) {
        String query = "INSERT INTO `kho`(`sl_san_pham`, `id_lo_sp`, `id_khu_vuc`) VALUES ('"+sl_sp+"','"+id_lo+"','"+id_khu_vuc+"')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public boolean updateSoLuongKho(int sl_sp, int id_lo) {
        String query = "UPDATE `kho` SET `sl_san_pham`='"+sl_sp+"' WHERE `id_lo_sp`='"+id_lo+"'";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
}
