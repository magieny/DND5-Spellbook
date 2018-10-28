package com.example.pchmiel.dnd5_spellbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import Logic.ProfileList;


public class ProfileListView extends AppCompatActivity{

    private DrawerLayout mDrawerLayout;
    private Menu menu;
    private ListActivity listActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list;
        setTitle(R.string.header_profiles);

        setContentView(R.layout.activity_profile_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        ListView listView = (ListView)findViewById(R.id.profiles_list);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()){
                            case R.id.nav_profiles: {
                                Toast.makeText(ProfileListView.this, "You're already in profile view", Toast.LENGTH_SHORT).show();
                                break;
                            }
                            case R.id.nav_spellbook: {
                                //ProfileListView.this.finish();
                                Intent intent = new Intent(ProfileListView.this, SpellbookView.class);
                                startActivity(intent);
                                Toast.makeText(ProfileListView.this, "Spellbook", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }

                        return true;
                    }
                }

        );
        final String[] itemname ={
                "Magieny",
                "Adalar",
                "Koło",
                "Ivan Wielki"
        };
        final String[] race ={
                "Human",
                "Adam",
                "Błotnik",
                "Koszykarz"
        };

        final String[] prof ={
                "Cleric (Death) Lvl 2",
                "Adolf (Rudolf) Lvl up!",
                "Wycieraczka (Zderzak) Lvl złom",
                "Bramkarz (NHL) Lvl 69"
        };

        Integer imgid = R.drawable.ic_action_edit;

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid, race, prof);
        list=(ListView)findViewById(R.id.profiles_list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), "Armor up! "+Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        hideOption(R.id.action_filter);
        hideOption(R.id.action_search);
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

        if(id == R.id.action_addNewProfile){
            Toast.makeText(ProfileListView.this,"Added new profile", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
