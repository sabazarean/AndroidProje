package com.music.saba.myapplication;

/**
 * Created by Saba on 4/19/2018.
 */
public class Navigation_Items {

    String title, subtitle;
    Integer icon;

    public Navigation_Items(String title, String subtitle, Integer icon) {
        this.title = title;
        this.subtitle = subtitle;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subtitle;
    }

    public Integer getIcon() {
        return icon;
    }

}