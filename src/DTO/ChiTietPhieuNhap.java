/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.lang.*;
/**
 *
 * @author admin
 */
public class ChiTietPhieuNhap {
    public int id_ctpn;
    public int so_tien_lo;
    public int so_luong_lo;
    public int id_nguon_cc;
    public int id_phieu_nhap;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(int id_ctpn, int so_tien_lo, int so_luong_lo, int id_nguon_cc, int id_phieu_nhap) {
        this.id_ctpn = id_ctpn;
        this.so_tien_lo = so_tien_lo;
        this.so_luong_lo = so_luong_lo;
        this.id_nguon_cc = id_nguon_cc;
        this.id_phieu_nhap = id_phieu_nhap;
    }
    
    
}
