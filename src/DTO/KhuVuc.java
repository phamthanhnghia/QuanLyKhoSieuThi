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
public class KhuVuc {
    public int id_khu_vuc;
    public String ten_khu_vuc;
    public String vi_tri;
    public int id_exist;
    public int id_loai_kho;

    public KhuVuc()
    {}
    public KhuVuc(int id_khu_vuc, String ten_khu_vuc, String vi_tri, int id_exist, int id_loai_kho) {
        this.id_khu_vuc = id_khu_vuc;
        this.ten_khu_vuc = ten_khu_vuc;
        this.vi_tri = vi_tri;
        this.id_exist = id_exist;
        this.id_loai_kho = id_loai_kho;
    }
}
