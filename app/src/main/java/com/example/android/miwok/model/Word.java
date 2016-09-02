package com.example.android.miwok.model;

/**
 * Created by alan_flores on 30/08/16.
 */
public class Word {



    private String english;
    private String miwoz;
    private int idImage = NO_IMAGE;
    private static final int NO_IMAGE = -1;

    public Word(String english, String miwoz, int idImage) {
        this.english = english;
        this.miwoz = miwoz;
        this.idImage = idImage;
    }

    public Word(String english, String miwoz) {
        this.english = english;
        this.miwoz = miwoz;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMiwoz() {
        return miwoz;
    }

    public void setMiwoz(String miwoz) {
        this.miwoz = miwoz;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public boolean hasImage(){
        return idImage != NO_IMAGE;
    }

}
