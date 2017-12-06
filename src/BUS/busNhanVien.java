/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoNhanVien;
import DTO.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class busNhanVien {
    private static busNhanVien instance;

    public static busNhanVien getInstance() {
        if (instance == null) {
            instance = new busNhanVien();
        }
        return instance;
    }

    public busNhanVien() {
    }
    public ArrayList<NhanVien> getListNhanVien(){
        return daoNhanVien.getInstance().getListNhanVien();
    }
    public ArrayList<NhanVien> FindListNhanVien (String ValToSearch){
        return daoNhanVien.getInstance().FindListNhanVien(ValToSearch);
    }
    public ArrayList<NhanVien> FindListNhanVien(ArrayList<NhanVien> DuLieuMau,String ValToSearch){
        return daoNhanVien.getInstance().FindListNhanVien(DuLieuMau, ValToSearch);
    }
    public  ArrayList<NhanVien> get20NhanVien(ArrayList<NhanVien> arr,long Trang){
        return daoNhanVien.getInstance().get20NhanVien(arr, Trang);
    }
}
