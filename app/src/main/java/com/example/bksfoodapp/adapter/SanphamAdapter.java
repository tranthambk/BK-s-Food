package com.example.bksfoodapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bksfoodapp.R;
import com.example.bksfoodapp.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanphamAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arraySanpham;

    public SanphamAdapter(Context context, ArrayList<Sanpham> arraySanpham) {
        this.context = context;
        this.arraySanpham = arraySanpham;
    }

    @Override
    public int getCount() {
        return arraySanpham.size();
    }

    @Override
    public Object getItem(int position) {
        return arraySanpham.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ItemHolder{
        public ImageView hinhanhSanpham;
        public TextView tenSanpham;
        public TextView giaSanpham;
    };

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemHolder viewHolder = null;
        if (view == null){
            viewHolder = new ItemHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_sanpham,null);
            viewHolder.tenSanpham = (TextView) view.findViewById(R.id.tensanpham);
            viewHolder.hinhanhSanpham = (ImageView) view.findViewById(R.id.hinhanhsanpham);
            viewHolder.giaSanpham = (TextView) view.findViewById(R.id.giasanpham);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ItemHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.tenSanpham.setText(sanpham.getName());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.giaSanpham.setText("Giá " + decimalFormat.format(sanpham.getPrice())+" đồng");
        Picasso.with(context).load(sanpham.getImage()).into(viewHolder.hinhanhSanpham);
        return view;
    }

}
