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
import java.awt.BorderLayout;
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

    public fBaoCao() throws FileNotFoundException {
        initComponents();
        build();
    }

    public fBaoCao(int id_nv) {
        initComponents();
        build();
        this.id_nv = id_nv;
    }

    void build() {
        String thoi_gian = DAO.DateTimeNow.getIntance().DateNow;
        jLabelHomNay.setText(jLabelHomNay.getText() + DAO.DateTimeNow.getIntance().DateView);
        ArrayList<PhieuNhap> arrNhap = daoPhieuNhap.getInstance().getListPhieuNhapTrongNgay(thoi_gian);
        ArrayList<XuatKho> arrXuat = daoXuatKho.getInstance().getListXuatKhoTheoThoiGian(thoi_gian);
        jLabelSoLanNhapKho.setText(jLabelSoLanNhapKho.getText() + " " + arrNhap.size());
        jLabelSoLanXuatKho.setText(jLabelSoLanXuatKho.getText() + " " + arrXuat.size());

        // set chart on panel
        JPanel jp = daoBaoCao.getInstance().createChartPanelLoaiSanPham_jTreeChart();
        jPanelShowSoLuongTheoLoaiPieChart.setLayout(new java.awt.BorderLayout());
        jPanelShowSoLuongTheoLoaiPieChart.add(jp, BorderLayout.CENTER);
        jPanelShowSoLuongTheoLoaiPieChart.validate();
        //
        jPanelShowSoLuongTheoLoai.setLayout(new java.awt.BorderLayout());
        jPanelShowSoLuongTheoLoai.add(createbarChartPanel(), BorderLayout.CENTER);
        jPanelShowSoLuongTheoLoai.validate();
        //
        //jPanelShowTonKho.setLayout(new java.awt.BorderLayout());
        //jPanelShowTonKho.add(createlineChartPanel(), BorderLayout.CENTER);
        //jPanelShowTonKho.validate();
        //
        Long soluonglo = daoBaoCao.getInstance().SoLuongLoTrongKhoHienTai();
        jLabelSoLuongTrongKhoHienTai.setText(jLabelSoLuongTrongKhoHienTai.getText() + " " + soluonglo.toString() + " Lô");

    }

    public JPanel createChartPanel() {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("One", new Integer(10));
        pieDataset.setValue("Two", new Integer(20));
        pieDataset.setValue("Three", new Integer(30));
        pieDataset.setValue("Four", new Integer(10));
        pieDataset.setValue("Five", new Integer(20));
        pieDataset.setValue("Six", new Integer(10));
        JFreeChart chart = ChartFactory.createPieChart3D("Số lượng theo loại sản phẩm trong kho", pieDataset, true, true, true);
        return new ChartPanel(chart);
    }

    public JPanel createbarChartPanel() {
        String fait = "FAIT";
        String audi = "AUDI";
        String ford = "FORD";
        String speed = "Speed";
        String popular = "Popular";
        String mailage = "Mailage";
        String userrating = "User Rating";
        String safety = "safety";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(4.0, fait, speed);
        dataset.addValue(4.0, fait, popular);
        dataset.addValue(3.0, fait, userrating);
        dataset.addValue(5.0, fait, mailage);
        dataset.addValue(5.0, fait, safety);

        dataset.addValue(5.0, audi, speed);
        dataset.addValue(7.0, audi, popular);
        dataset.addValue(8.0, audi, userrating);
        dataset.addValue(10.0, audi, mailage);
        dataset.addValue(4.0, audi, safety);

        dataset.addValue(4.0, ford, speed);
        dataset.addValue(3.0, ford, popular);
        dataset.addValue(2.0, ford, userrating);
        dataset.addValue(3.0, ford, mailage);
        dataset.addValue(6.0, ford, safety);

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Lượng sản phẩm tồn kho trong 3 tháng",
                "Tháng",
                "Số lượng",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return new ChartPanel(barChart);
    }

    public JPanel createlineChartPanel() {
        String fait = "";
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

        dataset.addValue(data6, fait, ngay6);
        dataset.addValue(data5, fait, ngay5);
        dataset.addValue(data4, fait, ngay4);
        dataset.addValue(data3, fait, ngay3);
        dataset.addValue(data2, fait, ngay2);
        dataset.addValue(data1, fait, ngay1);


        JFreeChart lineChart = ChartFactory.createLineChart3D(
                "Số lượng sản phẩm tồn kho",
                "Ngày",
                "Số lượng lô",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return new ChartPanel(lineChart);
    }

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
        jLabel1 = new javax.swing.JLabel();
        jComboBoxInDanhSach = new javax.swing.JComboBox<>();
        jButtonSanPham = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonPhieuNhap = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonPhieuXuat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabelHomNay = new javax.swing.JLabel();
        jLabelSoLanNhapKho = new javax.swing.JLabel();
        jLabelSoLanXuatKho = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxInDanhSachExcel = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelSoLuongTrongKhoHienTai = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelShowSoLuongTheoLoaiPieChart = new javax.swing.JPanel();
        jPanelShowSoLuongTheoLoai = new javax.swing.JPanel();
        jPanelShowTonKho = new javax.swing.JPanel();

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-40.png"))); // NOI18N
        jLabel1.setText(" In Danh Sách");

        jComboBoxInDanhSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxInDanhSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Tuỳ Chọn ---", "- Nhân Viên -", "- Khu Vực -", "- Nhà Cung Cấp -" }));
        jComboBoxInDanhSach.setBorder(null);
        jComboBoxInDanhSach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxInDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInDanhSachActionPerformed(evt);
            }
        });

        jButtonSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-new-product-40.png"))); // NOI18N
        jButtonSanPham.setText("Sản Phẩm");
        jButtonSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSanPhamActionPerformed(evt);
            }
        });

        jButtonPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPhieuNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-check-40.png"))); // NOI18N
        jButtonPhieuNhap.setText("Phiếu Nhập");
        jButtonPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPhieuNhapActionPerformed(evt);
            }
        });

        jButtonPhieuXuat.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPhieuXuat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPhieuXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-purchase-order-40.png"))); // NOI18N
        jButtonPhieuXuat.setText("Phiếu Xuất");
        jButtonPhieuXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPhieuXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jComboBoxInDanhSach, 0, 150, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jButtonPhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jButtonPhieuXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxInDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPhieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(78, Short.MAX_VALUE))
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-microsoft-excel-40.png"))); // NOI18N
        jLabel4.setText("Xuất Danh sách");

        jComboBoxInDanhSachExcel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxInDanhSachExcel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Tuỳ Chọn ---", "- Nhân Viên -", "- Khu Vực -", "- Nhà Cung Cấp -" }));
        jComboBoxInDanhSachExcel.setBorder(null);
        jComboBoxInDanhSachExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxInDanhSachExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInDanhSachExcelActionPerformed(evt);
            }
        });

        jLabelSoLuongTrongKhoHienTai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSoLuongTrongKhoHienTai.setText("Hiện tại có : ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelSoLuongTrongKhoHienTai)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxInDanhSachExcel, javax.swing.GroupLayout.Alignment.LEADING, 0, 157, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxInDanhSachExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSoLuongTrongKhoHienTai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanelShowSoLuongTheoLoaiLayout = new javax.swing.GroupLayout(jPanelShowSoLuongTheoLoai);
        jPanelShowSoLuongTheoLoai.setLayout(jPanelShowSoLuongTheoLoaiLayout);
        jPanelShowSoLuongTheoLoaiLayout.setHorizontalGroup(
            jPanelShowSoLuongTheoLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jPanelShowSoLuongTheoLoaiLayout.setVerticalGroup(
            jPanelShowSoLuongTheoLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Khối lượng lô theo loại", jPanelShowSoLuongTheoLoai);

        javax.swing.GroupLayout jPanelShowTonKhoLayout = new javax.swing.GroupLayout(jPanelShowTonKho);
        jPanelShowTonKho.setLayout(jPanelShowTonKhoLayout);
        jPanelShowTonKhoLayout.setHorizontalGroup(
            jPanelShowTonKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jPanelShowTonKhoLayout.setVerticalGroup(
            jPanelShowTonKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tồn kho", jPanelShowTonKho);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE))
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

    private void jComboBoxInDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInDanhSachActionPerformed
        String valueIn = String.valueOf(jComboBoxInDanhSach.getSelectedItem());
        if ("- Nhân Viên -".equals(valueIn)) {
            busReport.getIntance().rpNhanVien();
        }
        if ("- Khu Vực -".equals(valueIn)) {
            busReport.getIntance().rpKhuVuc();
        }
        if ("- Nhà Cung Cấp -".equals(valueIn)) {
            busReport.getIntance().rpNhaCungCap();
        }
    }//GEN-LAST:event_jComboBoxInDanhSachActionPerformed

    private void jButtonSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSanPhamActionPerformed
        JFrame chon = new fSanPham_BaoCao();
        chon.setVisible(true);

    }//GEN-LAST:event_jButtonSanPhamActionPerformed

    private void jButtonPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPhieuNhapActionPerformed
        JFrame nhap = new fDanhSach_NhapHang(id_nv);
        nhap.setVisible(true);
    }//GEN-LAST:event_jButtonPhieuNhapActionPerformed

    private void jButtonPhieuXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPhieuXuatActionPerformed
        JFrame xuat = new fXuat_Kho(id_nv);
        xuat.setVisible(true);
    }//GEN-LAST:event_jButtonPhieuXuatActionPerformed

    private void jComboBoxInDanhSachExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInDanhSachExcelActionPerformed
        String valueIn = String.valueOf(jComboBoxInDanhSachExcel.getSelectedItem());
        if ("- Nhân Viên -".equals(valueIn)) {
            busReport.getIntance().excelNhanVien();
            JOptionPane.showMessageDialog(rootPane,
                    "Đã lưu file Excel NhanVien trong C:/demo.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if ("- Khu Vực -".equals(valueIn)) {
            busReport.getIntance().excelKhuVuc();
            JOptionPane.showMessageDialog(rootPane,
                    "Đã lưu file Excel KhuVuc trong C:/demo.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if ("- Nhà Cung Cấp -".equals(valueIn)) {
            busReport.getIntance().excelNguonCungCap();
            JOptionPane.showMessageDialog(rootPane,
                    "Đã lưu file Excel NguonCungCap trong C:/demo.",
                    "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jComboBoxInDanhSachExcelActionPerformed

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
    private javax.swing.JButton jButtonPhieuNhap;
    private javax.swing.JButton jButtonPhieuXuat;
    private javax.swing.JButton jButtonSanPham;
    private javax.swing.JComboBox<String> jComboBoxInDanhSach;
    private javax.swing.JComboBox<String> jComboBoxInDanhSachExcel;
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
    private javax.swing.JPanel jPanelShowSoLuongTheoLoai;
    private javax.swing.JPanel jPanelShowSoLuongTheoLoaiPieChart;
    private javax.swing.JPanel jPanelShowTonKho;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
