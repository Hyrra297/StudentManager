/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import Model.etiny.KetQua;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ice
 */
public interface KetQuaInterface {
    public abstract boolean insert(KetQua kq);
    public abstract boolean update(KetQua kq);
    public abstract boolean delete(KetQua kq);
    public abstract ResultSet getData();
    public abstract ArrayList<KetQua> getAllKetQua();
    public abstract ResultSet sortDiem();
    public abstract ResultSet sortMaSV();
    public abstract ResultSet sortMaMH();
    
}
