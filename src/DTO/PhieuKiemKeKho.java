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
public class PhieuKiemKeKho {
    public int id_kk_kho;
    public int sl_hao_mon;
    public int sl_thuc_te;
    public String thoi_gian;
    public int id_kho;
    public int id_nv;

    public PhieuKiemKeKho(int id_kk_kho, int sl_hao_mon, int sl_thuc_te, String thoi_gian, int id_kho, int id_nv) {
        this.id_kk_kho = id_kk_kho;
        this.sl_hao_mon = sl_hao_mon;
        this.sl_thuc_te = sl_thuc_te;
        this.thoi_gian = thoi_gian;
        this.id_kho = id_kho;
        this.id_nv = id_nv;
    }

    
    
}
