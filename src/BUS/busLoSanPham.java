/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoLoSanPham;
import DTO.LoSanPham;
import GROUP.ThongTinLo;
import java.util.ArrayList;

/**
 *
 * @author Dinh Tien
 */
public class busLoSanPham {

    private static busLoSanPham instance;

    public static busLoSanPham getInstance() {
        if (instance == null) {
            instance = new busLoSanPham();
        }
        return instance;
    }

    public busLoSanPham() {
    }

    public ArrayList<ThongTinLo> getListThongTinLo() {
        return daoLoSanPham.getInstance().getListThongTinLo();
    }

    public ThongTinLo getThongTinLo(int id) {
        return daoLoSanPham.getInstance().getThongTinLo(id);
    }

    public ArrayList<LoSanPham> getDanhSachLoSanPham() {
        return daoLoSanPham.getInstance().getDanhSachLoSanPham();
    }

    public boolean insertLoSanPham(String hsd, String nsx, int id_exist, int id_ton_kho, int id_phieu_nhap) {
        return daoLoSanPham.getInstance().insertLoSanPham(hsd, nsx, id_exist, id_ton_kho, id_phieu_nhap);
    }

    public LoSanPham getLoSanPham(String hsd, String nsx, int id_phieu_nhap) {
        return daoLoSanPham.getInstance().getLoSanPham(hsd, nsx, id_phieu_nhap);
    }

    public LoSanPham getLoSanPham(int id_lo) {
        return daoLoSanPham.getInstance().getLoSanPham(id_lo);
    }

    public ArrayList<ThongTinLo> get20LoSanPham(ArrayList<ThongTinLo> arr, long Trang) {
        return daoLoSanPham.getInstance().get20LoSanPham(arr, Trang);
    }

    public ArrayList<ThongTinLo> FindListThongTinLo(ArrayList<ThongTinLo> DuLieuMau, String ValToSearch) {
        return daoLoSanPham.getInstance().FindListThongTinLo(DuLieuMau, ValToSearch);
    }

}
