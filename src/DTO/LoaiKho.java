/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.lang.*;
/**
 *
 * @author Dinh Tien
 */
public class LoaiKho {
    public int id_loai_kho;
    public String ten_loai_kho;
    public int id_exist;
    public LoaiKho(){}
    public LoaiKho(int id_loai_kho, String ten_loai_kho,int id_exist)
    {
        this.id_loai_kho=id_loai_kho;
        this.ten_loai_kho=ten_loai_kho;
        this.id_exist=id_exist;
    }
}
