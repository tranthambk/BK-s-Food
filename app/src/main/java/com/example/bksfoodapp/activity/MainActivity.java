package com.example.bksfoodapp.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.bksfoodapp.R;
import com.example.bksfoodapp.adapter.List_view_menu_Adapter;
import com.example.bksfoodapp.adapter.SanphamAdapter;
import com.example.bksfoodapp.model.Giohang_item;
import com.example.bksfoodapp.model.List_view_menu;
import com.example.bksfoodapp.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    ListView ListView_trang_chinh;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ListView listView;
    ArrayList<List_view_menu> mang_menu;
    List_view_menu_Adapter list_view_menu_adapter;
    int id = 0;
    String Name = "";
    String Image = "";
    ArrayList<Sanpham> mang_sp;
    SanphamAdapter sanphamAdapter;
    public static  ArrayList<Giohang_item> giohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Actionbar();
        ActionViewFlipper();
        GetDataLoaiSanpham();
        Getsanpham();
        CatchClick_Listview();
        CatchClick_sanpham();
    }

    private void CatchClick_sanpham() {
        ListView_trang_chinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,chitietsanpham.class);
                intent.putExtra("Thongtinsanpham",mang_sp.get(position));
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    private void Getsanpham() {
        for (int i = 0; i<32; i++) {
            mang_sp.add(i, new Sanpham(i, "Test" , i*1000, "https://mtc1-dydfxmh.netdna-ssl.com/wp-content/uploads/2017/06/ultimate-beach-road-guide-1300x929.jpg", "Đéo bán"));
        }
    }

    private void CatchClick_Listview() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this,food.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this,Lienhe.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this,Giohang.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
            }
        });
    }

    private void GetDataLoaiSanpham(){
        mang_menu.add(0,new List_view_menu(0,"Trang Chính","https://static.thenounproject.com/png/610387-200.png"));
        mang_menu.add(1,new List_view_menu(1,"Thức ăn","https://banner2.kisspng.com/20180724/gqy/kisspng-restaurant-drawing-coloring-book-menu-food-5b57f2b21374d8.2804758615324904180797.jpg"));
        mang_menu.add(2,new List_view_menu(2,"Liên hệ", "http://www.lab-maastricht.com/images/2016/09/20/contact-clipart-contact2.png"));
        mang_menu.add(3,new List_view_menu(3,"Giỏ hàng", "http://www.lab-maastricht.com/images/2016/09/20/contact-clipart-contact2.png"));
    }

    private void ActionViewFlipper() {
        ArrayList<String> mang_quang_cao = new ArrayList<>();
        mang_quang_cao.add("https://www.wur.nl/upload_mm/2/e/3/e8eaaee8-3c29-44c4-8cd9-a722a43b0d81_schijfvanvijf_sh_306293987_blog_4909f6b8_490x330.jpg");
        mang_quang_cao.add("https://ichef.bbci.co.uk/food/ic/food_16x9_832/recipes/one_pot_chorizo_and_15611_16x9.jpg");
        mang_quang_cao.add("https://www.bbcgoodfood.com/sites/default/files/guide/guide-image/2018/06/chicken-wings-main.jpg");
        for (int i = 0; i < mang_quang_cao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mang_quang_cao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void Actionbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        toolbar = (Toolbar) findViewById(R.id.ToolBar_trangchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        ListView_trang_chinh = (ListView) findViewById(R.id.listviewsanpham);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.Drawer_layout);
        listView = (ListView) findViewById(R.id.list_view_trang_chinh);
        mang_menu = new ArrayList<>();
        list_view_menu_adapter = new List_view_menu_Adapter(mang_menu, getApplicationContext());
        listView.setAdapter(list_view_menu_adapter);

        mang_sp = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getApplicationContext(),mang_sp);
        ListView_trang_chinh.setAdapter(sanphamAdapter);
        if (giohang != null){

        } else {
            giohang = new ArrayList<>();
        }

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


