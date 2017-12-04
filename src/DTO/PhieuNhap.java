/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.sql.Timestamp;
import java.lang.*;
/**
 *
 * @author nghia
 */
public class PhieuNhap {
    public int id_phieu_nhap;
    public String thoi_gian;
    public String ghi_chu;
    public int id_exist;
    public int id_nv;

    public PhieuNhap(int id_phieu_nhap, String thoi_gian, String ghi_chu, int id_exist, int id_nv) {
        this.id_phieu_nhap = id_phieu_nhap;
        this.thoi_gian = thoi_gian;
        this.ghi_chu = ghi_chu;
        this.id_exist = id_exist;
        this.id_nv = id_nv;
    }
}
