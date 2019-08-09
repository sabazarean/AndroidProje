package com.music.saba.myapplication;

/**
 * Created by Saba on 3/29/2018.
 */

public class DesignJava {

    public DesignJava(String title, int image, int mainImage) {
        Title = title;
        Image = image;
        MainImage = mainImage;

    }

    private String Title;
    private int Image;
    private int MainImage;


    public String getTitle() {
        return Title;
    }

    public int getImage() {
        return Image;
    }

    public int getMainImage() {
        return MainImage;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setMainImage(int mainImage) {
        MainImage = mainImage;
    }
}
