/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class NhapKho {
    
    public int id_chi_tiet_sp;
    public int so_luong_sp;
    public int so_tien_sp;
    public int id_lo_sp;
    public int id_sp;
    public int id_phieu_nhap;
    public Timestamp thoi_gian;
    public String ghi_chu;
    public int id_exist;
    public int id_nv;
    public Timestamp hsd;
    public Timestamp nsx;
    public int id_ton_kho;

    public NhapKho() {
    }
    
    

    public NhapKho(int id_chi_tiet_sp, int so_luong_sp, int so_tien_sp, int id_lo_sp, int id_sp, int id_phieu_nhap, Timestamp thoi_gian, String ghi_chu, int id_exist, int id_nv, Timestamp hsd, Timestamp nsx, int id_ton_kho) {
        this.id_chi_tiet_sp = id_chi_tiet_sp;
        this.so_luong_sp = so_luong_sp;
        this.so_tien_sp = so_tien_sp;
        this.id_lo_sp = id_lo_sp;
        this.id_sp = id_sp;
        this.id_phieu_nhap = id_phieu_nhap;
        this.thoi_gian = thoi_gian;
        this.ghi_chu = ghi_chu;
        this.id_exist = id_exist;
        this.id_nv = id_nv;
        this.hsd = hsd;
        this.nsx = nsx;
        this.id_ton_kho = id_ton_kho;
    }
    
    public boolean check(){
        return true ;
    }
    
   
    
}
