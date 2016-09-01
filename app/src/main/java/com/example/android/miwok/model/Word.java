package com.example.android.miwok.model;

/**
 * Created by alan_flores on 30/08/16.
 */
public class Word {


    private String english;
    private String miwoz;

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

}
