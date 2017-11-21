/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.daoTonKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author nghia
 */
public class test {
    public static void main(String[] args) throws SQLException {
        ArrayList<ThongTinNhap> arr = DAO.NhapKho.getInstance().getListDanhSachNhapKho();
        for(int i=0;i< arr.size();i++){
            System.out.println(arr.get(i).thoi_gian);
        }
    }
}
