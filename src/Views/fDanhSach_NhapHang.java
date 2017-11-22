package Views;


import DAO.NhapKho;
import DAO.daoXuatKho;
import DTO.ThongTinNhap;
import DTO.XuatKho;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class fDanhSach_NhapHang extends javax.swing.JFrame {

    /**
     * Creates new form fDanhSach_NhapHang
     */
    public int id_nv;
    public ArrayList<ThongTinNhap> arr;
    public fDanhSach_NhapHang(int id_nv) {
        initComponents();
        this.id_nv = id_nv;
        build();
    }

    private fDanhSach_NhapHang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNhapKho = new javax.swing.JTable();
        jButtonTaoMoi = new javax.swing.JButton();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jButtonIn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh Sách Nhập Hàng");
        setResizable(false);

        jTableNhapKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Thời gian nhập", "Giá lô", "Giá sản phẩm", "Nhân viên phụ trách"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableNhapKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNhapKhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNhapKho);
        jTableNhapKho.setRowHeight(30);
        if (jTableNhapKho.getColumnModel().getColumnCount() > 0) {
            jTableNhapKho.getColumnModel().getColumn(0).setMinWidth(200);
            jTableNhapKho.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTableNhapKho.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        jButtonTaoMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTaoMoi.setText("Tạo mới");
        jButtonTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaoMoiActionPerformed(evt);
            }
        });

        jTextFieldTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemKeyReleased(evt);
            }
        });

        jButtonIn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonIn.setText("In");
        jButtonIn.setMaximumSize(new java.awt.Dimension(81, 25));
        jButtonIn.setMinimumSize(new java.awt.Dimension(81, 25));
        jButtonIn.setPreferredSize(new java.awt.Dimension(81, 25));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phần mềm quản lý kho");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("siêu thị S.O.S");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DANH SÁCH PHIẾU NHẬP KHO");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonTaoMoi)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTaoMoi)
                    .addComponent(jButtonIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaoMoiActionPerformed
        JFrame ChonSanPham = new fChonSanPham_NhapHang(id_nv);
        ChonSanPham.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTaoMoiActionPerformed

    private void jTextFieldTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemKeyReleased
//        String [][] Data;
//        //System.out.println("Giai doan 1");
//        Data=DAO.daoXuatKho.getInstance().FindListXuatKho(jTextFieldTimKiem.getText());
//        // System.out.println("Giai doan 2");
//        DefaultTableModel model = (DefaultTableModel) jTableXuatKho.getModel();
//        while (jTableXuatKho.getRowCount() > 0) {
//            model.removeRow(0);
//        }
//        int i=0;
//        while(Data[i][0]!=null)
//        {
//            //System.out.println("Giai doan 3");
//            model.addRow(new Object[]{
//                Data[i][0],
//                Data[i][1],
//                Data[i][2],
//                Data[i][3],
//                Data[i][4]});
//        i++;
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimKiemKeyReleased

    private void jTableNhapKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNhapKhoMouseClicked
       if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                    evt.consume();
                    int selectedRowIndex = jTableNhapKho.getSelectedRow();
                    String thoi_gian = jTableNhapKho.getValueAt(selectedRowIndex, 0).toString();
                    ThongTinNhap nhap = NhapKho.getInstance().getThongTinNhap(arr, thoi_gian);
                    JFrame Xem = new fViewThongTinNhap(nhap,1);
                    Xem.setVisible(false);
                    //dispose();
                    //System.out.print("Nhap dup chuot" + id);
            }
    }//GEN-LAST:event_jTableNhapKhoMouseClicked

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
            java.util.logging.Logger.getLogger(fDanhSach_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fDanhSach_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fDanhSach_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fDanhSach_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fDanhSach_NhapHang().setVisible(true);
            }
        });
    }
    public void build()
    {
            listDanhSachNhapKho();

    }
    public void listDanhSachNhapKho()
    {
         DefaultTableModel model = (DefaultTableModel) jTableNhapKho.getModel();
        while (jTableNhapKho.getRowCount() > 0) {
            model.removeRow(0);
        }
        arr = DAO.NhapKho.getInstance().getListDanhSachNhapKho();
        arr.stream().forEach((item) -> {
            
            model.addRow(new Object[]{item.thoi_gian,item.so_tien_lo,item.so_tien_sp,item.ten_nv});
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIn;
    private javax.swing.JButton jButtonTaoMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNhapKho;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
