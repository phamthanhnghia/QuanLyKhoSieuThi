/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.daoLoaiSanPham;
import DAO.daoSanPham;
import DAO.daoXuatKho;
import DTO.SanPham;
import DTO.XuatKho;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xoan Tran
 */
public class fXuat_Kho extends javax.swing.JFrame {

    /**
     * Creates new form fXuat_Kho
     */
    private static fXuat_Kho XuatKho;
    public int id_nv;
    public fXuat_Kho() {
        initComponents();
        build();
    }
    public static fXuat_Kho getXuatKho()
    {
        return XuatKho;
    }
    public fXuat_Kho(int id_nv)
    {
        this.id_nv=id_nv;
        initComponents();
        build();
    }
    public fXuat_Kho(int id_nv, int Flag)
    {
        XuatKho=new fXuat_Kho(id_nv);
        XuatKho.setVisible(true);
    }
    public void refreshMethod()
    {
        invalidate();
        validate();
        repaint();
        listDanhSachXuatKho();
        System.out.println("reload");
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
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableXuatKho = new javax.swing.JTable();
        jButtonTaoMoi = new javax.swing.JButton();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xuất kho");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phần mềm quản lý kho");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("siêu thị S.O.S");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableXuatKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Thời gian xuất", "Tên sản phẩm", "Loại sản phẩm", "Số lượng", "Nhân viên phụ trách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableXuatKho.setRowHeight(30);
        jTableXuatKho.setAutoCreateRowSorter(true);
        jTableXuatKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableXuatKhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableXuatKho);
        jTableXuatKho.setAutoCreateRowSorter(true);
        if (jTableXuatKho.getColumnModel().getColumnCount() > 0) {
            jTableXuatKho.getColumnModel().getColumn(0).setMinWidth(30);
            jTableXuatKho.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableXuatKho.getColumnModel().getColumn(0).setMaxWidth(30);
            jTableXuatKho.getColumnModel().getColumn(1).setMinWidth(150);
            jTableXuatKho.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableXuatKho.getColumnModel().getColumn(1).setMaxWidth(150);
            jTableXuatKho.getColumnModel().getColumn(3).setMinWidth(100);
            jTableXuatKho.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableXuatKho.getColumnModel().getColumn(3).setMaxWidth(100);
            jTableXuatKho.getColumnModel().getColumn(4).setMinWidth(70);
            jTableXuatKho.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTableXuatKho.getColumnModel().getColumn(4).setMaxWidth(70);
            jTableXuatKho.getColumnModel().getColumn(5).setMinWidth(100);
            jTableXuatKho.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTableXuatKho.getColumnModel().getColumn(5).setMaxWidth(100);
        }
        jTableXuatKho.setRowHeight(30);

        jButtonTaoMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImageIcon imgTaoMoi = new ImageIcon(getClass().getResource("/icon/icons8-plus-48.png"));
        ImageIcon ImgTaoMoi = new ImageIcon(imgTaoMoi.getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH));
        jButtonTaoMoi.setIcon(ImgTaoMoi);
        jButtonTaoMoi.setText("Tạo mới");
        jButtonTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaoMoiActionPerformed(evt);
            }
        });

        jTextFieldTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DANH SÁCH PHIẾU XUẤT KHO");

        ImageIcon img = new ImageIcon(getClass().getResource("/icon/icons8-search.png"));
        ImageIcon Img = new ImageIcon(img.getImage().getScaledInstance(19, 19, Image.SCALE_SMOOTH));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(Img);
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonTaoMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTaoMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaoMoiActionPerformed
        JFrame XuatKho = new fCreate_PhieuXuat_sub(id_nv);
        XuatKho.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTaoMoiActionPerformed

    private void jTextFieldTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemKeyReleased
        if("".equals(jTextFieldTimKiem.getText()))
        {
            listDanhSachXuatKho();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimKiemKeyReleased

    private void jTableXuatKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableXuatKhoMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                    evt.consume();
                    int selectedRowIndex = jTableXuatKho.getSelectedRow();
                    int id = jTableXuatKho.getValueAt(selectedRowIndex, 0).hashCode();
                    JFrame Xem = new fPrintPhieuXuat(id_nv,id);
                    Xem.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableXuatKhoMouseClicked

    private void jTextFieldTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            FindList();
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimKiemKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FindList();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    public void build()
    {
            listDanhSachXuatKho();

    }
    public void listDanhSachXuatKho()
    {
         DefaultTableModel model = (DefaultTableModel) jTableXuatKho.getModel();
        while (jTableXuatKho.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<XuatKho> arr = daoXuatKho.getInstance().getListXuatKho();
        arr.stream().forEach((item) -> {
            int id_sp=DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(item.id_lo).id_sp;
            String tensp=DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
            String loaisp=DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
            String tennv=DAO.daoTaiKhoan.getInstance().getNhanVien(item.id_nv).ten_nv;
            model.addRow(new Object[]{item.id_xuat_kho,item.thoi_gian_xuat,tensp,loaisp,item.sl_sp,tennv});
        });
    }
    public void FindList()
    {
        String [][] Data;
        //System.out.println("Giai doan 1");
        Data=DAO.daoXuatKho.getInstance().FindListXuatKho(jTextFieldTimKiem.getText());
        // System.out.println("Giai doan 2");
        DefaultTableModel model = (DefaultTableModel) jTableXuatKho.getModel();
        while (jTableXuatKho.getRowCount() > 0) {
            model.removeRow(0);
        }
        int i=0;
        while(Data[i][0]!=null)
        {
             //System.out.println("Giai doan 3");
            model.addRow(new Object[]{
            Data[i][0],
            Data[i][1],
            Data[i][2],
            Data[i][3],
            Data[i][4],
            Data[i][5]});
            i++;
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
            java.util.logging.Logger.getLogger(fXuat_Kho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fXuat_Kho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fXuat_Kho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fXuat_Kho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fXuat_Kho(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonTaoMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableXuatKho;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
