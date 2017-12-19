/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhap;
import DTO.KhuVuc;
import DTO.NguonCungCap;
import DTO.NhanVien;
import DTO.XuatKho;
import GUI.fNhacungcap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.lang.*;

/**
 *
 * @author Dinh Tien
 */
public class daoNguonCungCap {

    private static daoNguonCungCap instance;

    public static daoNguonCungCap getInstance() {
        if (instance == null) {
            instance = new daoNguonCungCap();
        }
        return instance;
    }

    public daoNguonCungCap() {
    }

    //Lấy danh sách thông tin từ bảng nguồn cung cấp
    public ArrayList<NguonCungCap> getListNguonCungCap() {
        ArrayList<NguonCungCap> result = new ArrayList<>();
        String query = "select *from Nguon_cc where id_exist=1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new NguonCungCap(rs.getInt("id_nguon_cc"),
                        rs.getString("ten_nha_cc"),
                        rs.getString("ten_dai_dien"),
                        rs.getString("sdt"),
                        rs.getString("dia_chi"),
                        rs.getString("email"),
                        rs.getInt("id_exist"),
                        rs.getBytes("hinh_anh")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Tìm kiếm trong bảng nguồn cung cấp (cũ)
    public ArrayList<NguonCungCap> FindListNguonCungCap(String ValToSearch) {
        ArrayList<NguonCungCap> NguonCungCapList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `Nguon_cc` WHERE CONCAT(`id_nguon_cc`, `ten_nha_cc`,`ten_dai_dien`,`sdt`,`dia_chi`) LIKE '%" + ValToSearch + "%'";
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);
            NguonCungCap Nguon;

            while (rs.next()) {
                Nguon = new NguonCungCap(
                        rs.getInt("id_nguon_cc"),
                        rs.getString("ten_nha_cc"),
                        rs.getString("ten_dai_dien"),
                        rs.getString("sdt"),
                        rs.getString("dia_chi"),
                        rs.getString("email"),
                        rs.getInt("id_exist"),
                        rs.getBytes("hinh_anh")
                );
                NguonCungCapList.add(Nguon);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return NguonCungCapList;
    }

    //Thêm nguồn cung cấp mới
    public boolean insertNguonCungCap(String tennhacc, String tendaidien, String sdt, String diachi, String email, String hinh_anh, int id_nv) {
        if ("".equals(hinh_anh)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa chọn hình ảnh",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if ("".equals(tennhacc) || "".equals(tendaidien) || "".equals(sdt) || "".equals(diachi) || "".equals(email)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            DAO.DataProvider.getIntance().open();
            PreparedStatement ps = DAO.DataProvider.getIntance().getconn().prepareStatement("INSERT INTO `nguon_cc`(`ten_nha_cc`, `ten_dai_dien`, `sdt`, `dia_chi`, `email`, `id_exist`, `hinh_anh`) VALUES (?,?,?,?,?,1,?)");
            InputStream is = new FileInputStream(new File(hinh_anh));
            ps.setString(1, tennhacc);
            ps.setString(2, tendaidien);
            ps.setString(3, sdt);
            ps.setString(4, diachi);
            ps.setString(5, email);
            ps.setBlob(6, is);
            ps.executeUpdate();
            DAO.DataProvider.getIntance().close();
            JOptionPane.showMessageDialog(null,
                    "Thêm nhà cung cấp mới thành công.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

            DAO.daoThongBao.getInstance().insertThongBao("[Nhà cung cấp] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv + " đã thêm nhà cung cấp mới vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    //Lấy ra 1 nguồn cung cấp bằng id
    public NguonCungCap getNguonCungCap(int id_ncc) {
        String query = "SELECT * FROM `Nguon_cc` WHERE id_nguon_cc='" + id_ncc + "'";
        ArrayList<Object> arr = new ArrayList<>();
        NguonCungCap ncc = null;
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                ncc = new NguonCungCap(
                        rs.getInt("id_nguon_cc"),
                        rs.getString("ten_nha_cc"),
                        rs.getString("ten_dai_dien"),
                        rs.getString("sdt"),
                        rs.getString("dia_chi"),
                        rs.getString("email"),
                        rs.getInt("id_exist"),
                        rs.getBytes("hinh_anh")
                );

            } else {
                return null;
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return ncc;
    }

    //Update thông tin nguồn cung cấp
    public boolean UpdateNguonCungCap(int IdNguonCungCap,
            String TenNhaCungCap,
            String TenDaiDien,
            String Sdt,
            String DiaChi,
            String Email,
            int IdNhanVien) {
        if ("".equals(TenNhaCungCap) || "".equals(TenDaiDien) || "".equals(Sdt) || "".equals(DiaChi) || "".equals(Email)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa điền đầy đủ thông tin",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String query = "UPDATE `Nguon_cc` SET `ten_nha_cc`='" + TenNhaCungCap + "',`ten_dai_dien`='" + TenDaiDien + "',`sdt`='" + Sdt + "',`dia_chi`='" + DiaChi + "',`email`='" + Email + "' WHERE `id_nguon_cc`=" + IdNguonCungCap;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Sửa thông tin nhà cung cấp thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        DAO.daoThongBao.getInstance().insertThongBao("[Nhà cung cấp] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(IdNhanVien).ten_nv + " đã sửa thông tin của nhà cung cấp vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        return true;
    }
    public boolean HuyNguonCungCap(int id_ncc, int id_nv)
    {
        String query = "UPDATE `Nguon_cc` SET `id_exist`=0 WHERE `id_nguon_cc`=" + id_ncc;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        JOptionPane.showMessageDialog(null,
                "Xóa thông tin nhà cung cấp thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        DAO.daoThongBao.getInstance().insertThongBao("[Nhà cung cấp] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv + " đã xóa thông tin của nhà cung cấp vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        return true;
    }

    //Tìm số lần nhập kho của 1 nhà cung cấp
    public int GetSoLanNhapKho(int id_ncc) {
        int SoLanNhapKho = 0;
        String query = "SELECT * FROM `Chi_tiet_phieu_nhap` WHERE id_nguon_cc='" + id_ncc + "'";
        ArrayList<Object> arr = new ArrayList<>();

        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);

            while (rs.next()) {
                SoLanNhapKho++;
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return SoLanNhapKho;

    }

    //Tìm số lần xuất kho của một nhà cung cấp
    public int GetSoLanXuatKho(int id_ncc) {
        int SoLanXuatKho = 0;
        String query = "SELECT `phieu_xuat_kho`.`id_xuat_kho`, `lo_san_pham`.`id_phieu_nhap`,`chi_tiet_phieu_nhap`.`id_nguon_cc` "
                + "FROM `phieu_xuat_kho`,`lo_san_pham`,`chi_tiet_phieu_nhap` "
                + "WHERE `phieu_xuat_kho`.`id_lo_sp`=`lo_san_pham`.`id_lo_sp` and `chi_tiet_phieu_nhap`.`id_phieu_nhap`=`lo_san_pham`.`id_phieu_nhap` and id_nguon_cc='" + id_ncc + "'";
        ArrayList<Object> arr = new ArrayList<>();

        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);

            while (rs.next()) {
                ++SoLanXuatKho;
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return SoLanXuatKho;

    }
    public int GetSoLanTraKho(int id_ncc)
    {
        int SoLanTraKho = 0;
        String query = "SELECT `phieu_tra_kho`.`id_phieu_tra_kho`, `lo_san_pham`.`id_phieu_nhap`,`chi_tiet_phieu_nhap`.`id_nguon_cc` "
                + "FROM `phieu_tra_kho`,`lo_san_pham`,`chi_tiet_phieu_nhap` "
                + "WHERE `phieu_tra_kho`.`id_lo_sp`=`lo_san_pham`.`id_lo_sp` and `chi_tiet_phieu_nhap`.`id_phieu_nhap`=`lo_san_pham`.`id_phieu_nhap` and id_nguon_cc='" + id_ncc + "'";
        ArrayList<Object> arr = new ArrayList<>();

        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);

            while (rs.next()) {
                ++SoLanTraKho;
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return SoLanTraKho;
    }
    //Tìm số lượng lô nhập kho của một nhà cung cấp
    public int GetSoLuongTraKho(int id_ncc)
    {
        int SoLuongXuatKho = 0;
        String query = "SELECT * "
                + "FROM `phieu_tra_kho`,`lo_san_pham`,`chi_tiet_phieu_nhap` "
                + "WHERE `phieu_tra_kho`.`id_lo_sp`=`lo_san_pham`.`id_lo_sp` and `chi_tiet_phieu_nhap`.`id_phieu_nhap`=`lo_san_pham`.`id_phieu_nhap` and id_nguon_cc='" + id_ncc + "'";
        ArrayList<Object> arr = new ArrayList<>();

        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);

            while (rs.next()) {
                SoLuongXuatKho = SoLuongXuatKho + rs.getInt("sl_san_pham");
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return SoLuongXuatKho;
    }
    public int GetSoLuongNhapKho(int id_ncc) {
        int SoLuongNhapKho = 0;
        String query = "SELECT * FROM `Chi_tiet_phieu_nhap` WHERE id_nguon_cc='" + id_ncc + "'";
        ArrayList<Object> arr = new ArrayList<>();

        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);

            while (rs.next()) {
                SoLuongNhapKho = SoLuongNhapKho + rs.getInt("so_luong_lo");
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return SoLuongNhapKho;
    }

    //Tìm số lượng lô xuất kho của một nhà cung cấp
    public int GetSoLuongXuatKho(int id_ncc) {
        int SoLuongXuatKho = 0;
        String query = "SELECT * "
                + "FROM `phieu_xuat_kho`,`lo_san_pham`,`chi_tiet_phieu_nhap` "
                + "WHERE `phieu_xuat_kho`.`id_lo_sp`=`lo_san_pham`.`id_lo_sp` and `chi_tiet_phieu_nhap`.`id_phieu_nhap`=`lo_san_pham`.`id_phieu_nhap` and id_nguon_cc='" + id_ncc + "'";
        ArrayList<Object> arr = new ArrayList<>();

        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);

            while (rs.next()) {
                SoLuongXuatKho = SoLuongXuatKho + rs.getInt("sl_san_pham");
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return SoLuongXuatKho;

    }

    //Tìm kiếm trong bảng nguồn cung cấp (mới)
    public ArrayList<NguonCungCap> FindListNguonCungCap(ArrayList<NguonCungCap> DuLieuMau, String ValToSearch) {
        ArrayList<NguonCungCap> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {

            if (DuLieuMau.get(i).dia_chi.contains(ValToSearch)
                    || DuLieuMau.get(i).email.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).id_nguon_cc).contains(ValToSearch)
                    || DuLieuMau.get(i).sdt.contains(ValToSearch)
                    || DuLieuMau.get(i).ten_dai_dien.contains(ValToSearch)
                    || DuLieuMau.get(i).ten_nha_cc.contains(ValToSearch)) {
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

    //Lấy ra danh sách 20 nguồn cung cấp, để làm phân trang
    public ArrayList<NguonCungCap> get20NguonCungCap(ArrayList<NguonCungCap> arr, long Trang) {
        ArrayList<NguonCungCap> result = new ArrayList<>();
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }

    // Xuất file Excel cho nguồn cung cấp
    public void ExcelNguonCungCap(ArrayList<NguonCungCap> arr) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NguonCungCap");
        int rownum = 0;
        Cell cell;
        Row row;
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("Tên nhà cung cấp");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(1);
        cell.setCellValue("Tên Đại Diện");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(2);
        cell.setCellValue("SĐT");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(3);
        cell.setCellValue("Địa Chỉ");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(4);
        cell.setCellValue("Email");

        for (int i = 0; i < arr.size(); i++) {
            rownum++;
            row = sheet.createRow(rownum);
            //
            cell = row.createCell(0);
            cell.setCellValue(arr.get(i).ten_nha_cc);
            //
            cell = row.createCell(1);
            cell.setCellValue(arr.get(i).ten_dai_dien);
            //
            cell = row.createCell(2);
            cell.setCellValue(arr.get(i).sdt);
            //
            cell = row.createCell(3);
            cell.setCellValue(arr.get(i).dia_chi);
            //
            cell = row.createCell(4);
            cell.setCellValue(arr.get(i).email);
        }
        File file = new File("C:/demo/nguoncungcap.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile;
        try {
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fNhacungcap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(fNhacungcap.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Created file: " + file.getAbsolutePath());
    }
}
