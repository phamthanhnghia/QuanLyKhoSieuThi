/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.daoNguonCungCap;
import DTO.NguonCungCap;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class fChonNhaCungCap_NhapHang extends javax.swing.JFrame {

    /**
     * Creates new form fChonNhaCungCap_NhapHang
     */
    public int id_nv; 
    public int id_sp;
    public int id_nguon_cc;
    public int so_tien_lo;
    public int so_luong_lo;
    public fChonNhaCungCap_NhapHang(int id_nv,int id_sp) {
        initComponents();
        build();
        this.id_nv =id_nv;
        this.id_sp = id_sp;
    }
    public fChonNhaCungCap_NhapHang() {
        initComponents();
    }
    public void build(){
        listNguonCungCap();
    }
    public void listNguonCungCap(){
        DefaultTableModel model = (DefaultTableModel) jTableNguonCC.getModel();
        while (jTableNguonCC.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<NguonCungCap> arr = daoNguonCungCap.getInstance().getListNguonCungCap();
        for(int i=0 ;i< arr.size();i++){
            model.addRow(new Object[]{arr.get(i).id_nguon_cc,arr.get(i).ten_nha_cc,arr.get(i).ten_dai_dien,arr.get(i).sdt});
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextFieldTimKiemNhaCungCap = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNguonCC = new javax.swing.JTable();
        jButtonChonNhaCungCapTiepTuc = new javax.swing.JButton();
        jButtonQuayLai = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonTaoNhaCungCap = new javax.swing.JButton();
        jSpinnerSoLuongLo = new javax.swing.JSpinner();
        jSpinnerSoTienLo = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chọn nhà cung cấp - Nhập hàng");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-home.png"))); // NOI18N
        jLabel3.setText("Trang chủ");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-news.png"))); // NOI18N
        jLabel4.setText("Thông tin Lô");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-checked.png"))); // NOI18N
        jLabel5.setText("Hoàn thành");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-folder.png"))); // NOI18N
        jLabel6.setText("Chọn sản phẩm");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-container-truck.png"))); // NOI18N
        jLabel7.setText("Nhà cung cấp");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Tìm kiếm");

        jTextFieldTimKiemNhaCungCap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldTimKiemNhaCungCap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemNhaCungCapKeyReleased(evt);
            }
        });

        jTableNguonCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableNguonCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nhà cung cấp", "Đại diện", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNguonCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableNguonCCMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNguonCC);
        if (jTableNguonCC.getColumnModel().getColumnCount() > 0) {
            jTableNguonCC.getColumnModel().getColumn(0).setMinWidth(30);
            jTableNguonCC.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableNguonCC.getColumnModel().getColumn(0).setMaxWidth(30);
            jTableNguonCC.getColumnModel().getColumn(2).setMinWidth(130);
            jTableNguonCC.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTableNguonCC.getColumnModel().getColumn(2).setMaxWidth(130);
            jTableNguonCC.getColumnModel().getColumn(3).setMinWidth(100);
            jTableNguonCC.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableNguonCC.getColumnModel().getColumn(3).setMaxWidth(100);
        }
        jTableNguonCC.setRowHeight(30);

        jButtonChonNhaCungCapTiepTuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonChonNhaCungCapTiepTuc.setText("Tiếp tục");
        jButtonChonNhaCungCapTiepTuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChonNhaCungCapTiepTucActionPerformed(evt);
            }
        });

        jButtonQuayLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonQuayLai.setText("Quay lại");
        jButtonQuayLai.setToolTipText("");
        jButtonQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuayLaiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Số lượng lô * :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Số tiền lô * :");

        jButtonTaoNhaCungCap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTaoNhaCungCap.setText("Tạo mới");
        jButtonTaoNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaoNhaCungCapActionPerformed(evt);
            }
        });

        jSpinnerSoLuongLo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jSpinnerSoTienLo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("VNĐ.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonChonNhaCungCapTiepTuc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonTaoNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerSoLuongLo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldTimKiemNhaCungCap)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerSoTienLo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerSoLuongLo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerSoTienLo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButtonTaoNhaCungCap))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChonNhaCungCapTiepTuc)
                    .addComponent(jButtonQuayLai))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTimKiemNhaCungCapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemNhaCungCapKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTableNguonCC.getModel();
        while (jTableNguonCC.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<NguonCungCap> arr = daoNguonCungCap.getInstance().FindListNguonCungCap(jTextFieldTimKiemNhaCungCap.getText());
        for(int i=0;i<arr.size();i++){
            model.addRow(new Object[]{arr.get(i).id_nguon_cc,arr.get(i).ten_nha_cc,arr.get(i).ten_dai_dien,arr.get(i).sdt});
        }
    }//GEN-LAST:event_jTextFieldTimKiemNhaCungCapKeyReleased

    private void jButtonChonNhaCungCapTiepTucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChonNhaCungCapTiepTucActionPerformed

        this.so_tien_lo = (Integer)jSpinnerSoTienLo.getValue();
        this.so_luong_lo = (Integer)jSpinnerSoLuongLo.getValue();
        if(id_nguon_cc == 0 || so_tien_lo <= 0 || so_luong_lo <= 0){
            JOptionPane.showMessageDialog(rootPane,
            "Chưa chọn sản phẩm hoặc chưa nhập số tiền, số lượng lô.",
            "Thông báo",
            JOptionPane.ERROR_MESSAGE);
        }else{
            JFrame ThongTinLo = new fThongTinLo_NhapHang(id_nv,id_sp,id_nguon_cc,so_tien_lo,so_luong_lo);
            ThongTinLo.setVisible(true);
            dispose();
        }
        //System.out.println(id_nguon_cc+" "+ so_tien_lo +" "+ so_luong_lo);
    }//GEN-LAST:event_jButtonChonNhaCungCapTiepTucActionPerformed

    private void jTableNguonCCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNguonCCMousePressed
        DefaultTableModel model = (DefaultTableModel)jTableNguonCC.getModel();
        // get the selected row index
        int selectedRowIndex = jTableNguonCC.getSelectedRow();
        // set the selected row data into jtextfields
        this.id_nguon_cc = model.getValueAt(selectedRowIndex, 0).hashCode();
        //System.out.println(id_nguon_cc);
    }//GEN-LAST:event_jTableNguonCCMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void jButtonQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuayLaiActionPerformed
        JFrame ChonSanPham = new fChonSanPham_NhapHang(id_nv);
        ChonSanPham.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonQuayLaiActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
//        JFrame TrangChu = new fHome(id_nv);
//        TrangChu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jButtonTaoNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaoNhaCungCapActionPerformed
        JFrame nhacungcap = new fCreateNhaCungCap(id_nv);
        nhacungcap.setVisible(true);
    }//GEN-LAST:event_jButtonTaoNhaCungCapActionPerformed

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
            java.util.logging.Logger.getLogger(fChonNhaCungCap_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fChonNhaCungCap_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fChonNhaCungCap_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fChonNhaCungCap_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create ajButtonTaoNhaCungCapay the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fChonNhaCungCap_NhapHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonChonNhaCungCapTiepTuc;
    private javax.swing.JButton jButtonQuayLai;
    private javax.swing.JButton jButtonTaoNhaCungCap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerSoLuongLo;
    private javax.swing.JSpinner jSpinnerSoTienLo;
    private javax.swing.JTable jTableNguonCC;
    private javax.swing.JTextField jTextFieldTimKiemNhaCungCap;
    // End of variables declaration//GEN-END:variables
}
