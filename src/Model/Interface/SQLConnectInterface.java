/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ice
 */
public interface SQLConnectInterface {
    public abstract Connection getConnect();
    public abstract Statement getStatement();
    public abstract ResultSet executeQuery(String sql) throws SQLException;
    public abstract int executeUpdate(String sql) throws SQLException;
    public abstract int count(ResultSet rs);
}
