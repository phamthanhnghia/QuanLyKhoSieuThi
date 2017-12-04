/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GROUP;
import java.lang.*;

/**
 *
 * @author Dinh Tien
 */
public class ThongTinTon {

    public String ten_sp;
    public int id_ton;
    public int id_lo_sp;
    public String hsd;
    public int sl_sp;
    public String ngay;

    public ThongTinTon() {
    }

    public ThongTinTon(int id_lo_sp, int id_ton, String ten_sp, String hsd, int sl_sp, String ngay) {
        this.ten_sp = ten_sp;
        this.id_ton=id_ton;
        this.id_lo_sp = id_lo_sp;
        this.hsd = hsd;
        this.sl_sp=sl_sp;
        this.ngay=ngay;
    }
}
