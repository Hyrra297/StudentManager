/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Interface.ViewInterface;
import Model.etiny.KetQua;
import Model.etiny.Khoa;
import Model.etiny.Lop;
import Model.etiny.MonHoc;
import Model.etiny.SinhVien;
import View.MainFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ice
 */
public class ViewController implements ViewInterface{
    @Override
    public int kiemTraMaSV(String maSV) {
        ArrayList<SinhVien> arrSV = new ArrayList<>();
        SinhVienDAO svDAO = new SinhVienDAO();
        arrSV = svDAO.getAllSinhVien();
        for(SinhVien i : arrSV){
            if(i.getMaSV().compareTo(maSV) == 0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int kiemTraMaLop(String maLop) {
        ArrayList<Lop> arrLop = new ArrayList<>();
        LopDAO lopDAO = new LopDAO();
        arrLop = lopDAO.getAllLop();
        for(Lop i : arrLop){
            if(i.getMaLop().compareTo(maLop) == 0){
                return 1;
            }  
        }
        return 0;
    }

    @Override
    public int kiemTraMaKhoa(String maKhoa) {
        ArrayList<Khoa> arrKhoa = new ArrayList<>();
        KhoaDAO khoaDAO = new KhoaDAO();
        arrKhoa = khoaDAO.getAllKhoa();
        for(Khoa i : arrKhoa){
            if(i.getMaKhoa().compareTo(maKhoa) == 0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int kiemTraMaMonHoc(String maMH) {
        ArrayList<MonHoc> arrMH = new ArrayList<>();
        MonHocDAO mhDAO = new MonHocDAO();
        arrMH = mhDAO.getAllMonHoc();
        for(MonHoc i : arrMH){
            if(i.getMaMH().compareTo(maMH) == 0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int demSoLuongSV(String maLop) {
        SQLConnect con = new SQLConnect();
        ResultSet rs = null;
        PreparedStatement ps;
        int soLuongSV = 0;
        String sql = "select maSV from SinhVien where maLop = ?";
        try {
            ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, maLop);
            rs = ps.executeQuery();
            while(rs.next()){
                 soLuongSV++;
            }
        } catch (SQLException ex) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            return soLuongSV;
    }

    @Override
    public int kiemTraSoLuongLop(String maKhoa) {
        ResultSet rs = null;
        SQLConnect con = new SQLConnect();
        PreparedStatement ps;
        int soLuongLop = 0;
        String sql = "select maLop from Lop where maKhoa = ?";
        
        try {
            ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, maKhoa);
            rs = ps.executeQuery();
            while(rs.next()){
                soLuongLop++;
            }
        } catch (SQLException ex) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(soLuongLop > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int kiemTraSoLuongSinhVien(String maMH) {
        ResultSet rs = null;
        SQLConnect con = new SQLConnect();
        int soLuongSV = 0;
        PreparedStatement ps;
        String sql = "select maSV from KetQua where maMH = ?";
        try {
            ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, maMH);
            rs = ps.executeQuery();
            while(rs.next()){
                soLuongSV++;
            }
       } catch (SQLException ex) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
       }
        if(soLuongSV > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int kiemTraSinhVienConTonTai(String maSV) {
        ResultSet rs = null;
        SQLConnect con = new SQLConnect();
        int soLuongSV = 0;
        PreparedStatement ps;
        String sql = "select maSV from KetQua where maSV = ?";
        try {
            ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, maSV);
            rs = ps.executeQuery();
            while(rs.next()){
                soLuongSV++;
            }
       } catch (SQLException ex) {
           Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
       }
        if(soLuongSV > 0){
            return 1;
        }
        return 0;
    }

    @Override
    public int kiemTraDiemSinhVien(String maSV, String maMH) {
        KetQuaDAO kqDAO = new KetQuaDAO();
        ArrayList<KetQua> arrKQ = new ArrayList<>();
        arrKQ = kqDAO.getAllKetQua();  
        for(KetQua i : arrKQ){
            if(maSV.compareTo(i.getMaSV()) == 0 && maMH.compareTo(i.getMaMH()) == 0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public double doiCoSoDiem(double diemHe4, int a) {
        if (a > 0){
        int temp = 1;
        for (int i = 0; i < a; i++){
            temp = temp * 10;
        }
        diemHe4 = diemHe4 * temp;
        diemHe4 = Math.round(diemHe4);
        diemHe4 = diemHe4 / temp;
        return diemHe4;
    }else
        return 0.0;
    }

    @Override
    public ResultSet danhSachThongKe() {
        SQLConnect con = new SQLConnect();
        ResultSet rs = null;
        String sql = "select sv.maSV, tenSV, l.maLop, tenLop, kh.maKhoa, tenKhoa, diaChi, a.TB, hocBong\n" +
                     "from SinhVien sv, Lop l, Khoa kh, "
                +   "(select  maSV, SUM(diemThi * soTinChi)/Sum(soTinChi) as TB from KetQua kq, MonHoc mh where kq.maMH = mh.maMH group by maSV) as a\n" +
                     "where sv.maLop = l.maLop and l.maKhoa = kh.maKhoa and sv.maSV = a.maSV order by a.TB desc";
        try {
            rs = con.getStatement().executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs;
    }
}
