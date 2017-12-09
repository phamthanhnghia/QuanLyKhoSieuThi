/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KiemKePhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author nghia
 */
public class daoKiemKePhieuNhap {

    private static daoKiemKePhieuNhap instance;

    public static daoKiemKePhieuNhap getInstance() {
        if (instance == null) {
            instance = new daoKiemKePhieuNhap();
        }
        return instance;
    }

    //Lấy danh sách thông tin từ bảng kiểm kê phiếu nhập
    public ArrayList<KiemKePhieuNhap> getListKiemKePhieuNhap() {
        ArrayList<KiemKePhieuNhap> result = new ArrayList<>();
        String query = "select * from Kiem_ke_phieu_nhap";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new KiemKePhieuNhap(rs.getInt("id_kk_nhap"), rs.getInt("so_luong_nhap"), rs.getInt("id_kho"), rs.getInt("id_phieu_nhap"), rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
}
