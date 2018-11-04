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

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import Logic.ProfileList;


public class ProfileListView extends AppCompatActivity{
    public ArrayList<ProfileList> profileLists = new ArrayList<>();
    private DrawerLayout mDrawerLayout;
    private Menu menu;
    ListView list;




    private ListActivity listActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        /*final String[] profileName ={
                "Magieny",
                "Adalar",
                "Koło",
                "Ivan Wielki"
        };*/
//        final String[] race ={
//                "Human",
//                "Adam",
//                "Błotnik",
//                "Koszykarz"
//        };
//
//        final String[] prof ={
//                "Cleric",
//                "Paladin",
//                "Druid",
//                "Cleric"
//        };
//
//        final String[] archetype ={
//                "Death",
//                "Protector",
//                "Forest",
//                "War"
//        };
//
//        final String[] lvl ={
//                "2",
//                "12",
//                "22",
//                "3"
//        };

        final String profileName = "Vino";
        String race = "Human";
        String prof = "Cleric";
        String archetype = "War";
        String lvl = "4";
        //profileLists.add(new ProfileList("Vino","Human", "Cleric", "War", "3"));
        Integer imgid = R.drawable.ic_action_edit;

        CustomListAdapter adapter=new CustomListAdapter(this, profileName, imgid, race, prof, archetype, lvl);
        //adapter = new ArrayAdapter<ProfileList>(this, R.layout.list_row, profileLists);
        list=(ListView)findViewById(R.id.profiles_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = profileName;
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
        hideOption(R.id.action_applysettings);
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

            Intent intent = new Intent(ProfileListView.this, AddProfileView.class);
            startActivity(intent);

//            CustomListAdapter adapter=new CustomListAdapter(this, profileName, imgid, race, prof, archetype, lvl);
//            list=(ListView)findViewById(R.id.profiles_list);
//            adapter.notifyDataSetChanged();
//            list.setAdapter(adapter);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
