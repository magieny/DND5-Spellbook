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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class AddProfileView extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Menu menu;

    ListView classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(R.string.header_newProfile);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_profile_view);
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
                                AddProfileView.this.finish();
                                Intent intent = new Intent(AddProfileView.this, ProfileListView.class);
                                startActivity(intent);
                                break;
                            }
                            case R.id.nav_spellbook: {
                                Intent intent = new Intent(AddProfileView.this, SpellbookView.class);
                                startActivity(intent);
                                break;
                            }

                        }

                        return true;
                    }
                }

        );
        String[] arraySpinner = new String[]{
                "Human", "Dwarf", "Elf", "Halfling", "Aasimar", "Goliath", "Drow"
        };
        Spinner s = (Spinner) findViewById(R.id.race_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        final String classDesc = "Cleric (Death)";
        String classLevel = "4";
        String classSpellSave = "14";
        String classSpellAtt = "6";

        CustomClassListAdapter classListadapter = new CustomClassListAdapter(this, classDesc, classLevel, classSpellSave, classSpellAtt);
        classList = (ListView) findViewById(R.id.newprofile_class_list);
        classList.setAdapter(classListadapter);
        classList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = classDesc;
                Toast.makeText(getApplicationContext(), "Oh no... " + Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        hideOption(R.id.action_addNewProfile);
        hideOption(R.id.action_search);
        hideOption(R.id.action_filter);
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

