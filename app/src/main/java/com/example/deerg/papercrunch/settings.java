package com.example.deerg.papercrunch;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class settings extends AppCompatActivity {

    android.support.v7.widget.Toolbar custom_toolbar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    NavigationView navigationView;
    ExpandableListView mExpandableListView;
    ExpandableListAdapter mExpandableListAdapter;
    List<String> listheader;
    HashMap<String, List<String>> listchild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setuptoolbar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.onerflow_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void setuptoolbar() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            custom_toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.custom_toolbar);
        }
        setSupportActionBar(custom_toolbar);
        mExpandableListView = (ExpandableListView) findViewById(R.id.navmenu);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        prepareData();
        mExpandableListAdapter = new com.example.deerg.papercrunch.ExpandableListAdapter(this, listheader, listchild, mExpandableListView);
        mExpandableListView.setAdapter(mExpandableListAdapter);
        getSupportActionBar().setIcon(R.drawable.logo1);
        getSupportActionBar().setTitle("");
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, custom_toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        navigationView.setItemIconTintList(null);

        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    mExpandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });
    }
    private void prepareData() {
        listheader = new ArrayList<String>();
        listchild = new HashMap<String, List<String>>();
        listheader.add("View All Sub Levels");
        listheader.add("View Prevoius Level");
        listheader.add("View Next Level");
        listheader.add("");
        listheader.add("");
        listheader.add("");
        listheader.add("Settings");
        listheader.add("Rate us");
        listheader.add("About us");

        List<String> head1 = new ArrayList<String>();
        head1.add("Sub level 1");
        head1.add("Sub level 2");
        head1.add("Sub level 3");
        head1.add("Sub level 4");

        List<String> head2 = new ArrayList<String>();
        head2.add("Level 1");
        head2.add("Level 2");
        head2.add("Level 3");
        head2.add("Level 4");

        listchild.put(listheader.get(0), head1);
        listchild.put(listheader.get(1), head2);
    }
}
