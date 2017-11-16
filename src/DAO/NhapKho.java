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
/**
 *
 * @author nghia
 */
public class NhapKho {
    
    private static NhapKho instance;

    public static NhapKho getInstance() {
        if(instance==null)instance=new NhapKho();
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
    
    public NhapKho( int so_luong_sp, int so_tien_sp, int id_sp, String ghi_chu, int id_nv, String hsd, String nsx,int id_nguon_cc,int so_tien_lo,int so_luong_lo) {
        this.so_luong_sp = so_luong_sp;
        this.so_tien_sp = so_tien_sp;
        this.id_sp = id_sp;
        this.thoi_gian = DAO.DateTimeNow.getIntance().Now;
        this.ghi_chu = ghi_chu;
        this.id_nv = id_nv;
        this.hsd = hsd;
        this.nsx = nsx;
        this.id_nguon_cc = id_nguon_cc;
        this.so_tien_lo = so_tien_lo;
        this.so_luong_lo = so_luong_lo;
    }
    
    public boolean check(){
        return true ;
    }
     // Khi tất cả các giá trị điều có
    public void Run(){ 
        daoPhieuNhap.getInstance().insertPhieuNhap(thoi_gian, ghi_chu, 1, id_nv);
        PhieuNhap pn = daoPhieuNhap.getInstance().getPhieuNhap(thoi_gian, id_nv);
        int id_phieu_nhap = pn.id_phieu_nhap;
        // lấy lại id phieu nhập vừa nhập
        daoLoSanPham.getInstance().insertLoSanPham(hsd, nsx, 1,1,id_phieu_nhap );
        LoSanPham  lsp = daoLoSanPham.getInstance().getLoSanPham(hsd, nsx, id_phieu_nhap);
        int id_lo_sp = lsp.id_lo_sp;
        // lấy lại id lô sản phẩm vừa nhập
        daoChiTietLoSanPham.getInstance().insertChiTietLoSanPham(so_luong_sp, so_tien_sp, id_lo_sp, id_sp);
        // nhap vao thong tin của chi tiet phieu nhap
        daoChiTietPhieuNhap.getInstance().insertChiTietPhieuNhap(so_tien_lo, so_luong_lo, id_nguon_cc, id_phieu_nhap); 
        
        // luu vào thông báo
        NhanVien nv = DAO.daoTaiKhoan.getInstance().getNhanVien(id_nv);
        DAO.daoThongBao.getInstance().insertThongBao("[Nhập kho] Nhân viên "+nv.ten_nv+" đã nhập hàng vào kho vào thời gian "+ thoi_gian, thoi_gian);
        // luu vào kho 
        SanPham sp = daoSanPham.getInstance().getSanPham(id_sp);
        LoaiSanPham loaisp = daoLoaiSanPham.getInstance().getLoaiSanPham(sp.id_loai_sp);
        daoKho.getInstance().insertKho(so_luong_sp, id_lo_sp, loaisp.id_khu_vuc);
        // luu vào tồn kho và cập nhật tồn kho
        daoTonKho.getInstance().CapNhatTonKho();
    }
   
    
}
