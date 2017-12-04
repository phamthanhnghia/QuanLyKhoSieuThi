/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.*;
import DTO.*;
import java.awt.Image;
import java.util.ArrayList;
import java.lang.*;

import javax.swing.ImageIcon;

import javax.swing.table.DefaultTableModel;


public class fSanPham extends javax.swing.JFrame {
   
    public int id_nv;
    
    public fSanPham() {
        initComponents();
        LoadThongTinSanPham();
        //showComboboxLoaiSanPham();
    }
    public fSanPham(int idnv) { 
        initComponents();
        LoadThongTinSanPham();
        //showComboboxLoaiSanPham();
        this.id_nv = idnv;
    }
    
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
//    public void showComboboxLoaiSanPham(){
//        jComboBoxLoaiSanPhamTK.removeAllItems();
//        jComboBoxLoaiSanPhamTK.addItem("Tất cả");
//        ArrayList<LoaiSanPham> arr = daoLoaiSanPham.getInstance().getListLoaiSanPham();
//        for(int i=0;i< arr.size();i++){
//            jComboBoxLoaiSanPhamTK.addItem(arr.get(i).ten_loai_sp);
//        }
//    }

    public void listDanhSachSanPhamTheoLoai(String ten_loai_sp){
  
        if ("Tất cả".equals(ten_loai_sp)){
            listDanhSachSanPham();
            //System.out.println("Tat ca");
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel) jTableThongTinSanPham.getModel();
            while (jTableThongTinSanPham.getRowCount() > 0) {
                model.removeRow(0);
            }
            //int id_loai = daoLoaiSanPham.getInstance().getIDLoaiSanPham(ten_loai_sp).id_loai_sp;
            ArrayList<SanPham> arr = daoSanPham.getInstance().getListSanPham();
            for(int i = 0 ;i<arr.size();i++)
            {
                if(arr.get(i).id_loai_sp == daoLoaiSanPham.getInstance().getIDLoaiSanPham(ten_loai_sp).id_loai_sp){
                    String Loai_sp = daoLoaiSanPham.getInstance().getLoaiSanPham(arr.get(i).id_loai_sp).ten_loai_sp;
                    model.addRow(new Object[]{arr.get(i).id_sp,arr.get(i).ten_sp,Loai_sp});
                
                }
            }
            //System.out.println("Khac");
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
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThongTinSanPham = new javax.swing.JTable();
        jLabelLoadhinhAnh = new javax.swing.JLabel();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jButtonThemSanPham = new javax.swing.JButton();
        jButtonSuaSanPham = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelThongTinSanPham = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelLoaiSanPham = new javax.swing.JLabel();
        jLabelLoadLoaiSanPham = new javax.swing.JLabel();
        jLabelLoadTenSanPham = new javax.swing.JLabel();
        jLabelTenSanPham = new javax.swing.JLabel();
        jLabelIdSanpham = new javax.swing.JLabel();
        jLabelLoadIDSanPham = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh Sách Thông Tin Sản Phẩm");
        setResizable(false);

        jTableThongTinSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
            jTableThongTinSanPham.getColumnModel().getColumn(0).setMinWidth(50);
            jTableThongTinSanPham.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableThongTinSanPham.getColumnModel().getColumn(0).setMaxWidth(50);
        }
        jTableThongTinSanPham.setRowHeight(30);
        jTableThongTinSanPham.setAutoCreateRowSorter(true);

        jLabelLoadhinhAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLoadhinhAnh.setText("hinh");

        jTextFieldTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemKeyReleased(evt);
            }
        });

        jButtonTimKiem.setText("Tìm Kiếm");
        jButtonTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTimKiemMouseClicked(evt);
            }
        });

        jButtonThemSanPham.setText("Thêm Sản Phẩm");
        jButtonThemSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonThemSanPhamMouseClicked(evt);
            }
        });

        jButtonSuaSanPham.setText("Sửa Sản Phẩm");
        jButtonSuaSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSuaSanPhamMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabelThongTinSanPham.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabelThongTinSanPham.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThongTinSanPham.setText("Thông Tin Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("siêu thị S.O.S");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phần mềm quản lý kho");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelThongTinSanPham)
                .addGap(313, 313, 313))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelThongTinSanPham)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabelLoaiSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLoaiSanPham.setText("Loại Sản Phẩm  :");

        jLabelLoadLoaiSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelLoadTenSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelTenSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTenSanPham.setText("Tên Sản Phẩm  :");

        jLabelIdSanpham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdSanpham.setText("      ID         :");

        jLabelLoadIDSanPham.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLoadLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelIdSanpham)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelTenSanPham)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelLoadTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLoadIDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLoadIDSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdSanpham))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLoadTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTenSanPham))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLoaiSanPham)
                    .addComponent(jLabelLoadLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabelIdSanpham.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelLoadhinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                                        .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButtonTimKiem))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jButtonSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLoadhinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTimKiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonThemSanPham)
                    .addComponent(jButtonSuaSanPham))
                .addGap(13, 13, 13))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Methods
    
    





    
    //Events
    private void jTableThongTinSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableThongTinSanPhamMouseClicked
       DefaultTableModel model = (DefaultTableModel) jTableThongTinSanPham.getModel();
       int row = jTableThongTinSanPham.getSelectedRow();
       jLabelLoadIDSanPham.setText(model.getValueAt(row,0).toString());
       jLabelLoadTenSanPham.setText(model.getValueAt(row, 1).toString());
       jLabelLoadLoaiSanPham.setText(model.getValueAt(row, 2).toString());
       //ArrayList<SanPham> arr = daoSanPham.getInstance().getListSanPhamTheoID(jLabelLoadIDSanPham.getText().toString());        
       int id = Integer.parseInt(model.getValueAt(row,0).toString());
       SanPham sp = daoSanPham.getInstance().getSanPham(id);
       ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(sp.hinh_anh).getImage().getScaledInstance(
                        jLabelLoadhinhAnh.getWidth(), jLabelLoadhinhAnh.getHeight(), Image.SCALE_DEFAULT));
        jLabelLoadhinhAnh.setText("");
        jLabelLoadhinhAnh.setIcon(imageIcon);
    }//GEN-LAST:event_jTableThongTinSanPhamMouseClicked

    private void jButtonThemSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonThemSanPhamMouseClicked
        fThemSanPham TSP = new fThemSanPham();
        TSP.setVisible(true);
        
       
    }//GEN-LAST:event_jButtonThemSanPhamMouseClicked

    private void jButtonSuaSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSuaSanPhamMouseClicked
        fSuaThongTinSanPham STT = new fSuaThongTinSanPham();
        STT.setVisible(true);
    }//GEN-LAST:event_jButtonSuaSanPhamMouseClicked

    private void jButtonTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTimKiemMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTableThongTinSanPham.getModel();
        while (jTableThongTinSanPham.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        String timkiem = jTextFieldTimKiem.getText().toString();
        ArrayList<SanPham> arr = daoSanPham.getInstance().FindListSanPham(timkiem);
         for(int i = 0 ;i<arr.size();i++)
         {
            String Loai_sp = daoLoaiSanPham.getInstance().getLoaiSanPham(arr.get(i).id_loai_sp).ten_loai_sp;
            model.addRow(new Object[]{arr.get(i).id_sp,arr.get(i).ten_sp,Loai_sp});
         }
    }//GEN-LAST:event_jButtonTimKiemMouseClicked

    private void jTextFieldTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTableThongTinSanPham.getModel();
        while (jTableThongTinSanPham.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        String timkiem = jTextFieldTimKiem.getText().toString();
        ArrayList<SanPham> arr = daoSanPham.getInstance().FindListSanPham(timkiem);
         for(int i = 0 ;i<arr.size();i++)
         {
            String Loai_sp = daoLoaiSanPham.getInstance().getLoaiSanPham(arr.get(i).id_loai_sp).ten_loai_sp;
            model.addRow(new Object[]{arr.get(i).id_sp,arr.get(i).ten_sp,Loai_sp});
         }
    }//GEN-LAST:event_jTextFieldTimKiemKeyReleased
    
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
                new fSanPham(1).setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSuaSanPham;
    private javax.swing.JButton jButtonThemSanPham;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelIdSanpham;
    private javax.swing.JLabel jLabelLoadIDSanPham;
    private javax.swing.JLabel jLabelLoadLoaiSanPham;
    private javax.swing.JLabel jLabelLoadTenSanPham;
    private javax.swing.JLabel jLabelLoadhinhAnh;
    private javax.swing.JLabel jLabelLoaiSanPham;
    private javax.swing.JLabel jLabelTenSanPham;
    private javax.swing.JLabel jLabelThongTinSanPham;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThongTinSanPham;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
