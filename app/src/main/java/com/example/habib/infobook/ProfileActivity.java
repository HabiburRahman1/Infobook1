package com.example.habib.infobook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        HomeFragment homeFragment=new HomeFragment();
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment,homeFragment).commit();

    }
    private int exit=0;

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            exit=exit+1;
            if(exit==1){
                HomeFragment homeFragment=new HomeFragment();
                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.fragment,homeFragment).commit();
            }
            else if(exit==2){
                exit=0;
                moveTaskToBack(true);

            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
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
            Toast.makeText(this,"Profile setting",Toast.LENGTH_SHORT).show();
            Profile_setting_Fragment profile_setting_fragment=new Profile_setting_Fragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment,profile_setting_fragment).commit();
        }else if(id==R.id.logout){
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this,"Successfully signOut",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ProfileActivity.this, LogIn.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.nav_camera) {

            HomeFragment homeFragment=new HomeFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment,homeFragment).commit();

        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this,"Free Classroom",Toast.LENGTH_SHORT).show();
            FreeClassRoom freeClassRoom=new FreeClassRoom();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment,freeClassRoom).commit();

        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this,"Free Seat in Library",Toast.LENGTH_SHORT).show();
            FreeSeatFragment freeSeatFragment=new FreeSeatFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment,freeSeatFragment).commit();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            Toast.makeText(this,"Compare",Toast.LENGTH_SHORT).show();
            ClassRoutineFragment classRoutineFragment=new ClassRoutineFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment,classRoutineFragment).commit();

        } else if (id == R.id.nav_send) {
            intent = new Intent(ProfileActivity.this, MessageWithProfile.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
