/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.ChiTietPhieuNhap;
import DTO.NguonCungCap;
import DTO.NhanVien;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinh Tien
 */
public class daoNguonCungCap {
    private static daoNguonCungCap instance;
    public static daoNguonCungCap getInstance() {
        if(instance==null)instance=new daoNguonCungCap();
        return instance;
    }

    public daoNguonCungCap() {
    }
    //
    public ArrayList<NguonCungCap> getListNguonCungCap()
    {
        ArrayList<NguonCungCap> result = new ArrayList<>();
        String query="select *from Nguon_cc";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
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
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    public ArrayList<NguonCungCap> FindListNguonCungCap(String ValToSearch)
    {
        ArrayList<NguonCungCap> NguonCungCapList = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>();
        String searchQuery = "SELECT * FROM `Nguon_cc` WHERE CONCAT(`id_nguon_cc`, `ten_nha_cc`,`ten_dai_dien`,`sdt`,`dia_chi`) LIKE '%"+ValToSearch+"%'";
        try{
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(searchQuery, arr);          
            NguonCungCap Nguon;
            
            while(rs.next())
            {
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
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return NguonCungCapList;
    }
    public boolean insertNguonCungCap(String tennhacc, String tendaidien, String sdt, String diachi, String email, String hinh_anh,int id_nv)
    {
        if("".equals(hinh_anh))
        {
            JOptionPane.showMessageDialog(null,
            "Chưa chọn hình ảnh",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if("".equals(tennhacc) || "".equals(tendaidien) || "".equals(sdt) || "".equals(diachi) || "".equals(email))
        {
            JOptionPane.showMessageDialog(null,
            "Chưa điền đầy đủ thông tin",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try{
               DAO.DataProvider.getIntance().open();
               PreparedStatement ps = DAO.DataProvider.getIntance().getconn().prepareStatement("INSERT INTO `nguon_cc`(`ten_nha_cc`, `ten_dai_dien`, `sdt`, `dia_chi`, `email`, `id_exist`, `hinh_anh`) VALUES (?,?,?,?,?,1,?)");
               InputStream is = new FileInputStream(new File(hinh_anh));
               ps.setString(1, tennhacc);
               ps.setString(2, tendaidien);
               ps.setString(3, sdt);
               ps.setString(4, diachi);
               ps.setString(5, email);
               ps.setBlob(6,is);
               ps.executeUpdate();
               DAO.DataProvider.getIntance().close();
               JOptionPane.showMessageDialog(null,
            "Thêm nhà cung cấp mới thành công.",
            "Thông báo",
            JOptionPane.INFORMATION_MESSAGE);
               
                DAO.daoThongBao.getInstance().insertThongBao("[Nhà cung cấp] Nhân viên "+DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv+" đã thêm nhà cung cấp mới vào lúc "+ DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now,6);
           }catch(Exception ex){
               ex.printStackTrace();
           }
        return true;
    }
    public NguonCungCap getNguonCungCap(int id_ncc)
    {
        String query="SELECT * FROM `Nguon_cc` WHERE id_nguon_cc='"+id_ncc+"'";
        ArrayList<Object> arr = new ArrayList<>();
        NguonCungCap ncc=null;
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
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
            
        }
        else return null;
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return ncc;
    }
    public boolean UpdateNguonCungCap(int IdNguonCungCap, 
            String TenNhaCungCap, 
            String TenDaiDien, 
            String Sdt, 
            String DiaChi, 
            String Email,
            int IdNhanVien)
    {
        if("".equals(TenNhaCungCap) || "".equals(TenDaiDien) || "".equals(Sdt) || "".equals(DiaChi) || "".equals(Email))
        {
            JOptionPane.showMessageDialog(null,
            "Chưa điền đầy đủ thông tin",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String query = "UPDATE `Nguon_cc` SET `ten_nha_cc`='"+TenNhaCungCap+"',`ten_dai_dien`='"+TenDaiDien+"',`sdt`='"+Sdt+"',`dia_chi`='"+DiaChi+"',`email`='"+Email+"' WHERE `id_nguon_cc`="+IdNguonCungCap;
        //System.out.println(query);
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        JOptionPane.showMessageDialog(null,
            "Sửa thông tin nhà cung cấp thành công",
            "Thông báo",
            JOptionPane.INFORMATION_MESSAGE);
        DAO.daoThongBao.getInstance().insertThongBao("[Nhà cung cấp] Nhân viên "+DAO.daoTaiKhoan.getInstance().getNhanVien(IdNhanVien).ten_nv+" đã sửa thông tin của nhà cung cấp vào lúc "+ DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now,6);
        return true;
    }
    public int GetSoLanNhapKho(int id_ncc)
    {
        int SoLanNhapKho=0;
        String query="SELECT * FROM `Chi_tiet_phieu_nhap` WHERE id_nguon_cc='"+id_ncc+"'";
        ArrayList<Object> arr = new ArrayList<>();
        ArrayList<ChiTietPhieuNhap> NguonCungCapList = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        ChiTietPhieuNhap Nguon;
        if(rs.next())
        {
            Nguon = new ChiTietPhieuNhap(
                                rs.getInt("id_ctpn"),
                                rs.getInt("so_tien_lo"),
                                rs.getInt("so_luong_lo"),
                                rs.getInt("id_nguon_cc"),
                                rs.getInt("id_phieu_nhap")
                                );
             NguonCungCapList.add(Nguon);
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        if(NguonCungCapList.size()>0)
        {
            SoLanNhapKho=NguonCungCapList.size();
        }
        return SoLanNhapKho;
        
    }
    public int GetSoLanXuatKho(int id_ncc)
    {
        int SoLanXuatKho=0;
        String query="SELECT `phieu_xuat_kho`.`id_xuat_kho`, `lo_san_pham`.`id_phieu_nhap`,`chi_tiet_phieu_nhap`.`id_nguon_cc` "
                + "FROM `phieu_xuat_kho`,`lo_san_pham`,`chi_tiet_phieu_nhap` "
                + "WHERE `phieu_xuat_kho`.`id_lo_sp`=`lo_san_pham`.`id_lo_sp` and `chi_tiet_phieu_nhap`.`id_phieu_nhap`=`lo_san_pham`.`id_phieu_nhap` and id_nguon_cc='"+id_ncc+"'";
        ArrayList<Object> arr = new ArrayList<>();
        
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        
        while(rs.next())
        {
            ++SoLanXuatKho;
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return SoLanXuatKho;
        
    }
}
