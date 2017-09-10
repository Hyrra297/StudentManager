/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Interface.MonHocInterface;
import Model.etiny.Lop;
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
public class MonHocDAO implements MonHocInterface{
    SQLConnect con = new SQLConnect();
    @Override
    public boolean insert(MonHoc mh){
        String sql = "insert into MonHoc values(?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, mh.getMaMH());
            ps.setString(2, mh.getTenMH());
            ps.setInt(3, mh.getTinChi());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
    }
    @Override
    public boolean update(MonHoc mh){
        String sql = "update MonHoc set tenMH = ?, soTinChi = ? where maMH = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, mh.getTenMH());
            ps.setInt(2, mh.getTinChi());
            ps.setString(3, mh.getMaMH());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    @Override
    public boolean delete(MonHoc mh){
        String sql = "delete from MonHoc where maMH = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, mh.getMaMH());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    @Override
      public ResultSet getData(){
        ResultSet rs = null;
        String sql = "select * from MonHoc";    
        try {
            rs = con.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    @Override
     public ArrayList<MonHoc> getAllMonHoc(){
        ResultSet rs = null;
        ArrayList<MonHoc> list = new ArrayList();
        MonHoc mh;
        try {
            String sql = "select * from MonHoc";
            rs = con.executeQuery(sql);
            while(rs.next()){
                mh = new MonHoc();
                mh.setMaMH(rs.getString(1));
                mh.setTenMH(rs.getString(2));
                mh.setTinChi(rs.getInt(3));
                list.add(mh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
