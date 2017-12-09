/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NguonCungCap;
import DTO.NhanVien;
import DTO.SanPham;
import GUI.fNhacungcap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.lang.*;

/**
 *
 * @author VIENTHONGA
 */
public class daoNhanVien {

    private static daoNhanVien instance;

    public static daoNhanVien getInstance() {
        if (instance == null) {
            instance = new daoNhanVien();
        }
        return instance;
    }

    public daoNhanVien() {
    }

    //Lấy danh sách thông tin từ bảng nhân viên
    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> result = new ArrayList<>();
        String query = "select *from nhan_vien";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new NhanVien(rs.getInt("id_nv"),
                        rs.getString("ten_nv"),
                        rs.getString("sdt"),
                        rs.getString("cnmd"),
                        rs.getString("ngay_sinh"),
                        rs.getBytes("hinh_anh"),
                        rs.getInt("id_exist")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Tìm kiếm trong bảng nhân viên (cũ)
    public ArrayList<NhanVien> FindListNhanVien(String ValToSearch) {
        ArrayList<NhanVien> nhanvienList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `nhan_vien` WHERE CONCAT(`id_nv`, `ten_nv`,`cnmd`,`ngay_sinh`,`sdt`) LIKE '%" + ValToSearch + "%'";
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);
            NhanVien nhanvien;

            while (rs.next()) {
                nhanvien = new NhanVien(
                        rs.getInt("id_nv"),
                        rs.getString("ten_nv"),
                        rs.getString("sdt"),
                        rs.getString("cnmd"),
                        rs.getString("ngay_sinh"),
                        rs.getBytes("hinh_anh"),
                        rs.getInt("id_exist")
                );
                nhanvienList.add(nhanvien);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return nhanvienList;
    }
    //Xuất file Excel thông tin nhân viên

    public void ExcelNhanVien(ArrayList<NhanVien> arr) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NhanVien");
        int rownum = 0;
        Cell cell;
        Row row;
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("Tên Nhân Viên");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(1);
        cell.setCellValue("Ngày Sinh");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(2);
        cell.setCellValue("CMND");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(3);
        cell.setCellValue("SĐT");

        for (int i = 0; i < arr.size(); i++) {
            rownum++;
            row = sheet.createRow(rownum);
            //
            cell = row.createCell(0);
            cell.setCellValue(arr.get(i).ten_nv);
            //
            cell = row.createCell(1);
            cell.setCellValue(arr.get(i).ngay_sinh);
            //
            cell = row.createCell(2);
            cell.setCellValue(arr.get(i).cmnd);
            //
            cell = row.createCell(3);
            cell.setCellValue(arr.get(i).sdt);
        }
        File file = new File("C:/demo/nhanvien.xls");
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
    //Tìm kiếm trong bảng nhân viên (mới)

    public ArrayList<NhanVien> FindListNhanVien(ArrayList<NhanVien> DuLieuMau, String ValToSearch) {
        ArrayList<NhanVien> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {
            if (DuLieuMau.get(i).ten_nv.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).id_nv).contains(ValToSearch)
                    || DuLieuMau.get(i).sdt.contains(ValToSearch)
                    || DuLieuMau.get(i).ngay_sinh.contains(ValToSearch)
                    || DuLieuMau.get(i).cmnd.contains(ValToSearch)) {
                result.add(DuLieuMau.get(i));
            }
        }
        return result;
    }
    //Lấy danh sách 20 nhân viên, để làm phân trang

    public ArrayList<NhanVien> get20NhanVien(ArrayList<NhanVien> arr, long Trang) {
        ArrayList<NhanVien> result = new ArrayList<>();

        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
}
