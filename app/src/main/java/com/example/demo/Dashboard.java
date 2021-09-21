package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables
    CardView callUpLocation, callUpCompetitors, callUpInformation;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        callUpLocation = findViewById(R.id.location);
        callUpInformation = findViewById(R.id.information);
        callUpCompetitors = findViewById(R.id.competitors);

        callUpLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, activity_permission.class);
                startActivity(intent);
            }
        });

        callUpInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Informatiomi.class);
                startActivity(intent);
            }
        });

        callUpCompetitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, MapActivity.class);
                startActivity(intent);
            }
        });

        //HOOKS
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //TOOL BAR
        setSupportActionBar(toolbar);

        //NAVIGATION
        //show or hide items esp the login
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.logout).setVisible(false);
        menu.findItem(R.id.profile).setVisible(false);

        //------------------------------------------
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar , R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //make menu clickable
        navigationView.setNavigationItemSelectedListener(this);
        //make sure it loads home when launched
        navigationView.setCheckedItem(R.id.home);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
        super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.home:
                break;
            case R.id.CardView:
                Intent intent = new Intent(Dashboard.this, activity_permission.class);
                startActivity(intent);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
