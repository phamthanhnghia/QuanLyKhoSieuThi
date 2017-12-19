/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhap;
import GROUP.ThongTinNhap;
import DTO.XuatKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nghia
 */
public class daoPhieuNhap {

    private static daoPhieuNhap instance;

    public static daoPhieuNhap getInstance() {
        if (instance == null) {
            instance = new daoPhieuNhap();
        }
        return instance;
    }

    //Lấy ra danh sách thông tin phiếu nhập
    public ArrayList<PhieuNhap> getListPhieuNhap() {
        ArrayList<PhieuNhap> result = new ArrayList<>();
        String query = "select *from Phieu_nhap";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new PhieuNhap(rs.getInt("id_phieu_nhap"), rs.getString("thoi_gian"), rs.getString("ghi_chu"), rs.getInt("id_exist"), rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Tính số lần nhập kho trong ngày
    public int SoLanNhapKhoTrongNgay(String thoi_gian) {
        int so_lan = 0;
        String query = "SELECT COUNT(id_phieu_nhap) AS lan_nhap_kho  FROM `phieu_nhap` WHERE phieu_nhap.thoi_gian LIKE '%" + thoi_gian + "%'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                so_lan = rs.getInt("lan_nhap_kho");
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return so_lan;
    }

    //Lấy ra danh sách phiếu nhập trong ngày
    public ArrayList<PhieuNhap> getListPhieuNhapTrongNgay(String thoi_gian) {
        ArrayList<PhieuNhap> result = new ArrayList<>();
        String query = "SELECT * FROM `phieu_nhap` WHERE phieu_nhap.thoi_gian LIKE '%" + thoi_gian + "%'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new PhieuNhap(rs.getInt("id_phieu_nhap"), rs.getString("thoi_gian"), rs.getString("ghi_chu"), rs.getInt("id_exist"), rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Thêm phiếu nhập mới
    public boolean insertPhieuNhap(String thoi_gian, String ghi_chu, int id_exist, int id_nv) {
        String query = "INSERT INTO `Phieu_nhap`(`thoi_gian`, `ghi_chu`, `id_exist`, `id_nv`) VALUES ('" + thoi_gian + "','" + ghi_chu + "','" + id_exist + "','" + id_nv + "')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    //Lấy ra 1 phiếu nhập từ thời gian và id nhân viên
    public PhieuNhap getPhieuNhap(String thoi_gian, int id_nv) {
        PhieuNhap result = null;
        String query = "select * from Phieu_nhap where thoi_gian ='" + thoi_gian + "' and id_nv='" + id_nv + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new PhieuNhap(rs.getInt("id_phieu_nhap"),
                        rs.getString("thoi_gian"),
                        rs.getString("ghi_chu"),
                        rs.getInt("id_exist"),
                        rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;

    }

    //Lấy ra 1 phiếu nhập từ id phiếu nhập
    public PhieuNhap getPhieuNhap(int id_pn) {
        PhieuNhap result = null;
        String query = "SELECT * FROM `Phieu_nhap` WHERE id_phieu_nhap=" + id_pn;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new PhieuNhap(rs.getInt("id_phieu_nhap"),
                        rs.getString("thoi_gian"),
                        rs.getString("ghi_chu"),
                        rs.getInt("id_exist"),
                        rs.getInt("id_nv")));

            } else {
                result = null;
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }

    //Lấy ra 20 thông tin nhập kho, để làm phân trang
    public ArrayList<ThongTinNhap> get20NhapKho(ArrayList<ThongTinNhap> arr, long Trang) {
        ArrayList<ThongTinNhap> result = new ArrayList<>();

        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }

    //Tìm kiếm trong bảng nhập kho
    public ArrayList<ThongTinNhap> FindListNhapKho(ArrayList<ThongTinNhap> DuLieuMau, String ValToSearch) {
        ArrayList<ThongTinNhap> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {
            if (DuLieuMau.get(i).thoi_gian.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).so_tien_lo).contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).so_tien_sp).contains(ValToSearch)
                    || DuLieuMau.get(i).ten_nv.contains(ValToSearch)) {
                //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                // System.out.println(sl_sp);
                //   System.out.println(tennv);

                result.add(DuLieuMau.get(i));
            }
        }
        return result;
    }
    // Huy phieu nhap
    public boolean HuyPhieuNhap(int id_phieu_nhap, int id_nv)
    {
        String query = "UPDATE `phieu_nhap` SET `id_exist`=0 WHERE `id_phieu_nhap`="+id_phieu_nhap;
        try {
            DataProvider.getIntance().open();
            DataProvider.getIntance().excuteQuery(query);
            DataProvider.getIntance().close();
            JOptionPane.showMessageDialog(null, "Xóa phiếu nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            DAO.daoThongBao.getInstance().insertThongBao("[Nhập kho] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv + " đã xóa phiếu nhập"+id_phieu_nhap+" vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Xóa khu vực Thất bại", "Thông báo", 1);
             return false;
        }
        return true;
    }
}
