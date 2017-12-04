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
public class SanPham {
    public int id_sp;
    public String ten_sp;
    public byte[] hinh_anh;
    public int id_exist;
    public int id_loai_sp;
    
    public SanPham(int id_sp,String ten_sp,byte[] hinh_anh,int id_exist,int id_loai_sp) {
        this.id_sp = id_sp;
        this.ten_sp = ten_sp;
        this.hinh_anh = hinh_anh;
        this.id_exist = id_exist;
        this.id_loai_sp = id_loai_sp;
    }
}
