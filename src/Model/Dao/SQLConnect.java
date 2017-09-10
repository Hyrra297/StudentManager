/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dao;

import Model.Interface.SQLConnectInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AIO
 */
public class SQLConnect implements SQLConnectInterface{
    final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final String user = "sa";
    final String pass = "admin";
    final String url = "jdbc:sqlserver://ICE-PC:1433;databaseName=QLSV";
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    public SQLConnect(){
    }
    @Override
    public Connection getConnect(){
        if(con == null){
            try {
                Class.forName(className);
                con = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
    @Override
    public Statement getStatement(){
        if(st == null){
            try {
                st = getConnect().createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return st;
    }
    @Override
    public ResultSet executeQuery(String sql) throws SQLException{
        return getStatement().executeQuery(sql);
    }
    @Override
    public int executeUpdate(String sql) throws SQLException{
        int res = Integer.MIN_VALUE;
        try {
            res = getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            con.close();;
        }
        return res;
    }
    @Override
    public int count(ResultSet rs){
        int count = 0;
        try {
            while(rs.next()){
                count++;
            }
            rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
