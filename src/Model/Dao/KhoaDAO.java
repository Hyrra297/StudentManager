/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Interface.KhoaInterface;
import Model.etiny.Khoa;
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
public class KhoaDAO implements KhoaInterface{
    SQLConnect con = new SQLConnect();
    @Override
    public boolean insert(Khoa kh){
        String sql = "insert into Khoa values(?, ?)";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, kh.getMaKhoa());
            ps.setString(2, kh.getTenKhoa());
            return(ps.executeUpdate()== 1);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
    }
    @Override
    public boolean update(Khoa kh){
        String sql = "update Khoa set tenKhoa = ? where maKhoa = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, kh.getTenKhoa());
            ps.setString(2, kh.getMaKhoa());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    @Override
    public boolean delete(Khoa kh){
        String sql = "delete from Khoa where maKhoa = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, kh.getMaKhoa());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    @Override
      public ResultSet getData(){
        ResultSet rs = null;
        String sql = "select * from Khoa";    
        try {
            rs = con.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    @Override
    public ArrayList<Khoa> getAllKhoa(){
        ArrayList<Khoa> list = new ArrayList();
        ResultSet rs = null;
        Khoa kh = null;
        try {
            String sql = "select * from Khoa";
            rs = con.executeQuery(sql);
            while(rs.next()){
                kh = new Khoa();
                kh.setMaKhoa(rs.getString(1));
                kh.setTenKhoa(rs.getString(2));
                list.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
