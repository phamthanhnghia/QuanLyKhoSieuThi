/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GROUP;

/**
 *
 * @author admin
 */
public class ThongTinKiemKe {
    public int id_kk;
    public int id_lo;
    public int sl_hao_mon;
    public int sl_thuc_te;
    public String ten_nv;
    public String thoi_gian;

    public ThongTinKiemKe() {
    }

    public ThongTinKiemKe(int id_kk, int id_lo, int sl_hao_mon, int sl_thuc_te, String ten_nv, String thoi_gian) {
        this.id_kk = id_kk;
        this.id_lo = id_lo;
        this.sl_hao_mon = sl_hao_mon;
        this.sl_thuc_te = sl_thuc_te;
        this.ten_nv = ten_nv;
        this.thoi_gian = thoi_gian;
    }

    
}
