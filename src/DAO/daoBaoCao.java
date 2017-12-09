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
        if (instance == null) {
            instance = new daoBaoCao();
        }
        return instance;
    }

    //Tạo biểu đồ tròn về loại sản phẩm trong kho
    public JPanel createChartPanelLoaiSanPham_jTreeChart() {
        double tong_so_luong = 0;
        double du_thua = 0;
        ArrayList<LoaiSanPham_jTreeChart> arr = daoKho.getInstance().getListLoaiSanPham_jTreeChart();
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                tong_so_luong = tong_so_luong + (double) arr.get(i).so_luong;
            }
            if (arr.size() <= 6) {
                for (int i = 0; i < arr.size(); i++) {
                    double number = (arr.get(i).so_luong / tong_so_luong) * 100;
                    pieDataset.setValue(arr.get(i).ten_loai_sp, number);
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    du_thua = tong_so_luong - arr.get(i).so_luong;
                    double number = (arr.get(i).so_luong / tong_so_luong) * 100;
                    pieDataset.setValue(arr.get(i).ten_loai_sp, number);
                }
                double number = (du_thua / tong_so_luong) * 10;
                pieDataset.setValue("Loại khác", number);
            }

        } else {
            pieDataset.setValue("Chưa có dữ liệu trong kho", new Integer(90));
            pieDataset.setValue("Chưa có gì ", new Integer(10));

        }
        JFreeChart chart = ChartFactory.createPieChart3D("Phần trăm theo loại sản phẩm trong kho", pieDataset, true, true, true);
        return new ChartPanel(chart);
    }

    // biểu do cột bao cáo theo tháng bug là chỉ trong 3 tháng cố định
    public JPanel createbarChartPanelTheoThang() {
        ArrayList<LoaiSanPham_jTreeChart> arrthang12 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2017-12");
        ArrayList<LoaiSanPham_jTreeChart> arrthang11 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2017-11");
        ArrayList<LoaiSanPham_jTreeChart> arrthang10 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2017-10");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String thang10 = "Tháng 10";
        String thang11 = "Tháng 11";
        String thang12 = "Tháng 12";
        for (int i = 0; i < 7; i++) {
            dataset.addValue(arrthang10.get(i).so_luong, thang10, arrthang10.get(i).ten_loai_sp);
        }
        for (int i = 0; i < 7; i++) {
            dataset.addValue(arrthang11.get(i).so_luong, thang11, arrthang11.get(i).ten_loai_sp);
        }
        for (int i = 0; i < 7; i++) {
            dataset.addValue(arrthang12.get(i).so_luong, thang12, arrthang12.get(i).ten_loai_sp);
        }

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Lượng sản phẩm tồn kho trong 3 tháng cuối năm",
                "Loại Sản phẩm",
                "Số lượng lô sản phẩm",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return new ChartPanel(barChart);
    }

    //Tạo biểu đồ cột theo 4 Qúi
    public JPanel createbarChartPanelTheoQui() {
        ArrayList<LoaiSanPham_jTreeChart> arrqui1 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2017-03");
        ArrayList<LoaiSanPham_jTreeChart> arrqui2 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2017-06");
        ArrayList<LoaiSanPham_jTreeChart> arrqui3 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2017-09");
        ArrayList<LoaiSanPham_jTreeChart> arrqui4 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2017-12");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String qui1 = "Qúi I";
        String qui2 = "Qúi II";
        String qui3 = "Qúi III";
        String qui4 = "Qúi IV";
        for (int i = 0; i < 3; i++) {
            dataset.addValue(arrqui1.get(i).so_luong, qui1, arrqui1.get(i).ten_loai_sp);
        }
        for (int i = 0; i < 3; i++) {
            dataset.addValue(arrqui2.get(i).so_luong, qui2, arrqui2.get(i).ten_loai_sp);
        }
        for (int i = 0; i < 3; i++) {
            dataset.addValue(arrqui3.get(i).so_luong, qui3, arrqui3.get(i).ten_loai_sp);
        }
        for (int i = 0; i < 3; i++) {
            dataset.addValue(arrqui4.get(i).so_luong, qui4, arrqui4.get(i).ten_loai_sp);
        }

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Lượng sản phẩm tồn kho trong 4 quí năm 2017",
                "Loại sản phẩm",
                "Số lượng lô sản phẩm",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return new ChartPanel(barChart);
    }
    //Tạo biểu đồ cột theo 3 năm

    public JPanel createbarChartPanelTheoNam() {
        ArrayList<LoaiSanPham_jTreeChart> arrnam2015 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2015-01");
        ArrayList<LoaiSanPham_jTreeChart> arrnam2016 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2016-01");
        ArrayList<LoaiSanPham_jTreeChart> arrnam2017 = daoKho.getInstance().getListLoaiSanPham_jTreeChartforBarChart("2017-01");

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String nam2015 = "Năm 2015";
        String nam2016 = "Năm 2016";
        String nam2017 = "Năm 2017";
        for (int i = 0; i < 7; i++) {
            dataset.addValue(arrnam2015.get(i).so_luong, nam2015, arrnam2015.get(i).ten_loai_sp);
        }
        for (int i = 0; i < 7; i++) {
            dataset.addValue(arrnam2016.get(i).so_luong, nam2016, arrnam2016.get(i).ten_loai_sp);
        }
        for (int i = 0; i < 7; i++) {
            dataset.addValue(arrnam2017.get(i).so_luong, nam2017, arrnam2017.get(i).ten_loai_sp);
        }

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Lượng sản phẩm tồn kho trong 3 năm",
                "Loại Sản phẩm",
                "Số lượng lô sản phẩm",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return new ChartPanel(barChart);
    }

    //Lấy ra số lượng lô trong kho
    public Long SoLuongLoTrongKhoHienTai() {
        ArrayList<Kho> arrKho = daoKho.getInstance().getListKho();
        long sum = 0;
        for (int i = 0; i < arrKho.size(); i++) {
            sum = sum + arrKho.get(i).sl_san_pham;
        }
        return sum;
    }

    //Đếm số lượng sản phẩm tồn kho thao ngày
    public Long SoLuongTonKhoTheoNgay(String date) {
        ArrayList<ThongTinTon> arr = daoTonKho.getInstance().getTonKhoTheoNgay(date);
        long sum = 0;
        if (arr.isEmpty() == false) {
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + arr.get(i).sl_sp;
            }
        }
        return sum;
    }

    //Đếm số lượng sản phẩm tồn kho theo tháng
    public Long SoLuongTonKhoTheoThang(String thang, String nam) {
        ArrayList<ThongTinTon> arr = daoTonKho.getInstance().getTonKhoTheoThang(thang, nam);
        long sum = 0;
        if (arr.isEmpty() == false) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).ngay.equals(arr.get(0).ngay)) {
                    sum = sum + arr.get(i).sl_sp;
                }
            }
        }
        return sum;
    }

    //Tạo biểu đồ đường tồn kho trong 6 ngày gần đây
    public JPanel createlineChartTonKhoTheoNgay() {
        String TonKho = "";
        String ngay1 = DAO.DateTimeNow.getIntance().DateNow;
        //System.out.println(ngay1);
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

    //Tạo biểu đồ đường tồn kho trong 6 tháng gần đây
    public JPanel createlineChartTonKhoTheoThang() {
        String TonKho = "";
        String ngay = DAO.DateTimeNow.getIntance().DateNow;
        String nam1 = ngay.substring(0, 4);
        String thang1 = ngay.substring(5, 7);
        String thang2 = DAO.DateTimeNow.getIntance().getThangTruoc(thang1);
        String thang3 = DAO.DateTimeNow.getIntance().getThangTruoc(thang2);
        String thang4 = DAO.DateTimeNow.getIntance().getThangTruoc(thang3);
        String thang5 = DAO.DateTimeNow.getIntance().getThangTruoc(thang4);
        String thang6 = DAO.DateTimeNow.getIntance().getThangTruoc(thang5);
        String nam2 = DAO.DateTimeNow.getIntance().getNam(thang1, nam1);
        String nam3 = DAO.DateTimeNow.getIntance().getNam(thang2, nam2);
        String nam4 = DAO.DateTimeNow.getIntance().getNam(thang3, nam3);
        String nam5 = DAO.DateTimeNow.getIntance().getNam(thang4, nam4);
        String nam6 = DAO.DateTimeNow.getIntance().getNam(thang5, nam5);
        long data1 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoThang(thang1, nam1);
        long data2 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoThang(thang2, nam2);
        long data3 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoThang(thang3, nam3);
        long data4 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoThang(thang4, nam4);
        long data5 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoThang(thang5, nam5);
        long data6 = DAO.daoBaoCao.getInstance().SoLuongTonKhoTheoThang(thang6, nam6);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(data6, TonKho, thang6 + "/" + nam6);
        dataset.addValue(data5, TonKho, thang5 + "/" + nam5);
        dataset.addValue(data4, TonKho, thang4 + "/" + nam4);
        dataset.addValue(data3, TonKho, thang3 + "/" + nam3);
        dataset.addValue(data2, TonKho, thang2 + "/" + nam2);
        dataset.addValue(data1, TonKho, thang1 + "/" + nam1);

        JFreeChart lineChart = ChartFactory.createLineChart3D(
                "Số lượng sản phẩm tồn kho theo tháng",
                "Tháng",
                "Số lượng lô",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return new ChartPanel(lineChart);
    }
}
