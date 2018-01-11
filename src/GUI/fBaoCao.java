/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.busReport;
import DAO.daoBaoCao;
import DAO.daoKho;
import DAO.daoPhieuNhap;
import DAO.daoXuatKho;
import DTO.PhieuNhap;
import DTO.XuatKho;
import GROUP.JPanelBaoCao;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.lang.*;

/**
 *
 * @author admin
 */
public class fBaoCao extends javax.swing.JFrame {

    /**
     * Creates new form fBaoCao
     */
    public int id_nv;
    private JPanel chartPanel;
    public JPanelBaoCao PanelBaoCao;

    public fBaoCao() throws FileNotFoundException {
        initComponents();
        build();
    }

    public fBaoCao(int id_nv,JPanelBaoCao PanelBaoCaoMau) {
        initComponents();
        setIcon();
        this.PanelBaoCao = PanelBaoCaoMau;
        this.id_nv = id_nv;
        build();
    }
    
    public fBaoCao(int id_nv) {
        initComponents();
        setIcon();
        //this.PanelBaoCao = PanelBaoCaoMau;
        this.id_nv = id_nv;
        build();
    }
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/Logo2.png")));
    }

    void build() {
        PanelBaoCao = new JPanelBaoCao();
        PanelBaoCao.Run();
        String thoi_gian = DAO.DateTimeNow.getIntance().DateNow;
        jLabelHomNay.setText(jLabelHomNay.getText() + DAO.DateTimeNow.getIntance().DateView);
        //ArrayList<PhieuNhap> arrNhap = daoPhieuNhap.getInstance().getListPhieuNhapTrongNgay(thoi_gian);
        int so_lan_nhap = daoPhieuNhap.getInstance().SoLanNhapKhoTrongNgay(thoi_gian);
        //ArrayList<XuatKho> arrXuat = daoXuatKho.getInstance().getListXuatKhoTheoThoiGian(thoi_gian);
        int so_lan_xuat = daoXuatKho.getInstance().SoLanXuatKhoTheoThoiGian(thoi_gian);
        jLabelSoLanNhapKho.setText(jLabelSoLanNhapKho.getText() + " " + so_lan_nhap);
        jLabelSoLanXuatKho.setText(jLabelSoLanXuatKho.getText() + " " + so_lan_xuat);

         //set chart on panel
        //JPanel jp = daoBaoCao.getInstance().createChartPanelLoaiSanPham_jTreeChart();
        jPanelShowSoLuongTheoLoaiPieChart.setLayout(new java.awt.BorderLayout());
        jPanelShowSoLuongTheoLoaiPieChart.add(PanelBaoCao.JPanelPieChart, BorderLayout.CENTER);
        jPanelShowSoLuongTheoLoaiPieChart.validate();
        // theo tháng
        jPanelBarChartThang.setLayout(new java.awt.BorderLayout());
        jPanelBarChartThang.add(PanelBaoCao.JPanelBarChartThang, BorderLayout.CENTER);
        jPanelBarChartThang.validate();
        //
        // theo quí
        jPanelBarChartQui.setLayout(new java.awt.BorderLayout());
        jPanelBarChartQui.add(PanelBaoCao.JPanelBarChartQui, BorderLayout.CENTER);
        jPanelBarChartQui.validate();
        // theo năm
        
        jPanelBarChartNam.setLayout(new java.awt.BorderLayout());
        jPanelBarChartNam.add(PanelBaoCao.JPanelBarChartNam, BorderLayout.CENTER);
        jPanelBarChartNam.validate();
        //
        jPanelTonKhoTheoNgay.setLayout(new java.awt.BorderLayout());
        jPanelTonKhoTheoNgay.add(PanelBaoCao.JPanelLineChartNgay, BorderLayout.CENTER);
        jPanelTonKhoTheoNgay.validate();
        //
        jPanelTonKhoTheoThang.setLayout(new java.awt.BorderLayout());
        jPanelTonKhoTheoThang.add(PanelBaoCao.JPanelLineChartThang, BorderLayout.CENTER);
        jPanelTonKhoTheoThang.validate();
        //
        Long soluonglo = daoBaoCao.getInstance().SoLuongLoTrongKhoHienTai();
        jLabelSoLuongTrongKhoHienTai.setText(jLabelSoLuongTrongKhoHienTai.getText() + " " + soluonglo.toString() + " Lô");

    }

//    public JPanel createChartPanel() {
//        DefaultPieDataset pieDataset = new DefaultPieDataset();
//        pieDataset.setValue("One", new Integer(10));
//        pieDataset.setValue("Two", new Integer(20));
//        pieDataset.setValue("Three", new Integer(30));
//        pieDataset.setValue("Four", new Integer(10));
//        pieDataset.setValue("Five", new Integer(20));
//        pieDataset.setValue("Six", new Integer(10));
//        JFreeChart chart = ChartFactory.createPieChart3D("Số lượng theo loại sản phẩm trong kho", pieDataset, true, true, true);
//        return new ChartPanel(chart);
//    }

//    public JPanel createbarChartPanel() {
//        String fait = "FAIT";
//        String audi = "AUDI";
//        String ford = "FORD";
//        String speed = "Speed";
//        String popular = "Popular";
//        String mailage = "Mailage";
//        String userrating = "User Rating";
//        String safety = "safety";
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        dataset.addValue(4.0, fait, speed);
//        dataset.addValue(4.0, fait, popular);
//        dataset.addValue(3.0, fait, userrating);
//        dataset.addValue(5.0, fait, mailage);
//        dataset.addValue(5.0, fait, safety);
//
//        dataset.addValue(5.0, audi, speed);
//        dataset.addValue(7.0, audi, popular);
//        dataset.addValue(8.0, audi, userrating);
//        dataset.addValue(10.0, audi, mailage);
//        dataset.addValue(4.0, audi, safety);
//
//        dataset.addValue(4.0, ford, speed);
//        dataset.addValue(3.0, ford, popular);
//        dataset.addValue(2.0, ford, userrating);
//        dataset.addValue(3.0, ford, mailage);
//        dataset.addValue(6.0, ford, safety);
//
//        JFreeChart barChart = ChartFactory.createBarChart3D(
//                "Lượng sản phẩm tồn kho trong 3 tháng",
//                "Tháng",
//                "Số lượng",
//                dataset,
//                PlotOrientation.VERTICAL,
//                true, true, false);
//        return new ChartPanel(barChart);
        
//        SELECT loai_sp.ten_loai_sp , SUM(ton_kho.sl_sp) AS so_luong 
//        FROM `ton_kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`lo_san_pham` 
//        WHERE ton_kho.id_lo = lo_san_pham.id_lo_sp 
//        AND lo_san_pham.id_lo_sp = chi_tiet_lo_sp.id_lo_sp 
//        AND chi_tiet_lo_sp.id_sp = san_pham.id_sp 
//        AND san_pham.id_loai_sp =loai_sp.id_loai_sp 
//        AND ton_kho.ngay LIKE '%2016-11%'
//        GROUP BY loai_sp.ten_loai_sp ORDER BY so_luong DESC
 //   }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jXDatePickerNgayDau = new org.jdesktop.swingx.JXDatePicker();
        jXDatePickerNgayCuoi = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonXuat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabelHomNay = new javax.swing.JLabel();
        jLabelSoLanNhapKho = new javax.swing.JLabel();
        jLabelSoLanXuatKho = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelSoLuongTrongKhoHienTai = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelShowSoLuongTheoLoaiPieChart = new javax.swing.JPanel();
        jPanelShowSoLuongTheoLoaiBarChart = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanelBarChartThang = new javax.swing.JPanel();
        jPanelBarChartQui = new javax.swing.JPanel();
        jPanelBarChartNam = new javax.swing.JPanel();
        jPanelShowTonKho = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelTonKhoTheoNgay = new javax.swing.JPanel();
        jPanelTonKhoTheoThang = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Báo cáo");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Phần mềm quản lý kho");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("siêu thị S.O.S");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Từ ngày :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Đến ngày :");

        jButtonXuat.setBackground(new java.awt.Color(255, 255, 255));
        jButtonXuat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-microsoft-excel-40.png"))); // NOI18N
        jButtonXuat.setText("Xuất");
        jButtonXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jXDatePickerNgayDau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXDatePickerNgayCuoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXDatePickerNgayDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXDatePickerNgayCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(200, 95));

        jLabelHomNay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHomNay.setText("Hôm nay : ");

        jLabelSoLanNhapKho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSoLanNhapKho.setText("Số lần nhập kho : ");

        jLabelSoLanXuatKho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSoLanXuatKho.setText("Số lần xuất kho : ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHomNay)
                    .addComponent(jLabelSoLanNhapKho)
                    .addComponent(jLabelSoLanXuatKho))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelHomNay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSoLanNhapKho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSoLanXuatKho)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelSoLuongTrongKhoHienTai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSoLuongTrongKhoHienTai.setText("Hiện tại có : ");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-40.png"))); // NOI18N
        jButton1.setText("In Báo Cáo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSoLuongTrongKhoHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jSeparator4))
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSoLuongTrongKhoHienTai)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanelShowSoLuongTheoLoaiPieChart.setBackground(new java.awt.Color(153, 153, 153));
        jPanelShowSoLuongTheoLoaiPieChart.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanelShowSoLuongTheoLoaiPieChartLayout = new javax.swing.GroupLayout(jPanelShowSoLuongTheoLoaiPieChart);
        jPanelShowSoLuongTheoLoaiPieChart.setLayout(jPanelShowSoLuongTheoLoaiPieChartLayout);
        jPanelShowSoLuongTheoLoaiPieChartLayout.setHorizontalGroup(
            jPanelShowSoLuongTheoLoaiPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jPanelShowSoLuongTheoLoaiPieChartLayout.setVerticalGroup(
            jPanelShowSoLuongTheoLoaiPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Khối lượng sản phẩm", jPanelShowSoLuongTheoLoaiPieChart);

        jPanelBarChartThang.setToolTipText("");

        javax.swing.GroupLayout jPanelBarChartThangLayout = new javax.swing.GroupLayout(jPanelBarChartThang);
        jPanelBarChartThang.setLayout(jPanelBarChartThangLayout);
        jPanelBarChartThangLayout.setHorizontalGroup(
            jPanelBarChartThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanelBarChartThangLayout.setVerticalGroup(
            jPanelBarChartThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("  Tháng  ", jPanelBarChartThang);

        javax.swing.GroupLayout jPanelBarChartQuiLayout = new javax.swing.GroupLayout(jPanelBarChartQui);
        jPanelBarChartQui.setLayout(jPanelBarChartQuiLayout);
        jPanelBarChartQuiLayout.setHorizontalGroup(
            jPanelBarChartQuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanelBarChartQuiLayout.setVerticalGroup(
            jPanelBarChartQuiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("  Qúy  ", jPanelBarChartQui);

        javax.swing.GroupLayout jPanelBarChartNamLayout = new javax.swing.GroupLayout(jPanelBarChartNam);
        jPanelBarChartNam.setLayout(jPanelBarChartNamLayout);
        jPanelBarChartNamLayout.setHorizontalGroup(
            jPanelBarChartNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanelBarChartNamLayout.setVerticalGroup(
            jPanelBarChartNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("  Năm  ", jPanelBarChartNam);

        javax.swing.GroupLayout jPanelShowSoLuongTheoLoaiBarChartLayout = new javax.swing.GroupLayout(jPanelShowSoLuongTheoLoaiBarChart);
        jPanelShowSoLuongTheoLoaiBarChart.setLayout(jPanelShowSoLuongTheoLoaiBarChartLayout);
        jPanelShowSoLuongTheoLoaiBarChartLayout.setHorizontalGroup(
            jPanelShowSoLuongTheoLoaiBarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanelShowSoLuongTheoLoaiBarChartLayout.setVerticalGroup(
            jPanelShowSoLuongTheoLoaiBarChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("Khối lượng lô theo loại", jPanelShowSoLuongTheoLoaiBarChart);

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanelTonKhoTheoNgay.setBackground(new java.awt.Color(153, 153, 153));
        jPanelTonKhoTheoNgay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanelTonKhoTheoNgayLayout = new javax.swing.GroupLayout(jPanelTonKhoTheoNgay);
        jPanelTonKhoTheoNgay.setLayout(jPanelTonKhoTheoNgayLayout);
        jPanelTonKhoTheoNgayLayout.setHorizontalGroup(
            jPanelTonKhoTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanelTonKhoTheoNgayLayout.setVerticalGroup(
            jPanelTonKhoTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Tồn kho theo ngày", jPanelTonKhoTheoNgay);

        javax.swing.GroupLayout jPanelTonKhoTheoThangLayout = new javax.swing.GroupLayout(jPanelTonKhoTheoThang);
        jPanelTonKhoTheoThang.setLayout(jPanelTonKhoTheoThangLayout);
        jPanelTonKhoTheoThangLayout.setHorizontalGroup(
            jPanelTonKhoTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        jPanelTonKhoTheoThangLayout.setVerticalGroup(
            jPanelTonKhoTheoThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Tồn kho theo tháng", jPanelTonKhoTheoThang);

        javax.swing.GroupLayout jPanelShowTonKhoLayout = new javax.swing.GroupLayout(jPanelShowTonKho);
        jPanelShowTonKho.setLayout(jPanelShowTonKhoLayout);
        jPanelShowTonKhoLayout.setHorizontalGroup(
            jPanelShowTonKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(jPanelShowTonKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2))
        );
        jPanelShowTonKhoLayout.setVerticalGroup(
            jPanelShowTonKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
            .addGroup(jPanelShowTonKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("Tồn kho", jPanelShowTonKho);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXuatActionPerformed
        
        
        if(jXDatePickerNgayDau.getDate()!= null && jXDatePickerNgayCuoi.getDate()!= null){
            String ngaydau = DAO.DateTimeNow.getIntance().FormatDate(jXDatePickerNgayDau.getDate().toString());
            String ngaycuoi = DAO.DateTimeNow.getIntance().FormatDate(jXDatePickerNgayCuoi.getDate().toString());
//               String ngaytest = DAO.DateTimeNow.getIntance().FormatDate(jXDatePickerNgayDau.getDate().toString());
                       //System.out.println(ngaydau+"  "+ngaycuoi);
                        BUS.busReport.getIntance().rpTonKho(ngaydau, ngaycuoi);
                        JOptionPane.showMessageDialog(rootPane,
                "Đã lưu file trong thư mục C:/demo.",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        }


//        if(ngaydau == "" || ngaycuoi == ""){
//            JOptionPane.showMessageDialog(rootPane,
//                "Chưa nhập đầy đủ các thông tin.",
//                "Thông báo",
//                JOptionPane.ERROR_MESSAGE);
//        }else{
//            //BUS.busReport.getIntance().rpTonKho(ngaydau, ngaycuoi);
//        }
        //System.out.println(ngaydau+" "+ngaycuoi);

    }//GEN-LAST:event_jButtonXuatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fBaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fBaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fBaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fBaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fBaoCao().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(fBaoCao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelHomNay;
    private javax.swing.JLabel jLabelSoLanNhapKho;
    private javax.swing.JLabel jLabelSoLanXuatKho;
    private javax.swing.JLabel jLabelSoLuongTrongKhoHienTai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelBarChartNam;
    private javax.swing.JPanel jPanelBarChartQui;
    private javax.swing.JPanel jPanelBarChartThang;
    private javax.swing.JPanel jPanelShowSoLuongTheoLoaiBarChart;
    private javax.swing.JPanel jPanelShowSoLuongTheoLoaiPieChart;
    private javax.swing.JPanel jPanelShowTonKho;
    private javax.swing.JPanel jPanelTonKhoTheoNgay;
    private javax.swing.JPanel jPanelTonKhoTheoThang;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerNgayCuoi;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerNgayDau;
    // End of variables declaration//GEN-END:variables
}
