/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.lang.*;
/**
 *
 * @author Dinh Tien
 */
public class XuatKho {
    public int id_xuat_kho;
    public int sl_sp;
    public String thoi_gian_xuat;
    public int id_lo;   
    public int id_nv;
    //Hàm khởi tạo
    public XuatKho(int id_ton, int id_lo, String ngay, int sl_sp, int id_khu_vuc) {
        this.id_xuat_kho = id_ton;
        this.sl_sp = id_lo;
        this.thoi_gian_xuat = ngay;
        this.id_lo = sl_sp;
        this.id_nv = id_khu_vuc;
    }
}
