package com.example.shopee.toi.list;

import java.io.Serializable;

public class list_Toi  {
    private int anh;
    private String ten;

    public list_Toi(int anh, String ten) {
        this.anh = anh;
        this.ten = ten;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
