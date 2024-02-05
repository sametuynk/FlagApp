package com.example.flagapp;

public class Flags {
    private int flag_id;
    private String flag_ad;
    private String flag_image;

    public Flags() {
    }

    public Flags(int flag_id, String flag_ad, String flag_image) {
        this.flag_id = flag_id;
        this.flag_ad = flag_ad;
        this.flag_image = flag_image;
    }

    public int getFlag_id() {
        return flag_id;
    }

    public void setFlag_id(int flag_id) {
        this.flag_id = flag_id;
    }

    public String getFlag_ad() {
        return flag_ad;
    }

    public void setFlag_ad(String flag_ad) {
        this.flag_ad = flag_ad;
    }

    public String getFlag_image() {
        return flag_image;
    }

    public void setFlag_image(String flag_image) {
        this.flag_image = flag_image;
    }
}
