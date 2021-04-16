package com.vdh.doan2020.Model;

public class Diem {
    private String thoiGian;
    private String Diem;

    public Diem() {
    }

    public Diem(String thoiGian, String diem) {
        this.thoiGian = thoiGian;
        Diem = diem;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiem() {
        return Diem;
    }

    public void setDiem(String diem) {
        Diem = diem;
    }
}
