/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Kho;
import DTO.NhanVien;
import DTO.PhieuTraKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinh Tien
 */
public class daoTraNhaCungCap {
    private static daoTraNhaCungCap instance;

    public static daoTraNhaCungCap getInstance() {
        if(instance==null)instance=new daoTraNhaCungCap();
        return instance;
    }

    public daoTraNhaCungCap() {
    }
    public  ArrayList<PhieuTraKho> getListTraKho()
    {
         ArrayList<PhieuTraKho> result = new ArrayList<>();
        String query="select * from Phieu_xuat_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new PhieuTraKho(rs.getInt("id_phieu_tra_kho"),
                    rs.getString("thoi_gian_tra"),
                    rs.getInt("sl_san_pham"),
                    rs.getString("hinh_thuc_tra"),
                    rs.getInt("id_lo_sp"),
                    rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
     public PhieuTraKho getTraKho(int id_pt)
    {
        PhieuTraKho result = null;
        String query="SELECT * FROM `Phieu_tra_kho` WHERE id_phieu_tra_kho="+id_pt;
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            
            result = (new PhieuTraKho(rs.getInt("id_phieu_tra_kho"),
                    rs.getString("thoi_gian_tra"),
                    rs.getInt("sl_san_pham"),
                    rs.getString("hinh_thuc_tra"),
                    rs.getInt("id_lo_sp"),
                    rs.getInt("id_nv")));
                    
        }
        else
        {
            result=null;
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
     public boolean InsertPhieuTra(int id_kho,int id_nv)
    {
        Kho kho = DAO.daoKho.getInstance().getIdKho(id_kho);
        String ngay = DAO.DateTimeNow.getIntance().Now;
        String query = "INSERT INTO `phieu_tra_kho`("
                + "`thoi_gian_tra`, "
                + "`sl_san_pham`, "
                + "`hinh_thuc_tra`, "
                + "`id_lo_sp`, "
                + "`id_nv`) VALUES ("
                + "'"+ngay+"',"
                + ""+kho.sl_san_pham+","
                + "'Trả nhà cung cấp',"
                + ""+kho.id_lo_sp+","
                + ""+id_nv+")";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        JOptionPane.showMessageDialog(null,
            "Tạo phiếu trả thành công",
            "Thông báo",
            JOptionPane.INFORMATION_MESSAGE);
        NhanVien nv = DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv);
        DAO.daoKho.getInstance().updateSoLuongKho(0, kho.id_lo_sp);
        DAO.daoThongBao.getInstance().insertThongBao("[Trả hàng] Nhân viên "+nv.ten_nv+" đã trả hàng vào lúc "+ ngay, ngay,2);
        daoTonKho.getInstance().CapNhatTonKho();
        return true;
    }
}
