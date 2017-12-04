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
public class LoaiSanPham {
    public int id_loai_sp;
    public String ten_loai_sp;
    public String dvt;
    public int id_exist;
    public int id_khu_vuc;

    public LoaiSanPham(int id_loai_sp,String ten_loai_sp,String dvt, int id_exist, int id_khu_vuc) {
        this.id_loai_sp = id_loai_sp;
        this.ten_loai_sp = ten_loai_sp;
        this.dvt = dvt;
        this.id_exist = id_exist;
        this.id_khu_vuc = id_khu_vuc;
    }
    
}
