package com.example.pchmiel.dnd5_spellbook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer imgid;
    private final String[] race;
    private final String[] prof;

    public CustomListAdapter(Activity context, String[] itemname, Integer imgid, String[] race, String[] prof) {
        super(context, R.layout.list_row, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        this.race = race;
        this.prof = prof;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_row, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.profile_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.profile_icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.profile_race);
        TextView profession = (TextView) rowView.findViewById(R.id.profile_class);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid);
        extratxt.setText(race[position]);
        profession.setText(prof[position]);
        return rowView;

    }

    ;
}
