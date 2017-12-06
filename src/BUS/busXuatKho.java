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
    public ArrayList<XuatKho> getListXuatKho()
    {
        return daoXuatKho.getInstance().getListXuatKho();
    }
    public ArrayList<ThongTinXuat> getListThongTinXuatKho()
    {
        return daoXuatKho.getInstance().getListThongTinXuatKho();
    }
    public ArrayList<ThongTinXuat> getListThongTinXuatKho(int id_lo)
    {
         return daoXuatKho.getInstance().getListThongTinXuatKho(id_lo);
    }
    
}
