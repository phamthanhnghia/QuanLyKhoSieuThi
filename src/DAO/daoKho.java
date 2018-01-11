/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhap;
import DTO.Kho;
import DTO.LoSanPham;
import GROUP.LoaiSanPham_jTreeChart;
import DTO.NguonCungCap;
import DTO.PhieuTraKho;
import GROUP.ThongTinKhoHienTai;
import GROUP.ThongTinTon;
import GROUP.infoList_fTraHang_Kho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author Dinh Tien
 */
public class daoKho {

    private static daoKho instance;

    public static daoKho getInstance() {
        if (instance == null) {
            instance = new daoKho();
        }
        return instance;
    }

    //Lấy danh sách thông tin trong bảng kho với điều kiện số lượng >0
    public ArrayList<Kho> getListKho() {
        ArrayList<Kho> result = new ArrayList<>();
        String query = "select * from Kho where sl_san_pham != 0";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new Kho(rs.getInt("id_kho"), rs.getInt("sl_san_pham"), rs.getInt("id_lo_sp"), rs.getInt("id_khu_vuc")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public ThongTinKhoHienTai getThongTinKhoHienTai(int id_lo)
    {
        ThongTinKhoHienTai result= new ThongTinKhoHienTai();
        String query = "SELECT * FROM `kho`,`lo_san_pham`,`san_pham`,`chi_tiet_lo_sp` "
                + "WHERE kho.id_lo_sp =lo_san_pham.id_lo_sp "
                + "and lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + " and kho.sl_san_pham != 0 and lo_san_pham.id_lo_sp="+id_lo;

        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            if (rs.next()) {
                result= new ThongTinKhoHienTai(rs.getInt("id_kho"),
                        rs.getInt("so_luong_lo"),
                        rs.getString("ten_sp"),
                        rs.getInt("id_lo_sp"),
                        rs.getString("hsd"),
                        rs.getString("nsx"),
                        rs.getInt("so_luong_sp")
                );
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    
public ArrayList<ThongTinKhoHienTai> getListThongTinKhoHienTaiTheoLoai(int id_loai_sp) {
        ArrayList<ThongTinKhoHienTai> result = new ArrayList<>();
        String query = "SELECT * FROM `kho`,`lo_san_pham`,`san_pham`,`chi_tiet_lo_sp` "
                + "WHERE kho.id_lo_sp =lo_san_pham.id_lo_sp "
                + "and lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp "
                + "and chi_tiet_lo_sp.id_sp=san_pham.id_sp "
                + " and kho.sl_san_pham != 0 and san_pham.id_loai_sp="+id_loai_sp;

        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinKhoHienTai(rs.getInt("id_kho"),
                        rs.getInt("sl_san_pham"),
                        rs.getString("ten_sp"),
                        rs.getInt("id_lo_sp"),
                        rs.getString("hsd"),
                        rs.getString("nsx"),
                        rs.getInt("so_luong_sp")
                ));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    //Lay danh sách thông tin kho từ nhiều bảng khác nhau
    public ArrayList<ThongTinKhoHienTai> getListThongTinKhoHienTai() {
        ArrayList<ThongTinKhoHienTai> result = new ArrayList<>();
        String query = "SELECT * FROM `kho`,`lo_san_pham`,`san_pham`,`chi_tiet_lo_sp`,`chi_tiet_phieu_nhap`\n" +
                        " WHERE kho.id_lo_sp =lo_san_pham.id_lo_sp \n" +
                        " and lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp \n" +
                        " and chi_tiet_lo_sp.id_sp=san_pham.id_sp \n" +
                        " and chi_tiet_phieu_nhap.id_phieu_nhap = lo_san_pham.id_phieu_nhap\n" +
                        " and kho.sl_san_pham != 0 \n" +
                        " and lo_san_pham.id_ton_kho = 1 \n" +
                        " and kho.sl_san_pham != 0 ";

        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new ThongTinKhoHienTai(rs.getInt("id_kho"),
                        rs.getInt("so_luong_lo"),
                        rs.getString("ten_sp"),
                        rs.getInt("id_lo_sp"),
                        rs.getString("hsd"),
                        rs.getString("nsx"),
                        rs.getInt("sl_san_pham")
                ));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }

    //Chức năng tìm kiếm trong bảng kho
    public ArrayList<ThongTinKhoHienTai> FindListKhoHienTai(ArrayList<ThongTinKhoHienTai> DuLieuMau, String ValToSearch) {
        ArrayList<ThongTinKhoHienTai> result = new ArrayList<>();
        for (int i = 0; i < DuLieuMau.size(); i++) {
            if (String.valueOf(DuLieuMau.get(i).id_kho).contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).so_luong_lo).contains(ValToSearch)
                    || DuLieuMau.get(i).hsd.contains(ValToSearch)
                    || DuLieuMau.get(i).nsx.contains(ValToSearch)
                    || DuLieuMau.get(i).ten_sp.contains(ValToSearch)
                    || String.valueOf(DuLieuMau.get(i).sl_san_pham).contains(ValToSearch)) {
                result.add(DuLieuMau.get(i));
            }
        }
        //System.out.println("DAO.daoKho.FindListKhoHienTai()");
        return result;
    }

    //Lấy danh sách loại sản phẩm từ nhiều bảng khác nhau để làm biểu đồ tròn
    public ArrayList<LoaiSanPham_jTreeChart> getListLoaiSanPham_jTreeChart() {
        ArrayList<LoaiSanPham_jTreeChart> result = new ArrayList<>();
        String query = "SELECT loai_sp.ten_loai_sp , Sum((kho.sl_san_pham*chi_tiet_lo_sp.so_luong_sp)) AS so_luong FROM `kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`lo_san_pham` WHERE kho.id_lo_sp = lo_san_pham.id_lo_sp AND lo_san_pham.id_lo_sp = chi_tiet_lo_sp.id_lo_sp AND chi_tiet_lo_sp.id_sp = san_pham.id_sp AND san_pham.id_loai_sp =loai_sp.id_loai_sp GROUP BY loai_sp.ten_loai_sp ORDER BY so_luong DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new LoaiSanPham_jTreeChart(rs.getString("ten_loai_sp"), rs.getLong("so_luong")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }

    //Lấy danh sách loại sản phẩm từ nhiều bảng khác nhau để làm biểu đồ cột
    public ArrayList<LoaiSanPham_jTreeChart> getListLoaiSanPham_jTreeChartforBarChart(String month_yeah) {
        ArrayList<LoaiSanPham_jTreeChart> result = new ArrayList<>();
        //String query="SELECT loai_sp.ten_loai_sp , Sum((kho.sl_san_pham*chi_tiet_lo_sp.so_luong_sp)) AS so_luong FROM `kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`lo_san_pham` WHERE kho.id_lo_sp = lo_san_pham.id_lo_sp AND lo_san_pham.id_lo_sp = chi_tiet_lo_sp.id_lo_sp AND chi_tiet_lo_sp.id_sp = san_pham.id_sp AND san_pham.id_loai_sp =loai_sp.id_loai_sp GROUP BY loai_sp.ten_loai_sp ORDER BY so_luong DESC";
        String query = "SELECT loai_sp.ten_loai_sp , SUM(ton_kho.sl_sp) AS so_luong \n"
                + "  FROM `ton_kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`lo_san_pham` \n"
                + "  WHERE ton_kho.id_lo = lo_san_pham.id_lo_sp \n"
                + "  AND lo_san_pham.id_lo_sp = chi_tiet_lo_sp.id_lo_sp \n"
                + "  AND chi_tiet_lo_sp.id_sp = san_pham.id_sp \n"
                + "  AND san_pham.id_loai_sp =loai_sp.id_loai_sp \n"
                + "  AND ton_kho.ngay LIKE '%" + month_yeah + "%'\n"
                + "  GROUP BY loai_sp.ten_loai_sp ORDER BY so_luong DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result.add(new LoaiSanPham_jTreeChart(rs.getString("ten_loai_sp"), rs.getLong("so_luong")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }

    //Thêm một kho mới
    public boolean insertKho(int sl_sp, int id_lo, int id_khu_vuc) {
        String query = "INSERT INTO `kho`(`sl_san_pham`, `id_lo_sp`, `id_khu_vuc`) VALUES ('" + sl_sp + "','" + id_lo + "','" + id_khu_vuc + "')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    //Update số lượng lô trong kho bằng id lô
    public boolean updateSoLuongKhotheo_ID_LO(int sl_sp, int id_lo) {
        String query = "UPDATE `kho` SET `sl_san_pham`='" + sl_sp + "' WHERE `id_lo_sp`='" + id_lo + "'";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    //Update số lượng lô trong kho bằng id kho
    public boolean updateSoLuongKhotheo_ID_KHO(int sl_sp, int id_kho) {
        String query = "UPDATE `kho` SET `sl_san_pham`='" + sl_sp + "' WHERE `id_kho`='" + id_kho + "'";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }

    //Lấy danh sách thông tin trong bảng kho bằng id lô
    public Kho getLoKho(int id_lo) {
        Kho result = null;
        String query = "SELECT * FROM `kho` WHERE kho.id_lo_sp =" + id_lo;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new Kho(rs.getInt("id_kho"), rs.getInt("sl_san_pham"), rs.getInt("id_lo_sp"), rs.getInt("id_khu_vuc"));

            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        //if(result==null) System.out.print("Lo san pham bi null");
        return result;
    }

    //Lấy danh sách thông tin trong bảng kho từ id kho
    public Kho getIdKho(int id_kho) {
        Kho result = null;
        String query = "SELECT * FROM `kho` WHERE id_kho =" + id_kho;
        ArrayList<Object> arr = new ArrayList<>();
        try {
            DataProvider.getIntance().open();
            ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
            while (rs.next()) {
                result = new Kho(rs.getInt("id_kho"),
                        rs.getInt("sl_san_pham"),
                        rs.getInt("id_lo_sp"),
                        rs.getInt("id_khu_vuc"));

            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            DataProvider.getIntance().displayError(ex);
        }
        //if(result==null) System.out.print("Lo san pham bi null");
        return result;
    }

    //Tìm kiếm trong chức năng trả kho
    public String[][] FindListKhoTra(String ValToSearch) {
        String[][] Data = new String[1000][6];
        int RowData;
        RowData = 0;
        ArrayList<infoList_fTraHang_Kho> arr = DAO.daoLoSanPham.getInstance().getListInfoList_fTraHang_Kho();
        for (int i = 0; i < arr.size(); i++) {
//            int id_sp = DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuKhoTra.get(i).id_lo_sp).id_sp;
//            String tensp = DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
//            String loaisp = DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
//            String sl_sp = String.valueOf(DuLieuKhoTra.get(i).sl_san_pham);
//            LoSanPham lsp = DAO.daoLoSanPham.getInstance().getLoSanPham(DuLieuKhoTra.get(i).id_lo_sp);
//            ChiTietPhieuNhap ctpn = DAO.daoChiTietPhieuNhap.getInstance().getChiTietPhieuNhap(lsp.id_phieu_nhap);
//            NguonCungCap ncc = DAO.daoNguonCungCap.getInstance().getNguonCungCap(ctpn.id_nguon_cc);
            if (String.valueOf(arr.get(i).id_lo_sp).contains(ValToSearch)
                    || arr.get(i).ten_nha_cc.contains(ValToSearch)
                    || arr.get(i).ten_sp.contains(ValToSearch)
                    || String.valueOf(arr.get(i).sl_san_pham).contains(ValToSearch)) {
                //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                // System.out.println(sl_sp);
                //   System.out.println(tennv);
                Data[RowData][0] = String.valueOf(arr.get(i).id_lo_sp);
                Data[RowData][1] = arr.get(i).ten_nha_cc;
                Data[RowData][2] = arr.get(i).ten_sp;
                Data[RowData][3] = String.valueOf(arr.get(i).sl_san_pham);
                RowData++;
            }
        }
        return Data;
    }

    //Tìm kiếm trong chức năng xuất kho
    public String[][] FindListKhoXuat(String ValToSearch) {
        String[][] Data = new String[1000][6];
        int RowData;
        RowData = 0;
//        ArrayList<Kho> DuLieuKhoXuat = getListKho();
//        for (int i = 0; i < DuLieuKhoXuat.size(); i++) {
//            int id_sp = DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuKhoXuat.get(i).id_lo_sp).id_sp;
//            String tensp = DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
//            String loaisp = DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
//            String sl_sp = String.valueOf(DuLieuKhoXuat.get(i).sl_san_pham);
//            LoSanPham lsp = DAO.daoLoSanPham.getInstance().getLoSanPham(DuLieuKhoXuat.get(i).id_lo_sp);
//            ChiTietPhieuNhap ctpn = DAO.daoChiTietPhieuNhap.getInstance().getChiTietPhieuNhap(lsp.id_phieu_nhap);
//            NguonCungCap ncc = DAO.daoNguonCungCap.getInstance().getNguonCungCap(ctpn.id_nguon_cc);
//            if (String.valueOf(DuLieuKhoXuat.get(i).id_lo_sp).contains(ValToSearch)
//                    || tensp.contains(ValToSearch)
//                    || sl_sp.contains(ValToSearch)
//                    || lsp.hsd.contains(ValToSearch)) {
//                //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
//                //System.out.println(tensp);
//                // System.out.println(loaisp);
//                // System.out.println(sl_sp);
//                //   System.out.println(tennv);
//                Data[RowData][0] = String.valueOf(DuLieuKhoXuat.get(i).id_lo_sp);
//                Data[RowData][1] = tensp;
//                Data[RowData][2] = sl_sp;
//                Data[RowData][3] = lsp.hsd;
//                RowData++;
//            }
//        }
        ArrayList<infoList_fTraHang_Kho> arr = DAO.daoLoSanPham.getInstance().getListInfoList_fTraHang_Kho();
        for (int i = 0; i < arr.size(); i++) {
//            int id_sp = DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuKhoTra.get(i).id_lo_sp).id_sp;
//            String tensp = DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
//            String loaisp = DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
//            String sl_sp = String.valueOf(DuLieuKhoTra.get(i).sl_san_pham);
//            LoSanPham lsp = DAO.daoLoSanPham.getInstance().getLoSanPham(DuLieuKhoTra.get(i).id_lo_sp);
//            ChiTietPhieuNhap ctpn = DAO.daoChiTietPhieuNhap.getInstance().getChiTietPhieuNhap(lsp.id_phieu_nhap);
//            NguonCungCap ncc = DAO.daoNguonCungCap.getInstance().getNguonCungCap(ctpn.id_nguon_cc);
            if (String.valueOf(arr.get(i).id_lo_sp).contains(ValToSearch)
                    || arr.get(i).ten_nha_cc.contains(ValToSearch)
                    || arr.get(i).ten_sp.contains(ValToSearch)
                    || String.valueOf(arr.get(i).sl_san_pham).contains(ValToSearch)) {
                //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                // System.out.println(sl_sp);
                //   System.out.println(tennv);
                Data[RowData][0] = String.valueOf(arr.get(i).id_lo_sp);
                Data[RowData][1] = arr.get(i).ten_sp;
                Data[RowData][2] = String.valueOf(arr.get(i).sl_san_pham);
                Data[RowData][3] = arr.get(i).ten_nha_cc;
                RowData++;
            }
        }
        return Data;
    }

    //Kiểm tra những sản phẩm sắp hết trong kho
    public ArrayList<ThongTinKhoHienTai> KiemTraSoLuongTrongKho(ArrayList<ThongTinKhoHienTai> kho) {
        ArrayList<ThongTinKhoHienTai> result = new ArrayList<>();
        for (int i = 0; i < kho.size(); i++) {
            if (kho.get(i).so_luong_lo < 10) {
                result.add(kho.get(i));
            }
        }
        return result;
    }

    //Kiểm tra những sản phẩm sắp hết hạn sử dụng trong kho
    public ArrayList<ThongTinKhoHienTai> KiemTraHSDTrongKho(ArrayList<ThongTinKhoHienTai> kho) {
        ArrayList<ThongTinKhoHienTai> result = new ArrayList<>();
        String date = DAO.DateTimeNow.getIntance().DateNow;
        int ngay = Integer.parseInt(date.substring(8, 10));
        int nam = Integer.parseInt(date.substring(0, 4));
        int thang = Integer.parseInt(date.substring(5, 7)) + 1;
        if (thang == 13) {
            thang = 1;
            nam++;
        }
        if (ngay > 28 && thang == 2) {
            ngay = 28;
        }
        if (ngay == 31 && (thang == 4 || thang == 6 || thang == 9 || thang == 11)) {
            ngay = 30;
        }

        for (int i = 0; i < kho.size(); i++) {
            int ngayi = Integer.parseInt(kho.get(i).hsd.substring(8, 10));
            int thangi = Integer.parseInt(kho.get(i).hsd.substring(5, 7));
            int nami = Integer.parseInt(kho.get(i).hsd.substring(0, 4));
            if (nam > nami
                    || (nam == nami && thang > thangi)
                    || (nam == nami && thang == thangi && ngay > ngayi)) {
                result.add(kho.get(i));
            }
        }
        return result;
    }

    //Lấy 20 kho, để làm phân trang
    public ArrayList<ThongTinKhoHienTai> get20KhoHienTai(ArrayList<ThongTinKhoHienTai> arr, long Trang) {
        ArrayList<ThongTinKhoHienTai> result = new ArrayList<>();

        for (long i = (Trang * 20 - 20); i < (Trang * 20); i++) {
            if (i == arr.size()) {
                break;
            }
            result.add(arr.get((int) i));
        }
        return result;
    }
}
