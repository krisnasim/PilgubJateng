package id.mdh.pilgubjateng.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.mdh.pilgubjateng.R;
import id.mdh.pilgubjateng.customclass.CustomGridMenu;
import id.mdh.pilgubjateng.fragment.HomeFragment;
import id.mdh.pilgubjateng.fragment.InputHistoryTPSFragment;
import id.mdh.pilgubjateng.fragment.InputTPSFragment;
import id.mdh.pilgubjateng.fragment.ProfileFragment;
import id.mdh.pilgubjateng.fragment.RegistrationTPSFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set the first home fragment
        Fragment fragment = new HomeFragment();
        setFirstFragment(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        } else if (id == R.id.nav_regis_tps) {
            fragment = new RegistrationTPSFragment();
        } else if (id == R.id.nav_catat_tps) {
            fragment = new InputTPSFragment();
        } else if (id == R.id.nav_rekam_tps) {
            fragment = new InputHistoryTPSFragment();
        } else if (id == R.id.nav_profil) {
            fragment = new ProfileFragment();
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
}
