/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.busKiemKe;
import DAO.DateTimeNow;
import DAO.daoKho;
import DAO.daoKiemKe;
import DAO.daoLoaiSanPham;
import DAO.daoPhieuKiemKeKho;
import DAO.daoSanPham;
import DAO.daoXuatKho;
import DTO.LoaiSanPham;
import DTO.NhanVien;
import DTO.PhieuKiemKeKho;
import DTO.SanPham;
import DTO.TaiKhoan;
import GROUP.ThongTinKhoHienTai;
import GROUP.ThongTinKiemKe;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.lang.*;

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
//<<<<<<< HEAD
//        DanhSach = daoKho.getInstance().getListThongTinKhoHienTai();
//        DuLieuMau = DanhSach;
//=======
        DanhSach = busKiemKe.getInstance().DanhSachThongTinKhoHienTai();
        DuLieuMau = DanhSach ; 

        initComponents();
        setIcon();
        build();
    }


//    public fKiemKe(int id_nv) {
//        this.id_nv = id_nv;
//        DanhSach = daoKho.getInstance().getListThongTinKhoHienTai();
//        DuLieuMau = DanhSach;
//    }

    public fKiemKe(int id_nv)
    {
        this.id_nv=id_nv;
        DanhSach = busKiemKe.getInstance().DanhSachThongTinKhoHienTai();
        DuLieuMau = DanhSach ; 
        initComponents();
        setIcon();
        build();
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/Logo2.png")));
    }

    public void build() {
        showComboboxLoaiSanPham();
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
//<<<<<<< HEAD
//        NhanVienDangNhap();
//
//=======
        NhanVienDangNhap();       

    }

    public void showComboboxLoaiSanPham() {
        jComboBoxLoaiSP.removeAllItems();
        ArrayList<LoaiSanPham> arr = daoLoaiSanPham.getInstance().getListLoaiSanPham();
        jComboBoxLoaiSP.addItem("Tất cả");
        for (int i = 0; i < arr.size(); i++) {
            jComboBoxLoaiSP.addItem(arr.get(i).ten_loai_sp);
        }
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

    public void listDanhSachKhoHienTai(ArrayList<ThongTinKhoHienTai> arr) {
        DefaultTableModel model = (DefaultTableModel) jTableKhoHienTai.getModel();
        while (jTableKhoHienTai.getRowCount() > 0) {
            model.removeRow(0);
        }

        arr.stream().forEach((item) -> {
            PhieuKiemKeKho phieu = daoPhieuKiemKeKho.getInstance().getPhieuKiemKeKho(item.id_kho);
            //int _tongsp = item.so_luong_lo * item.sl_san_pham;
            if (phieu == null) {
                model.addRow(new Object[]{item.id_kho, item.ten_sp, item.hsd, item.sl_san_pham, "", "","", "Đầy đủ"});
            }
            if(phieu!=null && item.so_luong_lo==phieu.sl_hao_mon)
            {
                model.addRow(new Object[]{item.id_kho, item.ten_sp, item.hsd,item.sl_san_pham, phieu.sl_thuc_te , "",DateTimeNow.getIntance().FormatDateViewTable(phieu.thoi_gian), "Đầy đủ"});
            }
            if(phieu!=null && item.so_luong_lo!=phieu.sl_hao_mon) {
                model.addRow(new Object[]{item.id_kho, item.ten_sp, item.hsd, item.sl_san_pham ,phieu.sl_thuc_te, phieu.sl_hao_mon,DateTimeNow.getIntance().FormatDateViewTable(phieu.thoi_gian), "Hao hụt"});
            }
        });
    }

    public void FindList() {
        //String DuLieu = jTextFieldTimKiem.getText();
        this.DanhSach = DAO.daoKho.getInstance().FindListKhoHienTai(DuLieuMau, jTextFieldTimKiem.getText());
        if (DanhSach.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Không có dữ liệu kiểm kê kho",
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
        jSeparator2 = new javax.swing.JSeparator();
        jButtonLuu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Lo_ton = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSpinnerSLThucTe = new javax.swing.JSpinner();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldThoiGian = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxLoaiSP = new javax.swing.JComboBox<>();
        jButtonTaiLai = new javax.swing.JButton();
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Kho", "Tên Sản Phẩm", "HSD", "Lô Tồn", "Lô Kiểm kê", "SL Hao Mòn", "Ngày kiểm kê", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKhoHienTai.setRowHeight(30);
        jTableKhoHienTai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhoHienTaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKhoHienTai);
        if (jTableKhoHienTai.getColumnModel().getColumnCount() > 0) {
            jTableKhoHienTai.getColumnModel().getColumn(0).setMinWidth(60);
            jTableKhoHienTai.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableKhoHienTai.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableKhoHienTai.getColumnModel().getColumn(1).setMinWidth(350);
            jTableKhoHienTai.getColumnModel().getColumn(1).setPreferredWidth(350);
            jTableKhoHienTai.getColumnModel().getColumn(1).setMaxWidth(350);
            jTableKhoHienTai.getColumnModel().getColumn(2).setMinWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(2).setMaxWidth(80);
            jTableKhoHienTai.getColumnModel().getColumn(3).setMinWidth(70);
            jTableKhoHienTai.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTableKhoHienTai.getColumnModel().getColumn(3).setMaxWidth(70);
            jTableKhoHienTai.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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
        jLabelTrang.setForeground(new java.awt.Color(102, 102, 102));
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
        jLabelSoTrang.setForeground(new java.awt.Color(102, 102, 102));
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
        jTextFieldTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ID Kho :");

        jTextField_id_kho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_id_kho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField_id_kho.setEnabled(false);
        jTextField_id_kho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_khoActionPerformed(evt);
            }
        });

        jButtonLuu.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLuu.setText("Lưu");
        jButtonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("SL Lô :");

        jTextField_Lo_ton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Lo_ton.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Lo_ton.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextField_Lo_ton.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("SL Lô thực tế :");

        jSpinnerSLThucTe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Thời gian: ");

        jTextFieldThoiGian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldThoiGian.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldThoiGian.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldThoiGian.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Loại SP: ");

        jComboBoxLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxLoaiSPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBoxLoaiSPMousePressed(evt);
            }
        });
        jComboBoxLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLoaiSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Lo_ton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_id_kho, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerSLThucTe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxLoaiSP, jTextFieldThoiGian, jTextField_Lo_ton, jTextField_id_kho});

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
                    .addComponent(jLabel5)
                    .addComponent(jTextField_Lo_ton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinnerSLThucTe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLuu)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxLoaiSP, jTextFieldThoiGian});

        jButtonTaiLai.setText("Tải lại");
        jButtonTaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaiLaiActionPerformed(evt);
            }
        });

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
                                .addGap(33, 33, 33)
                                .addComponent(jButtonTaiLai)
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
                            .addComponent(jLabelKetQua)
                            .addComponent(jButtonTaiLai))
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
        //int sl_hao_mon = jSpinnerSLHaoMon.getValue().hashCode();
        int sl_kho = 0;
        sl_kho = Integer.parseInt(jTextField_Lo_ton.getText());
        int sl_thuc_te = jSpinnerSLThucTe.getValue().hashCode();
        

            if ( sl_thuc_te == 0) { // hao mon
                JOptionPane.showMessageDialog(rootPane,
                        "Số lượng thực tế không phù hợp.",
                        "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            if(sl_thuc_te <= sl_kho && sl_thuc_te > 0) { // hao mon
                String thoi_gian = DateTimeNow.getIntance().Now;
                int id_kho = Integer.parseInt(jTextField_id_kho.getText());
                //daoKho.getInstance().updateSoLuongKhotheo_ID_KHO(sl_thuc_te, id_kho);
                DanhSach = daoKho.getInstance().getListThongTinKhoHienTai();
                                    DuLieuMau = DanhSach;

                ArrayList<ThongTinKiemKe> arr = daoKiemKe.getInstance().getListThongTinKiemKe(id_kho);
                if(arr.isEmpty() == true){
                    daoPhieuKiemKeKho.getInstance().insertPhieuKiemKeKho(sl_kho-sl_thuc_te,sl_thuc_te, thoi_gian, id_kho, id_nv);
                    JOptionPane.showMessageDialog(rootPane,
                            "Lưu ID Kho " + id_kho + " thành công.",
                            "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE); 
                     
                }else{
                    int sl_thuc_te_truoc = arr.get(arr.size()-1).sl_thuc_te;
                    
                    if(sl_thuc_te > sl_thuc_te_truoc){
                        JOptionPane.showMessageDialog(rootPane,
                        "Số lượng thực tế không phù hợp.",
                        "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(sl_thuc_te < sl_thuc_te_truoc){
                         daoPhieuKiemKeKho.getInstance().insertPhieuKiemKeKho(sl_thuc_te_truoc-sl_thuc_te,sl_thuc_te, thoi_gian, id_kho, id_nv);
                         JOptionPane.showMessageDialog(rootPane,
                            "Lưu ID Kho " + id_kho + " thành công.",
                            "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE); 
                    }

                }
                ArrayList<ThongTinKhoHienTai> table = DAO.daoKho.getInstance().get20KhoHienTai(DanhSach, 1);
                    listDanhSachKhoHienTai(table);
                
                
                     
            }
    }//GEN-LAST:event_jButtonLuuActionPerformed

    private void jTableKhoHienTaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKhoHienTaiMouseClicked
            
        int selectedRowIndex = jTableKhoHienTai.getSelectedRow();
        int id_kho = jTableKhoHienTai.getValueAt(selectedRowIndex, 0).hashCode();
        int lo_ton = jTableKhoHienTai.getValueAt(selectedRowIndex, 3).hashCode();
        jTextField_id_kho.setText(id_kho + "");
        jTextField_Lo_ton.setText(lo_ton + "");
        jTextFieldThoiGian.setText(DAO.DateTimeNow.getIntance().DateView);
        
//        if (evt.getClickCount() == 1 && !evt.isConsumed()) {
//            evt.consume();
//            
//            //System.out.print(id_kho);
//        }
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            //evt.consume();
            
            JFrame Xem = new fChiTietKiemKe(id_kho);
            Xem.setVisible(true);
            //System.out.print("Nhap dup chuot");
        }
    }//GEN-LAST:event_jTableKhoHienTaiMouseClicked

    private void jButtonTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaiLaiActionPerformed
        DuLieuMau = daoKho.getInstance().getListThongTinKhoHienTai();
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
    }//GEN-LAST:event_jButtonTaiLaiActionPerformed

    private void jTextField_id_khoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_khoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_khoActionPerformed

    private void jTextFieldTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimKiemKeyReleased

    private void jTextFieldTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DanhSach = DuLieuMau;
            FindList();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTimKiemKeyPressed

    private void jComboBoxLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLoaiSPActionPerformed
        if (jComboBoxLoaiSP.getSelectedItem().toString() != null) {
            String tenloai = jComboBoxLoaiSP.getSelectedItem().toString();
            if ("Tất cả".equals(tenloai)) {
                DuLieuMau = DAO.daoKho.getInstance().getListThongTinKhoHienTai();
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
            } else {
                LoaiSanPham lsp = DAO.daoLoaiSanPham.getInstance().getIDLoaiSanPham(tenloai);
                DuLieuMau = DAO.daoKho.getInstance().getListThongTinKhoHienTaiTheoLoai(lsp.id_loai_sp);
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
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLoaiSPActionPerformed

    private void jComboBoxLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxLoaiSPMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLoaiSPMouseClicked

    private void jComboBoxLoaiSPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxLoaiSPMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLoaiSPMousePressed

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
    private javax.swing.JButton jButtonTaiLai;
    private javax.swing.JComboBox<String> jComboBoxLoaiSP;
    private javax.swing.JComboBox<String> jComboBoxNhanVien2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinnerSLThucTe;
    private javax.swing.JTable jTableKhoHienTai;
    private javax.swing.JTextField jTextFieldThoiGian;
    private javax.swing.JTextField jTextFieldTimKiem;
    private javax.swing.JTextField jTextField_Lo_ton;
    private javax.swing.JTextField jTextField_id_kho;
    // End of variables declaration//GEN-END:variables
}
