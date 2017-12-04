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
public class ThongTinKhoHienTai {
    public int id_kho;
    public int sl_san_pham; // so luong lô
    // san pham
    public String ten_sp;

    // lo san pham
    public int id_lo_sp;
    public String hsd;
    public String nsx;
    public int so_luong_sp;
    // chi tiet lo sp
    
    

    public ThongTinKhoHienTai() {
    }

    public ThongTinKhoHienTai(int id_kho, int sl_san_pham, String ten_sp, int id_lo_sp, String hsd, String nsx, int so_luong_sp) {
        this.id_kho = id_kho;
        this.sl_san_pham = sl_san_pham;
        this.ten_sp = ten_sp;
        this.id_lo_sp = id_lo_sp;
        this.hsd = hsd;
        this.nsx = nsx;
        this.so_luong_sp=so_luong_sp;
        
    }
    
}
