package com.vdh.doan2020.Model;

public class NguyenToHoaHoc{
    private int mId;
    private String mTen;
    private String mKiHieu;
    private float mNguyenTuKhoi;
    private String mPhanLoai;
    private int mMauSac;
    private String mChiTiet;
    public NguyenToHoaHoc() {
    }

    public NguyenToHoaHoc(String mTen, String mKiHieu, float mNguyenTuKhoi, int mMauSac, String mChiTiet) {
        this.mTen = mTen;
        this.mKiHieu = mKiHieu;
        this.mNguyenTuKhoi = mNguyenTuKhoi;
        this.mMauSac = mMauSac;
        this.mChiTiet=mChiTiet;
    }

    public NguyenToHoaHoc(int mId, String mTen, String mKiHieu, float mNguyenTuKhoi, String mPhanLoai, int mMauSac, String mChiTiet) {
        this.mId = mId;
        this.mTen = mTen;
        this.mKiHieu = mKiHieu;
        this.mNguyenTuKhoi = mNguyenTuKhoi;
        this.mPhanLoai = mPhanLoai;
        this.mMauSac = mMauSac;
    }

    public NguyenToHoaHoc(int mId, String mTen, String mKiHieu, float mNguyenTuKhoi, String mPhanLoai, int mMauSac) {
        this.mId = mId;
        this.mTen = mTen;
        this.mKiHieu = mKiHieu;
        this.mNguyenTuKhoi = mNguyenTuKhoi;
        this.mPhanLoai = mPhanLoai;
        this.mMauSac = mMauSac;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public String getmKiHieu() {
        return mKiHieu;
    }

    public void setmKiHieu(String mKiHieu) {
        this.mKiHieu = mKiHieu;
    }

    public float getmNguyenTuKhoi() {
        return mNguyenTuKhoi;
    }

    public void setmNguyenTuKhoi(float mNguyenTuKhoi) {
        this.mNguyenTuKhoi = mNguyenTuKhoi;
    }

    public String getmPhanLoai() {
        return mPhanLoai;
    }

    public void setmPhanLoai(String mPhanLoai) {
        this.mPhanLoai = mPhanLoai;
    }

    public int getmMauSac() {
        return mMauSac;
    }

    public void setmMauSac(int mMauSac) {
        this.mMauSac = mMauSac;
    }

    public String getmChiTiet() {
        return mChiTiet;
    }

    public void setmChiTiet(String mChiTiet) {
        this.mChiTiet = mChiTiet;
    }
}
