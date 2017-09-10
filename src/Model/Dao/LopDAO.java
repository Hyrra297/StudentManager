/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Interface.LopInterface;
import Model.etiny.Lop;
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
public class LopDAO implements LopInterface{
    SQLConnect con = new SQLConnect();
    @Override
    public boolean insert(Lop l){
        String sql = "insert into Lop values(?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, l.getMaLop());
            ps.setString(2, l.getTenLop());
            ps.setString(3, l.getMaKhoa());
            ps.setInt(4, l.getSoSV());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    @Override
    public boolean update(Lop l){
        String sql = "update Lop set tenLop = ?, soSv = ? where maLop = ? and maKhoa = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, l.getTenLop());
            ps.setInt(2, l.getSoSV());
            ps.setString(3, l.getMaLop());
            ps.setString(4, l.getMaKhoa());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    @Override
    public boolean delete(Lop l){
        String sql = "delete from Lop where maLop = ? and maKhoa = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, l.getMaLop());
            ps.setString(2, l.getMaKhoa());
            return (ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    @Override
      public ResultSet getData(){
        ResultSet rs = null;
        String sql = "select * from Lop";    
        try {
            rs = con.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    @Override
    public ArrayList<Lop> getAllLop(){
        ResultSet rs = null;
        ArrayList<Lop> list = new ArrayList();
        Lop l;
        try {
            String sql = "select * from Lop";
            rs = con.executeQuery(sql);
            while(rs.next()){
                l = new Lop();
                l.setMaLop(rs.getString(1));
                l.setTenLop(rs.getString(2));
                l.setMaKhoa(rs.getString(3));
                l.setSoSV(rs.getInt(4));
                list.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
