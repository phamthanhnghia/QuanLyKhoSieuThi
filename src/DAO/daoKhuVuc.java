/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KhuVuc;
import GUI.fNhacungcap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author nghia
 */
public class daoKhuVuc {
    private static daoKhuVuc instance;

    public static daoKhuVuc getInstance() {
        if(instance==null)instance=new daoKhuVuc();
        return instance;
    }

    //
    public ArrayList<KhuVuc> getListKhuVuc()
    {
        ArrayList<KhuVuc> result = new ArrayList<>();
        String query="select * from Khu_vuc";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new KhuVuc(rs.getInt("id_khu_vuc"),rs.getString("ten_khu_vuc"),rs.getString("vi_tri"),rs.getInt("id_exist"),rs.getInt("id_loai_kho")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
     public KhuVuc getIDKhuVuc(String tenkhuvuc)
    {
        KhuVuc result = null;
        String query="select *from khu_vuc where ten_khu_vuc = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(tenkhuvuc);
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new KhuVuc(rs.getInt("id_khu_vuc"),rs.getString("ten_khu_vuc"),rs.getString("vi_tri"),rs.getInt("id_exist"),rs.getInt("id_loai_kho")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
    }
     public KhuVuc getKhuVuc(int id_khu_vuc)
     {
        KhuVuc result = null;
        String query="select *from khu_vuc where id_khu_vuc = ?";
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(id_khu_vuc);
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        if(rs.next())
        {
            result = (new KhuVuc(rs.getInt("id_khu_vuc"),
                    rs.getString("ten_khu_vuc"),
                    rs.getString("vi_tri"),
                    rs.getInt("id_exist"),
                    rs.getInt("id_loai_kho")));
        }
        
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        
        return result;
     }
     public void ExcelKhuVuc(ArrayList<KhuVuc> arr){
         HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("KhuVuc");
        int rownum = 0;
        Cell cell;
        Row row;
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("id khu vực");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(1);
        cell.setCellValue("Tên Khu Vực");
        //
        row = sheet.createRow(rownum);
        cell = row.createCell(2);
        cell.setCellValue("Vị trí");
        //
        
        
        for(int i=0;i< arr.size() ; i++){
            rownum++;
            row = sheet.createRow(rownum);
            //
            cell = row.createCell(0);
            cell.setCellValue(arr.get(i).id_khu_vuc);
            //
            cell = row.createCell(1);
            cell.setCellValue(arr.get(i).ten_khu_vuc);
            //
            cell = row.createCell(2);
            cell.setCellValue(arr.get(i).vi_tri);
            //
            
        }
        File file = new File("C:/demo/khuvuc.xls");
        file.getParentFile().mkdirs();
 
        FileOutputStream outFile;
        try {
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fNhacungcap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(fNhacungcap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Created file: " + file.getAbsolutePath());
     }
}
