/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.TaiKhoan;
import DTO.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Dinh Tien
 */
public class daoTaiKhoan {
     private static daoTaiKhoan instance;

    public static daoTaiKhoan getInstance() {
        if(instance==null)instance=new daoTaiKhoan();
        return instance;
    }

    public daoTaiKhoan() {
    }
    public ArrayList<TaiKhoan> getListTaiKhoan()
    {
        ArrayList<TaiKhoan> result = new ArrayList<>();
        String query="select *from Tai_khoan";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new TaiKhoan(rs.getInt("id_tk"),
                    rs.getString("ten_tai_khoan"),
                    rs.getString("mat_khau"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_nv"),
                    rs.getInt("loai")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public boolean KiemTraDangNhap(String User, String Pass)
    {
        ArrayList<Object> arr = new ArrayList<>();
        
        String query="SELECT * FROM `Tai_khoan` WHERE ten_tai_khoan='"+User+"' and mat_khau='"+Pass+"'";
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            return true;
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
                return false;
    }
    public int KiemTraTaiKhoan(String User, String Pass, String Mkmoi, String MK){
        TaiKhoan Tk = getTaiKhoan(User,Pass);
        if(Tk == null) 
        {
            JOptionPane.showMessageDialog(null,
            "Tên đăng nhập hoặc mật khẩu sai.",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return 1;
        }
        if("".equals(Mkmoi) || "".equals(MK))
        {
            JOptionPane.showMessageDialog(null,
            "Chưa nhập mật khẩu mới",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return 2;
        }
        if(Mkmoi.equals(Pass))
        {
            JOptionPane.showMessageDialog(null,
            "Mật khẩu mới trùng mật khẩu cũ",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return 3;
        }
        if(!Mkmoi.equals(MK))
        {
            JOptionPane.showMessageDialog(null,
            "Mật khẩu mới không khớp",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return 4;
        }
        String query = "UPDATE `tai_khoan` SET mat_khau='"+Mkmoi+"'WHERE ten_tai_khoan='"+User+"' and mat_khau='"+Pass+"'";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        JOptionPane.showMessageDialog(null,
            "Sửa mật khẩu thành công",
            "Thông báo",
            JOptionPane.OK_OPTION);

        return 0;
    }
    
    public TaiKhoan getTaiKhoan(String User, String Pass){
        TaiKhoan result = null;
        String query="SELECT * FROM `Tai_khoan` WHERE ten_tai_khoan='"+User+"' and mat_khau='"+Pass+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            
            result = (new TaiKhoan(rs.getInt("id_tk"),
                    rs.getString("ten_tai_khoan"),
                    rs.getString("mat_khau"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_nv"),
                    rs.getInt("loai")));
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
    public TaiKhoan getTaiKhoan(int id_nhanvien){
        TaiKhoan result = null;
        String query="SELECT * FROM `Tai_khoan` WHERE id_tk='"+id_nhanvien+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new TaiKhoan(rs.getInt("id_tk"),
                    rs.getString("ten_tai_khoan"),
                    rs.getString("mat_khau"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_nv"),
                    rs.getInt("loai")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public NhanVien getNhanVien(int id_nv)
    {
        String query="SELECT * FROM `Nhan_vien` WHERE id_nv='"+id_nv+"'";
        ArrayList<Object> arr = new ArrayList<>();
        NhanVien tk;
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            tk = (new NhanVien(rs.getInt("id_nv"),
                    rs.getString("ten_nv"),
                    rs.getString("sdt"),
                    rs.getString("cnmd"),
                    rs.getString("ngay_sinh"),
                    rs.getBytes("hinh_anh"),
                    rs.getInt("id_exist")));
            return tk;
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return null;
    }
}
