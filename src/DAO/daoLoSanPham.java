/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoSanPham;
import DTO.SanPham;
import GROUP.ThongTinLo;
import GROUP.infoList_fTraHang_Kho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author nghia
 */
public class daoLoSanPham {

    private static daoLoSanPham instance;

    public static daoLoSanPham getInstance() {
        if (instance == null) {
            instance = new daoLoSanPham();
        }
        return instance;
    }

    //Lấy danh sách thông tin lô sản phẩm từ nhiều bảng khác nhau
    public ArrayList<ThongTinLo> getListThongTinLo() {
        ArrayList<ThongTinLo> result = new ArrayList<>();
        String query = "SELECT lo_san_pham.id_lo_sp, lo_san_pham.hsd,lo_san_pham.nsx, "
                + "chi_tiet_lo_sp.so_luong_sp,chi_tiet_lo_sp.so_tien_sp, "
                + "phieu_nhap.thoi_gian, phieu_nhap.id_phieu_nhap, "
                + "nhan_vien.ten_nv, chi_tiet_phieu_nhap.so_tien_lo, "
                + "chi_tiet_phieu_nhap.so_luong_lo, nguon_cc.ten_nha_cc, "
                + "nguon_cc.id_nguon_cc, san_pham.ten_sp, loai_sp.ten_loai_sp, "
                + "san_pham.hinh_anh "
                + "FROM `lo_san_pham`,`chi_tiet_lo_sp`,`phieu_nhap`,`chi_tiet_phieu_nhap`,`nguon_cc`,`san_pham`,`loai_sp`,`nhan_vien` "
                + "WHERE lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "AND phieu_nhap.id_phieu_nhap=chi_tiet_phieu_nhap.id_phieu_nhap "
                + "AND lo_san_pham.id_phieu_nhap=phieu_nhap.id_phieu_nhap "
                + "AND chi_tiet_phieu_nhap.id_nguon_cc=nguon_cc.id_nguon_cc "
                + "AND chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "AND loai_sp.id_loai_sp=san_pham.id_loai_sp "
                + "AND nhan_vien.id_nv=phieu_nhap.id_nv "
                + "ORDER BY lo_san_pham.id_ton_kho DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinLo(rs.getInt("lo_san_pham.id_lo_sp"),
                        rs.getString("lo_san_pham.hsd"),
                        rs.getString("lo_san_pham.nsx"),
                        rs.getInt("chi_tiet_lo_sp.so_luong_sp"),
                        rs.getInt("chi_tiet_lo_sp.so_tien_sp"),
                        rs.getString("phieu_nhap.thoi_gian"),
                        rs.getInt("phieu_nhap.id_phieu_nhap"),
                        rs.getString("nhan_vien.ten_nv"),
                        rs.getInt("chi_tiet_phieu_nhap.so_tien_lo"),
                        rs.getInt("chi_tiet_phieu_nhap.so_luong_lo"),
                        rs.getString("nguon_cc.ten_nha_cc"),
                        rs.getInt("nguon_cc.id_nguon_cc"),
                        rs.getString("san_pham.ten_sp"),
                        rs.getString("loai_sp.ten_loai_sp"),
                        rs.getBytes("san_pham.hinh_anh")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
    
    public ArrayList<infoList_fTraHang_Kho> getListInfoList_fTraHang_Kho() {
        ArrayList<infoList_fTraHang_Kho> result = new ArrayList<>();
        String query = "SELECT kho.id_lo_sp, nguon_cc.ten_nha_cc,san_pham.ten_sp, kho.sl_san_pham \n" +
                        "FROM `lo_san_pham`,`chi_tiet_lo_sp`,`phieu_nhap`,`chi_tiet_phieu_nhap`,`nguon_cc`,`san_pham`,`nhan_vien`, `kho`\n" +
                        "WHERE lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp \n" +
                        "AND phieu_nhap.id_phieu_nhap=chi_tiet_phieu_nhap.id_phieu_nhap \n" +
                        "AND lo_san_pham.id_phieu_nhap=phieu_nhap.id_phieu_nhap \n" +
                        "AND chi_tiet_phieu_nhap.id_nguon_cc=nguon_cc.id_nguon_cc \n" +
                        "AND chi_tiet_lo_sp.id_sp=san_pham.id_sp \n" +
                        "AND nhan_vien.id_nv=phieu_nhap.id_nv \n" +
                        "AND kho.id_lo_sp = lo_san_pham.id_lo_sp";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new infoList_fTraHang_Kho(rs.getInt("kho.id_lo_sp"),
                                                    rs.getString("nguon_cc.ten_nha_cc"),
                                                    rs.getString("san_pham.ten_sp"),
                                                    rs.getInt("kho.sl_san_pham")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
//    public ArrayList<infoList_fTraHang_Kho> getListInfoList_fTraHang_Kho_TimKiem(ArrayList<infoList_fTraHang_Kho> arr, Sring varSearch) {
//        
//    }

    //Lấy ra thông tin lô sản phẩm từ id lô
    public ThongTinLo getThongTinLo(int id) {
        ThongTinLo result = null;
        String query = "SELECT lo_san_pham.id_lo_sp, lo_san_pham.hsd,lo_san_pham.nsx, "
                + "chi_tiet_lo_sp.so_luong_sp,chi_tiet_lo_sp.so_tien_sp, "
                + "phieu_nhap.thoi_gian, phieu_nhap.id_phieu_nhap, "
                + "nhan_vien.ten_nv, chi_tiet_phieu_nhap.so_tien_lo, "
                + "chi_tiet_phieu_nhap.so_luong_lo, nguon_cc.ten_nha_cc, "
                + "nguon_cc.id_nguon_cc, san_pham.ten_sp, loai_sp.ten_loai_sp, "
                + "san_pham.hinh_anh "
                + "FROM `lo_san_pham`,`chi_tiet_lo_sp`,`phieu_nhap`,`chi_tiet_phieu_nhap`,`nguon_cc`,`san_pham`,`loai_sp`,`nhan_vien` "
                + "WHERE lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "AND phieu_nhap.id_phieu_nhap=chi_tiet_phieu_nhap.id_phieu_nhap "
                + "AND lo_san_pham.id_phieu_nhap=phieu_nhap.id_phieu_nhap "
                + "AND chi_tiet_phieu_nhap.id_nguon_cc=nguon_cc.id_nguon_cc "
                + "AND chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "AND loai_sp.id_loai_sp=san_pham.id_loai_sp "
                + "AND nhan_vien.id_nv=phieu_nhap.id_nv "
                + "AND lo_san_pham.id_lo_sp=" + id;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = new ThongTinLo(rs.getInt("lo_san_pham.id_lo_sp"),
                        rs.getString("lo_san_pham.hsd"),
                        rs.getString("lo_san_pham.nsx"),
                        rs.getInt("chi_tiet_lo_sp.so_luong_sp"),
                        rs.getInt("chi_tiet_lo_sp.so_tien_sp"),
                        rs.getString("phieu_nhap.thoi_gian"),
                        rs.getInt("phieu_nhap.id_phieu_nhap"),
                        rs.getString("nhan_vien.ten_nv"),
                        rs.getInt("chi_tiet_phieu_nhap.so_tien_lo"),
                        rs.getInt("chi_tiet_phieu_nhap.so_luong_lo"),
                        rs.getString("nguon_cc.ten_nha_cc"),
                        rs.getInt("nguon_cc.id_nguon_cc"),
                        rs.getString("san_pham.ten_sp"),
                        rs.getString("loai_sp.ten_loai_sp"),
                        rs.getBytes("san_pham.hinh_anh"));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //lấy danh sách thông tin từ bảng lô sản phẩm
    public ArrayList<LoSanPham> getDanhSachLoSanPham() {
        ArrayList<LoSanPham> result = new ArrayList<>();
        String query = "select * from Lo_san_pham";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new LoSanPham(rs.getInt("id_lo_sp"), rs.getString("hsd"), rs.getString("nsx"), rs.getInt("id_exist"), rs.getInt("id_ton_kho"), rs.getInt("id_phieu_nhap")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
// Thêm lô sản phẩm mới

    public boolean insertLoSanPham(String hsd, String nsx, int id_exist, int id_ton_kho, int id_phieu_nhap) {
        String query = "INSERT INTO `Lo_san_pham`(`hsd`, `nsx`, `id_exist`, `id_ton_kho`, `id_phieu_nhap`) VALUES ('" + hsd + "','" + nsx + "','" + id_exist + "','" + id_ton_kho + "','" + id_phieu_nhap + "')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
// Lấy ra 1 lô sản phẩm từ hsd, nsx, id_phieu nhap

    public LoSanPham getLoSanPham(String hsd, String nsx, int id_phieu_nhap) {
        LoSanPham result = null;
        String query = "SELECT * FROM `Lo_san_pham` WHERE hsd='" + hsd + "' and nsx='" + nsx + "' and id_phieu_nhap='" + id_phieu_nhap + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new LoSanPham(rs.getInt("id_lo_sp"), rs.getString("hsd"), rs.getString("nsx"), rs.getInt("id_exist"), rs.getInt("id_ton_kho"), rs.getInt("id_phieu_nhap")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
// Lấy ra 1 lô sản phẩm từ id lô

    public LoSanPham getLoSanPham(int id_lo) {
        LoSanPham result = null;
        String query = "select * from Lo_san_pham where id_lo_sp=" + id_lo;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new LoSanPham(
                        rs.getInt("id_lo_sp"),
                        rs.getString("hsd"),
                        rs.getString("nsx"),
                        rs.getInt("id_exist"),
                        rs.getInt("id_ton_kho"),
                        rs.getInt("id_phieu_nhap"));

            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        if (result == null) {
            System.out.print("Lo san pham bi null");
        }
        return result;
    }

    //Lấy ra danh sách thông tin 20 lô sản phẩm, để làm phân trang
    public ArrayList<ThongTinLo> get20LoSanPham(ArrayList<ThongTinLo> arr, long Trang) {
        ArrayList<ThongTinLo> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }

    //Tìm kiếm trong bảng lô sản phẩm
    public ArrayList<ThongTinLo> FindListThongTinLo(ArrayList<ThongTinLo> DuLieuMau, String ValToSearch) {
        ArrayList<ThongTinLo> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {

            if (String.valueOf(DuLieuMau.get(i).id_lo_sp).contains(ValToSearch)
                    || DuLieuMau.get(i).ten_sp.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).so_luong_lo).contains(ValToSearch)
                    || DuLieuMau.get(i).thoi_gian_nhap.contains(ValToSearch)) {
                result.add(DuLieuMau.get(i));
            }
        }
        return result;
    }
    
    public void CapNhatLoKhiTraKho(int id_lo_sp){
        String query = "UPDATE `lo_san_pham` SET `id_ton_kho` = '0' WHERE `lo_san_pham`.`id_lo_sp` ="+id_lo_sp;
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
    }
}
