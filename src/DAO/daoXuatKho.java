/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Kho;
import DTO.NguonCungCap;
import DTO.NhanVien;
import DTO.SanPham;
import DTO.XuatKho;
import GROUP.ThongTinXuat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.lang.*;

/**
 *
 * @author Dinh Tien
 */
public class daoXuatKho {

    private static daoXuatKho instance;

    public static daoXuatKho getInstance() {
        if (instance == null) {
            instance = new daoXuatKho();
        }
        return instance;
    }

    public daoXuatKho() {
    }

    // Hàm trả về danh sách xuất kho
    public ArrayList<XuatKho> getListXuatKho() {
        ArrayList<XuatKho> result = new ArrayList<>();
        String query = "select * from Phieu_xuat_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new XuatKho(rs.getInt("id_xuat_kho"), rs.getInt("sl_san_pham"), rs.getString("thoi_gian_xuat"), rs.getInt("id_lo_sp"), rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Lấy ra danh sách thông tin xuất kho từ nhiều bảng
    public ArrayList<ThongTinXuat> getListThongTinXuatKho() {
        ArrayList<ThongTinXuat> result = new ArrayList<>();
        String query = "SELECT phieu_xuat_kho.id_xuat_kho, phieu_xuat_kho.thoi_gian_xuat, san_pham.ten_sp, loai_sp.ten_loai_sp, phieu_xuat_kho.sl_san_pham,nhan_vien.ten_nv "
                + "FROM `phieu_xuat_kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`nhan_vien` "
                + "WHERE phieu_xuat_kho.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "and san_pham.id_loai_sp = loai_sp.id_loai_sp "
                + "and phieu_xuat_kho.id_nv=nhan_vien.id_nv "
                + "ORDER by phieu_xuat_kho.thoi_gian_xuat DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinXuat(rs.getInt("phieu_xuat_kho.id_xuat_kho"),
                        rs.getString("phieu_xuat_kho.thoi_gian_xuat"),
                        rs.getString("san_pham.ten_sp"),
                        rs.getString("loai_sp.ten_loai_sp"),
                        rs.getInt("phieu_xuat_kho.sl_san_pham"),
                        rs.getString("nhan_vien.ten_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    // thong tin xuat theo id lô
    public ArrayList<ThongTinXuat> getListThongTinXuatKho(int id_lo) {
        ArrayList<ThongTinXuat> result = new ArrayList<>();
        String query = "SELECT phieu_xuat_kho.id_xuat_kho, phieu_xuat_kho.thoi_gian_xuat, san_pham.ten_sp, loai_sp.ten_loai_sp, phieu_xuat_kho.sl_san_pham,nhan_vien.ten_nv "
                + "FROM `phieu_xuat_kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`nhan_vien` "
                + "WHERE phieu_xuat_kho.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + "and san_pham.id_loai_sp = loai_sp.id_loai_sp "
                + "and phieu_xuat_kho.id_nv=nhan_vien.id_nv "
                + "and phieu_xuat_kho.id_lo_sp = '" + id_lo + "' "
                + "ORDER by phieu_xuat_kho.thoi_gian_xuat DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinXuat(rs.getInt("phieu_xuat_kho.id_xuat_kho"),
                        rs.getString("phieu_xuat_kho.thoi_gian_xuat"),
                        rs.getString("san_pham.ten_sp"),
                        rs.getString("loai_sp.ten_loai_sp"),
                        rs.getInt("phieu_xuat_kho.sl_san_pham"),
                        rs.getString("nhan_vien.ten_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Lấy ra số lần xuất kho trong thời gian tương ứng
    public int SoLanXuatKhoTheoThoiGian(String thoi_gian) {
        int so_lan = 0;
        String query = "SELECT COUNT(id_xuat_kho) AS lan_xuat_kho FROM `phieu_xuat_kho` WHERE phieu_xuat_kho.thoi_gian_xuat LIKE '%" + thoi_gian + "%'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                so_lan = rs.getInt("lan_xuat_kho");
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return so_lan;
    }

    // Lấy ra danh sách xuất kho theo thời gian tương ứng
    public ArrayList<XuatKho> getListXuatKhoTheoThoiGian(String thoi_gian) {
        ArrayList<XuatKho> result = new ArrayList<>();
        String query = "SELECT * FROM `phieu_xuat_kho` WHERE phieu_xuat_kho.thoi_gian_xuat LIKE '%" + thoi_gian + "%'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new XuatKho(rs.getInt("id_xuat_kho"), rs.getInt("sl_san_pham"), rs.getString("thoi_gian_xuat"), rs.getInt("id_lo_sp"), rs.getInt("id_nv")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }

    //Hàm kiểm tra thông tin xuất kho trước khi thêm
    public boolean KiemTraXuatKho(String id_lo, String slton, String slxuat, String ngay, int id_nv) {
        if (slton == null || "".equals(id_lo)) {
            JOptionPane.showMessageDialog(null,
                    "Chưa chọn sản phẩm",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int sl = Integer.parseInt(slton);
        int slx = Integer.parseInt(slxuat);
        if (slx <= 0 || slx > sl) {
            JOptionPane.showMessageDialog(null,
                    "Số lượng xuất không hợp lệ",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        ngay = DAO.DateTimeNow.getIntance().Now;
        
        String query = "INSERT INTO `phieu_xuat_kho`(`sl_san_pham`, `thoi_gian_xuat`, `id_lo_sp`, `id_nv`) VALUES (" + slxuat + ",'" + ngay + "'," + id_lo + "," + id_nv + ")";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        
        if(slx == sl){
            daoLoSanPham.getInstance().CapNhatLoKhiTraKho(Integer.parseInt(id_lo));
        }
        
        JOptionPane.showMessageDialog(null,
                "Thêm phiếu xuất thành công",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        NhanVien nv = DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv);
        int soluong = sl - slx;
        int id_loi = Integer.parseInt(id_lo);
        DAO.daoKho.getInstance().updateSoLuongKhotheo_ID_LO(soluong, id_loi);
        DAO.daoThongBao.getInstance().insertThongBao("[Xuất kho] Nhân viên " + nv.ten_nv + " đã xuất hàng ra kho vào lúc " + ngay, ngay, 2);
        daoTonKho.getInstance().CapNhatTonKho();
        return true;
    }

    //Hàm tìm kiếm xuất kho
    public ArrayList<ThongTinXuat> FindListXuatKho(ArrayList<ThongTinXuat> DuLieuMau, String ValToSearch) {
        ArrayList<ThongTinXuat> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {
            if (DuLieuMau.get(i).thoi_gian_xuat.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).id_xuat_kho).contains(ValToSearch)
                    || DuLieuMau.get(i).loai_san_pham.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).sl_san_pham).contains(ValToSearch)
                    || DuLieuMau.get(i).ten_nv.contains(ValToSearch)
                    || DuLieuMau.get(i).ten_san_pham.contains(ValToSearch)) {
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

    /*public String[][] FindListXuatKho(ArrayList<XuatKho> DuLieuXuatKho,String ValToSearch)
    {
        String [][] Data=new String[1000][6];
        int RowData;
        RowData = 0;
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
               Data[RowData][0]=String.valueOf(DuLieuXuatKho.get(i).id_xuat_kho);
               Data[RowData][1]=DuLieuXuatKho.get(i).thoi_gian_xuat;
               Data[RowData][2]=tensp;
               Data[RowData][3]=loaisp;
               Data[RowData][4]=sl_sp;
               Data[RowData][5]=tennv;
               RowData++;
            }
        }       
        return Data;
    }*/
    // Lấy ra 1 thông tin xuất kho từ id
    public XuatKho getXuatKho(int id_px) {
        XuatKho result = null;
        String query = "SELECT * FROM `Phieu_xuat_kho` WHERE id_xuat_kho=" + id_px;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {

                result = (new XuatKho(rs.getInt("id_xuat_kho"),
                        rs.getInt("sl_san_pham"),
                        rs.getString("thoi_gian_xuat"),
                        rs.getInt("id_lo_sp"),
                        rs.getInt("id_nv")));

            } else {
                result = null;
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }

    // kiểm tra nếu phù hợp với số lượng tồn thì xuất, không thì cho qua hổ trợ cho DataSeeder
    public void RunXuatKho(int id_lo, int sl_xuat, String thoi_gian, int id_nv) {
        Kho _kho = daoKho.getInstance().getLoKho(id_lo);
        if (_kho != null && _kho.sl_san_pham > sl_xuat) {
            int sl_sp = _kho.sl_san_pham - sl_xuat;
            daoKho.getInstance().updateSoLuongKhotheo_ID_LO(sl_sp, id_lo);
            String query = "INSERT INTO `phieu_xuat_kho`(`sl_san_pham`, `thoi_gian_xuat`, `id_lo_sp`, `id_nv`) VALUES (" + sl_xuat + ",'" + thoi_gian + "'," + id_lo + "," + id_nv + ")";
            ArrayList<Object> arr = new ArrayList<>();
            DataProvider.getIntance().open();
            DataProvider.getIntance().excuteUpdate(query, arr);
            DataProvider.getIntance().close();
        }
    }

    //Lấy 20 thông tin xuất kho, để phân trang
    public ArrayList<ThongTinXuat> get20XuatKho(ArrayList<ThongTinXuat> arr, long Trang) {
        ArrayList<ThongTinXuat> result = new ArrayList<>();
        /*String query="SELECT * from `phieu_xuat_kho` "
                + "WHERE `id_xuat_kho` not in ("
                + "select * from ("
                + "select `id_xuat_kho` from `phieu_xuat_kho` "
                + "order by `id_xuat_kho` limit "+(trang*20-20)+") as t) order by `id_xuat_kho` limit 20"; 
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
        }*/
        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
    public boolean HuyPhieuXuat(int id, int id_nv)
    {
        String query = "UPDATE `phieu_xuat_kho` SET `id_exist`="+0+" WHERE `id_xuat_kho`="+id;
        try {
            DataProvider.getIntance().open();
            DataProvider.getIntance().excuteQuery(query);
            DataProvider.getIntance().close();
            JOptionPane.showMessageDialog(null, "Xóa phiếu xuất thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            DAO.daoThongBao.getInstance().insertThongBao("[Xuất kho] Nhân viên " + DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv).ten_nv + " đã xóa phiếu xuất vào lúc " + DAO.DateTimeNow.getIntance().Now, DAO.DateTimeNow.getIntance().Now, 6);
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Xóa phiếu xuất thất bại", "Thông báo", 1);
             return false;
        }
        return true;
    }
}
