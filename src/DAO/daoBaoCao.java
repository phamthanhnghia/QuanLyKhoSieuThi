/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Kho;
import GROUP.LoaiSanPham_jTreeChart;
import GROUP.ThongTinTon;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.lang.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Pham Thanh Nghia
 */

public class daoBaoCao {
    
    private static daoBaoCao instance;
    public static daoBaoCao getInstance() {
        if(instance==null)instance=new daoBaoCao();
        return instance;
    }
    
    public JPanel createChartPanelLoaiSanPham_jTreeChart(){
        double tong_so_luong = 0;
        double du_thua = 0;
        ArrayList<LoaiSanPham_jTreeChart> arr = daoKho.getInstance().getListLoaiSanPham_jTreeChart();
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        if(!arr.isEmpty()){
            for(int i=0;i<arr.size();i++){
                tong_so_luong = tong_so_luong + (double)arr.get(i).so_luong;
            }
            if(arr.size() <= 6){
                for(int i = 0;i<arr.size();i++){
                    double number = (arr.get(i).so_luong/tong_so_luong)*100;
                    pieDataset.setValue(arr.get(i).ten_loai_sp, number);
                }
            }else{
                for(int i = 0;i < 6 ;i++){
                    du_thua = tong_so_luong - arr.get(i).so_luong;
                    double number = (arr.get(i).so_luong/tong_so_luong)*100;
                    pieDataset.setValue(arr.get(i).ten_loai_sp, number);
                }
                double number = (du_thua/tong_so_luong)*10;
                pieDataset.setValue("Loại khác", number );
            }
            
        }else{
            pieDataset.setValue("Chưa có dữ liệu trong kho", new Integer(90));
            pieDataset.setValue("Chưa có gì ", new Integer(10));

        }
        JFreeChart chart = ChartFactory.createPieChart3D("Phần trăm theo loại sản phẩm trong kho", pieDataset, true, true, true);
        return new ChartPanel(chart);
    }
    
    public Long SoLuongLoTrongKhoHienTai(){
        ArrayList<Kho> arrKho = daoKho.getInstance().getListKho();
        long sum =0;
        for(int i=0;i< arrKho.size();i++){
            sum=sum + arrKho.get(i).sl_san_pham;
        }
        return sum;
    }
    public Long SoLuongTonKhoTheoNgay(String date)
    {
        ArrayList<ThongTinTon> arr = daoTonKho.getInstance().getTonKhoTheoNgay(date);
        long sum =0;
        if(arr.isEmpty()==false)
        {
        for(int i=0;i< arr.size();i++){
            sum=sum + arr.get(i).sl_sp;
        }
        }
        return sum;
    }
    public JPanel createlineChartTonKhoTheoNgay() {
        String TonKho = "";
        String ngay1 = DAO.DateTimeNow.getIntance().DateNow;
        System.out.println(ngay1);
        String ngay2 = DAO.DateTimeNow.getIntance().getHomQua(ngay1);
        String ngay3 = DAO.DateTimeNow.getIntance().getHomQua(ngay2);
        String ngay4 = DAO.DateTimeNow.getIntance().getHomQua(ngay3);
        String ngay5 = DAO.DateTimeNow.getIntance().getHomQua(ngay4);
        String ngay6 = DAO.DateTimeNow.getIntance().getHomQua(ngay5);
        long data1 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoNgay(ngay1);
        long data2 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoNgay(ngay2);
        long data3 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoNgay(ngay3);
        long data4 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoNgay(ngay4);
        long data5 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoNgay(ngay5);
        long data6 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoNgay(ngay6);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(data6, TonKho, ngay6);
        dataset.addValue(data5, TonKho, ngay5);
        dataset.addValue(data4, TonKho, ngay4);
        dataset.addValue(data3, TonKho, ngay3);
        dataset.addValue(data2, TonKho, ngay2);
        dataset.addValue(data1, TonKho, ngay1);


        JFreeChart lineChart = ChartFactory.createLineChart3D(
                "Số lượng sản phẩm tồn kho theo ngày",
                "Ngày",
                "Số lượng lô",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return new ChartPanel(lineChart);
    }
}
