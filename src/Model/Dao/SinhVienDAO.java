/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Interface.SinhVienInterface;
import Model.etiny.SinhVien;
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
public class SinhVienDAO implements SinhVienInterface{
    SQLConnect con = new SQLConnect();
    @Override
    public boolean insert(SinhVien sv){
        String sql = "insert into SinhVien values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getTenSV());
            ps.setString(3, sv.getDiaChi());
            ps.setString(4, sv.getMaLop());
            ps.setLong(5, sv.getHocBong());
            return(ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public boolean update(SinhVien sv){
        String sql = "update SinhVien set tenSV = ?, diaChi = ?, maLop = ?, hocBong = ? where maSV = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, sv.getTenSV());
            ps.setString(2, sv.getDiaChi());
            ps.setString(3, sv.getMaLop());
            ps.setLong(4, sv.getHocBong());
            ps.setString(5, sv.getMaSV());
            return(ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public boolean delete(SinhVien sv){
        String sql = "delete from SinhVien where maSV = ?";
        try {
            PreparedStatement ps = con.getConnect().prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            return(ps.executeUpdate() == 1);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public ResultSet getData(){
        ResultSet rs = null;
        String sql = "select * from SinhVien";    
        try {
            rs = con.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    @Override
    public ArrayList<SinhVien> getAllSinhVien(){
        ResultSet rs = null;
        SinhVien sv = null;
        ArrayList<SinhVien> list = new ArrayList();
        try {
            String sql = "select * from SinhVien";
            rs = con.executeQuery(sql);
            while(rs.next()){
                sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                sv.setDiaChi(rs.getString(3));
                sv.setMaLop(rs.getString(4));
                sv.setHocBong(rs.getLong(5));
                
                list.add(sv);
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
}
    
