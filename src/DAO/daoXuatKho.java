/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NguonCungCap;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.XuatKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinh Tien
 */
public class daoXuatKho {
    private static daoXuatKho instance;

    public static daoXuatKho getInstance() {
        if(instance==null)instance=new daoXuatKho();
        return instance;
    }

    public daoXuatKho() {
    }
    // Hàm trả về danh sách xuất kho
    public  ArrayList<XuatKho> getListXuatKho()
    {
         ArrayList<XuatKho> result = new ArrayList<>();
        String query="select * from Phieu_xuat_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new XuatKho(rs.getInt("id_xuat_kho"),rs.getInt("sl_san_pham"),rs.getString("thoi_gian_xuat"),rs.getInt("id_lo_sp"),rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    //Hàm kiểm tra thông tin xuất kho trước khi thêm
    public boolean KiemTraXuatKho(String id_lo, String slton, String slxuat, String ngay,int id_nv)
    {
        if(slton==null || "".equals(id_lo))
        {
            JOptionPane.showMessageDialog(null,
            "Chưa chọn sản phẩm",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int sl = Integer.parseInt(slton);
        int slx = Integer.parseInt(slxuat);
        if(slx <= 0 || slx > sl) 
        {
            JOptionPane.showMessageDialog(null,
            "Số lượng xuất không hợp lệ",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        ngay = DAO.DateTimeNow.getIntance().Now;
        String query = "INSERT INTO `phieu_xuat_kho`(`sl_san_pham`, `thoi_gian_xuat`, `id_lo_sp`, `id_nv`) VALUES ("+slxuat+",'"+ngay+"',"+id_lo+","+id_nv+")";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        JOptionPane.showMessageDialog(null,
            "Thêm phiếu xuất thành công",
            "Thông báo",
            JOptionPane.INFORMATION_MESSAGE);
        NhanVien nv = DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv);
        int soluong =sl-slx;
        int id_loi = Integer.parseInt(id_lo);
        DAO.daoKho.getInstance().updateSoLuongKho(soluong, id_loi);
        DAO.daoThongBao.getInstance().insertThongBao("[Xuất kho] Nhân viên "+nv.ten_nv+" đã xuất hàng ra kho vào lúc "+ ngay, ngay,2);
        daoTonKho.getInstance().CapNhatTonKho();
        return true;
    }
    //Hàm tìm kiếm xuất kho
    public String[][] FindListXuatKho(String ValToSearch)
    {
        String [][] Data=new String[1000][5];
        int RowData;
        RowData = 0;
        ArrayList<XuatKho> DuLieuXuatKho = getListXuatKho();
        for (int i=0;i<DuLieuXuatKho.size();i++)
        {
            int id_sp=DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuXuatKho.get(i).id_lo).id_sp;
            String tensp=DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
            String loaisp=DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
            String tennv=DAO.daoTaiKhoan.getInstance().getNhanVien(DuLieuXuatKho.get(i).id_nv).ten_nv;
            String sl_sp=String.valueOf(DuLieuXuatKho.get(i).sl_sp);
            if (DuLieuXuatKho.get(i).thoi_gian_xuat.contains(ValToSearch) ||
                    tensp.contains(ValToSearch) ||
                    loaisp.contains(ValToSearch) ||
                    sl_sp.contains(ValToSearch) ||
                    tennv.contains(ValToSearch))
            {
               //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                 // System.out.println(sl_sp);
                //   System.out.println(tennv);
               Data[RowData][0]=DuLieuXuatKho.get(i).thoi_gian_xuat;
               Data[RowData][1]=tensp;
               Data[RowData][2]=loaisp;
               Data[RowData][3]=sl_sp;
               Data[RowData][4]=tennv;
               RowData++;
            }
        }       
        return Data;
    }
}
