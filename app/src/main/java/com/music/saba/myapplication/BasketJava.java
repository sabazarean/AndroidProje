package com.music.saba.myapplication;

/**
 * Created by Saba on 4/1/2018.
 */

public class BasketJava {

    private int BasketImage ;
    private String BasketTitle ;

    public BasketJava(int basketImage, String basketTitle) {
        BasketImage = basketImage;
        BasketTitle = basketTitle;
    }

    public int getBasketImage() {
        return BasketImage;
    }

    public void setBasketImage(int basketImage) {
        BasketImage = basketImage;
    }

    public String getBasketTitle() {
        return BasketTitle;
    }

    public void setBasketTitle(String basketTitle) {
        BasketTitle = basketTitle;
    }
}
