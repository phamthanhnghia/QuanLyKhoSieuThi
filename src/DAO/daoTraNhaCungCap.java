/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import DTO.Kho;
import DTO.NhanVien;
import DTO.PhieuTraKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.lang.*;

/**
 *
 * @author Dinh Tien
 */
public class daoTraNhaCungCap {

    private static daoTraNhaCungCap instance;

    public static daoTraNhaCungCap getInstance() {
        if (instance == null) {
            instance = new daoTraNhaCungCap();
        }
        return instance;
    }

    public daoTraNhaCungCap() {
    }

    //Lấy ra danh sách thông tin từ bảng trả kho
    public ArrayList<PhieuTraKho> getListTraKho() {
        ArrayList<PhieuTraKho> result = new ArrayList<>();
        String query = "select * from Phieu_tra_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new PhieuTraKho(rs.getInt("id_phieu_tra_kho"),
                        rs.getString("thoi_gian_tra"),
                        rs.getInt("sl_san_pham"),
                        rs.getString("hinh_thuc_tra"),
                        rs.getInt("id_lo_sp"),
                        rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Lấy ra phiếu trả kho từ id
    public PhieuTraKho getTraKho(int id_pt) {
        PhieuTraKho result = null;
        String query = "SELECT * FROM `Phieu_tra_kho` WHERE id_phieu_tra_kho=" + id_pt;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new PhieuTraKho(rs.getInt("id_phieu_tra_kho"),
                        rs.getString("thoi_gian_tra"),
                        rs.getInt("sl_san_pham"),
                        rs.getString("hinh_thuc_tra"),
                        rs.getInt("id_lo_sp"),
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

    //Thêm phiếu trả mới
    public boolean InsertPhieuTra(int id_kho, int id_nv) {
        Kho kho = DAO.daoKho.getInstance().getIdKho(id_kho);
        String ngay = DAO.DateTimeNow.getIntance().Now;
        String query = "INSERT INTO `phieu_tra_kho`("
                + "`thoi_gian_tra`, "
                + "`sl_san_pham`, "
                + "`hinh_thuc_tra`, "
                + "`id_lo_sp`, "
                + "`id_nv`) VALUES ("
                + "'" + ngay + "',"
                + "" + kho.sl_san_pham + ","
                + "'Trả nhà cung cấp',"
                + "" + kho.id_lo_sp + ","
                + "" + id_nv + ")";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        // lo san pham khong rỗng id_ton_kho = 0
        daoLoSanPham.getInstance().CapNhatLoKhiTraKho(kho.id_lo_sp);
        //
        JOptionPane.showMessageDialog(null,
                "Tạo phiếu trả thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        NhanVien nv = DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv);
        DAO.daoKho.getInstance().updateSoLuongKhotheo_ID_LO(0, kho.id_lo_sp);
        String ngayluu=ngay.substring(0,10);
        //System.out.println("DAO.daoTraNhaCungCap.InsertPhieuTra()" + ngayluu);
        DAO.daoTonKho.getInstance().updateSoLuongTonKho(kho.id_lo_sp,ngayluu,0);
        DAO.daoThongBao.getInstance().insertThongBao("[Trả hàng] Nhân viên " + nv.ten_nv + " đã trả hàng vào lúc " + ngay, ngay, 2);
        return true;
    }

    //Tìm kiếm trong bảng trả kho
    public ArrayList<PhieuTraKho> FindListTraKho(ArrayList<PhieuTraKho> DuLieuMau, String ValToSearch) {
        ArrayList<PhieuTraKho> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {
            int id_sp = DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuMau.get(i).id_lo_sp).id_sp;
            String tensp = DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
            String loaisp = DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
            String tennv = DAO.daoTaiKhoan.getInstance().getNhanVien(DuLieuMau.get(i).id_nv).ten_nv;
            String sl_sp = String.valueOf(DuLieuMau.get(i).sl_san_pham);
            LoSanPham lsp = DAO.daoLoSanPham.getInstance().getLoSanPham(DuLieuMau.get(i).id_lo_sp);
            ChiTietPhieuNhap ctpn = DAO.daoChiTietPhieuNhap.getInstance().getChiTietPhieuNhap(lsp.id_phieu_nhap);
            NguonCungCap ncc = DAO.daoNguonCungCap.getInstance().getNguonCungCap(ctpn.id_nguon_cc);
            if (DuLieuMau.get(i).thoi_gian_tra.contains(ValToSearch)
                    || tensp.contains(ValToSearch)
                    || sl_sp.contains(ValToSearch)
                    || ncc.ten_nha_cc.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).id_phieu_tra_kho).contains(ValToSearch)
                    || tennv.contains(ValToSearch)) {
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

    //Lấy ra 20 phiếu tra, để phân trang
    public ArrayList<PhieuTraKho> get20PhieuTraKho(ArrayList<PhieuTraKho> arr, long Trang) {
        ArrayList<PhieuTraKho> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
}
