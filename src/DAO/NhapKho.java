/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoSanPham;
import DTO.PhieuNhap;
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

    public NhapKho() {
    }
    
    public NhapKho( int so_luong_sp, int so_tien_sp, int id_sp, String ghi_chu, int id_nv, String hsd, String nsx) {
        this.so_luong_sp = so_luong_sp;
        this.so_tien_sp = so_tien_sp;
        this.id_sp = id_sp;
        this.thoi_gian = DAO.DateTimeNow.getIntance().Now;
        this.ghi_chu = ghi_chu;
        this.id_nv = id_nv;
        this.hsd = hsd;
        this.nsx = nsx;
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
        
    }
   
    
}
