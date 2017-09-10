/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import Model.etiny.SinhVien;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ice
 */
public interface SinhVienInterface {
    public abstract boolean insert(SinhVien sv);
    public abstract boolean update(SinhVien sv);
    public abstract boolean delete(SinhVien sv);
    public abstract ResultSet getData();
    public abstract ArrayList<SinhVien> getAllSinhVien();
}
