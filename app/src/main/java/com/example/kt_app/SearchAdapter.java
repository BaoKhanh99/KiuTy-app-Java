package com.example.kt_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
public class SearchAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<resultsearch> resultsearchList;

    public SearchAdapter(Context context, int layout, List<resultsearch> resultsearchList) {
        this.context = context;
        this.layout = layout;
        this.resultsearchList = resultsearchList;
    }

    @Override
    public int getCount() {
        return resultsearchList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{
        TextView txt_destination;
        TextView txt_city;
        TextView txt_point;
        TextView txt_comments;
        ImageView img;
        String listView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txt_destination = convertView.findViewById(R.id.txt_destination);
            holder.txt_city = convertView.findViewById(R.id.txt_city);
            holder.txt_point = convertView.findViewById(R.id.txt_point);
            holder.txt_comments = convertView.findViewById(R.id.txt_comments);
            holder.img = convertView.findViewById(R.id.images);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        resultsearch resultsearch = resultsearchList.get(position);
        holder.txt_destination.setText(resultsearch.getDestination());
        holder.txt_city.setText(resultsearch.getCity());
        holder.txt_point.setText(""+resultsearch.getPoint());
        holder.txt_comments.setText(resultsearch.getComment());
        Picasso.with(context).load(resultsearch.getImg()).into(holder.img);
        holder.listView = resultsearch.getCity();
        return convertView;
    }
}
