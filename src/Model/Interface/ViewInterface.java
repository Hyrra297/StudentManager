/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ice
 */
public interface ViewInterface {
    
    public abstract int kiemTraMaSV(String maSV);
    public abstract int kiemTraMaLop(String maLop);
    public abstract int kiemTraMaKhoa(String maKhoa);
    public abstract int kiemTraMaMonHoc(String maMH);
    public abstract int kiemTraSoLuongLop(String maKhoa);//Kiem tra so luong lop trong mot khoa
    public abstract int kiemTraSoLuongSinhVien(String maMH);//Kiem tra so luong sinh vien trong mot mon hoc
    public abstract int kiemTraSinhVienConTonTai(String maSV);//Kiem tra sinh vien con hoc khong
    public abstract int kiemTraDiemSinhVien(String maSV, String maMH);//Kiem tra sinh vien con hoc khong
    public abstract int demSoLuongSV(String maLop);//Dem so luong sinh vien trong mot lop
    public abstract double doiCoSoDiem(double diemHe4, int a);//Doi tu co so 4 sang co so 10
    public abstract ResultSet danhSachThongKe();//Tao bang thong ke tren CSDL cac thong tin cua Sinh vien
    


}
