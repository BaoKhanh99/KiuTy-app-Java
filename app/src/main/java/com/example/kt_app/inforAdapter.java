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
public class inforAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<resultsearch> resultsearchList;

    public inforAdapter(Context context, int layout, List<resultsearch> resultsearchList) {
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
        TextView title;
        TextView txt_infor;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.title = convertView.findViewById(R.id.title_infor);
            holder.txt_infor = convertView.findViewById(R.id.txtinfo);

            holder.img = convertView.findViewById(R.id.image_infor);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        resultsearch resultsearch = resultsearchList.get(position);
        holder.title.setText(resultsearch.getDestination());
        holder.txt_infor.setText(resultsearch.getInfor());
        Picasso.with(context).load(resultsearch.getImg()).into(holder.img);
        return convertView;
    }
}
