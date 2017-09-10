/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Interface.KetQuaInterface;
import Model.etiny.KetQua;
import Model.etiny.MonHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AIO
 */
public class KetQuaDAO implements KetQuaInterface{
    SQLConnect con = new SQLConnect();
    public boolean insert(KetQua kq){
        String sql = "insert into KetQua values(?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, kq.getMaSV());
            ps.setString(2, kq.getMaMH());
            ps.setDouble(3, kq.getDiemThi());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
    }
    public boolean update(KetQua kq){
        String sql = "update KetQua set diemThi= ? where maSV = ? and maMH = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setDouble(1, kq.getDiemThi());
            ps.setString(2, kq.getMaSV());
            ps.setString(3, kq.getMaMH());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(KetQua kq){
        String sql = "delete from KetQua where maSV = ? and maMH = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, kq.getMaSV());
            ps.setString(2, kq.getMaMH());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
      public ResultSet getData(){
        ResultSet rs = null;
        String sql = "select * from KetQua";    
        try {
            rs = con.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
     public ArrayList<KetQua> getAllKetQua(){
        ResultSet rs = null;
        ArrayList<KetQua> list = new ArrayList();
        KetQua kq;
        try {
            String sql = "select * from KetQua";
            rs = con.executeQuery(sql);
            while(rs.next()){
                kq = new KetQua();
                kq.setMaSV(rs.getString(1));
                kq.setMaMH(rs.getString(2));
                kq.setDiemThi(rs.getDouble(3));
                list.add(kq);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public ResultSet sortDiem(){
         ResultSet rs = null;
         String sql = "select * from KetQua order by diemThi asc";
        try {
            rs = con.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
     }
     public ResultSet sortMaSV(){
         ResultSet rs = null;
         String sql = "select * from KetQua order by maSV asc";
        try {
            rs = con.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
     }
     public ResultSet sortMaMH(){
         ResultSet rs = null;
         String sql = "select * from KetQua order by maMH asc";
        try {
            rs = con.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KetQuaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
     }
    
}
