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
public class NguonCungCap {
    public int id_nguon_cc;
    public String ten_nha_cc;
    public String ten_dai_dien;
    public String sdt;
    public String dia_chi;
    public String email;
    public int id_exist;
    public byte[] hinh_anh;
    
    public NguonCungCap(int id,String ten,String tendd,String sdt,String diachi,String email,int exist,byte[] hinhanh)
    {
        this.id_nguon_cc=id;
        this.ten_nha_cc=ten;
        this.ten_dai_dien=tendd;
        this.sdt=sdt;
        this.dia_chi=diachi;
        this.email=email;
        this.id_exist=exist;
        this.hinh_anh=hinhanh;
    }
}
