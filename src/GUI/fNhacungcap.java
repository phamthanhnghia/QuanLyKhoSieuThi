/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.*;
import DTO.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.lang.*;

/**
 *
 * @author Xoan Tran
 */
public class fNhacungcap extends javax.swing.JFrame {

    /**
     * Creates new form fNhacungcap
     */
    public int id_nv;
    public ArrayList<NguonCungCap> DanhSachXuatKho;
    public long count, SoTrang, Trang = 1;
    public ArrayList<NguonCungCap> DuLieuMau;

    public fNhacungcap() {
        initComponents();
        build();
    }

    public fNhacungcap(int id) {
        id_nv = id;
        initComponents();
        DanhSachXuatKho = daoNguonCungCap.getInstance().getListNguonCungCap();
        DuLieuMau = DanhSachXuatKho;
        build();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ArrayList<NguonCungCap> DuLieuMau = daoNguonCungCap.getInstance().getListNguonCungCap();
        String[] columnName = {"STT", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email", "Người đại diện"};
        Object[][] rows = new Object[DuLieuMau.size()][7];
        for(int i = 0; i < DuLieuMau.size(); i++){
            rows[i][0] = DuLieuMau.get(i).id_nguon_cc;
            rows[i][1] = DuLieuMau.get(i).ten_nha_cc;
            rows[i][2] = DuLieuMau.get(i).dia_chi;
            rows[i][3] = DuLieuMau.get(i).sdt;
            rows[i][4] = DuLieuMau.get(i).email;
            rows[i][5] = DuLieuMau.get(i).ten_dai_dien;
            /*
            if(DuLieuMau.get(i).hinh_anh != null){
                ImageIcon image = new ImageIcon(new ImageIcon(DuLieuMau.get(i).hinh_anh).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH) );
                //ImageIcon image = new ImageIcon(DuLieuMau.get(i).hinh_anh);
                //ImageIcon image = new ImageIcon(getClass().getResource("/Image/fXuatKho.jpg"));
                rows[i][6] = image;

            }
            else{
                rows[i][6] = "Chưa có hình ảnh";
            }
            */
        }
        DefaultTableModel model = new DefaultTableModel (rows,columnName)
        {
            @Override
            public Class getColumnClass(int c) {
                switch (c)

                {
                    //case 6:
                    //return ImageIcon.class;
                    default:
                    return Object.class;
                }
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        jTableNguonCungCap = new javax.swing.JTable(model);
        jButtonThem = new javax.swing.JButton();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jButtonExcel = new javax.swing.JButton();
        jButtonTimKiem = new javax.swing.JButton();
        jButtonLamMoi = new javax.swing.JButton();
        jLabelKetQua = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonNhoMax = new javax.swing.JButton();
        jButtonNho = new javax.swing.JButton();
        jLabelTrang = new javax.swing.JLabel();
        jButtonLon = new javax.swing.JButton();
        jButtonLonMax = new javax.swing.JButton();
        jLabelSoTrang = new javax.swing.JLabel();
        jComboBoxNhanVien = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhà cung cấp");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phần mềm quản lý kho");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("siêu thị S.O.S");

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setAlignmentX(0.2F);

        /*
        jTableNguonCungCap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableNguonCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email", "Người đại diện"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        */
        jTableNguonCungCap.setRequestFocusEnabled(false);
        jTableNguonCungCap.setRowHeight(50);
        jTableNguonCungCap.setRowSelectionAllowed(true);
        jTableNguonCungCap.setAutoCreateRowSorter(true);
        jTableNguonCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNguonCungCapMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableNguonCungCap);
        if (jTableNguonCungCap.getColumnModel().getColumnCount() > 0) {
            jTableNguonCungCap.getColumnModel().getColumn(0).setMinWidth(30);
            jTableNguonCungCap.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableNguonCungCap.getColumnModel().getColumn(0).setMaxWidth(30);
            jTableNguonCungCap.getColumnModel().getColumn(0).setHeaderValue("STT");
            jTableNguonCungCap.getColumnModel().getColumn(1).setHeaderValue("Tên nhà cung cấp");
            jTableNguonCungCap.getColumnModel().getColumn(2).setHeaderValue("Địa chỉ");
            jTableNguonCungCap.getColumnModel().getColumn(3).setHeaderValue("Số điện thoại");
            jTableNguonCungCap.getColumnModel().getColumn(4).setHeaderValue("Email");
            jTableNguonCungCap.getColumnModel().getColumn(5).setHeaderValue("Người đại diện");
        }

        jButtonThem.setBackground(new java.awt.Color(255, 255, 255));
        jButtonThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonThem.setText("Tạo mới");
        ImageIcon imgTaoMoi = new ImageIcon(getClass().getResource("/icon/icons8-plus-48.png"));
        ImageIcon ImgTaoMoi = new ImageIcon(imgTaoMoi.getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH));
        jButtonThem.setIcon(ImgTaoMoi);
        jButtonThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemnhacungcap(evt);
            }
        });
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemjButton2ActionPerformed(evt);
            }
        });

        jTextFieldTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimKiemActionPerformed(evt);
            }
        });
        jTextFieldTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemKeyReleased(evt);
            }
        });

        jButtonExcel.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExcel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImageIcon img = new ImageIcon(getClass().getResource("/icon/icons8-microsoft-excel-40.png"));
        ImageIcon Img = new ImageIcon(img.getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH));
        jButtonExcel.setIcon(Img);
        jButtonExcel.setText("Excel");
        jButtonExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcelActionPerformed(evt);
            }
        });

        jButtonTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImageIcon imgTimKiem = new ImageIcon(getClass().getResource("/icon/icons8-search.png"));
        ImageIcon ImgTimKiem = new ImageIcon(imgTimKiem.getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH));
        jButtonTimKiem.setIcon(ImgTimKiem);
        jButtonTimKiem.setText("Tìm kiếm");
        jButtonTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemActionPerformed(evt);
            }
        });

        jButtonLamMoi.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImageIcon imgLamMoi = new ImageIcon(getClass().getResource("/icon/icons8-synchronize-30.png"));
        ImageIcon ImgLamMoi = new ImageIcon(imgLamMoi.getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH));
        jButtonLamMoi.setIcon(ImgLamMoi);
        jButtonLamMoi.setText("Tải lại");
        jButtonLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLamMoiActionPerformed(evt);
            }
        });

        jLabelKetQua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelKetQua.setForeground(new java.awt.Color(255, 255, 255));
        jLabelKetQua.setText("Có tổng cộng 000 kết quả");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DANH SÁCH NHÀ CUNG CẤP");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(797, 797, 797)
                        .addComponent(jLabelKetQua))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jButtonThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTimKiem)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonThem)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExcel)
                        .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTimKiem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelKetQua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jButtonNhoMax.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonNhoMax.setText("<<");
        jButtonNhoMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNhoMaxActionPerformed(evt);
            }
        });

        jButtonNho.setText("<");
        jButtonNho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNhoActionPerformed(evt);
            }
        });

        jLabelTrang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTrang.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTrang.setText("jLabel2");

        jButtonLon.setText(">");
        jButtonLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLonActionPerformed(evt);
            }
        });

        jButtonLonMax.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonLonMax.setText(">>");
        jButtonLonMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLonMaxActionPerformed(evt);
            }
        });

        jLabelSoTrang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSoTrang.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSoTrang.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNhoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTrang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLonMax)
                .addGap(18, 18, 18)
                .addComponent(jLabelSoTrang)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNhoMax)
                    .addComponent(jButtonNho)
                    .addComponent(jButtonLon)
                    .addComponent(jButtonLonMax)
                    .addComponent(jLabelSoTrang)
                    .addComponent(jLabelTrang))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jComboBoxNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonThemjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemjButton2ActionPerformed
        JFrame Them = new fCreateNhaCungCap(id_nv);
        Them.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonThemjButton2ActionPerformed

    private void jTextFieldTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemKeyReleased
        if ("".equals(jTextFieldTimKiem.getText())) {
            build();
        }
    }//GEN-LAST:event_jTextFieldTimKiemKeyReleased

    private void btnThemnhacungcap(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemnhacungcap
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemnhacungcap

    private void jTableNguonCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNguonCungCapMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            int selectedRowIndex = jTableNguonCungCap.getSelectedRow();
            int id = jTableNguonCungCap.getValueAt(selectedRowIndex, 0).hashCode();
            JFrame Xem = new fViewNhaCungCap(id_nv, id);
            Xem.setVisible(true);
            //System.out.print("Nhap dup chuot");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableNguonCungCapMouseClicked

    private void jComboBoxNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNhanVienActionPerformed
        String valueIn = String.valueOf(jComboBoxNhanVien.getSelectedItem());
        if ("Thoát".equals(valueIn)) {
            JFrame dn = new fDangNhap();
            dn.setVisible(true);
            dispose();
        }
        if ("Thông tin".equals(valueIn)) {
            JFrame nv = new fViewNhanVien(id_nv, id_nv);
            nv.setVisible(true);
        }
        jComboBoxNhanVien.setSelectedIndex(0);
    }//GEN-LAST:event_jComboBoxNhanVienActionPerformed

    private void jButtonExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcelActionPerformed
        // TODO add your handling code here:
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");
        int rownum = 0;
        Cell cell;
        Row row;

        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("Tên nhà cung cấp");

        cell = row.createCell(1);
        cell.setCellValue("Địa chỉ");

        cell = row.createCell(2);
        cell.setCellValue("Sđt");

        cell = row.createCell(3);
        cell.setCellValue("Email");

        cell = row.createCell(4);
        cell.setCellValue("Đại diện");

        for (int i = 0; i < DuLieuMau.size(); i++) {
            rownum++;
            row = sheet.createRow(rownum);
            //
            cell = row.createCell(0);
            cell.setCellValue(DuLieuMau.get(i).ten_nha_cc);
            //
            cell = row.createCell(1);
            cell.setCellValue(DuLieuMau.get(i).dia_chi);
            //
            cell = row.createCell(2);
            cell.setCellValue(DuLieuMau.get(i).sdt);
            //
            cell = row.createCell(3);
            cell.setCellValue(DuLieuMau.get(i).email);
            //
            cell = row.createCell(4);
            cell.setCellValue(DuLieuMau.get(i).ten_dai_dien);
            //

        }
        File file = new File("C:/demo/NhaCungCap.xls");
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

        JOptionPane.showMessageDialog(rootPane,
                "Đã lưu file Excel NhaCungCap trong C:/demo.",
                "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonExcelActionPerformed

    private void jTextFieldTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimKiemActionPerformed

    private void jButtonNhoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhoMaxActionPerformed
        Trang = 1;
        ArrayList<NguonCungCap> table = DAO.daoNguonCungCap.getInstance().get20NguonCungCap(DanhSachXuatKho, Trang);
        listDanhSachNguonCungCap(table);
        jLabelTrang.setText("1");
        jLabelSoTrang.setText("1/" + SoTrang);
    }//GEN-LAST:event_jButtonNhoMaxActionPerformed

    private void jButtonNhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhoActionPerformed
        if (Trang > 1) {
            Trang--;
            ArrayList<NguonCungCap> table = DAO.daoNguonCungCap.getInstance().get20NguonCungCap(DanhSachXuatKho, Trang);
            listDanhSachNguonCungCap(table);
            jLabelTrang.setText("" + Trang);
            jLabelSoTrang.setText(Trang + "/" + SoTrang);
        }
    }//GEN-LAST:event_jButtonNhoActionPerformed

    private void jButtonLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLonActionPerformed
        if (Trang < SoTrang) {
            Trang++;
            ArrayList<NguonCungCap> table = DAO.daoNguonCungCap.getInstance().get20NguonCungCap(DanhSachXuatKho, Trang);
            listDanhSachNguonCungCap(table);
            jLabelTrang.setText("" + Trang);
            jLabelSoTrang.setText(Trang + "/" + SoTrang);
        }
    }//GEN-LAST:event_jButtonLonActionPerformed

    private void jButtonLonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLonMaxActionPerformed
        Trang = SoTrang;
        ArrayList<NguonCungCap> table = DAO.daoNguonCungCap.getInstance().get20NguonCungCap(DanhSachXuatKho, Trang);
        listDanhSachNguonCungCap(table);
        jLabelTrang.setText("" + SoTrang);
        jLabelSoTrang.setText(SoTrang + "/" + SoTrang);
    }//GEN-LAST:event_jButtonLonMaxActionPerformed

    private void jButtonLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLamMoiActionPerformed
        invalidate();
        validate();
        repaint();
        build();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLamMoiActionPerformed

    private void jTextFieldTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DanhSachXuatKho = DuLieuMau;
            FindList();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimKiemKeyPressed

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemActionPerformed
        DanhSachXuatKho = DuLieuMau;
        FindList();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTimKiemActionPerformed
    //
    // 
    public void NhanVienDangNhap() {
        if (id_nv != 0) {
            TaiKhoan tk = DAO.daoTaiKhoan.getInstance().getTaiKhoan(id_nv);
            NhanVien nv = DAO.daoTaiKhoan.getInstance().getNhanVien(tk.id_nv);
            jComboBoxNhanVien.addItem(nv.ten_nv);
            jComboBoxNhanVien.addItem("Thông tin");
            jComboBoxNhanVien.addItem("Thoát");
        } else {
            jComboBoxNhanVien.addItem("Chưa đăng nhập");
        }
    }

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
            java.util.logging.Logger.getLogger(fNhacungcap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fNhacungcap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fNhacungcap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fNhacungcap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame ncc = new fNhacungcap(1);
                ncc.setVisible(true);
            }
        });
    }

    public void build() {
        DanhSachXuatKho = DuLieuMau;
        this.count = this.DanhSachXuatKho.size();
        jLabelKetQua.setText("Có tổng cộng " + count + " kết quả");
        if (count % 20 == 0) {
            SoTrang = count / 20;
        } else {
            SoTrang = count / 20 + 1;
        }
        jLabelSoTrang.setText("1/" + SoTrang);
        jLabelTrang.setText("1");
        ArrayList<NguonCungCap> table = DAO.daoNguonCungCap.getInstance().get20NguonCungCap(DanhSachXuatKho, 1);
        listDanhSachNguonCungCap(table);
        NhanVienDangNhap();
    }

    public void FindList() {
        this.DanhSachXuatKho = DAO.daoNguonCungCap.getInstance().FindListNguonCungCap(DuLieuMau, jTextFieldTimKiem.getText());
        if (DanhSachXuatKho.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Không có dữ liệu nhà cung cấp",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            build();
        } else {
            this.count = this.DanhSachXuatKho.size();
            jLabelKetQua.setText("Có tổng cộng " + count + " kết quả");
            if (count % 20 == 0) {
                SoTrang = count / 20;
            } else {
                SoTrang = count / 20 + 1;
            }
            jLabelSoTrang.setText("1/" + SoTrang);
            jLabelTrang.setText("1");
            ArrayList<NguonCungCap> table = DAO.daoNguonCungCap.getInstance().get20NguonCungCap(DanhSachXuatKho, 1);
            listDanhSachNguonCungCap(table);
        }
    }

    public void listDanhSachNguonCungCap(ArrayList<NguonCungCap> arr) {
        DefaultTableModel model = (DefaultTableModel) jTableNguonCungCap.getModel();
        while (jTableNguonCungCap.getRowCount() > 0) {
            model.removeRow(0);
        }
        arr.stream().forEach((item) -> {
            ImageIcon icon = new ImageIcon(item.hinh_anh);
            model.addRow(new Object[]{item.id_nguon_cc, item.ten_nha_cc, item.dia_chi, item.sdt, item.email, item.ten_dai_dien});
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExcel;
    private javax.swing.JButton jButtonLamMoi;
    private javax.swing.JButton jButtonLon;
    private javax.swing.JButton jButtonLonMax;
    private javax.swing.JButton jButtonNho;
    private javax.swing.JButton jButtonNhoMax;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JComboBox<String> jComboBoxNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelKetQua;
    private javax.swing.JLabel jLabelSoTrang;
    private javax.swing.JLabel jLabelTrang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTableNguonCungCap;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
