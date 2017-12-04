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
public class ChiTietLoSanPham {
    public int id_chi_tiet_sp;
    public int so_luong_sp;
    public int so_tien_sp;
    public int id_lo_sp;
    public int id_sp;

    public ChiTietLoSanPham(int id_chi_tiet_sp, int so_luong_sp, int so_tien_sp, int id_lo_sp, int id_sp) {
        this.id_chi_tiet_sp = id_chi_tiet_sp;
        this.so_luong_sp = so_luong_sp;
        this.so_tien_sp = so_tien_sp;
        this.id_lo_sp = id_lo_sp;
        this.id_sp = id_sp;
    }
    
    
}
