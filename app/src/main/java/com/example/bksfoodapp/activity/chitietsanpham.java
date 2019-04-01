package com.example.bksfoodapp.activity;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bksfoodapp.R;
import com.example.bksfoodapp.model.Giohang_item;
import com.example.bksfoodapp.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class chitietsanpham extends AppCompatActivity {

    int id = 0;
    String tenchitiet = "";
    int giachitiet = 0;
    String hinhanhchitiet = "";
    String motachitiet = "";

    android.support.v7.widget.Toolbar toolbarchitiet;
    ImageView imgChitiet;
    TextView txtten,txtgia,txtmota;
    Spinner spinner;
    Button btngiohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);
        Anhxa();
        ActionToolbar();
        GetInformation();
        Catcheventspinner();
        Eventbutton();
    }

    private void Eventbutton() {
        btngiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.giohang.size()>0){
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exit = false;
                    for (int i = 0; i< MainActivity.giohang.size();i++){
                        if (MainActivity.giohang.get(i).getId() == id){
                            MainActivity.giohang.get(i).setSoluongsp(MainActivity.giohang.get(i).getSoluongsp()+sl);
                            if (MainActivity.giohang.get(i).getSoluongsp() >= 10){
                                MainActivity.giohang.get(i).setSoluongsp(10);
                            }
                            MainActivity.giohang.get(i).setGiasp(giachitiet * MainActivity.giohang.get(i).getSoluongsp());
                            exit = true;
                        }
                    }
                    if (exit == false){
                        int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                        long giamoi = soluong * giachitiet;
                        MainActivity.giohang.add(new Giohang_item(id,tenchitiet,giamoi,hinhanhchitiet,soluong));
                    }

                } else {
                    int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                    long giamoi = soluong * giachitiet;
                    MainActivity.giohang.add(new Giohang_item(id,tenchitiet,giamoi,hinhanhchitiet,soluong));
                }
                Intent intent = new Intent(getApplicationContext(),Giohang.class);
                startActivity(intent);
            }
        });
    }

    private void Catcheventspinner() {
        Integer[] Soluong = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, Soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInformation(){
        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("Thongtinsanpham");
        id = sanpham.getID();
        tenchitiet = sanpham.getName();
        giachitiet = sanpham.getPrice();
        hinhanhchitiet = sanpham.getImage();
        motachitiet = sanpham.getDes();

        txtten.setText(tenchitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgia.setText("Giá " + decimalFormat.format(giachitiet)+" đồng");
        txtmota.setText(motachitiet);
        Picasso.with(getApplicationContext()).load(hinhanhchitiet).into(imgChitiet);
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarchitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarchitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbarchitiet = (Toolbar) findViewById(R.id.toolbar_chi_tiet_san_pham);
        imgChitiet = (ImageView) findViewById(R.id.hinhanh_chi_tiet_san_pham);
        txtten = (TextView) findViewById(R.id.tensanpham_chi_tiet_san_pham);
        txtgia = (TextView) findViewById(R.id.giasanpham_chi_tiet_san_pham);
        txtmota = (TextView) findViewById(R.id.textview_mo_ta_san_pham);
        spinner = (Spinner) findViewById(R.id.spinner_chi_tiet_san_pham);
        btngiohang = (Button) findViewById(R.id.button_chi_tiet_san_pham);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent = new Intent(getApplicationContext(),Giohang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
