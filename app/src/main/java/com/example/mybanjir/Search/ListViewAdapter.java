package com.example.mybanjir.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mybanjir.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
    List view adapter class
 */
public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<LocationNames> locationNamesList = null;
    private ArrayList<LocationNames> arraylist;

    public ListViewAdapter(Context context, ArrayList<LocationNames> locationNamesList) {
        mContext = context;
        this.locationNamesList = locationNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<LocationNames>();
        this.arraylist.addAll(locationNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return locationNamesList.size();
    }

    @Override
    public LocationNames getItem(int position) {
        return locationNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(locationNamesList.get(position).getLocationName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        locationNamesList.clear();
        if (charText.length() == 0) {
            locationNamesList.addAll(arraylist);
        } else {
            for (LocationNames wp : arraylist) {
                if (wp.getLocationName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    locationNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}