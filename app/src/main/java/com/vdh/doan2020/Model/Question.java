package com.vdh.doan2020.Model;

public class Question {
    private String DapanA;
    private String DapanB;
    private String DapanC;
    private String DapanD;
    private Integer ID;
    private String KetQua;
    private String NoiDung;
    private Integer PhanLoai;
    private String TraLoi="";
    public Question() {
    }

    public Question(String dapanA, String dapanB, String dapanC, String dapanD, Integer ID, String ketQua, String noiDung, Integer phanLoai) {
        DapanA = dapanA;
        DapanB = dapanB;
        DapanC = dapanC;
        DapanD = dapanD;
        this.ID = ID;
        KetQua = ketQua;
        NoiDung = noiDung;
        PhanLoai = phanLoai;
    }

    public String getDapanA() {
        return DapanA;
    }

    public void setDapanA(String dapanA) {
        DapanA = dapanA;
    }

    public String getDapanB() {
        return DapanB;
    }

    public void setDapanB(String dapanB) {
        DapanB = dapanB;
    }

    public String getDapanC() {
        return DapanC;
    }

    public void setDapanC(String dapanC) {
        DapanC = dapanC;
    }

    public String getDapanD() {
        return DapanD;
    }

    public void setDapanD(String dapanD) {
        DapanD = dapanD;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getKetQua() {
        return KetQua;
    }

    public void setKetQua(String ketQua) {
        KetQua = ketQua;
    }

    public String getTraLoi() {
        return TraLoi;
    }

    public void setTraLoi(String traLoi) {
        TraLoi = traLoi;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public Integer getPhanLoai() {
        return PhanLoai;
    }

    public void setPhanLoai(Integer phanLoai) {
        PhanLoai = phanLoai;
    }
}
