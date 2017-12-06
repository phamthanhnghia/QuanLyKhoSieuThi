/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.daoTraNhaCungCap;
import DTO.PhieuTraKho;
import java.util.ArrayList;
/**
 *
 * @author Dinh Tien
 */
public class busTraNhaCungCap {
    private static busTraNhaCungCap instance;

    public static busTraNhaCungCap getInstance() {
        if (instance == null) {
            instance = new busTraNhaCungCap();
        }
        return instance;
    }

    public busTraNhaCungCap() {
    }
    public ArrayList<PhieuTraKho> getListTraKho() {
        return daoTraNhaCungCap.getInstance().getListTraKho();
    }
    public PhieuTraKho getTraKho(int id_pt) {
        return daoTraNhaCungCap.getInstance().getTraKho(id_pt);
    }
    public boolean InsertPhieuTra(int id_kho, int id_nv) {
        return daoTraNhaCungCap.getInstance().InsertPhieuTra(id_kho,id_nv);
    }
    public ArrayList<PhieuTraKho> FindListTraKho(ArrayList<PhieuTraKho> DuLieuMau, String ValToSearch) {
        return daoTraNhaCungCap.getInstance().FindListTraKho(DuLieuMau,ValToSearch);
    }
    public ArrayList<PhieuTraKho> get20PhieuTraKho(ArrayList<PhieuTraKho> arr, long Trang) {
        return daoTraNhaCungCap.getInstance().get20PhieuTraKho(arr,Trang);
    }
}
