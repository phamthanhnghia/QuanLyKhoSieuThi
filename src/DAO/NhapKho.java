/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoSanPham;
import DTO.LoaiSanPham;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.SanPham;
import GROUP.ThongTinNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author nghia
 */
public class NhapKho {

    private static NhapKho instance;

    public static NhapKho getInstance() {
        if (instance == null) {
            instance = new NhapKho();
        }
        return instance;
    }

    public int so_luong_sp;
    public int so_tien_sp;
    public int id_sp;
    public String thoi_gian;
    public String ghi_chu;
    public int id_nv;
    public String hsd;
    public String nsx;
    public int id_nguon_cc; // id chi tiet phieu nhap
    public int so_tien_lo; // 
    public int so_luong_lo; //

    public NhapKho() {
    }

    public NhapKho(String thoi_gian, int so_luong_sp, int so_tien_sp, int id_sp, String ghi_chu, int id_nv, String hsd, String nsx, int id_nguon_cc, int so_tien_lo, int so_luong_lo) {
        this.so_luong_sp = so_luong_sp;
        this.so_tien_sp = so_tien_sp;
        this.id_sp = id_sp;
        this.thoi_gian = thoi_gian;
        this.ghi_chu = ghi_chu;
        this.id_nv = id_nv;
        this.hsd = hsd;
        this.nsx = nsx;
        this.id_nguon_cc = id_nguon_cc;
        this.so_tien_lo = so_tien_lo;
        this.so_luong_lo = so_luong_lo;
    }

    public boolean check() {
        return true;
    }

    //Lấy ra danh sách thông tin nhập kho từ bảng phiếu nhập, chi tiết phiếu nhập, lô sản phẩm, sản phẩm, v.v.....
    public ArrayList<ThongTinNhap> getListDanhSachNhapKho() {
        ArrayList<ThongTinNhap> result = new ArrayList<>();
        String query = "SELECT * FROM `phieu_nhap`,`chi_tiet_phieu_nhap`,`nhan_vien`,`lo_san_pham`,`san_pham`,`loai_sp`,`chi_tiet_lo_sp`,`nguon_cc` WHERE phieu_nhap.id_phieu_nhap =chi_tiet_phieu_nhap.id_phieu_nhap AND phieu_nhap.id_nv = nhan_vien.id_nv AND san_pham.id_loai_sp = loai_sp.id_loai_sp AND san_pham.id_sp = chi_tiet_lo_sp.id_sp AND chi_tiet_lo_sp.id_lo_sp= lo_san_pham.id_lo_sp AND nguon_cc.id_nguon_cc = chi_tiet_phieu_nhap.id_nguon_cc AND lo_san_pham.id_phieu_nhap = phieu_nhap.id_phieu_nhap AND phieu_nhap.id_exist = 1 ORDER BY phieu_nhap.thoi_gian ASC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinNhap(rs.getInt("id_phieu_nhap"),
                        rs.getString("thoi_gian"),
                        rs.getString("ghi_chu"),
                        rs.getInt("so_tien_lo"),
                        rs.getInt("so_luong_lo"),
                        rs.getString("ten_sp"),
                        rs.getString("ten_loai_sp"),
                        rs.getString("dvt"),
                        rs.getInt("id_lo_sp"),
                        rs.getString("hsd"),
                        rs.getString("nsx"),
                        rs.getInt("id_ton_kho"),
                        rs.getInt("id_chi_tiet_sp"),
                        rs.getInt("so_luong_sp"),
                        rs.getInt("so_tien_sp"),
                        rs.getString("ten_nv"),
                        rs.getString("ten_nha_cc"),
                        rs.getString("nguon_cc.sdt"),
                        rs.getString("dia_chi"),
                        rs.getString("email"),
                        rs.getBytes("nguon_cc.hinh_anh")));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
    // Lấy ra thông tin nhập ro từ id nhập
    public ThongTinNhap getThongTinNhap(int id) {
        ThongTinNhap result = null;
        String query = "SELECT * FROM `phieu_nhap`,`chi_tiet_phieu_nhap`,`nhan_vien`,`lo_san_pham`,`san_pham`,`loai_sp`,`chi_tiet_lo_sp`,`nguon_cc` WHERE phieu_nhap.id_phieu_nhap =chi_tiet_phieu_nhap.id_phieu_nhap AND phieu_nhap.id_nv = nhan_vien.id_nv AND san_pham.id_loai_sp = loai_sp.id_loai_sp AND san_pham.id_sp = chi_tiet_lo_sp.id_sp AND chi_tiet_lo_sp.id_lo_sp= lo_san_pham.id_lo_sp AND nguon_cc.id_nguon_cc = chi_tiet_phieu_nhap.id_nguon_cc AND lo_san_pham.id_phieu_nhap = phieu_nhap.id_phieu_nhap AND phieu_nhap.id_exist = 1 AND phieu_nhap.id_phieu_nhap=" + id;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new ThongTinNhap(rs.getInt("id_phieu_nhap"),
                        rs.getString("thoi_gian"),
                        rs.getString("ghi_chu"), rs.getInt("so_tien_lo"), rs.getInt("so_luong_lo"), rs.getString("ten_sp"), rs.getString("ten_loai_sp"), rs.getString("dvt"), rs.getInt("id_lo_sp"), rs.getString("hsd"), rs.getString("nsx"), rs.getInt("id_ton_kho"), rs.getInt("id_chi_tiet_sp"), rs.getInt("so_luong_sp"), rs.getInt("so_tien_sp"), rs.getString("ten_nv"), rs.getString("ten_nha_cc"), rs.getString("nguon_cc.sdt"), rs.getString("dia_chi"), rs.getString("email"), rs.getBytes("nguon_cc.hinh_anh"));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
    // Lấy ra 1 thông tin nhập từ thời gian cụ thể
    public ThongTinNhap getThongTinNhap(String thoi_gian) {
        ThongTinNhap result = null;
        String query = "SELECT * FROM `phieu_nhap`,`chi_tiet_phieu_nhap`,`nhan_vien`,`lo_san_pham`,`san_pham`,`loai_sp`,`chi_tiet_lo_sp`,`nguon_cc` WHERE phieu_nhap.id_phieu_nhap =chi_tiet_phieu_nhap.id_phieu_nhap AND phieu_nhap.id_nv = nhan_vien.id_nv AND san_pham.id_loai_sp = loai_sp.id_loai_sp AND san_pham.id_sp = chi_tiet_lo_sp.id_sp AND chi_tiet_lo_sp.id_lo_sp= lo_san_pham.id_lo_sp AND nguon_cc.id_nguon_cc = chi_tiet_phieu_nhap.id_nguon_cc AND lo_san_pham.id_phieu_nhap = phieu_nhap.id_phieu_nhap AND phieu_nhap.id_exist = 1 AND phieu_nhap.thoi_gian='" + thoi_gian + "'";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new ThongTinNhap(rs.getInt("id_phieu_nhap"),
                        rs.getString("thoi_gian"),
                        rs.getString("ghi_chu"), rs.getInt("so_tien_lo"), rs.getInt("so_luong_lo"), rs.getString("ten_sp"), rs.getString("ten_loai_sp"), rs.getString("dvt"), rs.getInt("id_lo_sp"), rs.getString("hsd"), rs.getString("nsx"), rs.getInt("id_ton_kho"), rs.getInt("id_chi_tiet_sp"), rs.getInt("so_luong_sp"), rs.getInt("so_tien_sp"), rs.getString("ten_nv"), rs.getString("ten_nha_cc"), rs.getString("nguon_cc.sdt"), rs.getString("dia_chi"), rs.getString("email"), rs.getBytes("nguon_cc.hinh_anh"));
            }

            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }

        return result;
    }
    // Lấy ra 1 thông tin nhập từ thời gian cụ thể
    public ThongTinNhap getThongTinNhap(ArrayList<ThongTinNhap> arr, String thoi_gian) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).thoi_gian.equals(thoi_gian)) {
                return (ThongTinNhap) arr.get(i);
            }
        }
        return null;
    }
    // Khi tất cả các giá trị điều có

    public void Run() {
        daoPhieuNhap.getInstance().insertPhieuNhap(thoi_gian, ghi_chu, 1, id_nv);
        PhieuNhap pn = daoPhieuNhap.getInstance().getPhieuNhap(thoi_gian, id_nv);
        int id_phieu_nhap = pn.id_phieu_nhap;
        // lấy lại id phieu nhập vừa nhập
        daoLoSanPham.getInstance().insertLoSanPham(hsd, nsx, 1, 1, id_phieu_nhap);
        LoSanPham lsp = daoLoSanPham.getInstance().getLoSanPham(hsd, nsx, id_phieu_nhap);
        int id_lo_sp = lsp.id_lo_sp;
        // lấy lại id lô sản phẩm vừa nhập
        daoChiTietLoSanPham.getInstance().insertChiTietLoSanPham(so_luong_sp, so_tien_sp, id_lo_sp, id_sp);
        // nhap vao thong tin của chi tiet phieu nhap
        daoChiTietPhieuNhap.getInstance().insertChiTietPhieuNhap(so_tien_lo, so_luong_lo, id_nguon_cc, id_phieu_nhap);
        //System.out.println("so_luong_lo" + so_luong_lo );
        // luu vào thông báo
        NhanVien nv = DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv);
        DAO.daoThongBao.getInstance().insertThongBao("[Nhập kho] Nhân viên " + nv.ten_nv + " đã nhập hàng vào kho vào thời gian " + thoi_gian, thoi_gian, 2);
        // luu vào kho 
        SanPham sp = daoSanPham.getInstance().getSanPham(id_sp);
        LoaiSanPham loaisp = daoLoaiSanPham.getInstance().getLoaiSanPham(sp.id_loai_sp);
        daoKho.getInstance().insertKho(so_luong_lo, id_lo_sp, loaisp.id_khu_vuc);
        // luu vào tồn kho và cập nhật tồn kho
        daoTonKho.getInstance().CapNhatTonKho();
    }

}
