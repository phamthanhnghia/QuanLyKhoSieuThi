/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SanPham;
import GROUP.ThongTinKiemKe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author Dinh Tien
 */
public class daoKiemKe {

    private static daoKiemKe instance;

    public static daoKiemKe getInstance() {
        if (instance == null) {
            instance = new daoKiemKe();
        }
        return instance;
    }

    public daoKiemKe() {
    }

    //Lấy danh sách thông tin từ bảng sản phẩm
    public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> result = new ArrayList<>();
        String query = "select * from San_pham";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new SanPham(rs.getInt("id_sp"), rs.getString("ten_sp"), rs.getBytes("hinh_anh"), rs.getInt("id_exist"), rs.getInt("id_loai_sp")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
    
    
    // Lấy danh sách thông tin kiểm kê từ nhiều bảng khác nhau
    public ArrayList<ThongTinKiemKe> getListThongTinKiemKe(int id_lo_sp) {
        ArrayList<ThongTinKiemKe> result = new ArrayList<>();
        String query = "SELECT phieu_kiem_ke_kho.id_kk_kho,phieu_kiem_ke_kho.sl_thuc_te, nhan_vien.ten_nv, phieu_kiem_ke_kho.sl_hao_mon , phieu_kiem_ke_kho.thoi_gian , kho.id_lo_sp\n"
                + "FROM `phieu_kiem_ke_kho`,`kho`,`nhan_vien` "
                + "WHERE phieu_kiem_ke_kho.id_kho = kho.id_kho "
                + "AND phieu_kiem_ke_kho.id_nv = nhan_vien.id_nv "
                + "and kho.id_lo_sp = '" + id_lo_sp + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinKiemKe(rs.getInt("id_kk_kho"),
                        rs.getInt("id_lo_sp"),
                        rs.getInt("sl_hao_mon"),
                        rs.getInt("sl_thuc_te"),
                        rs.getString("ten_nv"),
                        rs.getString("thoi_gian")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
    
}
