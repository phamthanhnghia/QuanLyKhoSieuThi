/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuKiemKeKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author nghia
 */
public class daoPhieuKiemKeKho {

    private static daoPhieuKiemKeKho instance;

    public static daoPhieuKiemKeKho getInstance() {
        if (instance == null) {
            instance = new daoPhieuKiemKeKho();
        }
        return instance;
    }

    //Lấy danh sách thông tin từ bảng phiếu kiểm kê kho
    public ArrayList<PhieuKiemKeKho> getListPhieuKiemKeKho() {
        ArrayList<PhieuKiemKeKho> result = new ArrayList<>();
        String query = "select * from Phieu_kiem_ke_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new PhieuKiemKeKho(rs.getInt("id_kk_kho"), rs.getInt("sl_hao_mon"), rs.getInt("sl_thuc_te"),rs.getString("thoi_gian"), rs.getInt("id_kho"), rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Lấy ra một phiếu kiểm kê kho từ id
    public PhieuKiemKeKho getPhieuKiemKeKho(int id_kho) {
        PhieuKiemKeKho result = null;
        String query = "select * from Phieu_kiem_ke_kho WHERE id_kho='" + id_kho + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = (new PhieuKiemKeKho(rs.getInt("id_kk_kho"), rs.getInt("sl_hao_mon"),rs.getInt("sl_thuc_te"), rs.getString("thoi_gian"), rs.getInt("id_kho"), rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    

    //Thêm phiếu kiểm kê kho mới // sl hao mon
    public boolean insertPhieuKiemKeKho(int sl_hao_mon,int sl_thuc_te, String thoi_gian, int id_kho, int id_nv) {
        String query = "INSERT INTO `phieu_kiem_ke_kho`(`sl_hao_mon`,`sl_thuc_te`, `thoi_gian`, `id_kho`, `id_nv`) VALUES ('" + sl_hao_mon + "','" +sl_thuc_te +"','" + thoi_gian + "', '" + id_kho + "','" + id_nv + "')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
}
