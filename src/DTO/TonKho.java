/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.lang.*;
/**
 *
 * @author nghia
 */
public class TonKho {
    public int id_ton;
    public int id_lo;
    public String ngay;
    public int sl_sp;
    public int id_khu_vuc;

    public TonKho(int id_ton, int id_lo, String ngay, int sl_sp, int id_khu_vuc) {
        this.id_ton = id_ton;
        this.id_lo = id_lo;
        this.ngay = ngay;
        this.sl_sp = sl_sp;
        this.id_khu_vuc = id_khu_vuc;
    }
    
}
