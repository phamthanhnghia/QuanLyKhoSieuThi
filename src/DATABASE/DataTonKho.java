/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import DAO.daoKho;
import DAO.daoTonKho;
import DTO.Kho;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author admin
 */
public class DataTonKho {
    
    public static void main(String[] args){
        RanDomTonKho(2015);
        RanDomTonKho(2016);
        RanDomTonKho(2017);
    }
    public static void RanDomTonKho(int nam){
        Random rand = new Random();
        int thang  = 1;
        ArrayList<Kho> arr = daoKho.getInstance().getListKho();
        while(thang<13){
            String thoi_gian = nam+"-"+thang+"-10" ;
            for(int i=0;i< arr.size();i++){
                int slsp = rand.nextInt(arr.get(i).id_lo_sp+100)+ arr.get(i).id_lo_sp - 70;
                daoTonKho.getInstance().insertTonKho(arr.get(i).id_lo_sp, thoi_gian,arr.get(i).sl_san_pham, arr.get(i).id_khu_vuc);
            }
            thang++;
        }
    }
}
