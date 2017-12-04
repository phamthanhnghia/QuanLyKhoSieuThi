/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.lang.*;
/**
 *
 * @author nghia
 */
public class KiemKePhieuNhap {
    public int id_kk_nhap;
    public int so_luong_nhap;
    public int id_kho;
    public int id_phieu_nhap;
    public int id_nv;

    public KiemKePhieuNhap(int id_kk_nhap, int so_luong_nhap, int id_kho, int id_phieu_nhap, int id_nv) {
        this.id_kk_nhap = id_kk_nhap;
        this.so_luong_nhap = so_luong_nhap;
        this.id_kho = id_kho;
        this.id_phieu_nhap = id_phieu_nhap;
        this.id_nv = id_nv;
    }
    
}
