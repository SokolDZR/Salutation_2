package com.example.ordi.salutation;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DataInputFragment fDataInput;
    SelectSalutationFragment fSelectSalutation;
    InstructionFragment fInstruction;
    AboutUsFragment fAboutUs;
    SettingsFragment fSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton navigationFab = (FloatingActionButton) findViewById(R.id.NavigationFab);
        navigationFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
                fTrans.replace(R.id.container, fSelectSalutation);
                fTrans.commit();
                navigationFab.hide();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fDataInput = new DataInputFragment();
        fSelectSalutation = new SelectSalutationFragment();
        fInstruction = new InstructionFragment();
        fAboutUs = new AboutUsFragment();
        fSettings = new SettingsFragment();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        final FloatingActionButton navigationFab = (FloatingActionButton) findViewById(R.id.NavigationFab);
        int id = item.getItemId();
        FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.addToBackStack(null);
        if (id == R.id.selectSalutation) {
            fTrans.replace(R.id.container, fSelectSalutation);
            navigationFab.hide();
            setTitle(getString(R.string.title_select_salutation));
        } else if (id == R.id.settings_item) {
            fTrans.replace(R.id.container, fSettings);
            setTitle(getString(R.string.title_select_salutation));
            navigationFab.show();
        } else if (id == R.id.aboutUs_item) {
            fTrans.replace(R.id.container, fAboutUs);
            setTitle(getString(R.string.title_about_us));
            navigationFab.show();
        } else if (id == R.id.instruction_item) {
            fTrans.replace(R.id.container, fInstruction);
            setTitle(getString(R.string.title_instruction));
            navigationFab.show();
        }
        fTrans.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
