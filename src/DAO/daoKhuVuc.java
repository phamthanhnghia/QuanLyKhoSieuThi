/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuVuc;
import DTO.LoaiKho;
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
import javax.swing.JOptionPane;

/**
 *
 * @author nghia
 */
public class daoKhuVuc {

    private static daoKhuVuc instance;

    public static daoKhuVuc getInstance() {
        if (instance == null) {
            instance = new daoKhuVuc();
        }
        return instance;
    }

    // Lấy danh sách thông tin từ bảng khu vực
    public ArrayList<KhuVuc> getListKhuVuc() {
        ArrayList<KhuVuc> result = new ArrayList<>();
        String query = "select * from Khu_vuc where id_exist=1";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new KhuVuc(rs.getInt("id_khu_vuc"), rs.getString("ten_khu_vuc"), rs.getString("vi_tri"), rs.getInt("id_exist"), rs.getInt("id_loai_kho")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Lấy ra 1 khu vực từ tên khu vực
    public KhuVuc getIDKhuVuc(String tenkhuvuc) {
        KhuVuc result = null;
        String query = "select *from khu_vuc where ten_khu_vuc = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(tenkhuvuc);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new KhuVuc(rs.getInt("id_khu_vuc"), rs.getString("ten_khu_vuc"), rs.getString("vi_tri"), rs.getInt("id_exist"), rs.getInt("id_loai_kho")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
    //Lấy ra 1 khu vực từ id khu vực

    public KhuVuc getKhuVuc(int id_khu_vuc) {
        KhuVuc result = null;
        String query = "select *from khu_vuc where id_khu_vuc = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(id_khu_vuc);
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result = (new KhuVuc(rs.getInt("id_khu_vuc"),
                        rs.getString("ten_khu_vuc"),
                        rs.getString("vi_tri"),
                        rs.getInt("id_exist"),
                        rs.getInt("id_loai_kho")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
    //Xuất khu vực ra file excel

    public void ExcelKhuVuc(ArrayList<KhuVuc> arr) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("KhuVuc");
        int rownum = 0;
        Cell cell;
        Row row;
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("id khu vực");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(1);
        cell.setCellValue("Tên Khu Vực");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(2);
        cell.setCellValue("Vị trí");
        //

        for (int i = 0; i < arr.size(); i++) {
            rownum++;
            row = sheet.createRow(rownum);
            //
            cell = row.createCell(0);
            cell.setCellValue(arr.get(i).id_khu_vuc);
            //
            cell = row.createCell(1);
            cell.setCellValue(arr.get(i).ten_khu_vuc);
            //
            cell = row.createCell(2);
            cell.setCellValue(arr.get(i).vi_tri);
            //

        }
        File file = new File("C:/demo/khuvuc.xls");
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
    public boolean insertKhuVuc(String tenkv,String vitri,String loaikho,int id_nv)
    {
        LoaiKho lk = DAO.daoLoaiKho.getInstance().getLoaiKho(loaikho);
        String query = "INSERT INTO `khu_vuc`(`ten_khu_vuc`, `vi_tri`, `id_exist`, `id_loai_kho`) VALUES ('"+tenkv+"','"+vitri+"',1,"+lk.id_loai_kho+")";
        try {
            DataProvider.getIntance().open();
            DataProvider.getIntance().excuteQuery(query);
            DataProvider.getIntance().close();
            JOptionPane.showMessageDialog(null, "Thêm khu vực thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            DAO.daoThongBao.getInstance().insertThongBao("[Khu vực] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv + " đã thêm khu vực mới vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Thêm khu vực Thất bại", "Thông báo", 1);
             return false;
        }
        return true;
    }
    public boolean updateKhuVuc(String tenkv,String vitri,String loaikho,int id_nv,int id)
    {
        LoaiKho lk = DAO.daoLoaiKho.getInstance().getLoaiKho(loaikho);
        String query = "UPDATE `khu_vuc` SET `ten_khu_vuc`='"+tenkv+"',`vi_tri`='"+vitri+"',`id_loai_kho`="+lk.id_loai_kho+" WHERE `id_khu_vuc`="+id;
        try {
            DataProvider.getIntance().open();
            DataProvider.getIntance().excuteQuery(query);
            DataProvider.getIntance().close();
            JOptionPane.showMessageDialog(null, "Sửa khu vực thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            DAO.daoThongBao.getInstance().insertThongBao("[Khu vực] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv + " đã sửa khu vực vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Sửa khu vực Thất bại", "Thông báo", 1);
             return false;
        }
        return true;
    }
    public boolean HuyKhuVuc(int id, int id_nv)
    {
        String query = "UPDATE `khu_vuc` SET `id_exist`="+0+" WHERE `id_khu_vuc`="+id;
        try {
            DataProvider.getIntance().open();
            DataProvider.getIntance().excuteQuery(query);
            DataProvider.getIntance().close();
            JOptionPane.showMessageDialog(null, "Xóa khu vực thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            DAO.daoThongBao.getInstance().insertThongBao("[Khu vực] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv + " đã xóa khu vực vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Xóa khu vực Thất bại", "Thông báo", 1);
             return false;
        }
        return true;
    }

    public void HuyPhieuNhap(int id, int id_nv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
