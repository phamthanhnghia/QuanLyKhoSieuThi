/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoXuatKho;
import DTO.XuatKho;
import GROUP.ThongTinXuat;
import java.util.ArrayList;

/**
 *
 * @author Dinh Tien
 */
public class busXuatKho {

    private static busXuatKho instance;

    public static busXuatKho getInstance() {
        if (instance == null) {
            instance = new busXuatKho();
        }
        return instance;
    }

    public busXuatKho() {
    }

    public ArrayList<XuatKho> getListXuatKho() {
        return daoXuatKho.getInstance().getListXuatKho();
    }

    public ArrayList<ThongTinXuat> getListThongTinXuatKho() {
        return daoXuatKho.getInstance().getListThongTinXuatKho();
    }

    public ArrayList<ThongTinXuat> getListThongTinXuatKho(int id_lo) {
        return daoXuatKho.getInstance().getListThongTinXuatKho(id_lo);
    }

    public int SoLanXuatKhoTheoThoiGian(String thoi_gian) {
        return daoXuatKho.getInstance().SoLanXuatKhoTheoThoiGian(thoi_gian);
    }

    public ArrayList<XuatKho> getListXuatKhoTheoThoiGian(String thoi_gian) {
        return daoXuatKho.getInstance().getListXuatKhoTheoThoiGian(thoi_gian);
    }
    public boolean KiemTraXuatKho(String id_lo, String slton, String slxuat, String ngay, int id_nv) {
        return daoXuatKho.getInstance().KiemTraXuatKho(id_lo, slton, slxuat, ngay, id_nv);
    }
    public ArrayList<ThongTinXuat> FindListXuatKho(ArrayList<ThongTinXuat> DuLieuMau, String ValToSearch) {
        return daoXuatKho.getInstance().FindListXuatKho(DuLieuMau, ValToSearch);
    }
    public XuatKho getXuatKho(int id_px) {
        return daoXuatKho.getInstance().getXuatKho(id_px);
    }
    // kiểm tra nếu phù hợp với số lượng tồn thì xuất, không thì cho qua hổ trợ cho DataSeeder
    public void RunXuatKho(int id_lo, int sl_xuat, String thoi_gian, int id_nv) {
        daoXuatKho.getInstance().RunXuatKho(id_lo,sl_xuat,thoi_gian,id_nv);
    }
    public ArrayList<ThongTinXuat> get20XuatKho(ArrayList<ThongTinXuat> arr, long Trang) {
         return daoXuatKho.getInstance().get20XuatKho(arr, Trang);
    }
    
}
