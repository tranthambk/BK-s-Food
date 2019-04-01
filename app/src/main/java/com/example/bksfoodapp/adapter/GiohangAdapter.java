package com.example.bksfoodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bksfoodapp.R;
import com.example.bksfoodapp.activity.Giohang;
import com.example.bksfoodapp.activity.MainActivity;
import com.example.bksfoodapp.model.Giohang_item;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GiohangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Giohang_item> arrayList;

    public GiohangAdapter(Context context, ArrayList<Giohang_item> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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

    public class ViewHolderGioHang{
        public TextView txttengiohang,txtgiagiohang;
        public ImageView imggiohang;
        public Button btnminus,btnvalues,btnplus;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolderGioHang viewHolderGioHang = null;
        if (convertView == null){
            viewHolderGioHang = new ViewHolderGioHang();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_giohang,null);
            viewHolderGioHang.txttengiohang = (TextView) convertView.findViewById(R.id.textviewtengiohang);
            viewHolderGioHang.txtgiagiohang = (TextView) convertView.findViewById(R.id.textviewgiagiohang);
            viewHolderGioHang.imggiohang = (ImageView) convertView.findViewById(R.id.imageviewgiohang);
            viewHolderGioHang.btnminus = (Button) convertView.findViewById(R.id.button_tru);
            viewHolderGioHang.btnvalues = (Button) convertView.findViewById(R.id.button_giatri);
            viewHolderGioHang.btnplus = (Button) convertView.findViewById(R.id.button_cong);
            convertView.setTag(viewHolderGioHang);
        } else {
            viewHolderGioHang = (ViewHolderGioHang) convertView.getTag();
        }
        final Giohang_item giohang_item = (Giohang_item) getItem(position);
        viewHolderGioHang.txttengiohang.setText(giohang_item.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolderGioHang.txtgiagiohang.setText(decimalFormat.format(giohang_item.getGiasp()) + "đồng");
        Picasso.with(context).load(giohang_item.getHinhanhsanpham()).into(viewHolderGioHang.imggiohang);
        viewHolderGioHang.btnvalues.setText(giohang_item.getSoluongsp() + "");
        final int sl = Integer.parseInt(viewHolderGioHang.btnvalues.getText().toString());
        if (sl>= 10){
            viewHolderGioHang.btnplus.setVisibility(View.INVISIBLE);
            viewHolderGioHang.btnminus.setVisibility(View.VISIBLE);
        } else if (sl<=1){
            viewHolderGioHang.btnplus.setVisibility(View.VISIBLE);
            viewHolderGioHang.btnminus.setVisibility(View.INVISIBLE);
        } else {
            viewHolderGioHang.btnplus.setVisibility(View.VISIBLE);
            viewHolderGioHang.btnminus.setVisibility(View.VISIBLE);
        }
        final ViewHolderGioHang finalViewHolderGioHang = viewHolderGioHang;
        viewHolderGioHang.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolderGioHang.btnvalues.getText().toString()) + 1;
                int slhientai = MainActivity.giohang.get(position).getSoluongsp();
                long giaht = MainActivity.giohang.get(position).getGiasp();
                MainActivity.giohang.get(position).setSoluongsp(slmoinhat);
                long giamoi = slmoinhat * giaht / slhientai;
                MainActivity.giohang.get(position).setGiasp(giamoi);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolderGioHang.txtgiagiohang.setText(decimalFormat.format(giohang_item.getGiasp()) + "đồng");
                Giohang.EvenUtil();
                if (slmoinhat > 9){
                    finalViewHolderGioHang.btnplus.setVisibility(View.INVISIBLE);
                    finalViewHolderGioHang.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolderGioHang.btnvalues.setText(String.valueOf(slmoinhat));
                } else {
                    finalViewHolderGioHang.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolderGioHang.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolderGioHang.btnvalues.setText(String.valueOf(slmoinhat));
                }
            }
        });
        viewHolderGioHang.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolderGioHang.btnvalues.getText().toString()) - 1;
                int slhientai = MainActivity.giohang.get(position).getSoluongsp();
                long giaht = MainActivity.giohang.get(position).getGiasp();
                MainActivity.giohang.get(position).setSoluongsp(slmoinhat);
                long giamoi = slmoinhat * giaht / slhientai;
                MainActivity.giohang.get(position).setGiasp(giamoi);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolderGioHang.txtgiagiohang.setText(decimalFormat.format(giohang_item.getGiasp()) + "đồng");
                Giohang.EvenUtil();
                if (slmoinhat < 2){
                    finalViewHolderGioHang.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolderGioHang.btnminus.setVisibility(View.INVISIBLE);
                    finalViewHolderGioHang.btnvalues.setText(String.valueOf(slmoinhat));
                } else {
                    finalViewHolderGioHang.btnplus.setVisibility(View.VISIBLE);
                    finalViewHolderGioHang.btnminus.setVisibility(View.VISIBLE);
                    finalViewHolderGioHang.btnvalues.setText(String.valueOf(slmoinhat));
                }
            }
        });
        return convertView;
    }
}
