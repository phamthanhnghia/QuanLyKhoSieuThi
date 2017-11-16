/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinh Tien
 */
public class daoXuatKho {
    private static daoXuatKho instance;

    public static daoXuatKho getInstance() {
        if(instance==null)instance=new daoXuatKho();
        return instance;
    }

    public daoXuatKho() {
    }
    public boolean KiemTraXuatKho(String id_lo, String slton, String slxuat, String ngay,int id_nv)
    {
        if(slton==null)
        {
            JOptionPane.showMessageDialog(null,
            "Chưa chọn sản phẩm",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int sl = Integer.parseInt(slton);
        int slx = Integer.parseInt(slxuat);
        if(slx >= 0 || slx > sl) 
        {
            JOptionPane.showMessageDialog(null,
            "Số lượng xuất không hợp lệ",
            "Lỗi",
            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        ngay = DAO.DateTimeNow.getIntance().Now;
        String query = "INSERT INTO `phieu_xuat_kho`(`sl_san_pham`, `thoi_gian_xuat`, `id_lo_sp`, `id_nv`) VALUES ("+slxuat+",'"+ngay+"',"+id_lo+","+id_nv+")";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        JOptionPane.showMessageDialog(null,
            "Sửa mật khẩu thành công",
            "Thông báo",
            JOptionPane.OK_OPTION);

        return true;
    }
}
