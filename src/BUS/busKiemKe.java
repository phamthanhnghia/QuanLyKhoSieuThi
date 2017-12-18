/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.daoKho;
import GROUP.ThongTinKhoHienTai;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class busKiemKe {
    private static busKiemKe instance;

    public static busKiemKe getInstance() {
        if (instance == null) {
            instance = new busKiemKe();
        }
        return instance;
    }

    public busKiemKe() {
    }
    
    public ArrayList<ThongTinKhoHienTai> DanhSachThongTinKhoHienTai(){
        return daoKho.getInstance().getListThongTinKhoHienTai();
    }
}
