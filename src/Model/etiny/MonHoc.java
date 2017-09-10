/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.etiny;

import Model.Interface.GiaoTiep;

/**
 *
 * @author AIO
 */
public class MonHoc implements GiaoTiep{
    private String maMH;
    private String tenMH;
    private int tinChi;
    

    public MonHoc(String maMH, String tenMH, int tinChi) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.tinChi = tinChi;
       
    }
    
    public MonHoc(){
        
    }
    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            this.maMH, this.tenMH, this.tinChi
        };
    }
    
}
