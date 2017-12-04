/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.lang.*;
import java.sql.Timestamp;
/**
 *
 * @author nghia
 */
public class LoSanPham {
    public int id_lo_sp;
    public String hsd;
    public String nsx;
    public int id_exist;
    public int id_ton_kho;
    public int id_phieu_nhap;

    public LoSanPham(int id_lo_sp, String hsd, String nsx, int id_exist, int id_ton_kho, int id_phieu_nhap) {
        this.id_lo_sp = id_lo_sp;
        this.hsd = hsd;
        this.nsx = nsx;
        this.id_exist = id_exist;
        this.id_ton_kho = id_ton_kho;
        this.id_phieu_nhap = id_phieu_nhap;
    }
    
    
    
}
