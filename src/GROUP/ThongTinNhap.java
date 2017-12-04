 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GROUP;
import java.lang.*;

/**
 *
 * @author admin
 */
public class ThongTinNhap {
    // phieu nhap
    public int id_phieu_nhap;
    public String thoi_gian;
    public String ghi_chu;
    // chi tiet phieu nhap
    public int so_tien_lo;
    public int so_luong_lo;
    // san pham
    public String ten_sp;
    public String ten_loai_sp;
    public String dvt;
    // lo san pham
    public int id_lo_sp;
    public String hsd;
    public String nsx;
    public int id_ton_kho;
    // chi tiet lo sp
    public int id_chi_tiet_sp;
    public int so_luong_sp;
    public int so_tien_sp;
    // nhan vien
    public String ten_nv;

    //public int id_nguon_cc;
    public String ten_nha_cc;
    public String sdt_nguon_cc;
    public String dia_chi;
    public String email;
    public byte[] hinh_anh;

    public ThongTinNhap() {
    }

    public ThongTinNhap(int id_phieu_nhap, String thoi_gian, String ghi_chu, int so_tien_lo, int so_luong_lo, String ten_sp, String ten_loai_sp, String dvt, int id_lo_sp, String hsd, String nsx, int id_ton_kho, int id_chi_tiet_sp, int so_luong_sp, int so_tien_sp, String ten_nv, String ten_nha_cc, String sdt_nguon_cc, String dia_chi, String email, byte[] hinh_anh) {
        this.id_phieu_nhap = id_phieu_nhap;
        this.thoi_gian = thoi_gian;
        this.ghi_chu = ghi_chu;
        this.so_tien_lo = so_tien_lo;
        this.so_luong_lo = so_luong_lo;
        this.ten_sp = ten_sp;
        this.ten_loai_sp = ten_loai_sp;
        this.dvt = dvt;
        this.id_lo_sp = id_lo_sp;
        this.hsd = hsd;
        this.nsx = nsx;
        this.id_ton_kho = id_ton_kho;
        this.id_chi_tiet_sp = id_chi_tiet_sp;
        this.so_luong_sp = so_luong_sp;
        this.so_tien_sp = so_tien_sp;
        this.ten_nv = ten_nv;
        this.ten_nha_cc = ten_nha_cc;
        this.sdt_nguon_cc = sdt_nguon_cc;
        this.dia_chi = dia_chi;
        this.email = email;
        this.hinh_anh = hinh_anh;
    }
    
    
    
    
    

}
