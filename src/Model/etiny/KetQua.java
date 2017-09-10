/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.etiny;

import Model.Interface.GiaoTiep;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author AIO
 */
public class KetQua implements GiaoTiep, Comparable<KetQua>{
    private String maSV;
    private String maMH;
    private Double diemThi;

    public KetQua(String maSV, String maMH, Double diemThi) {
        this.maSV = maSV;
        this.maMH = maMH;
        this.diemThi = diemThi;
    }
    public KetQua(){
        
    }
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public double getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(Double diemThi) {
        this.diemThi = diemThi;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            this.maSV, this.maMH, this.diemThi
        };
    }  

    @Override
    public int compareTo(KetQua o) {
        return o.getMaSV().compareTo(this.getMaSV());
    }

   
}
