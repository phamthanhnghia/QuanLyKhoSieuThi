/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietLoSanPham;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author nghia
 */
public class daoChiTietLoSanPham {

    private static daoChiTietLoSanPham instance;

    public static daoChiTietLoSanPham getInstance() {
        if (instance == null) {
            instance = new daoChiTietLoSanPham();
        }
        return instance;
    }

    //Lấy danh sách thông tin trong bảng chi tiết lô sản phẩm
    public ArrayList<ChiTietLoSanPham> getListChiTietLoSanPham() {
        ArrayList<ChiTietLoSanPham> result = new ArrayList<>();
        String query = "select * from Chi_tiet_lo_sp";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ChiTietLoSanPham(rs.getInt("id_chi_tiet_sp"), rs.getInt("so_luong_sp"), rs.getInt("so_tien_sp"), rs.getInt("id_lo_sp"), rs.getInt("id_sp")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }

    //Thêm Chi tiết lô sản phẩm mới
    public boolean insertChiTietLoSanPham(int so_luong_sp, int so_tien_sp, int id_lo_sp, int id_sp) {
        String query = "INSERT INTO `Chi_tiet_lo_sp`( `so_luong_sp`, `so_tien_sp`, `id_lo_sp`, `id_sp`) VALUES  ('" + so_luong_sp + "','" + so_tien_sp + "','" + id_lo_sp + "','" + id_sp + "')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    //Lấy 1 chi tiết lô sản phẩm từ id 
    public ChiTietLoSanPham getChiTietLoSanPham(int id_lo) {
        ChiTietLoSanPham result = null;
        String query = "select * from Chi_tiet_lo_sp where id_lo_sp=" + id_lo;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new ChiTietLoSanPham(rs.getInt("id_chi_tiet_sp"), rs.getInt("so_luong_sp"), rs.getInt("so_tien_sp"), rs.getInt("id_lo_sp"), rs.getInt("id_sp"));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        if (result == null) {
            System.out.print("Chi tiet Lo san pham bi null");
        }
        return result;
    }
}
