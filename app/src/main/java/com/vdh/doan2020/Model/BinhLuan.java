package com.vdh.doan2020.Model;

public class BinhLuan {
    private String  binhluan;
    private String username;


    public BinhLuan() {
    }

    public BinhLuan(String binhluan, String username) {
        this.binhluan = binhluan;
        this.username = username;
    }

    public String getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
