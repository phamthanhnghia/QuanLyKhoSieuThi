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
public class TaiKhoan {
    public int id_tk;
    public String ten_tai_khoan;
    public String mat_khau;
    public int id_exist;
    public int id_nv;
    public int loai;
    
    public TaiKhoan(int id,String ten,String mk, int exist,int idnv,int loai)
    {
        this.id_exist=exist;
        this.id_nv=idnv;
        this.id_tk=id;
        this.loai=loai;
        this.mat_khau=mk;
        this.ten_tai_khoan=ten;
        
    }
    public TaiKhoan()
    {

    }
}
