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
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Hashtable;
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
}
