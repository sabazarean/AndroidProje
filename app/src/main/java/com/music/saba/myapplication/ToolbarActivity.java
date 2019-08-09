package com.music.saba.myapplication;



import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.music.saba.myapplication.AboutUs_Fragment;
import com.music.saba.myapplication.Messages_Fragment;
import com.music.saba.myapplication.Settings_Fragment;
import com.music.saba.myapplication.UserAccount_Fragment;

import java.util.ArrayList;

public class ToolbarActivity extends AppCompatActivity {
    private static DrawerLayout drawer;
    private static ActionBarDrawerToggle actionbarToggle;

    private static ArrayList<Navigation_Items> arrayList;
    private static Navigation_Drawer_Adapter adapter;

    private static ListView listview;

    private static FragmentManager fragment_manager;
    private static Toolbar toolbar;
    private static RelativeLayout left_slider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);



        init();
        populateListItems();


        // Replace the default/home fragment if savedinstance is null
        if (savedInstanceState == null) {
            selectItem(0);
        }
    }




    void init() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        listview = (ListView) findViewById(R.id.list_slidermenu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        left_slider = (RelativeLayout) findViewById(R.id.slider);

        // Fragment manager to manage fragment
        fragment_manager = getSupportFragmentManager();
        arrayList = new ArrayList<Navigation_Items>();

        TextView txt =(TextView)findViewById(R.id.profile_name);
        TextView txtEmail =(TextView)findViewById(R.id.profile_email);

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(G.context);
        String email = sharedPreferences.getString("email", "No name defined");//"No name defined" is the default value.
        String name = sharedPreferences.getString("name", "No name defined");//"No name defined" is the default value.
        int id = sharedPreferences.getInt("id", 0); //0 is the default value.
        if (id != 0) {
            txt.setText(name);
            txtEmail.setText(email);
        }


        // Setting actionbar toggle
//        actionbarToggle = new ActionBarDrawerToggle(this, drawer, toolbar,
//                R.string.drawer_open, R.string.drawer_close) {

//            @Override
//            public void onDrawerClosed(View drawerView) {
//                Toast.makeText(ToolbarActivity.this, "Drawer Close",
//                        Toast.LENGTH_SHORT).show();
//                super.onDrawerClosed(drawerView);
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                Toast.makeText(ToolbarActivity.this, "Drawer Open",
//                        Toast.LENGTH_SHORT).show();
//                super.onDrawerOpened(drawerView);
//            }
//
//        };

        // Setting drawer listener
     //  drawer.setDrawerListener(actionbarToggle);


    }

    // Populate navigation drawer listitems
    void populateListItems() {
        Integer Icons[] = { R.drawable.ic_home, R.drawable.ic_person_black_24dp,
                R.drawable.ic_share_black_24dp, R.drawable.ic_info,
                R.drawable.ic_info };
        String title[] = getResources().getStringArray(R.array.list_items);
        String subtitle[] = getResources()
                .getStringArray(R.array.list_subitems);

        for (int i = 0; i < Icons.length-1; i++) {
            arrayList
                    .add(new Navigation_Items(title[i], subtitle[i], Icons[i]));
        }

        adapter = new Navigation_Drawer_Adapter(ToolbarActivity.this, arrayList);

        // Setting adapter
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    // Select item method for replacing fragments
    public void selectItem(int position) {

        // Setting toolbar title
        toolbar.setTitle(arrayList.get(position).getTitle());



        // Close drawer method
        closeDrawer();
        switch (position) {
            case 0:
                replaceFragment(new Home_Fragment(), "صفحه اصلی");
                break;
            case 1:
                replaceFragment(new UserAccount_Fragment(), "حساب کاربری");
                break;
            case 2:
                replaceFragment(new Messages_Fragment(), "اشتراک گذاری");
                break;

            case 3:
                replaceFragment(new Settings_Fragment(), "تماس با ما");
                break;
            case 4:
                replaceFragment(new AboutUs_Fragment(), "درباره ما");
                break;

        }
    }

    // Replace fragment method
    void replaceFragment(Fragment fragment, String tag) {

        // First find the fragment by TAG and if it null then replace the
        // fragment else do nothing
        Fragment fr = fragment_manager.findFragmentByTag(tag);
        if (fr == null) {
            fragment_manager.beginTransaction()
                    .replace(R.id.frame_container, fragment, tag).commit();
        }

    }

    // close the open drawer
    void closeDrawer() {
        if (drawer.isDrawerOpen(left_slider)) {
            drawer.closeDrawer(left_slider);
        }
    }

    @Override
    public void onBackPressed() {

        // Call whenBackpressed method to do task
        whenBackPressed();
    }

    // Method to be execute on back pressed
    void whenBackPressed() {
        Fragment fr = fragment_manager.findFragmentByTag("Home");
        // First close the drawer if open
        if (drawer.isDrawerOpen(left_slider)) {
            drawer.closeDrawer(left_slider);

        }
        // else replace the home fragment if TAG is null
        else {
            if (fr == null) {
                selectItem(0);
            }

            // finally finish activity
            else {
                finish();
            }
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync state for actionbar toggle
 //       actionbarToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
      //  actionbarToggle.onConfigurationChanged(newConfig);
    }
}