/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoChiTietLoSanPham;
import DTO.ChiTietLoSanPham;
import java.util.ArrayList;

/**
 *
 * @author Dinh Tien
 */
public class busChiTietLoSanPham {

    private static busChiTietLoSanPham instance;

    public static busChiTietLoSanPham getInstance() {
        if (instance == null) {
            instance = new busChiTietLoSanPham();
        }
        return instance;
    }

    public busChiTietLoSanPham() {
    }

    public ArrayList<ChiTietLoSanPham> getListChiTietLoSanPham() {
        return daoChiTietLoSanPham.getInstance().getListChiTietLoSanPham();
    }

    public boolean insertChiTietLoSanPham(int so_luong_sp, int so_tien_sp, int id_lo_sp, int id_sp) {
        return daoChiTietLoSanPham.getInstance().insertChiTietLoSanPham(so_luong_sp, so_tien_sp, id_lo_sp, id_sp);
    }

    public ChiTietLoSanPham getChiTietLoSanPham(int id_lo) {
        return daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(id_lo);
    }

}
