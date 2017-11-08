/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DTO.TaiKhoan;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Xoan Tran
 */
public class fHome extends javax.swing.JFrame {

    /**
     * Creates new form fHome
     */
    public int id_nv;
    
    public fHome() {
        this.id_nv = 0;
        initComponents();
        build();
    }
    public fHome(int id_nv) {
        this.id_nv = id_nv;
        initComponents();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonThongBao = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBoxNhanVien = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jButtonKiemKe = new javax.swing.JButton();
        jButtonXuatKho = new javax.swing.JButton();
        jButtonNhaCungCap = new javax.swing.JButton();
        jButtonTraNhaCungCap = new javax.swing.JButton();
        jButtonBaoCao = new javax.swing.JButton();
        jButtonNhapHang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Màn hình chính");

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phần mềm quản lý kho");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("siêu thị S.O.S");

        jButtonThongBao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonThongBao.setForeground(new java.awt.Color(255, 255, 255));
        jButtonThongBao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fMessage.png"))); // NOI18N
        jButtonThongBao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonThongBao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonThongBaoMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fbell.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBoxNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNhanVienActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButtonKiemKe.setBackground(new java.awt.Color(255, 255, 255));
        jButtonKiemKe.setForeground(new java.awt.Color(255, 255, 255));
        jButtonKiemKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-pos-terminal.png"))); // NOI18N
        jButtonKiemKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonKiemKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonKiemKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonKiemKeMouseExited(evt);
            }
        });

        jButtonXuatKho.setBackground(new java.awt.Color(255, 255, 255));
        jButtonXuatKho.setForeground(new java.awt.Color(255, 255, 255));
        jButtonXuatKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-checkout.png"))); // NOI18N
        jButtonXuatKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonXuatKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonXuatKhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonXuatKhoMouseExited(evt);
            }
        });

        jButtonNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-handshake.png"))); // NOI18N
        jButtonNhaCungCap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonNhaCungCapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonNhaCungCapMouseExited(evt);
            }
        });

        jButtonTraNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTraNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTraNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-export.png"))); // NOI18N
        jButtonTraNhaCungCap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTraNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonTraNhaCungCapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonTraNhaCungCapMouseExited(evt);
            }
        });
        jButtonTraNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraNhaCungCapActionPerformed(evt);
            }
        });

        jButtonBaoCao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBaoCao.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-report-card.png"))); // NOI18N
        jButtonBaoCao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBaoCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBaoCaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBaoCaoMouseExited(evt);
            }
        });

        jButtonNhapHang.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-warehouse.png"))); // NOI18N
        jButtonNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNhapHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonNhapHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonNhapHangMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel3.setText("Nhà cung cấp");

        jLabel4.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel4.setText("Nhập hàng");

        jLabel5.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel5.setText("Kiểm kê");

        jLabel6.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel6.setText("Trả nhà cung cấp");

        jLabel7.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel7.setText("Xuất kho");

        jLabel8.setFont(new java.awt.Font("Sitka Small", 3, 24)); // NOI18N
        jLabel8.setText("Báo cáo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonXuatKho, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonTraNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(211, 211, 211))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonKiemKe, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(184, 184, 184))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBaoCao, jButtonKiemKe, jButtonNhaCungCap, jButtonNhapHang, jButtonTraNhaCungCap, jButtonXuatKho});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNhaCungCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNhapHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonKiemKe, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonXuatKho)
                    .addComponent(jButtonTraNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBaoCao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBaoCao, jButtonKiemKe, jButtonNhaCungCap, jButtonNhapHang, jButtonTraNhaCungCap, jButtonXuatKho});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButtonThongBao});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(299, 299, 299))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButtonThongBao});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNhanVienActionPerformed

    private void jButtonTraNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraNhaCungCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTraNhaCungCapActionPerformed

    private void jButtonThongBaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonThongBaoMouseClicked
        JFrame TB = new fThongBao();
            TB.setVisible(true);
            //dispose();
    }//GEN-LAST:event_jButtonThongBaoMouseClicked

    private void jButtonNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNhapHangMouseClicked
        JFrame ChonSanPham = new fChonSanPham_NhapHang(id_nv);
        ChonSanPham.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonNhapHangMouseClicked

    private void jButtonNhaCungCapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNhaCungCapMouseEntered
    jButtonNhaCungCap.setBackground(UIManager.getColor("control"));
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNhaCungCapMouseEntered

    private void jButtonNhaCungCapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNhaCungCapMouseExited
    jButtonNhaCungCap.setBackground(Color.WHITE);
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonNhaCungCapMouseExited

    private void jButtonXuatKhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonXuatKhoMouseEntered
    jButtonXuatKho.setBackground(UIManager.getColor("control"));
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonXuatKhoMouseEntered

    private void jButtonXuatKhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonXuatKhoMouseExited
    jButtonXuatKho.setBackground(Color.WHITE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonXuatKhoMouseExited

    private void jButtonNhapHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNhapHangMouseEntered
    jButtonNhapHang.setBackground(UIManager.getColor("control"));    
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonNhapHangMouseEntered

    private void jButtonNhapHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNhapHangMouseExited
    jButtonNhapHang.setBackground(Color.WHITE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNhapHangMouseExited

    private void jButtonTraNhaCungCapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTraNhaCungCapMouseEntered
    jButtonTraNhaCungCap.setBackground(UIManager.getColor("control"));    
// TODO add your handling code here:
    }//GEN-LAST:event_jButtonTraNhaCungCapMouseEntered

    private void jButtonTraNhaCungCapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTraNhaCungCapMouseExited
    jButtonTraNhaCungCap.setBackground(Color.WHITE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTraNhaCungCapMouseExited

    private void jButtonKiemKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonKiemKeMouseEntered
    jButtonKiemKe.setBackground(UIManager.getColor("control"));
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonKiemKeMouseEntered

    private void jButtonKiemKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonKiemKeMouseExited
    jButtonKiemKe.setBackground(Color.WHITE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonKiemKeMouseExited

    private void jButtonBaoCaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBaoCaoMouseEntered
    jButtonBaoCao.setBackground(UIManager.getColor("control"));
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBaoCaoMouseEntered

    private void jButtonBaoCaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBaoCaoMouseExited
    jButtonBaoCao.setBackground(Color.WHITE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBaoCaoMouseExited

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
            java.util.logging.Logger.getLogger(fHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fHome().setVisible(true);
            }
        });
    }
    void build(){
        if(id_nv != 0){
            TaiKhoan tk = DAO.daoTaiKhoan.getInstance().getTaiKhoan(id_nv);
            jComboBoxNhanVien.addItem(tk.ten_tai_khoan);
            jComboBoxNhanVien.addItem("Thoát");
        }else{
            jComboBoxNhanVien.addItem("Chưa đăng nhập");
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBaoCao;
    private javax.swing.JButton jButtonKiemKe;
    private javax.swing.JButton jButtonNhaCungCap;
    private javax.swing.JButton jButtonNhapHang;
    private javax.swing.JButton jButtonThongBao;
    private javax.swing.JButton jButtonTraNhaCungCap;
    private javax.swing.JButton jButtonXuatKho;
    private javax.swing.JComboBox<String> jComboBoxNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
