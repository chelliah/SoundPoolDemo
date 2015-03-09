package aron.soundpooldemo;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aronthomas on 3/8/15.
 */

public class soundAdapter extends ArrayAdapter<sound>{
    private ArrayList<sound> items;
    private Context c = null;
    public soundAdapter(Context context, int textViewResourceId, ArrayList<sound> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.c = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_row, null);
        }
        sound s = items.get(position);
        if (s != null) {
            TextView description = (TextView) v.findViewById(R.id.description);
            if (description != null) {
                description.setText(s.getDescription());
            }
            ImageView icon = (ImageView) v.findViewById(R.id.icon);
            icon.setImageResource(s.getIconResourceId());
        }
        return v;
    }
}