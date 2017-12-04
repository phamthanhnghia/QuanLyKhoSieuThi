/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GROUP;

/**
 *
 * @author Dinh Tien
 */
public class ThongTinLo {
    //Lô
    public int id_lo_sp;
    public String hsd;
    public String nsx;
    public int so_luong_sp;
    public int so_tien_sp;
    //Phiếu nhập
    public String thoi_gian_nhap;
    public int id_phieu_nhap;
    public String ten_nv;
    public int so_tien_lo;
    public int so_luong_lo;        
    //Nhà cung cấp
    public int id_ncc;
    public String ten_ncc;
    //Sản phẩm
    public String ten_sp;
    public String ten_loai_sp;
    public byte[] hinh_anh;
    
    public ThongTinLo(){}
    
    public ThongTinLo(int id_lo_sp,
    String hsd, String nsx,
    int so_luong_sp,
    int so_tien_sp, String thoi_gian_nhap,
    int id_phieu_nhap, String ten_nv,
    int so_tien_lo, int so_luong_lo,
    String ten_ncc,int id_ncc, String ten_sp,
    String ten_loai_sp, byte[] hinh_anh)
    {
        this.id_lo_sp=id_lo_sp;
        this.hsd=hsd;
        this.nsx=nsx;
        this.so_luong_sp=so_luong_sp;
        this.so_tien_sp=so_tien_sp;
        this.thoi_gian_nhap=thoi_gian_nhap;
        this.id_phieu_nhap=id_phieu_nhap;
        this.ten_nv=ten_nv;
        this.so_tien_lo=so_tien_lo;
        this.so_luong_lo=so_luong_lo;
        this.ten_ncc=ten_ncc;
        this.ten_sp=ten_sp;
        this.ten_loai_sp=ten_loai_sp;
        this.hinh_anh=hinh_anh;
        this.id_ncc=id_ncc;
    }
}
