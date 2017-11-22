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
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Xoan Tran
 */
public class fNhacungcap extends javax.swing.JFrame {

    /**
     * Creates new form fNhacungcap
     */
    private static fNhacungcap ncc;
    public int id_nv;
    public static fNhacungcap getNhaCungCap()
    {
        return ncc;
    }
    public fNhacungcap() {
        initComponents();
        build();
    }
    public fNhacungcap(int id)
    {
        id_nv=id;
        initComponents();
        build();
    }
    public void refreshMethod()
    {
        invalidate();
        validate();
        repaint();
        listDanhSachNhaCungCap();
        System.out.println("reload");
    }
    public fNhacungcap(int IdNhanVien, int Flag)
    {
        ncc = new fNhacungcap(IdNhanVien);
        ncc.setVisible(true);
    }
     public void listDanhSachNhaCungCap(){
        DefaultTableModel model = (DefaultTableModel) jTableNguonCungCap.getModel();
        while (jTableNguonCungCap.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<NguonCungCap> arr = daoNguonCungCap.getInstance().getListNguonCungCap();
        arr.stream().forEach((item) -> {
            ImageIcon icon = new ImageIcon(item.hinh_anh);
            model.addRow(new Object[]{item.id_nguon_cc,item.ten_nha_cc,item.dia_chi, item.sdt, item.email,item.ten_dai_dien});
        });
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
        ArrayList<NguonCungCap> arr = daoNguonCungCap.getInstance().getListNguonCungCap();
        String[] columnName = {"STT", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email", "Người đại diện"};
        Object[][] rows = new Object[arr.size()][7];
        for(int i = 0; i < arr.size(); i++){
            rows[i][0] = arr.get(i).id_nguon_cc;
            rows[i][1] = arr.get(i).ten_nha_cc;
            rows[i][2] = arr.get(i).dia_chi;
            rows[i][3] = arr.get(i).sdt;
            rows[i][4] = arr.get(i).email;
            rows[i][5] = arr.get(i).ten_dai_dien;
            /*
            if(arr.get(i).hinh_anh != null){
                ImageIcon image = new ImageIcon(new ImageIcon(arr.get(i).hinh_anh).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH) );
                //ImageIcon image = new ImageIcon(arr.get(i).hinh_anh);
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
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();

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

        jPanel13.setBackground(new java.awt.Color(245, 245, 245));
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
        jButtonThem.setLabel("Thêm nhà cung cấp");
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

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fSearch1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 857, Short.MAX_VALUE)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1302, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonThem.getAccessibleContext().setAccessibleParent(jTableNguonCungCap);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) jTableNguonCungCap.getModel();
        while (jTableNguonCungCap.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<NguonCungCap> arr = daoNguonCungCap.getInstance().FindListNguonCungCap(jTextFieldSearch.getText());
        arr.stream().forEach((item) -> {
            ImageIcon icon = new ImageIcon(item.hinh_anh);
            model.addRow(new Object[]{item.id_nguon_cc,item.ten_nha_cc,item.dia_chi,item.sdt,item.email,item.ten_dai_dien});
        });
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void btnThemnhacungcap(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemnhacungcap
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemnhacungcap

    private void jTableNguonCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNguonCungCapMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                    evt.consume();
                    int selectedRowIndex = jTableNguonCungCap.getSelectedRow();
                    int id = jTableNguonCungCap.getValueAt(selectedRowIndex, 0).hashCode();
                    JFrame Xem = new fViewNhaCungCap(id_nv,id);
                    Xem.setVisible(true);
                    //System.out.print("Nhap dup chuot");
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableNguonCungCapMouseClicked

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
                fNhacungcap fNhacungcap = new fNhacungcap(1,1);
            }
        });
    }
    public void build ()
    {
        listDanhSachNguonCungCap();
    }
    public void listDanhSachNguonCungCap()
    {
        DefaultTableModel model = (DefaultTableModel) jTableNguonCungCap.getModel();
        while (jTableNguonCungCap.getRowCount() > 0) {
            model.removeRow(0);
        }
        ArrayList<NguonCungCap> arr = daoNguonCungCap.getInstance().getListNguonCungCap();
        arr.stream().forEach((item) -> {
            ImageIcon icon = new ImageIcon(item.hinh_anh);
            model.addRow(new Object[]{item.id_nguon_cc,item.ten_nha_cc,item.dia_chi,item.sdt,item.email,item.ten_dai_dien});
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTableNguonCungCap;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
