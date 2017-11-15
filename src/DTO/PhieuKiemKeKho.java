/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
/**
 *
 * @author nghia
 */
public class PhieuKiemKeKho {
    public int id_kk_kho;
    public int sl_hao_mon;
    public String thoi_gian;
    public int id_kho;
    public int id_nv;

    public PhieuKiemKeKho(int id_kk_kho, int sl_hao_mon, String thoi_gian, int id_kho, int id_nv) {
        this.id_kk_kho = id_kk_kho;
        this.sl_hao_mon = sl_hao_mon;
        this.thoi_gian = thoi_gian;
        this.id_kho = id_kho;
        this.id_nv = id_nv;
    }
    
}
