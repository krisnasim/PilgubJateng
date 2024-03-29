package com.count.cakep.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import com.count.cakep.R;
import com.count.cakep.fragment.DirektifFragment;
import com.count.cakep.fragment.HomeFragment;
import com.count.cakep.fragment.InputHistoryTPSFragment;
import com.count.cakep.fragment.InputTPSFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean specialRegion = true;
    private FragmentManager manager;
    private TextView name_header_view;
    private TextView nrp_header_view;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        checkforBundle();

        if(specialRegion) {
            //everything should be okay here
        } else {
            //uh-oh, some feature should be disabled here
            hideMenuItems();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        name_header_view = ButterKnife.findById(headerView, R.id.name_header_view);
        nrp_header_view = ButterKnife.findById(headerView, R.id.nrp_header_view);

        name_header_view.setText("Jonathan Simananda");
        nrp_header_view.setText("11012356");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //get the fragment manager here!
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new Fragment();

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_beranda) {
            fragment = new HomeFragment();
        } else if (id == R.id.nav_direktif) {
            fragment = new DirektifFragment();
        } else if (id == R.id.nav_catat_tps_pilgub) {
            fragment = new InputTPSFragment();
        } else if (id == R.id.nav_catat_tps_pilbup) {
            fragment = new InputTPSFragment();
        } else if (id == R.id.nav_rekam_tps) {
            fragment = new InputHistoryTPSFragment();
        } else if (id == R.id.nav_logout) {
            logout();
        }

        transaction.replace(R.id.home_main_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //a function that you can use to change fragment, from fragment
    public void changeFragment(Fragment fragment) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.home_main_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //remove fragment from backstack
    public void removeFragment(Fragment fragment) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
        manager.popBackStack();
    }

    private void setFirstFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.home_main_frame, fragment);
        transaction.commit();
    }

    private void logout() {
        //clear all shared preferences first
        SharedPreferences sharedPref = getSharedPreferences("userCred", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
        //start intent, and kill the previous activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
        //add some Toast to help undertand better
        Toast.makeText(this, "Kamu telah berhasil keluar", Toast.LENGTH_SHORT).show();
    }

    private void hideMenuItems() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_catat_tps_pilbup).setVisible(false);
    }

    private void checkforBundle() {
        // You can be pretty confident that the intent will not be null here.
        Intent intent = getIntent();

        // Get the extras (if there are any)
        Bundle extras = intent.getExtras();

        if(intent.hasExtra("intent")) {
            //only if the intent exists
            Fragment fragment;
            if (extras.getString("intent").equals("new")) {
                //set the first fragment to input
                fragment = new InputTPSFragment();
                setFirstFragment(fragment);
            } else if (extras.getString("intent").equals("home")) {
                //set the first home fragment, again
                fragment = new HomeFragment();
                setFirstFragment(fragment);
            }
        } else {
            //set the first home fragment
            Fragment fragment = new HomeFragment();
            setFirstFragment(fragment);
        }
    }
}
