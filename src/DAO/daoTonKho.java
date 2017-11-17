/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Kho;
import DTO.TonKho;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
