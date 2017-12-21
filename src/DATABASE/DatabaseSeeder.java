/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import DAO.DateTimeNow;
import DAO.NhapKho;
import DAO.daoXuatKho;
import java.util.Random;

/**
 *
 * @author admin
 */
public class DatabaseSeeder {
    public static void main(String[] args){
        //Dữ liệu mẫu có thể bị lỗi như một phiếu nhập có nhiều chi tiết phiếu nhập
        for(int i=0 ; i< 20; i++){
            RanDomNhapKho(2016);
            RanDomNhapKho(2017);
        }
        
        for(int i=0 ; i< 20; i++){
            RanDomXuatKho(2016);
            RanDomXuatKho(2017);
        }
        System.out.print("correct");
    }
    public static void RanDomNhapKho(int nam){
        Random rand = new Random();
        String thoi_gian = DateTimeNow.getIntance().RanDomDate(nam);
        String hsd = DateTimeNow.getIntance().RanDomDate(2018);
        String nsx = DateTimeNow.getIntance().RanDomDate(2017);
        int so_luong_sp = (rand.nextInt(20)+1)*10;
        int so_tien_sp = (rand.nextInt(50)+1)*10000;
        int id_sp = rand.nextInt(31)+1;
        int id_nv = rand.nextInt(10)+1;
        int id_nguon_cc = rand.nextInt(17)+1;
        int so_tien_lo = (rand.nextInt(50)+1)*10000000;
        int so_luong_lo = (rand.nextInt(30)+1)*150;
        NhapKho nk = new NhapKho(thoi_gian, so_luong_sp, so_tien_sp,id_sp, "", id_nv, hsd, nsx, id_nguon_cc, so_tien_lo, so_luong_lo);
        nk.Run();
    }
    public static void RanDomXuatKho(int nam ){
        Random rand = new Random();
        String thoi_gian = DateTimeNow.getIntance().RanDomDate(nam);
        int id_nv = rand.nextInt(10)+1;
        int sl_xuat = (rand.nextInt(25)+1)*100;
        int id_lo = rand.nextInt(500)+1;
        daoXuatKho.getInstance().RunXuatKho(id_lo, sl_xuat, thoi_gian, id_nv);
    }
}
