/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import GROUP.ThongTinNhap;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class busNhapKho {
    private static busNhapKho instance;

    public static busNhapKho getInstance() {
        if (instance == null) {
            instance = new busNhapKho();
        }
        return instance;
    }
    public ArrayList<ThongTinNhap> DanhSachXuatKho(){
        return DAO.NhapKho.getInstance().getListDanhSachNhapKho();
    }
    public  ArrayList<ThongTinNhap> get20NhapKho(ArrayList<ThongTinNhap> arr,long Trang){
        return DAO.daoPhieuNhap.getInstance().get20NhapKho(arr, Trang);
    }
}
