/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GROUP;
import java.lang.*;

/**
 *
 * @author Dinh Tien
 */
public class ThongTinXuat {
    public int id_xuat_kho;
    public String thoi_gian_xuat;
    public String ten_san_pham;
    public String loai_san_pham;
    public int sl_san_pham;
    public String ten_nv;
    
    public ThongTinXuat(){}
    public ThongTinXuat(int id_xuat_kho, String thoi_gian_xuat, String ten_san_pham, String loai_san_pham,int sl_san_pham, String ten_nv){
        this.id_xuat_kho=id_xuat_kho;
        this.loai_san_pham=loai_san_pham;
        this.sl_san_pham=sl_san_pham;
        this.ten_nv=ten_nv;
        this.ten_san_pham=ten_san_pham;
        this.thoi_gian_xuat=thoi_gian_xuat;
    }
    
}
