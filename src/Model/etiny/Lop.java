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
public class Lop implements GiaoTiep{
    private String maLop;
    private String tenLop;
    private String maKhoa;
    private int soSV;

    public Lop(String maLop, String tenLop, String maKhoa, int soSV){
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maKhoa = maKhoa;
        this.soSV = soSV;
    }
    public Lop(){
        
    }
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            this.maLop, this.tenLop, this.maKhoa, this.soSV
        };
    }
    
}
