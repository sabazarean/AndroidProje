package com.music.saba.myapplication;

        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;

    //Constructor to the class
    public PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                AboutUs_Fragment tab1 = new AboutUs_Fragment();
                return tab1;
            case 1:
                Home_Fragment tab2 = new Home_Fragment();
                return tab2;
            case 2:
                Messages_Fragment tab3 = new Messages_Fragment();
                return tab3;
            default:
                return null;
        }
    }

    public int getCount() {
        return tabCount;
    }
}