/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

/**
 *
 * @author admin
 */
import DAO.daoBaoCao;
import DAO.daoKhuVuc;
import DAO.daoNguonCungCap;
import DAO.daoNhanVien;
import DTO.KhuVuc;
import DTO.NguonCungCap;
import DTO.NhanVien;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Admin
 */
public class busReport {

    
    private static String url = "jdbc:mysql://localhost:3306/QuanLyKhoSieuThi?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String pass = "root";
    
    private Connection conn = null;
    private static busReport intance;

    public static busReport getIntance() {
        if (intance == null) {
            intance = new busReport();
        }
        return intance;
    }
    public void rpKhuVuc() {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            Connection conn = DriverManager.getConnection(url, user, pass);
            try {
                String Rb = "src/Reports/KhuVuc.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, null, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void rpNhanVien() {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            Connection conn = DriverManager.getConnection(url, user, pass);
            try {
                String Rb = "src/Reports/NhanVien.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, null, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void rpNhaCungCap() {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            Connection conn = DriverManager.getConnection(url, user, pass);
            try {
                String Rb = "src/Reports/NhaCungCap.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, null, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void rpTatCaSanPham() {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            conn = DriverManager.getConnection(url, user, pass);
            try {
                String Rb = "src/Reports/TatCaSanPham.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, null, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void rpSanPhamTheoLoai(int id_loai) {
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
            DriverManager.registerDriver(driver);// dang ky driver         
            conn = DriverManager.getConnection(url, user, pass);
            try {
                Map hash = new HashMap();
                hash.put("id_loai", id_loai);
                String Rb = "src/Reports/SanPhamTheoLoai.jrxml";
                JasperReport JASP = JasperCompileManager.compileReport(Rb);
                JasperPrint PR = JasperFillManager.fillReport(JASP, hash, conn);
                JasperViewer.viewReport(PR, false);
            } catch (JRException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //
    
    public void rpTonKho(String ngaydau,String ngaycuoi) {
//        try {
//            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver
//            DriverManager.registerDriver(driver);// dang ky driver         
//            conn = DriverManager.getConnection(url, user, pass);
//            try {
//                //Map hash = new HashMap();
//                 Map<String, Object> hash = new HashMap<String, Object>();
//                hash.put("ngaydau", ngaydau);
//                hash.put("ngaycuoi", ngaycuoi);
//                String Rb = "src/Reports/TonKho.jrxml";
//                JasperReport JASP = JasperCompileManager.compileReport(Rb);
//                JasperPrint PR = JasperFillManager.fillReport(JASP, hash, conn);
//                JasperViewer.viewReport(PR, false);
//            } catch (JRException ex) {
//                System.out.println(ex);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(busReport.class.getName()).log(Level.SEVERE, null, ex);
//        }
        ArrayList<GROUP.BaoCaoExcel> arr = DAO.daoBaoCao.getInstance().listBaoCaoExcel(ngaydau, ngaycuoi);
        daoBaoCao.getInstance().ExcelBaoCao(arr);
    }
    public void excelNhanVien(){
        ArrayList<NhanVien> arr = daoNhanVien.getInstance().getListNhanVien();
        daoNhanVien.getInstance().ExcelNhanVien(arr);
    }
    public void excelKhuVuc(){
        ArrayList<KhuVuc> arr = daoKhuVuc.getInstance().getListKhuVuc();
        daoKhuVuc.getInstance().ExcelKhuVuc(arr);
    }
    public void excelNguonCungCap(){
        ArrayList<NguonCungCap> arr = daoNguonCungCap.getInstance().getListNguonCungCap();
        daoNguonCungCap.getInstance().ExcelNguonCungCap(arr);
    }
}
