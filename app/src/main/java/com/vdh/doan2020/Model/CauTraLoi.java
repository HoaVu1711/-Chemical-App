package com.vdh.doan2020.Model;

public class CauTraLoi {
    private  int index;
    private String  anwser;

    public CauTraLoi() {
    }

    public CauTraLoi(int index, String anwser) {
        this.index = index;
        this.anwser = anwser;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }
}
