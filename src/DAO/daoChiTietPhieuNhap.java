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
import java.lang.*;

/**
 *
 * @author admin
 */
public class daoChiTietPhieuNhap {

    private static daoChiTietPhieuNhap instance;

    public static daoChiTietPhieuNhap getInstance() {
        if (instance == null) {
            instance = new daoChiTietPhieuNhap();
        }
        return instance;
    }

    public daoChiTietPhieuNhap() {
    }

    //Lấy danh sách thông tin trong bảng chi tiết phiếu nhập
    public ArrayList<ChiTietPhieuNhap> getListChiTietPhieuNhap() {
        ArrayList<ChiTietPhieuNhap> result = new ArrayList<>();
        String query = "SELECT * FROM `chi_tiet_phieu_nhap`";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ChiTietPhieuNhap(rs.getInt("id_ctpn"),
                        rs.getInt("so_tien_lo"),
                        rs.getInt("so_luong_lo"),
                        rs.getInt("id_nguon_cc"),
                        rs.getInt("id_phieu_nhap")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Thêm chi tiết phiếu nhập mới
    public boolean insertChiTietPhieuNhap(int so_tien_lo, int so_luong_lo, int id_nguon_cc, int id_phieu_nhap) {
        String query = "INSERT INTO `chi_tiet_phieu_nhap`(`so_tien_lo`, `so_luong_lo`, `id_nguon_cc`, `id_phieu_nhap`) VALUES ('" + so_tien_lo + "','" + so_luong_lo + "','" + id_nguon_cc + "','" + id_phieu_nhap + "')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    // Lấy một chi tiết phiếu nhập từ id
    public ChiTietPhieuNhap getChiTietPhieuNhap(int id_pn) {
        ChiTietPhieuNhap result = null;
        String query = "SELECT * FROM `chi_tiet_phieu_nhap` WHERE id_phieu_nhap=" + id_pn;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new ChiTietPhieuNhap(rs.getInt("id_ctpn"),
                        rs.getInt("so_tien_lo"),
                        rs.getInt("so_luong_lo"),
                        rs.getInt("id_nguon_cc"),
                        rs.getInt("id_phieu_nhap")));

            } else {
                result = null;
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
}
