/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SanPham;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.lang.*;

/**
 *
 * @author nghia
 */
public class daoSanPham {

    private static daoSanPham instance;

    public static daoSanPham getInstance() {
        if (instance == null) {
            instance = new daoSanPham();
        }
        return instance;
    }

    public daoSanPham() {
    }

    //Lấy ra danh sách thông tin từ bảng sản phẩm
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

    //Tìm kiếm trong bảng sản phẩm
    public ArrayList<SanPham> FindListSanPham(String ValToSearch) {
        ArrayList<SanPham> sanphamList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `San_pham` WHERE CONCAT(`id_sp`, `ten_sp`) LIKE '%" + ValToSearch + "%'";
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);
            SanPham sanpham;

            while (rs.next()) {
                sanpham = new SanPham(
                        rs.getInt("id_sp"),
                        rs.getString("ten_sp"),
                        rs.getBytes("hinh_anh"),
                        rs.getInt("id_exist"),
                        rs.getInt("id_loai_sp")
                );
                sanphamList.add(sanpham);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return sanphamList;
    }

    //Lấy ra danh sách thông tin sản phẩm có cùng loại
    public ArrayList<SanPham> getListSanPhamTheoLoai(int id_loai_sp) {
        ArrayList<SanPham> sanphamList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `San_pham` WHERE id_loai_sp ='%" + id_loai_sp + "%'";
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);
            SanPham sanpham;

            while (rs.next()) {
                sanpham = new SanPham(
                        rs.getInt("id_sp"),
                        rs.getString("ten_sp"),
                        rs.getBytes("hinh_anh"),
                        rs.getInt("id_exist"),
                        rs.getInt("id_loai_sp")
                );
                sanphamList.add(sanpham);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return sanphamList;
    }

    //Lấy danh sách thông tin sản phẩm từ số có tồn tại trong id sản phẩm
    public ArrayList<SanPham> getListSanPhamTheoID(String id_sp) {
        ArrayList<SanPham> sanphamList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `San_pham` WHERE id_sp ='%" + id_sp + "%'";
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);
            SanPham sanpham;

            while (rs.next()) {
                sanpham = new SanPham(
                        rs.getInt("id_sp"),
                        rs.getString("ten_sp"),
                        rs.getBytes("hinh_anh"),
                        rs.getInt("id_exist"),
                        rs.getInt("id_loai_sp")
                );
                sanphamList.add(sanpham);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return sanphamList;
    }

    //Thêm sản phẩm mới
    public boolean insertSanPham(String ten_sp, String hinh_anh, int id_exist, int id_loai_sp, int id_nv) {
        try {
            DAO.DataProvider.getIntance().open();
            PreparedStatement ps = DAO.DataProvider.getIntance().getconn().prepareStatement("INSERT INTO `san_pham`( `ten_sp`, `hinh_anh`, `id_exist`, `id_loai_sp`) VALUES (?,?,1,?)");
            InputStream is = new FileInputStream(new File(hinh_anh));
            ps.setString(1, ten_sp);
            ps.setBlob(2, is);
            ps.setInt(3, id_loai_sp);
            ps.executeUpdate();
            DAO.DataProvider.getIntance().close();
            JOptionPane.showMessageDialog(null,
                    "Thêm sản phẩm mới thành công.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

            DAO.daoThongBao.getInstance().insertThongBao("[Sản Phẩm] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv + " đã thêm sản phẩm mới vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    //Sửa thông tin sản phẩm
    public boolean updateSanPham(int id_sp, String ten_sp, byte[] hinh_anh, int id_exist, int id_loai_sp) {
        String query = "Call USP_updateNhanVien(?,?,?,?,?,?,?)";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(id_sp);
        arr.add(ten_sp);
        arr.add(hinh_anh);
        arr.add(id_exist);
        arr.add(id_loai_sp);
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    //Lấy 1 sản phẩm từ id sản phẩm
    public SanPham getSanPham(int id_sp) {
        SanPham result = null;
        String query = "select * from San_pham where id_sp=" + id_sp;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new SanPham(
                        rs.getInt("id_sp"),
                        rs.getString("ten_sp"),
                        rs.getBytes("hinh_anh"),
                        rs.getInt("id_exist"),
                        rs.getInt("id_loai_sp")
                );
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        if (result == null) {
            System.out.print("san pham bi null");
        }
        return result;
    }
}
