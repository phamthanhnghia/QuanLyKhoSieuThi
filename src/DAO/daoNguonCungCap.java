/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
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
    public boolean insertNguonCungCap(String tennhacc, String tendaidien, String sdt, String diachi, String email, String hinh_anh)
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
}
