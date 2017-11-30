/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ChiTietPhieuNhap;
import DTO.Kho;
import DTO.LoSanPham;
import GROUP.LoaiSanPham_jTreeChart;
import DTO.NguonCungCap;
import DTO.PhieuTraKho;
import GROUP.ThongTinKhoHienTai;
import GROUP.ThongTinTon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dinh Tien
 */
public class daoKho {
    private static daoKho instance;

    public static daoKho getInstance() {
        if(instance==null)instance=new daoKho();
        return instance;
    }
    public ArrayList<Kho> getListKho()
    {
        ArrayList<Kho> result = new ArrayList<>();
        String query="select * from Kho where sl_san_pham != 0";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new Kho(rs.getInt("id_kho"),rs.getInt("sl_san_pham"),rs.getInt("id_lo_sp"),rs.getInt("id_khu_vuc")));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    
    public ArrayList<ThongTinKhoHienTai> getListThongTinKhoHienTai()
    {
        ArrayList<ThongTinKhoHienTai> result = new ArrayList<>();
        String query="SELECT * FROM `kho`,`lo_san_pham`,`san_pham`,`chi_tiet_lo_sp` " +
                            "WHERE kho.id_lo_sp =lo_san_pham.id_lo_sp " +
                            "and lo_san_pham.id_lo_sp=chi_tiet_lo_sp.id_lo_sp" +
                            "and chi_tiet_lo_sp.id_sp=san_pham.id_sp ";
                    
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new ThongTinKhoHienTai(rs.getInt("kho.id_kho"),
                                        rs.getInt("kho.sl_san_pham"),
                                        rs.getString("san_pham.ten_sp"),
                                        rs.getInt("kho.id_lo_sp"),
                                        rs.getString("lo_san_pham.hsd"),
                                        rs.getString("lo_san_pham.nsx"),
                                        rs.getInt("ton_kho.sl_sp")
                                        ));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    
    public ArrayList<LoaiSanPham_jTreeChart> getListLoaiSanPham_jTreeChart()
    {
        ArrayList<LoaiSanPham_jTreeChart> result = new ArrayList<>();
        String query="SELECT loai_sp.ten_loai_sp , Sum((kho.sl_san_pham*chi_tiet_lo_sp.so_luong_sp)) AS so_luong FROM `kho`,`chi_tiet_lo_sp`,`san_pham`,`loai_sp`,`lo_san_pham` WHERE kho.id_lo_sp = lo_san_pham.id_lo_sp AND lo_san_pham.id_lo_sp = chi_tiet_lo_sp.id_lo_sp AND chi_tiet_lo_sp.id_sp = san_pham.id_sp AND san_pham.id_loai_sp =loai_sp.id_loai_sp GROUP BY loai_sp.ten_loai_sp ORDER BY so_luong DESC";
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result.add(new LoaiSanPham_jTreeChart(rs.getString("ten_loai_sp"),rs.getLong("so_luong")));
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        return result;
    }
    public boolean insertKho(int sl_sp, int id_lo, int id_khu_vuc) {
        String query = "INSERT INTO `kho`(`sl_san_pham`, `id_lo_sp`, `id_khu_vuc`) VALUES ('"+sl_sp+"','"+id_lo+"','"+id_khu_vuc+"')";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public boolean updateSoLuongKho(int sl_sp, int id_lo) {
        String query = "UPDATE `kho` SET `sl_san_pham`='"+sl_sp+"' WHERE `id_lo_sp`='"+id_lo+"'";
        ArrayList<Object> arr = new ArrayList<>();
        DataProvider.getIntance().open();
        int result = DataProvider.getIntance().excuteUpdate(query, arr);
        DataProvider.getIntance().close();
        return result > 0;
    }
    public Kho getLoKho(int id_lo)
    {
        Kho result = null;
        String query="SELECT * FROM `kho` WHERE kho.id_lo_sp ="+id_lo;
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result= new Kho(rs.getInt("id_kho"),rs.getInt("sl_san_pham"),rs.getInt("id_lo_sp"),rs.getInt("id_khu_vuc"));
                               
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        //if(result==null) System.out.print("Lo san pham bi null");
        return result;
    }
    public Kho getIdKho(int id_kho)
    {
        Kho result = null;
        String query="SELECT * FROM `kho` WHERE id_kho ="+id_kho;
        ArrayList<Object> arr = new ArrayList<>();
        try{
        DataProvider.getIntance().open();
        ResultSet rs = DataProvider.getIntance().excuteQuery(query, arr);
        while(rs.next())
        {
            result= new Kho(rs.getInt("id_kho"),
                    rs.getInt("sl_san_pham"),
                    rs.getInt("id_lo_sp"),
                    rs.getInt("id_khu_vuc"));
                               
        }
        DataProvider.getIntance().close();
        }catch(SQLException ex){
            DataProvider.getIntance().displayError(ex);
        }
        //if(result==null) System.out.print("Lo san pham bi null");
        return result;
    }
    public String[][] FindListKhoTra(String ValToSearch)
    {
        String [][] Data=new String[1000][6];
        int RowData;
        RowData = 0;
        ArrayList<Kho> DuLieuKhoTra = getListKho();
        for (int i=0;i<DuLieuKhoTra.size();i++)
        {
            int id_sp=DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuKhoTra.get(i).id_lo_sp).id_sp;
            String tensp=DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
            String loaisp=DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
            String sl_sp=String.valueOf(DuLieuKhoTra.get(i).sl_san_pham);
            LoSanPham lsp = DAO.daoLoSanPham.getInstance().getLoSanPham(DuLieuKhoTra.get(i).id_lo_sp);
            ChiTietPhieuNhap ctpn = DAO.daoChiTietPhieuNhap.getInstance().getChiTietPhieuNhap(lsp.id_phieu_nhap);
            NguonCungCap ncc = DAO.daoNguonCungCap.getInstance().getNguonCungCap(ctpn.id_nguon_cc);
            if (String.valueOf(DuLieuKhoTra.get(i).id_lo_sp).contains(ValToSearch) ||
                    tensp.contains(ValToSearch) ||
                    sl_sp.contains(ValToSearch) ||
                    ncc.ten_nha_cc.contains(ValToSearch))
            {
               //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                 // System.out.println(sl_sp);
                //   System.out.println(tennv);
               Data[RowData][0]=String.valueOf(DuLieuKhoTra.get(i).id_lo_sp);
               Data[RowData][1]=ncc.ten_nha_cc;
               Data[RowData][2]=tensp;
               Data[RowData][3]=sl_sp;
               RowData++;
            }
        }       
        return Data;
    }
    public String[][] FindListKhoXuat(String ValToSearch)
    {
        String [][] Data=new String[1000][6];
        int RowData;
        RowData = 0;
        ArrayList<Kho> DuLieuKhoXuat = getListKho();
        for (int i=0;i<DuLieuKhoXuat.size();i++)
        {
            int id_sp=DAO.daoChiTietLoSanPham.getInstance().getChiTietLoSanPham(DuLieuKhoXuat.get(i).id_lo_sp).id_sp;
            String tensp=DAO.daoSanPham.getInstance().getSanPham(id_sp).ten_sp;
            String loaisp=DAO.daoLoaiSanPham.getInstance().getLoaiSanPham(DAO.daoSanPham.getInstance().getSanPham(id_sp).id_loai_sp).ten_loai_sp;
            String sl_sp=String.valueOf(DuLieuKhoXuat.get(i).sl_san_pham);
            LoSanPham lsp = DAO.daoLoSanPham.getInstance().getLoSanPham(DuLieuKhoXuat.get(i).id_lo_sp);
            ChiTietPhieuNhap ctpn = DAO.daoChiTietPhieuNhap.getInstance().getChiTietPhieuNhap(lsp.id_phieu_nhap);
            NguonCungCap ncc = DAO.daoNguonCungCap.getInstance().getNguonCungCap(ctpn.id_nguon_cc);
            if (String.valueOf(DuLieuKhoXuat.get(i).id_lo_sp).contains(ValToSearch) ||
                    tensp.contains(ValToSearch) ||
                    sl_sp.contains(ValToSearch) ||
                    lsp.hsd.contains(ValToSearch))
            {
               //System.out.println(DuLieuXuatKho.get(i).thoi_gian_xuat);
                //System.out.println(tensp);
                // System.out.println(loaisp);
                 // System.out.println(sl_sp);
                //   System.out.println(tennv);
               Data[RowData][0]=String.valueOf(DuLieuKhoXuat.get(i).id_lo_sp);
               Data[RowData][1]=tensp;
               Data[RowData][2]=sl_sp;
               Data[RowData][3]=lsp.hsd;
               RowData++;
            }
        }       
        return Data;
    }
}
