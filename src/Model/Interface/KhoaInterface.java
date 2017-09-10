/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import Model.etiny.Khoa;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ice
 */
public interface KhoaInterface {
    public abstract boolean insert(Khoa kh);
    public abstract boolean update(Khoa kh);
    public abstract boolean delete(Khoa kh);
    public abstract ResultSet getData();
    public abstract ArrayList<Khoa> getAllKhoa();
}
