/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Interface.UserNameInterface;
import Model.etiny.UserName;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Ice
 */
public class UserNameDAO implements UserNameInterface{

    @Override
    public boolean kiemTraUser(String userName, String passWord) {
        try {
            SQLConnect conn = new SQLConnect();
            ResultSet rs = null;
            String result = "";
            String sql = "SELECT * from UserName where userName = ? and passWord = ?";
            PreparedStatement ps = conn.getConnect().prepareStatement(sql);
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(passWord.getBytes());
            BigInteger bigInteger = new BigInteger(1,digest.digest());
            result = bigInteger.toString(16);
            ps.setString(1, userName);
            ps.setString(2, result);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(UserNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean kiemTraUser(String userName) {
        try {
            SQLConnect conn = new SQLConnect();
            ResultSet rs = null;
            String sql = "SELECT * from UserName where userName = ?";
            PreparedStatement ps = conn.getConnect().prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(UserNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void register(UserName user) {
        SQLConnect conn = new SQLConnect();
        String sql = "insert into UserName(userName, passWord, email) values(?, ?, ?)";
        try {
            String result = "";
            PreparedStatement ps = conn.getConnect().prepareStatement(sql);
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(user.getPassWord().getBytes());
            BigInteger bigInteger = new BigInteger(1,digest.digest());
            result = bigInteger.toString(16);
            ps.setString(1, user.getUserName());
            ps.setString(2, result);
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserNameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
