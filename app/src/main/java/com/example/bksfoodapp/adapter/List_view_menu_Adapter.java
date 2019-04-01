package com.example.bksfoodapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bksfoodapp.R;
import com.example.bksfoodapp.model.List_view_menu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class List_view_menu_Adapter extends BaseAdapter {
    ArrayList<List_view_menu> arrayList;
    Context context;

    public List_view_menu_Adapter(ArrayList<List_view_menu> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView textView;
        ImageView imageView;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item,null);
            viewHolder.textView = (TextView) view.findViewById(R.id.text_view1);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image_view_list);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        List_view_menu list_view_menu = (List_view_menu) getItem(position);
        viewHolder.textView.setText(list_view_menu.getName());
        Picasso.with(context).load(list_view_menu.getImage())
                .into(viewHolder.imageView);
        return view;
    }

}
