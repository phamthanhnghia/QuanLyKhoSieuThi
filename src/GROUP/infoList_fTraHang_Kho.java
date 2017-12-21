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
public class infoList_fTraHang_Kho {
    public int id_lo_sp;
    public String ten_nha_cc;
    public String ten_sp;
    public int sl_san_pham; // sl hien tại trong kho

    public infoList_fTraHang_Kho() {
    }

    public infoList_fTraHang_Kho(int id_lo_sp, String ten_nha_cc, String ten_sp, int sl_san_pham) {
        this.id_lo_sp = id_lo_sp;
        this.ten_nha_cc = ten_nha_cc;
        this.ten_sp = ten_sp;
        this.sl_san_pham = sl_san_pham;
    }

    
    
    
}
