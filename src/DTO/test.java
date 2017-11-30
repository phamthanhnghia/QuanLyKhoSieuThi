/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import GROUP.LoaiSanPham_jTreeChart;
import DAO.daoKho;
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
        ArrayList<LoaiSanPham_jTreeChart> arr = daoKho.getInstance().getListLoaiSanPham_jTreeChart();
        for(int i=0;i< arr.size();i++){
            System.out.println(arr.get(i).ten_loai_sp);
        }
    }
}
