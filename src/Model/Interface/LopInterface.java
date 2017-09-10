/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;

import Model.etiny.Lop;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ice
 */
public interface LopInterface {
    public boolean insert(Lop l);
    public boolean update(Lop l);
    public boolean delete(Lop l);
    public ResultSet getData();
    public ArrayList<Lop> getAllLop();
    
}
