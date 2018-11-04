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

public class CustomClassListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String className;
    private final String level;
    private final String spellSave;
    private final String spellAtt;

    public CustomClassListAdapter(Activity context, String className,  String level, String spellSave, String spellAtt) {
        super(context, R.layout.classlist_row, Collections.singletonList(className));
        // TODO Auto-generated constructor stub

        this.context = context;
        this.className = className;
        this.level = level;
        this.spellSave = spellSave;
        this.spellAtt = spellAtt;


    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.classlist_row, null, true);

        TextView classDesc = (TextView) rowView.findViewById(R.id.class_name);
        TextView classLvl = (TextView) rowView.findViewById(R.id.class_level);
        TextView classSpellSave = (TextView) rowView.findViewById(R.id.class_spellsave);
        TextView classSpellAtt = (TextView) rowView.findViewById(R.id.class_spellatt);


        classDesc.setText(className);
        classLvl.setText(level);
        classSpellSave.setText(spellSave);
        classSpellAtt.setText(spellAtt);

        return rowView;

    }
}
