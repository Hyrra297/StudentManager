/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import Model.etiny.MonHoc;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ice
 */
public interface MonHocInterface {
    public abstract boolean insert(MonHoc mh);
    public abstract boolean update(MonHoc mh);
    public abstract boolean delete(MonHoc mh);
    public abstract ResultSet getData();
    public abstract ArrayList<MonHoc> getAllMonHoc();
    
}
