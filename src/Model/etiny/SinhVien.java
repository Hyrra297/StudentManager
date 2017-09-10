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
public class SinhVien implements GiaoTiep{
    private String maSV;
    private String tenSV;
    private String diaChi;
    private String maLop;
    private Long hocBong;

    public SinhVien(String maSV, String tenSV, String diaChi, String maLop, Long hocBong) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diaChi = diaChi;
        this.maLop = maLop;
        this.hocBong = hocBong;
    }
    public SinhVien(){
        
    }
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public Long getHocBong() {
        return hocBong;
    }

    public void setHocBong(Long hocBong) {
        this.hocBong = hocBong;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            this.maSV, this.tenSV, this.diaChi, this.maLop, this.hocBong
        };
    }
    
    
}
