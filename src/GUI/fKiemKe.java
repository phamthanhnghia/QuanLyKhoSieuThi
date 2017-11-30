/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DateTimeNow;
import DAO.daoKho;
import DAO.daoLoaiSanPham;
import DAO.daoPhieuKiemKeKho;
import DAO.daoSanPham;
import DTO.NhanVien;
import DTO.PhieuKiemKeKho;
import DTO.SanPham;
import DTO.TaiKhoan;
import GROUP.ThongTinKhoHienTai;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xoan Tran
 */
public class fKiemKe extends javax.swing.JFrame {

    /**
     * Creates new form fKiemKe
     */
    public int id_nv;
    public ArrayList<ThongTinKhoHienTai> DuLieuMau;
    public ArrayList<ThongTinKhoHienTai> DanhSach;
    public long count, SoTrang, Trang = 1;
    public fKiemKe() {
        DanhSach = daoKho.getInstance().getListThongTinKhoHienTai();
        DuLieuMau = DanhSach ; 
        initComponents();
        build();
    }
    public fKiemKe(int id_nv)
    {
        this.id_nv=id_nv;
        DanhSach = daoKho.getInstance().getListThongTinKhoHienTai();
        DuLieuMau = DanhSach ; 
        initComponents();
        build();
    }
    public void build()
    {
        DanhSach = DuLieuMau;
        this.count = this.DanhSach.size();
        jLabelKetQua.setText("Có tổng cộng " + count + " kết quả");
        if (count % 20 == 0) {
            SoTrang = count / 20;
        } else {
            SoTrang = count / 20 + 1;
        }
        jLabelSoTrang.setText("1/" + SoTrang);
        jLabelTrang.setText("1");
        ArrayList<ThongTinKhoHienTai> table = DAO.daoKho.getInstance().get20KhoHienTai(DanhSach, 1);
        listDanhSachKhoHienTai(table);
        NhanVienDangNhap();
        
    }
    public void NhanVienDangNhap() {
        if (id_nv != 0) {
            TaiKhoan tk = DAO.daoTaiKhoan.getInstance().getTaiKhoan(id_nv);
            NhanVien nv = DAO.daoTaiKhoan.getInstance().getNhanVien(tk.id_nv);
            jComboBoxNhanVien2.addItem(nv.ten_nv);
            jComboBoxNhanVien2.addItem("Thông tin");
            jComboBoxNhanVien2.addItem("Thoát");
        } else {
            jComboBoxNhanVien2.addItem("Chưa đăng nhập");
        }
    }
    public void listDanhSachKhoHienTai(ArrayList<ThongTinKhoHienTai> arr){
        DefaultTableModel model = (DefaultTableModel) jTableKhoHienTai.getModel();
        while (jTableKhoHienTai.getRowCount() > 0) {
            model.removeRow(0);
        }
        arr.stream().forEach((item) -> {
            PhieuKiemKeKho phieu = daoPhieuKiemKeKho.getInstance().getPhieuKiemKeKho(item.id_kho);
            if(phieu == null){
                model.addRow(new Object[]{item.id_kho,item.ten_sp,item.hsd,item.nsx,item.sl_san_pham,item.so_luong_sp});
            }else{
                model.addRow(new Object[]{item.id_kho,item.ten_sp,item.hsd,item.nsx,item.sl_san_pham,item.so_luong_sp,phieu.sl_hao_mon});
            }
        });
    }
    
    public void FindList() {
        //String DuLieu = jTextFieldTimKiem.getText();
        this.DanhSach = DAO.daoKho.getInstance().FindListKhoHienTai(DuLieuMau, jTextFieldTimKiem.getText());
        if (DanhSach.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Không có dữ liệu xuất kho",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            build();
        } else {
            this.count = this.DanhSach.size();
            jLabelKetQua.setText("Có tổng cộng " + count + " kết quả");
            if (count % 20 == 0) {
                SoTrang = count / 20;
            } else {
                SoTrang = count / 20 + 1;
            }
            jLabelSoTrang.setText("1/" + SoTrang);
            jLabelTrang.setText("1");
            ArrayList<ThongTinKhoHienTai> table = DAO.daoKho.getInstance().get20KhoHienTai(DanhSach, 1);
            listDanhSachKhoHienTai(table);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKhoHienTai = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButtonNhoMax = new javax.swing.JButton();
        jButtonNho = new javax.swing.JButton();
        jLabelTrang = new javax.swing.JLabel();
        jButtonLon = new javax.swing.JButton();
        jButtonLonMax = new javax.swing.JButton();
        jLabelSoTrang = new javax.swing.JLabel();
        jLabelKetQua = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_id_kho = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerSLHaoMon = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonLuu = new javax.swing.JButton();
        jComboBoxNhanVien2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kiểm kê");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phần mềm quản lý kho");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("siêu thị S.O.S");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTableKhoHienTai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Kho", "Tên Sản Phẩm", "HSD", "NSX", "SL Lô", "SL Sản Phẩm 1 Lô", "SL Hao Mòn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKhoHienTai.setRowHeight(30);
        jScrollPane1.setViewportView(jTableKhoHienTai);
        if (jTableKhoHienTai.getColumnModel().getColumnCount() > 0) {
            jTableKhoHienTai.getColumnModel().getColumn(0).setMinWidth(60);
            jTableKhoHienTai.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableKhoHienTai.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableKhoHienTai.getColumnModel().getColumn(1).setMinWidth(500);
            jTableKhoHienTai.getColumnModel().getColumn(1).setPreferredWidth(500);
            jTableKhoHienTai.getColumnModel().getColumn(1).setMaxWidth(500);
            jTableKhoHienTai.getColumnModel().getColumn(2).setMinWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(2).setMaxWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(3).setMinWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(3).setMaxWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(4).setMinWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(4).setMaxWidth(80);
        }

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

        jLabelKetQua.setBackground(new java.awt.Color(51, 51, 51));
        jLabelKetQua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelKetQua.setForeground(new java.awt.Color(102, 102, 102));
        jLabelKetQua.setText("Có tổng cộng 000 kết quả");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID Kho :");

        jTextField_id_kho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("SL Hao Mòn :");

        jSpinnerSLHaoMon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLuu.setText("Lưu");
        jButtonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonLuu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerSLHaoMon, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_id_kho)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_id_kho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerSLHaoMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLuu)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelKetQua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKetQua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jComboBoxNhanVien2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxNhanVien2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNhanVien2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxNhanVien2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxNhanVien2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
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

    private void jButtonNhoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhoMaxActionPerformed
        Trang = 1;
        ArrayList<ThongTinKhoHienTai> table = DAO.daoKho.getInstance().get20KhoHienTai(DanhSach, Trang);
        listDanhSachKhoHienTai(table);
        jLabelTrang.setText("1");
        jLabelSoTrang.setText("1/" + SoTrang);
    }//GEN-LAST:event_jButtonNhoMaxActionPerformed

    private void jButtonNhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhoActionPerformed
        if (Trang > 1) {
            Trang--;
            ArrayList<ThongTinKhoHienTai> table = DAO.daoKho.getInstance().get20KhoHienTai(DanhSach, Trang);
            listDanhSachKhoHienTai(table);
            jLabelTrang.setText("" + Trang);
            jLabelSoTrang.setText(Trang + "/" + SoTrang);
        }
    }//GEN-LAST:event_jButtonNhoActionPerformed

    private void jButtonLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLonActionPerformed
        if (Trang < SoTrang) {
            Trang++;
            ArrayList<ThongTinKhoHienTai> table = DAO.daoKho.getInstance().get20KhoHienTai(DanhSach, Trang);
            listDanhSachKhoHienTai(table);
            jLabelTrang.setText("" + Trang);
            jLabelSoTrang.setText(Trang + "/" + SoTrang);
        }
    }//GEN-LAST:event_jButtonLonActionPerformed

    private void jButtonLonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLonMaxActionPerformed
        Trang = SoTrang;
        ArrayList<ThongTinKhoHienTai> table = DAO.daoKho.getInstance().get20KhoHienTai(DanhSach, Trang);
        listDanhSachKhoHienTai(table);
        jLabelTrang.setText("" + SoTrang);
        jLabelSoTrang.setText(SoTrang + "/" + SoTrang);
    }//GEN-LAST:event_jButtonLonMaxActionPerformed

    private void jComboBoxNhanVien2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNhanVien2ActionPerformed
        String valueIn = String.valueOf(jComboBoxNhanVien2.getSelectedItem());
        if ("Thoát".equals(valueIn)) {
            JFrame dn = new fDangNhap();
            dn.setVisible(true);
            dispose();
        }
        if ("Thông tin".equals(valueIn)) {
            JFrame nv = new fViewNhanVien(id_nv, id_nv);
            nv.setVisible(true);
        }
        jComboBoxNhanVien2.setSelectedIndex(0);
    }//GEN-LAST:event_jComboBoxNhanVien2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DanhSach = DuLieuMau;
        FindList();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuuActionPerformed
        int sl_hao_mon = jSpinnerSLHaoMon.getValue().hashCode();
        String thoi_gian = DateTimeNow.getIntance().DateNow;
        int id_kho = Integer.parseInt(jTextField_id_kho.getText());
        daoPhieuKiemKeKho.getInstance().insertPhieuKiemKeKho(sl_hao_mon, thoi_gian, id_kho, id_nv);
        ArrayList<ThongTinKhoHienTai> table = DAO.daoKho.getInstance().get20KhoHienTai(DanhSach, 1);
        listDanhSachKhoHienTai(table);
    }//GEN-LAST:event_jButtonLuuActionPerformed

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
            java.util.logging.Logger.getLogger(fKiemKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fKiemKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fKiemKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fKiemKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fKiemKe(1).setVisible(true);
            }
        });
    }
        
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonLon;
    private javax.swing.JButton jButtonLonMax;
    private javax.swing.JButton jButtonLuu;
    private javax.swing.JButton jButtonNho;
    private javax.swing.JButton jButtonNhoMax;
    private javax.swing.JComboBox<String> jComboBoxNhanVien;
    private javax.swing.JComboBox<String> jComboBoxNhanVien1;
    private javax.swing.JComboBox<String> jComboBoxNhanVien2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelKetQua;
    private javax.swing.JLabel jLabelSoTrang;
    private javax.swing.JLabel jLabelTrang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinnerSLHaoMon;
    private javax.swing.JTable jTableKhoHienTai;
    private javax.swing.JTextField jTextFieldTimKiem;
    private javax.swing.JTextField jTextField_id_kho;
    // End of variables declaration//GEN-END:variables
}
