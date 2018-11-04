package com.example.pchmiel.dnd5_spellbook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import Logic.ProfileList;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer imgid;
    private final String race;
    private final String profileName;
    private final String prof;
    private final String archetype;
    private final String profLvl;

    public CustomListAdapter(Activity context, String profileName, Integer imgid, String race, String prof, String archetype, String profLvl) {
        super(context, R.layout.list_row, Collections.singletonList(profileName));
        // TODO Auto-generated constructor stub

        this.context = context;
        this.profileName = profileName;
        this.imgid = imgid;
        this.race = race;
        this.prof = prof;
        this.archetype = archetype;
        this.profLvl = profLvl;


    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_row, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.profile_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.profile_icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.profile_race);
        TextView profession = (TextView) rowView.findViewById(R.id.profile_class);
        TextView archetypeC = (TextView) rowView.findViewById(R.id.profile_archetype);
        TextView profileLvl = (TextView) rowView.findViewById(R.id.profile_lvl);

        txtTitle.setText(profileName);
        imageView.setImageResource(imgid);
        extratxt.setText(race);
        profession.setText(prof);
        archetypeC.setText("("+archetype+")");
        profileLvl.setText("Lvl " + profLvl);
        return rowView;

    }
}
