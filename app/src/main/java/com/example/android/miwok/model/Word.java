package com.example.android.miwok.model;

/**
 * Created by alan_flores on 30/08/16.
 */
public class Word {



    private String english;
    private String miwoz;
    private int idImage = NO_IMAGE;
    private static final int NO_IMAGE = -1;
    private int idAudio;

    public Word(String english, String miwoz, int idImage, int idAudio) {
        this.english = english;
        this.miwoz = miwoz;
        this.idImage = idImage;
        this.idAudio = idAudio;
    }

    public Word(int idAudio,String english, String miwoz ) {
        this.english = english;
        this.miwoz = miwoz;
        this.idAudio = idAudio;
    }

    public Word(String english, String miwoz, int idImage) {
        this.english = english;
        this.miwoz = miwoz;
        this.idImage = idImage;
    }

    public Word(String english, String miwoz) {
        this.english = english;
        this.miwoz = miwoz;
    }

    public int getIdAudio() {
        return idAudio;
    }

    public void setIdAudio(int idAudio) {
        this.idAudio = idAudio;
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

    @Override
    public String toString() {
        return "Word{" +
                "english='" + english + '\'' +
                ", miwoz='" + miwoz + '\'' +
                ", idImage=" + idImage +
                ", idAudio=" + idAudio +
                '}';
    }
}
