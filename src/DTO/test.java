/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.daoSanPham;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class test {
    public static void main(String[] args) {
        ArrayList<dtoSanPham> arr = daoSanPham.getInstance().getDanhSachSanPham();
        
        for(int i=0;i< arr.size();i++){
            System.out.println(arr.get(i).hinh_anh);
        }
        
    }
}
