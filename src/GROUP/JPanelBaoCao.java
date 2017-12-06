/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GROUP;

import DAO.daoBaoCao;
import javax.swing.JPanel;
import java.lang.*;
/**
 *
 * @author admin
 */
public class JPanelBaoCao {
    public JPanel JPanelPieChart;
    public JPanel JPanelBarChartThang;
    public JPanel JPanelBarChartQui;
    public JPanel JPanelBarChartNam;
    public JPanel JPanelLineChartNgay;
    public JPanel JPanelLineChartThang;

    public JPanelBaoCao() {
    }

    public JPanelBaoCao(JPanel JPanelPieChart, JPanel JPanelBarChartThang, JPanel JPanelBarChartQui, JPanel JPanelBarChartNam, JPanel JPanelLineChartNgay, JPanel JPanelLineChartThang) {
        this.JPanelPieChart = JPanelPieChart;
        this.JPanelBarChartThang = JPanelBarChartThang;
        this.JPanelBarChartQui = JPanelBarChartQui;
        this.JPanelBarChartNam = JPanelBarChartNam;
        this.JPanelLineChartNgay = JPanelLineChartNgay;
        this.JPanelLineChartThang = JPanelLineChartThang;
    }
    
    public void Run(){
        this.JPanelPieChart = daoBaoCao.getInstance().createChartPanelLoaiSanPham_jTreeChart();
        this.JPanelBarChartThang = daoBaoCao.getInstance().createbarChartPanelTheoThang();
        this.JPanelBarChartQui = daoBaoCao.getInstance().createbarChartPanelTheoQui();
        this.JPanelBarChartNam = daoBaoCao.getInstance().createbarChartPanelTheoNam();
        this.JPanelLineChartNgay = DAO.daoBaoCao.getInstance().createlineChartTonKhoTheoNgay();
        this.JPanelLineChartThang = DAO.daoBaoCao.getInstance().createlineChartTonKhoTheoThang();
    }
    
}
