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
public class Kho {
    public int id_kho;
    public int id_lo_sp;
    public int sl_san_pham;
    public int id_khu_vuc;

    public Kho(int id_ton, int sl_sp, int id_lo, int id_khu_vuc) {
        this.id_kho = id_ton;
        this.id_lo_sp = id_lo;
        this.sl_san_pham = sl_sp;
        this.id_khu_vuc = id_khu_vuc;
    }
    
}

