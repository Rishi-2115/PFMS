package com.example.keshri_rakesh.pfms;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class Expensemanager extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expensemanager);


        //android.support.v7.widget.Toolbar Toolbar  = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(Toolbar);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.content_main);
         relativeLayout.setBackgroundColor(Color.WHITE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
              this, drawer, /*Toolbar*/ R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Overview fragment = new Overview();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment, "Overview");
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.add_record:
                startActivity(new Intent(this, Tab2.class));
                return true;

            case R.id.action_1:
                startActivity(new Intent(this, Setting.class));
                return true;

            // case R.id.action_1:
            //  return true;

            //case R.id.exit:
            //  finish();
            //return true;
        }/*

                if (id == R.id.action_red){
                    relativeLayout.setBackgroundColor(Color.RED);
                    return true;
                }
                else if (id == R.id.action_blue){
                    relativeLayout.setBackgroundColor(Color.BLUE);
                    return true;
                }
                else if (id == R.id.action_yellow){
                    relativeLayout.setBackgroundColor(Color.YELLOW);
                    return true;
                }
                else if (id == R.id.action_green){
                    relativeLayout.setBackgroundColor(Color.GREEN);
                    return true;
                } */



        if (id == R.id.Overview) {
            setTitle("Overview");
            Overview fragment = new Overview();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Overview");
            fragmentTransaction.commit();
        } else if (id == R.id.History) {
            setTitle("History");
            History fragment = new History();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "History");
            fragmentTransaction.commit();
        } else if (id == R.id.Graph_all) {
            setTitle("Graph");
            Graph_all fragment = new Graph_all();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Graphs");
            fragmentTransaction.commit();
        }else if (id == R.id.Distribution) {
            setTitle("Distribution");
            Distribution fragment = new Distribution();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Add");
            fragmentTransaction.commit();
        }

        return super.onOptionsItemSelected(item);
    }

   // @Override
   // public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       // return false;
   // }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
   public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
       int id = item.getItemId();

        if (id == R.id.Overview) {
            setTitle("Overview");
            Overview fragment = new Overview();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Overview");
            fragmentTransaction.commit();
        } else if (id == R.id.History) {
            setTitle("History");
            History fragment = new History();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "History");
            fragmentTransaction.commit();
        } else if (id == R.id.Graph_all) {
            setTitle("Graph");
            Graph_all fragment = new Graph_all();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Graphs");
            fragmentTransaction.commit();
        }else if (id == R.id.Distribution) {
            setTitle("Distribution");
            Distribution fragment = new Distribution();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment, "Add");
            fragmentTransaction.commit();
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
}
