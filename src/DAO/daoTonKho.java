/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietLoSanPham;
import DTO.Kho;
import DTO.LoSanPham;
import DTO.TonKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nghia
 */
public class daoTonKho {
    private static daoTonKho instance;

    public static daoTonKho getInstance() {
        if(instance==null)instance=new daoTonKho();
        return instance;
    }
    public ArrayList<TonKho> getListTonKho()
    {
        ArrayList<TonKho> result = new ArrayList<>();
        String query="select * from Ton_kho";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new TonKho(rs.getInt("id_ton"),rs.getInt("id_lo"),rs.getString("ngay"),rs.getInt("sl_sp"),rs.getInt("id_khu_vuc")));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public ArrayList<TonKho> getListCheckOverWriteTonKho(int id_lo, String ngay)
    {
        ArrayList<TonKho> result = new ArrayList<>();
        String query = "SELECT * FROM `ton_kho` WHERE `id_lo` = '"+id_lo+"' and `ngay` = '"+ngay+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new TonKho(rs.getInt("id_ton"),rs.getInt("id_lo"),rs.getString("ngay"),rs.getInt("sl_sp"),rs.getInt("id_khu_vuc")));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public ArrayList<TonKho> getListCheckOverWriteTonKhoUpDate(int id_lo,int sl_sp, String ngay)
    {
        ArrayList<TonKho> result = new ArrayList<>();
        String query = "SELECT * FROM `ton_kho` WHERE `id_lo` = '"+id_lo+"' and `ngay` = '"+ngay+"' and `sl_sp`='"+sl_sp+"'";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new TonKho(rs.getInt("id_ton"),rs.getInt("id_lo"),rs.getString("ngay"),rs.getInt("sl_sp"),rs.getInt("id_khu_vuc")));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public boolean insertTonKho(int id_lo, String ngay, int sl_sp, int id_khu_vuc) {
        String query = "INSERT INTO `Ton_kho`(`id_lo`, `ngay`, `sl_sp`, `id_khu_vuc`) VALUES ('"+id_lo+"','"+ngay+"','"+sl_sp+"','"+id_khu_vuc+"')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public boolean updateSoLuongTonKho(int id_lo, String ngay, int sl_sp) {
        String query = "UPDATE `Ton_kho` SET `sl_sp`= '"+sl_sp+"'  WHERE `id_lo`= '"+id_lo+"' and `ngay`= '"+ngay+"'";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public void CapNhatTonKho(){
        ArrayList<Kho> arrKho = daoKho.getInstance().getListKho();
        //ArrayList<TonKho> arrTon = daoTonKho.getInstance().getListTonKho();
        for(int i=0;i< arrKho.size();i++){
            Kho item = arrKho.get(i);
            String ngay = DateTimeNow.getIntance().DateNow;
            // lấy list xem đã tồn tại trong csdl chưa
            ArrayList<TonKho> arrTonCheck = daoTonKho.getInstance().getListCheckOverWriteTonKho(item.id_lo_sp, ngay);
            //System.out.println(arrTonCheck.size());
            if(arrTonCheck.size() > 0 ){
                // nếu đã có thì cập nhật lại số lượng
                ArrayList<TonKho> arrUpdate = daoTonKho.getInstance().getListCheckOverWriteTonKhoUpDate(item.id_lo_sp, item.sl_san_pham, ngay);
                if(arrUpdate.size() <= 0){
                    daoTonKho.getInstance().updateSoLuongTonKho(item.id_lo_sp, ngay, item.sl_san_pham);
                }
            }else{
                // nếu chưa có thì thêm mới
                daoTonKho.getInstance().insertTonKho(item.id_lo_sp, ngay , item.sl_san_pham, item.id_khu_vuc);
            }
        }
    }
    public ArrayList<TonKho> getTonKhoTheoNgay (String Date)
    {
        ArrayList<TonKho> Result = new ArrayList<>();
        ArrayList<TonKho> TonKhoTrongNgay = new ArrayList<>();
        ArrayList<TonKho> TonKhoQuaKhu = new ArrayList<>();
        ArrayList<TonKho> TonKhoTuongLai = new ArrayList<>();
        String query1="SELECT * FROM `ton_kho` WHERE `ngay`='"+Date+"' ORDER BY `ngay`DESC";
        String query2="SELECT * FROM `ton_kho` WHERE `ngay`<'"+Date+"' ORDER BY `ngay`DESC";
        String query3="SELECT * FROM `ton_kho` WHERE `ngay`>'"+Date+"' ORDER BY `ngay`DESC";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        ResultSet rs1= DataProvider.getIntance().excuteQuery(query1, arr);
        ResultSet rs2 = DataProvider.getIntance().excuteQuery(query2, arr);
        ResultSet rs3 = DataProvider.getIntance().excuteQuery(query3, arr);
        try {
            while(rs1.next())
            {
                TonKhoTrongNgay.add(new TonKho(rs1.getInt("id_ton"),
                        rs1.getInt("id_lo"),
                        rs1.getString("ngay"),
                        rs1.getInt("sl_sp"),
                        rs1.getInt("id_khu_vuc")));
            }
             while(rs2.next())
            {
                TonKhoQuaKhu.add(new TonKho(rs2.getInt("id_ton"),
                        rs2.getInt("id_lo"),
                        rs2.getString("ngay"),
                        rs2.getInt("sl_sp"),
                        rs2.getInt("id_khu_vuc")));
            }
              while(rs3.next())
            {
                TonKhoTuongLai.add(new TonKho(rs3.getInt("id_ton"),
                        rs3.getInt("id_lo"),
                        rs3.getString("ngay"),
                        rs3.getInt("sl_sp"),
                        rs3.getInt("id_khu_vuc")));
            }
            DataProvider.getIntance().close();
        } catch (SQLException ex) {
            Logger.getLogger(daoTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(TonKhoTrongNgay.isEmpty()== false)
        {
            return TonKhoTrongNgay;
        }
        if(TonKhoTrongNgay.isEmpty()==true && TonKhoQuaKhu.isEmpty()==false)
        {
            for(int i=0;i<TonKhoQuaKhu.size();i++)
            {
                if(!TonKhoQuaKhu.get(i).ngay.equals(TonKhoQuaKhu.get(0).ngay))
                {
                    TonKhoQuaKhu.remove(i);
                    i=i-1;
                }
            }
            
            return TonKhoQuaKhu;
        }
        /*if(TonKhoTrongNgay.isEmpty()==true && TonKhoQuaKhu.isEmpty()==true)
        {
            return TonKhoTrongNgay;
        }*/
        
        return Result;
    }
    public String[][] FindListTonKho(String ValToSearch)
    {
        String [][] Data=new String[1000][6];
        int RowData;
        RowData = 0;
        ArrayList<TonKho> DuLieuTonKho = getListTonKho();
        for (int i=0;i<DuLieuTonKho.size();i++)
        {
            int id_sp=DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuTonKho.get(i).id_lo).id_sp;
            String tensp=DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
            String loaisp=DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
            LoSanPham lsp = DAO.daoLoSanPham.getInstance().getLoSanPham(DuLieuTonKho.get(i).id_lo);
            String sl_sp=String.valueOf(DuLieuTonKho.get(i).sl_sp);
            if (String.valueOf(DuLieuTonKho.get(i).id_lo).contains(ValToSearch) ||
                    tensp.contains(ValToSearch) ||
                    lsp.hsd.contains(ValToSearch) ||
                    sl_sp.contains(ValToSearch))
            {
               //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                 // System.out.println(sl_sp);
                //   System.out.println(tennv);
               Data[RowData][0]=String.valueOf(DuLieuTonKho.get(i).id_lo);
               Data[RowData][1]=tensp;
               Data[RowData][2]=lsp.hsd;
               Data[RowData][3]=sl_sp;
               RowData++;
            }
        }       
        return Data;
    }
}
