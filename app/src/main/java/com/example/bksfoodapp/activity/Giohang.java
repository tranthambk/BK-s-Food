package com.example.bksfoodapp.activity;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bksfoodapp.R;
import com.example.bksfoodapp.adapter.GiohangAdapter;

import java.text.DecimalFormat;

public class Giohang extends AppCompatActivity {

    ListView lvgiohang;
    TextView txtThongbao;
    static TextView txtTonggiatri;
    Button btnthanhtoan,btntieptucmua;
    Toolbar toolbargiohang;
    GiohangAdapter giohangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        Anhxa();
        Actionbar();
        Checkdata();
        EvenUtil();
        CatchOnItemListView();
    }

    private void CatchOnItemListView() {
        lvgiohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Giohang.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (MainActivity.giohang.size()<=0){
                            txtThongbao.setVisibility(View.VISIBLE);
                        } else {
                            MainActivity.giohang.remove(position);
                            giohangAdapter.notifyDataSetChanged();
                            EvenUtil();
                            if (MainActivity.giohang.size()<=0){
                                txtThongbao.setVisibility(View.VISIBLE);
                            } else {
                                txtThongbao.setVisibility(View.INVISIBLE);
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        giohangAdapter.notifyDataSetChanged();
                        EvenUtil();
                    }
                });
                builder.show();
                return true;
            }
        });
    }


    public static void EvenUtil() {
        long tongtien = 0;
        for (int i = 0; i<MainActivity.giohang.size();i++){
            tongtien += MainActivity.giohang.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTonggiatri.setText(decimalFormat.format(tongtien) + "đồng");
    }

    private void Checkdata() {
        if (MainActivity.giohang.size() <= 0 ){
            giohangAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.VISIBLE);
            lvgiohang.setVisibility(View.INVISIBLE);
        } else {
            giohangAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.INVISIBLE);
            lvgiohang.setVisibility(View.VISIBLE);

        }
    }

    private void Actionbar() {
        setSupportActionBar(toolbargiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbargiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        lvgiohang = (ListView) findViewById(R.id.listview_gio_hang);
        txtThongbao = (TextView) findViewById(R.id.textviewthongbao);
        txtTonggiatri = (TextView) findViewById(R.id.textviewgiatri);
        btnthanhtoan = (Button) findViewById(R.id.btn_thanh_toan);
        btntieptucmua = (Button) findViewById(R.id.btn_tiep_tuc_mua);
        toolbargiohang = (Toolbar) findViewById(R.id.toolbar_gio_hang);
        giohangAdapter = new GiohangAdapter(getApplicationContext(),MainActivity.giohang);
        lvgiohang.setAdapter(giohangAdapter);
    }
}
