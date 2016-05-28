package com.example.user.biodata;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AlumniFragment.OnContentItemClickListener {

    Toolbar toolbar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolBar();
        setUpContent();
        setUpNavigationDrawer();
    }

    private void setUpToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
       /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    private void setUpContent() {
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_fragment,new HomeFragment()).commit();
    }

    private void setUpNavigationDrawer(){
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

    @SuppressWarnings("StatementWithEmptyBody")
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            //Intent i = new Intent(this, AlumniFragment.class);
            //startActivity(i);
            getSupportActionBar().setTitle("Home");
            fragmentManager.beginTransaction().replace(R.id.frame_fragment, new HomeFragment()).commit();
        } else if (id == R.id.nav_alumni) {
            //ListAlumniActivity
            getSupportActionBar().setTitle("Alumni");
            Bundle b = new Bundle();
            b.putInt("tipe", 0);
            AlumniFragment alumniFragment = new AlumniFragment();
            alumniFragment.setArguments(b);
            fragmentManager.beginTransaction().replace(R.id.frame_fragment, alumniFragment).commit();
        } else if (id == R.id.nav_best) {
            getSupportActionBar().setTitle("Best Alumni");
            Bundle b = new Bundle();
            b.putInt("tipe",1);
            AlumniFragment alumniFragment = new AlumniFragment();
            alumniFragment.setArguments(b);
            fragmentManager.beginTransaction().replace(R.id.frame_fragment, alumniFragment).commit();
        } else if (id == R.id.nav_about) {
            getSupportActionBar().setTitle("About");
            fragmentManager.beginTransaction().replace(R.id.frame_fragment, new AboutFragment()).commit();
        } else if (id == R.id.nav_help) {
            getSupportActionBar().setTitle("Help");
            fragmentManager.beginTransaction().replace(R.id.frame_fragment, new HelpFragment()).commit();
        } else if (id == R.id.nav_exit) {
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onContentItemClick(String npm){
       Intent i = new Intent(this, AlumniDetailActivity.class) ;
       i.putExtra("npm", npm);
        startActivity(i);
    }
}
