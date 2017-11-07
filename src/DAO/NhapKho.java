/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoSanPham;
import DTO.PhieuNhap;
import java.util.ArrayList;

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
    public int id_exist;
    public int id_nv;
    public String hsd;
    public String nsx;
    public int id_ton_kho;

    public NhapKho() {
    }
    
    public NhapKho( int so_luong_sp, int so_tien_sp, int id_sp, String ghi_chu, int id_nv, String hsd, String nsx) {
        this.so_luong_sp = so_luong_sp;
        this.so_tien_sp = so_tien_sp;
        this.id_sp = id_sp;
        this.thoi_gian = DAO.DateTimeNow.getIntance().Now;
        this.ghi_chu = ghi_chu;
        this.id_exist = 1;
        this.id_nv = id_nv;
        this.hsd = hsd;
        this.nsx = nsx;
        this.id_ton_kho = 1;
    }
    
    public boolean check(){
        return true ;
    }
     // Khi tất cả các giá trị điều có
    public void Run(){ 
        daoPhieuNhap.getInstance().insertPhieuNhap(thoi_gian, ghi_chu, id_exist, id_nv);
        PhieuNhap pn = daoPhieuNhap.getInstance().getPhieuNhap(thoi_gian, ghi_chu, id_nv);
        int id_phieu_nhap = pn.id_phieu_nhap;
        //
        daoLoSanPham.getInstance().insertLoSanPham(hsd, nsx, id_exist, id_ton_kho,id_phieu_nhap );
        LoSanPham  lsp = daoLoSanPham.getInstance().getLoSanPham(hsd, nsx, id_phieu_nhap);
        int id_lo_sp = lsp.id_lo_sp;
        //
        daoChiTietLoSanPham.getInstance().insertChiTietLoSanPham(so_luong_sp, so_tien_sp, id_lo_sp, id_sp);
        
    }
   
    
}
