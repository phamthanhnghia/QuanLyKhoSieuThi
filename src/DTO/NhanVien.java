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
public class NhanVien {
    public int id_nv;
    public String ten_nv;
    public String sdt;
    public String cmnd;
    public String ngay_sinh;
    public byte[] hinh_anh;
    public int id_exist;

    public NhanVien(int id_nv,String ten_nv,String sdt, String cmnd, String ngay_sinh, byte[] hinh_anh,int id_exist ) {
        this.id_nv =id_nv;
        this.ten_nv = ten_nv;
        this.sdt =sdt;
        this.cmnd = cmnd;
        this.ngay_sinh = ngay_sinh;
        this.hinh_anh = hinh_anh;
        this.id_exist = id_exist;
    }
    
}
