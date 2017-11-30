/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhap;
import GROUP.ThongTinNhap;
import DTO.XuatKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nghia
 */
public class daoPhieuNhap {
    private static daoPhieuNhap instance;

    public static daoPhieuNhap getInstance() {
        if(instance==null)instance=new daoPhieuNhap();
        return instance;
    }
    // 
    public ArrayList<PhieuNhap> getListPhieuNhap(){
        ArrayList<PhieuNhap> result = new ArrayList<>();
        String query="select *from Phieu_nhap";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new PhieuNhap(rs.getInt("id_phieu_nhap"),rs.getString("thoi_gian"),rs.getString("ghi_chu"),rs.getInt("id_exist"),rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    
    public ArrayList<PhieuNhap> getListPhieuNhapTrongNgay(String thoi_gian){
        ArrayList<PhieuNhap> result = new ArrayList<>();
        String query="SELECT * FROM `phieu_nhap` WHERE phieu_nhap.thoi_gian LIKE '%"+thoi_gian+"%'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new PhieuNhap(rs.getInt("id_phieu_nhap"),rs.getString("thoi_gian"),rs.getString("ghi_chu"),rs.getInt("id_exist"),rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
    
    public boolean insertPhieuNhap(String thoi_gian, String ghi_chu, int id_exist, int id_nv) {
        String query = "INSERT INTO `Phieu_nhap`(`thoi_gian`, `ghi_chu`, `id_exist`, `id_nv`) VALUES ('"+thoi_gian+"','"+ghi_chu+"','"+id_exist+"','"+id_nv+"')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public PhieuNhap getPhieuNhap(String thoi_gian, int id_nv){
        PhieuNhap result = null;
        String query="select * from Phieu_nhap where thoi_gian ='"+thoi_gian+"' and id_nv='"+id_nv+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new PhieuNhap(rs.getInt("id_phieu_nhap"),
                    rs.getString("thoi_gian"),
                    rs.getString("ghi_chu"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_nv")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
        
    }
    public PhieuNhap getPhieuNhap(int id_pn)
    {
        PhieuNhap result = null;
        String query="SELECT * FROM `Phieu_nhap` WHERE id_phieu_nhap="+id_pn;
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            
            result = (new PhieuNhap(rs.getInt("id_phieu_nhap"),
                    rs.getString("thoi_gian"),
                    rs.getString("ghi_chu"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_nv")));
                    
        }
        else
        {
            result=null;
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public  ArrayList<ThongTinNhap> get20NhapKho(ArrayList<ThongTinNhap> arr,long Trang)
    {
         ArrayList<ThongTinNhap> result = new ArrayList<>();
        
        for (long i = (Trang*20-20);i<(Trang*20);i++)
        {
            if(i==arr.size())
                break;
            result.add(arr.get((int)i));
        }
        return result;
    }
    public ArrayList<ThongTinNhap> FindListNhapKho(ArrayList<ThongTinNhap> DuLieuMau,String ValToSearch)
    {
        ArrayList<ThongTinNhap> result=new ArrayList<>();
        for (int i=0;i<DuLieuMau.size();i++)
        {
            if (DuLieuMau.get(i).thoi_gian.contains(ValToSearch) ||
                    String.valueOf(DuLieuMau.get(i).so_tien_lo).contains(ValToSearch) ||
                    String.valueOf(DuLieuMau.get(i).so_tien_sp).contains(ValToSearch) ||
                    DuLieuMau.get(i).ten_nv.contains(ValToSearch))
            {
               //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                 // System.out.println(sl_sp);
                //   System.out.println(tennv);

               result.add(DuLieuMau.get(i));    
            }
        }       
        return result;
    }
}
