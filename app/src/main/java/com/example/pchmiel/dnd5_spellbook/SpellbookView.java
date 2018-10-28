package com.example.pchmiel.dnd5_spellbook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import Logic.ProfileList;

public class SpellbookView extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.header_spellbook);
        setContentView(R.layout.activity_spellbook_view);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        ListView listView = (ListView) findViewById(R.id.profiles_list);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {
                            case R.id.nav_profiles: {
                                Toast.makeText(SpellbookView.this, "Profiles", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SpellbookView.this, ProfileListView.class);
                                startActivity(intent);
                                break;
                            }
                            case R.id.nav_spellbook: {
                                //ProfileListView.this.finish();
                                Toast.makeText(SpellbookView.this, "You're already in spellbook view", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }

                        return true;
                    }
                }

        );


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        hideOption(R.id.action_addNewProfile);
        return super.onCreateOptionsMenu(menu);
    }

    private void hideOption(int id) {
        menu.findItem(id).setVisible(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }


        return super.onOptionsItemSelected(item);
    }
}

