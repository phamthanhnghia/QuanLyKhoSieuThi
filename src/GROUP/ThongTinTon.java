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
    public int id_ton;
    public int sl_sp;
    // nhan vien
    public String ten_nv;

    public ThongTinTon() {
    }

    public ThongTinTon(int id_lo_sp, int id_ton, String ten_sp, String hsd, int sl_sp) {
        this.ten_sp = ten_sp;
        this.id_ton=id_ton;
        this.id_lo_sp = id_lo_sp;
        this.hsd = hsd;
        this.sl_sp=sl_sp;
    }
}
