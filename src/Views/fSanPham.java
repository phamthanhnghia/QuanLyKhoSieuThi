/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.*;
import DTO.*;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import javax.swing.table.DefaultTableModel;


public class fSanPham extends javax.swing.JFrame {
   
    
    public fSanPham() {
        initComponents();
        LoadThongTinSanPham();
        showComboboxLoaiSanPham();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThongTinSanPham = new javax.swing.JTable();
        jLabelIdSanpham = new javax.swing.JLabel();
        jLabelTenSanPham = new javax.swing.JLabel();
        jLabelLoaiSanPham = new javax.swing.JLabel();
        jLabelHinhAnh = new javax.swing.JLabel();
        jLabelLoadIDSanPham = new javax.swing.JLabel();
        jLabelLoadTenSanPham = new javax.swing.JLabel();
        jLabelLoadLoaiSanPham = new javax.swing.JLabel();
        jLabelLoadhinhAnh = new javax.swing.JLabel();
        jLabelThongTinSanPham = new javax.swing.JLabel();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jButtonThemSanPham = new javax.swing.JButton();
        jButtonSuaSanPham = new javax.swing.JButton();
        jLabelLoaiSanPhamTK = new javax.swing.JLabel();
        jComboBoxLoaiSanPhamTK = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableThongTinSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID ", "Tên Sản Phẩm", "Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableThongTinSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableThongTinSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableThongTinSanPham);
        if (jTableThongTinSanPham.getColumnModel().getColumnCount() > 0) {
            jTableThongTinSanPham.getColumnModel().getColumn(0).setPreferredWidth(-200);
        }

        jLabelIdSanpham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdSanpham.setText("ID       :");

        jLabelTenSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTenSanPham.setText("Tên Sản Phẩm  :");

        jLabelLoaiSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLoaiSanPham.setText("Loại Sản Phẩm :");

        jLabelHinhAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHinhAnh.setText("Hình Ảnh :");

        jLabelLoadIDSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelLoadTenSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelLoadLoaiSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelLoadhinhAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelThongTinSanPham.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelThongTinSanPham.setText("Thông Tin Sản Phẩm");

        jButtonTimKiem.setText("Tìm Kiếm");

        jButtonThemSanPham.setText("Thêm Sản Phẩm");
        jButtonThemSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonThemSanPhamMouseClicked(evt);
            }
        });

        jButtonSuaSanPham.setText("Sửa Sản Phẩm");

        jLabelLoaiSanPhamTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLoaiSanPhamTK.setText("Loại Sản Phẩm :");

        jComboBoxLoaiSanPhamTK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxLoaiSanPhamTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLoaiSanPhamTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButtonSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLoaiSanPhamTK)
                        .addGap(42, 42, 42)
                        .addComponent(jComboBoxLoaiSanPhamTK, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonTimKiem)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTenSanPham)
                            .addComponent(jLabelIdSanpham))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelHinhAnh)
                                .addGap(78, 78, 78)
                                .addComponent(jLabelLoadhinhAnh)
                                .addGap(290, 290, 290))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                                        .addComponent(jLabelThongTinSanPham))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelLoadTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelLoadIDSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelLoaiSanPham)))
                                .addGap(88, 88, 88)
                                .addComponent(jLabelLoadLoaiSanPham)
                                .addGap(265, 265, 265))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabelThongTinSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLoadIDSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLoadLoaiSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelIdSanpham)
                        .addComponent(jLabelLoaiSanPham)))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLoadTenSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLoadhinhAnh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTenSanPham)
                        .addComponent(jLabelHinhAnh)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTimKiem)
                    .addComponent(jLabelLoaiSanPhamTK)
                    .addComponent(jComboBoxLoaiSanPhamTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonThemSanPham)
                    .addComponent(jButtonSuaSanPham))
                .addGap(8, 8, 8))
        );

        jLabelIdSanpham.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Methods
    
    public void LoadThongTinSanPham()
    {
        
        DefaultTableModel model = (DefaultTableModel) jTableThongTinSanPham.getModel();
        while (jTableThongTinSanPham.getRowCount() > 0)
        {
            model.removeRow(0);
        }
         ArrayList<SanPham> arr = daoSanPham.getInstance().getListSanPham();
         for(int i = 0 ;i<arr.size();i++)
         {
            String Loai_sp = daoLoaiSanPham.getInstance().getLoaiSanPham(arr.get(i).id_loai_sp).ten_loai_sp;
            model.addRow(new Object[]{arr.get(i).id_sp,arr.get(i).ten_sp,Loai_sp});
         }
        
    }
    public void showComboboxLoaiSanPham(){
        jComboBoxLoaiSanPhamTK.removeAllItems();
        jComboBoxLoaiSanPhamTK.addItem("Tất cả");
        ArrayList<LoaiSanPham> arr = daoLoaiSanPham.getInstance().getListLoaiSanPham();
        for(int i=0;i< arr.size();i++){
            jComboBoxLoaiSanPhamTK.addItem(arr.get(i).ten_loai_sp);
        }
    }

    public void listDanhSachSanPhamTheoLoai(String ten_loai_sp){
        if ("Tất cả".equals(ten_loai_sp))
            listDanhSachSanPham();
        else
        {
        DefaultTableModel model = (DefaultTableModel) jTableThongTinSanPham.getModel();
        while (jTableThongTinSanPham.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<SanPham> arr = daoSanPham.getInstance().getListSanPham();
         for(int i = 0 ;i<arr.size();i++)
         {
            String Loai_sp = daoLoaiSanPham.getInstance().getLoaiSanPham(arr.get(i).id_loai_sp).ten_loai_sp;
            model.addRow(new Object[]{arr.get(i).id_sp,arr.get(i).ten_sp,Loai_sp});
         }
        }
    }
    public void listDanhSachSanPham(){
        DefaultTableModel model = (DefaultTableModel) jTableThongTinSanPham.getModel();
        while (jTableThongTinSanPham.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<SanPham> arr = daoSanPham.getInstance().getListSanPham();
         for(int i = 0 ;i<arr.size();i++)
         {
            String Loai_sp = daoLoaiSanPham.getInstance().getLoaiSanPham(arr.get(i).id_loai_sp).ten_loai_sp;
            model.addRow(new Object[]{arr.get(i).id_sp,arr.get(i).ten_sp,Loai_sp});
         }
    }





    
    //Events
    private void jTableThongTinSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableThongTinSanPhamMouseClicked
       DefaultTableModel model = (DefaultTableModel) jTableThongTinSanPham.getModel();
       int row = jTableThongTinSanPham.getSelectedRow();
       jLabelLoadIDSanPham.setText(model.getValueAt(row,0).toString());
       jLabelLoadTenSanPham.setText(model.getValueAt(row, 1).toString());
       jLabelLoadLoaiSanPham.setText(model.getValueAt(row, 2).toString());
       ArrayList<SanPham> arr = daoSanPham.getInstance().getListSanPhamTheoID(jLabelLoadIDSanPham.getText().toString());        
        
    }//GEN-LAST:event_jTableThongTinSanPhamMouseClicked

    private void jComboBoxLoaiSanPhamTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLoaiSanPhamTKActionPerformed
        String tenloai = String.valueOf(jComboBoxLoaiSanPhamTK.getSelectedItem());
        if (!"null".equals(tenloai) && !"".equals(tenloai))
        {
            listDanhSachSanPhamTheoLoai(tenloai);
        }
    }//GEN-LAST:event_jComboBoxLoaiSanPhamTKActionPerformed

    private void jButtonThemSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonThemSanPhamMouseClicked
        fThemSanPham TSP = new fThemSanPham();
        this.setVisible(false);
        TSP.setVisible(true);
        
       
    }//GEN-LAST:event_jButtonThemSanPhamMouseClicked
    
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
            java.util.logging.Logger.getLogger(fSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fSanPham().setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSuaSanPham;
    private javax.swing.JButton jButtonThemSanPham;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JComboBox<String> jComboBoxLoaiSanPhamTK;
    private javax.swing.JLabel jLabelHinhAnh;
    private javax.swing.JLabel jLabelIdSanpham;
    private javax.swing.JLabel jLabelLoadIDSanPham;
    private javax.swing.JLabel jLabelLoadLoaiSanPham;
    private javax.swing.JLabel jLabelLoadTenSanPham;
    private javax.swing.JLabel jLabelLoadhinhAnh;
    private javax.swing.JLabel jLabelLoaiSanPham;
    private javax.swing.JLabel jLabelLoaiSanPhamTK;
    private javax.swing.JLabel jLabelTenSanPham;
    private javax.swing.JLabel jLabelThongTinSanPham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThongTinSanPham;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
