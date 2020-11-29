package com.example.shopee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.shopee.shopee_feed.AdapterOfListMenu;
import com.example.shopee.shopee_feed.List_Menu;
import com.example.shopee.shopee_feed.posts.AdapterPosts;
import com.example.shopee.shopee_feed.posts.post;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView();
        toolBar();
        addControler();
    }

    //add controler
    private void addControler(){
        init_ListToolBar();
        init_Posts();
    }

    //setmenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toobar_shopeefeed,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //set toolbar
    private void toolBar(){
        toolbar = findViewById(R.id.toolBar_shopeeFeed);
        toolbar.setTitle("Shopee Feed");

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_search);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    //Hiện thị list toolbar
    public  void init_ListToolBar(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_dsmenu);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<List_Menu> arrayList =  new ArrayList<>();
        arrayList.add(new List_Menu(R.drawable.thoi_gian,"Thời Gian"));
        arrayList.add(new List_Menu(R.drawable.review,"Shopee Review"));
        arrayList.add(new List_Menu(R.drawable.idol,"Shopee Idol"));
        arrayList.add(new List_Menu(R.drawable.make_up,"Làm đẹp"));
        arrayList.add(new List_Menu(R.drawable.thoitrang,"Thời Trang"));
        arrayList.add(new List_Menu(R.drawable.songchat,"Sống Chất"));
        arrayList.add(new List_Menu(R.drawable.sale,"Siêu Sale"));
        arrayList.add(new List_Menu(R.drawable.khampha,"Khám Phá"));

        AdapterOfListMenu adapter = new AdapterOfListMenu(arrayList,getApplicationContext(),R.layout.row_listmenu);
        recyclerView.setAdapter(adapter);

    }
    //Hiện thị posts
    //Hiện thị list toolbar
    public  void init_Posts(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_posts);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<post> arrayList =  new ArrayList<>();
        arrayList.add(new post(R.drawable.logo_suxi,"Su.xi.vn",R.drawable.post1,1040,200,300));
        arrayList.add(new post(R.drawable.logo_jg,"Jungjan.vn",R.drawable.post2,400,200,300));
        arrayList.add(new post(R.drawable.logo_tuni,"Tuni Store",R.drawable.post3,100,200,30));
        arrayList.add(new post(R.drawable.tuenhishop,"TueNhiShop",R.drawable.post4,400,100,90));
        arrayList.add(new post(R.drawable.logo_shopee,"Shopeevn",R.drawable.post5,100,800,300));

        AdapterPosts adapter = new AdapterPosts(arrayList,getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
    //Controler Footer
    private void bottomNavigationView(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bt_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.shopeeFeed:
                        return true;
                    case R.id.shopeeLive:
                        return true;
                    case R.id.thongbao:
                        return true;
                    case R.id.toi:
                        goto_Toi();
                        return true;
                }
                return false;
            }
        });
    }

    //Đén toi
    private void goto_Toi(){
        Intent intent = new Intent (this, Toi_Activity.class);
        startActivity(intent);
    }
}