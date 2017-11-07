/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author nghia
 */
public class ThongBao {
    public int id_thong_bao;
    public String noi_dung;
    public int id_exits;
    public Timestamp thoi_gian;

    public ThongBao() {
    }

    public ThongBao(int id_thong_bao, String noi_dung, int id_exits, Timestamp thoi_gian) {
        this.id_thong_bao = id_thong_bao;
        this.noi_dung = noi_dung;
        this.id_exits = id_exits;
        this.thoi_gian = thoi_gian;
    }
    
    
}
