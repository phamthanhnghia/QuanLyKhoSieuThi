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
public class ThongTinTon {

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

    public ThongTinTon() {
    }

    public ThongTinTon(String ten_sp, String ten_loai_sp, String dvt, int id_lo_sp, String hsd, String nsx, int id_ton_kho, int id_chi_tiet_sp, int so_luong_sp, int so_tien_sp, String ten_nv) {
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
    }
}
