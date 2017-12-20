/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietLoSanPham;
import DTO.Kho;
import DTO.LoSanPham;
import DTO.TonKho;
import GROUP.ThongTinNhap;
import GROUP.ThongTinTon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.*;

/**
 *
 * @author nghia
 */
public class daoTonKho {

    private static daoTonKho instance;

    public static daoTonKho getInstance() {
        if (instance == null) {
            instance = new daoTonKho();
        }
        return instance;
    }
    //Lấy ra danh sách thông tin tồn kho từ nhiều bảng khác nhau
    public ArrayList<ThongTinTon> getListThongTinTon() {
        ArrayList<ThongTinTon> result = new ArrayList<>();
        String query = "SELECT ton_kho.id_lo,ton_kho.id_ton,san_pham.ten_sp,lo_san_pham.hsd,ton_kho.sl_sp,ton_kho.ngay FROM `ton_kho`,`lo_san_pham`,`san_pham`,`chi_tiet_lo_sp` "
                + "WHERE ton_kho.id_lo=lo_san_pham.id_lo_sp "
                + "and lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "ORDER BY ton_kho.ngay DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinTon(rs.getInt("ton_kho.id_lo"),
                        rs.getInt("ton_kho.id_ton"),
                        rs.getString("san_pham.ten_sp"),
                        rs.getString("lo_san_pham.hsd"),
                        rs.getInt("ton_kho.sl_sp"),
                        rs.getString("ton_kho.ngay")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    //Lấy ra danh sách thông tin tồn kho từ bảng tồn kho
    public ArrayList<TonKho> getListTonKho() {
        ArrayList<TonKho> result = new ArrayList<>();
        String query = "select * from Ton_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new TonKho(rs.getInt("id_ton"), rs.getInt("id_lo"), rs.getString("ngay"), rs.getInt("sl_sp"), rs.getInt("id_khu_vuc")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    //Lấy ra danh sách tồn kho có id lô và ngày tương ứng
    public ArrayList<TonKho> getListCheckOverWriteTonKho(int id_lo, String ngay) {
        ArrayList<TonKho> result = new ArrayList<>();
        String query = "SELECT * FROM `ton_kho` WHERE `id_lo` = '" + id_lo + "' and `ngay` = '" + ngay + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new TonKho(rs.getInt("id_ton"), rs.getInt("id_lo"), rs.getString("ngay"), rs.getInt("sl_sp"), rs.getInt("id_khu_vuc")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    //Lấy ra danh sách thông tin kho từ id lô, số lượng lô và ngày tương ứng
    public ArrayList<TonKho> getListCheckOverWriteTonKhoUpDate(int id_lo, int sl_sp, String ngay) {
        ArrayList<TonKho> result = new ArrayList<>();
        String query = "SELECT * FROM `ton_kho` WHERE `id_lo` = '" + id_lo + "' and `ngay` = '" + ngay + "' and `sl_sp`='" + sl_sp + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new TonKho(rs.getInt("id_ton"), rs.getInt("id_lo"), rs.getString("ngay"), rs.getInt("sl_sp"), rs.getInt("id_khu_vuc")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    //Thêm tồn kho mới
    public boolean insertTonKho(int id_lo, String ngay, int sl_sp, int id_khu_vuc) {
        String query = "INSERT INTO `Ton_kho`(`id_lo`, `ngay`, `sl_sp`, `id_khu_vuc`) VALUES ('" + id_lo + "','" + ngay + "','" + sl_sp + "','" + id_khu_vuc + "')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    //Update số lượng trong bảng tồn kho bằng id lô, ngày, số lượng sản phẩm
    public boolean updateSoLuongTonKho(int id_lo, String ngay, int sl_sp) {
        String query = "UPDATE `Ton_kho` SET `sl_sp`= '" + sl_sp + "'  WHERE `id_lo`= '" + id_lo + "' and `ngay`= '" + ngay + "'";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    //Cập nhật thông tin tồn kho
    public void CapNhatTonKho() {
        ArrayList<Kho> arrKho = daoKho.getInstance().getListKho();
        //ArrayList<TonKho> arrTon = daoTonKho.getInstance().getListTonKho();
        for (int i = 0; i < arrKho.size(); i++) {
            Kho item = arrKho.get(i);
            String ngay = DateTimeNow.getIntance().DateNow;
            // lấy list xem đã tồn tại trong csdl chưa
            ArrayList<TonKho> arrTonCheck = daoTonKho.getInstance().getListCheckOverWriteTonKho(item.id_lo_sp, ngay);
            //System.out.println(arrTonCheck.size());
            if (arrTonCheck.size() > 0) {
                // nếu đã có thì cập nhật lại số lượng
                ArrayList<TonKho> arrUpdate = daoTonKho.getInstance().getListCheckOverWriteTonKhoUpDate(item.id_lo_sp, item.sl_san_pham, ngay);
                if (arrUpdate.size() <= 0) {
                    daoTonKho.getInstance().updateSoLuongTonKho(item.id_lo_sp, ngay, item.sl_san_pham);
                }
            } else {
                // nếu chưa có thì thêm mới
                daoTonKho.getInstance().insertTonKho(item.id_lo_sp, ngay, item.sl_san_pham, item.id_khu_vuc);
            }
        }
    }
    //Lấy ra danh sách thông tin tồn kho theo ngày tương ứng
    public ArrayList<ThongTinTon> getTonKhoTheoNgay(String Date) {
        ArrayList<ThongTinTon> Result = new ArrayList<>();
        ArrayList<ThongTinTon> TonKhoTrongNgay = new ArrayList<>();
        ArrayList<ThongTinTon> TonKhoQuaKhu = new ArrayList<>();
        String query1 = "SELECT * FROM `ton_kho`,`lo_san_pham`,`san_pham`,`chi_tiet_lo_sp` "
                + "WHERE ton_kho.ngay='" + Date + "' "
                + "and ton_kho.id_lo=lo_san_pham.id_lo_sp "
                + "and lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "ORDER BY ton_kho.ngay DESC";
        String query2 = "SELECT * FROM `ton_kho`,`lo_san_pham`,`san_pham`,`chi_tiet_lo_sp` "
                + "WHERE ton_kho.ngay<'" + Date + "' "
                + "and ton_kho.id_lo=lo_san_pham.id_lo_sp "
                + "and lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "ORDER BY ton_kho.ngay DESC";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        ResultSet rs1 = DataProvider.getIntance().excuteQuery(query1, arr);
        ResultSet rs2 = DataProvider.getIntance().excuteQuery(query2, arr);
        try {
            while (rs1.next()) {
                TonKhoTrongNgay.add(new ThongTinTon(rs1.getInt("ton_kho.id_lo"),
                        rs1.getInt("ton_kho.id_ton"),
                        rs1.getString("san_pham.ten_sp"),
                        rs1.getString("lo_san_pham.hsd"),
                        rs1.getInt("ton_kho.sl_sp"),
                        rs1.getString("ton_kho.ngay")));
            }
            while (rs2.next()) {
                TonKhoQuaKhu.add(new ThongTinTon(rs2.getInt("ton_kho.id_lo"),
                        rs2.getInt("ton_kho.id_ton"),
                        rs2.getString("san_pham.ten_sp"),
                        rs2.getString("lo_san_pham.hsd"),
                        rs2.getInt("ton_kho.sl_sp"),
                        rs2.getString("ton_kho.ngay")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            Logger.getLogger(daoTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (TonKhoTrongNgay.isEmpty() == false) {
            return TonKhoTrongNgay;
        }
        if (TonKhoTrongNgay.isEmpty() == true && TonKhoQuaKhu.isEmpty() == false) {
            for (int i = 0; i < TonKhoQuaKhu.size(); i++) {
                if (!TonKhoQuaKhu.get(i).ngay.equals(TonKhoQuaKhu.get(0).ngay)) {
                    TonKhoQuaKhu.remove(i);
                    i = i - 1;
                }
            }

            return TonKhoQuaKhu;
        }
        /*if(TonKhoTrongNgay.isEmpty()==true && TonKhoQuaKhu.isEmpty()==true)
        {
            return TonKhoTrongNgay;
        }*/

        return Result;
    }
    // Lấy ra danh sách thông tin tồn kho theo tháng tương ứng
    public ArrayList<ThongTinTon> getTonKhoTheoThang(String thang, String nam) {
        ArrayList<ThongTinTon> result = new ArrayList<>();
        String query1 = "SELECT * FROM `ton_kho`,`lo_san_pham`,`san_pham`,`chi_tiet_lo_sp` "
                + "WHERE MONTH(ton_kho.ngay)=" + thang + " "
                + "and YEAR(ton_kho.ngay)=" + nam + " "
                + "and ton_kho.id_lo=lo_san_pham.id_lo_sp "
                + "and lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "ORDER BY ton_kho.ngay DESC";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        ResultSet rs1 = DataProvider.getIntance().excuteQuery(query1, arr);
        try {
            while (rs1.next()) {
                result.add(new ThongTinTon(rs1.getInt("ton_kho.id_lo"),
                        rs1.getInt("ton_kho.id_ton"),
                        rs1.getString("san_pham.ten_sp"),
                        rs1.getString("lo_san_pham.hsd"),
                        rs1.getInt("ton_kho.sl_sp"),
                        rs1.getString("ton_kho.ngay")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            Logger.getLogger(daoTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    // Tìm kiếm trong bảng tồn kho (cũ)
    public String[][] FindListTonKho(String ValToSearch) {
        String[][] Data = new String[1000][6];
        int RowData;
        RowData = 0;
        ArrayList<TonKho> DuLieuTonKho = getListTonKho();
        for (int i = 0; i < DuLieuTonKho.size(); i++) {
            int id_sp = DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuTonKho.get(i).id_lo).id_sp;
            String tensp = DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
            String loaisp = DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
            LoSanPham lsp = DAO.daoLoSanPham.getInstance().getLoSanPham(DuLieuTonKho.get(i).id_lo);
            String sl_sp = String.valueOf(DuLieuTonKho.get(i).sl_sp);
            if (String.valueOf(DuLieuTonKho.get(i).id_lo).contains(ValToSearch)
                    || tensp.contains(ValToSearch)
                    || lsp.hsd.contains(ValToSearch)
                    || sl_sp.contains(ValToSearch)) {
                //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                // System.out.println(sl_sp);
                //   System.out.println(tennv);
                Data[RowData][0] = String.valueOf(DuLieuTonKho.get(i).id_lo);
                Data[RowData][1] = tensp;
                Data[RowData][2] = lsp.hsd;
                Data[RowData][3] = sl_sp;
                RowData++;
            }
        }
        return Data;
    }
    // Tìm kiếm trong bảng tồn kho (mới)
    public ArrayList<ThongTinTon> FindListTonKho(ArrayList<ThongTinTon> DuLieuMau, String ValToSearch) {
        ArrayList<ThongTinTon> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {
            if (String.valueOf(DuLieuMau.get(i).id_lo_sp).contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).id_ton).contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).sl_sp).contains(ValToSearch)
                    || DuLieuMau.get(i).hsd.contains(ValToSearch)
                    || DuLieuMau.get(i).ten_sp.contains(ValToSearch)) {
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
    //Lấy ra danh sách 20 tồn kho, để phân trang
    public ArrayList<ThongTinTon> get20TonKho(ArrayList<ThongTinTon> arr, long Trang) {
        ArrayList<ThongTinTon> result = new ArrayList<>();

        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
}
