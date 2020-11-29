package com.example.shopee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopee.shopee_feed.AdapterOfListMenu;
import com.example.shopee.shopee_feed.List_Menu;
import com.example.shopee.toi.fragment.CallBackFragment;
import com.example.shopee.toi.fragment.Fragment_dangnhap;
import com.example.shopee.toi.fragment.fragmentDangKy;
import com.example.shopee.toi.list.AdapterListToi;
import com.example.shopee.toi.list.list_Toi;

import java.util.ArrayList;

public class Toi_Activity extends AppCompatActivity implements CallBackFragment {

    Button bt_DangNhap,bt_DangKy;
    Fragment fragment;
    android.app.FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toi_);



        //add controler
        addControler();
        //go to đăng nhập
        fragmentDangNhap();
        //go to đăng ký
        fragmentDangKy();
        //


    }

    //Fragment đăng nhập
    private void fragmentDangNhap() {
        bt_DangNhap = (Button) findViewById(R.id.bt_dangNhap);
        bt_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragmentDangNhap();
            }
        });
    }
    // add fragment đăng nhập
    public void replaceFragmentDangNhap() {
        Fragment_dangnhap fragment = new Fragment_dangnhap();
        fragment.setCallBackFragment(this);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
    //Fragment đăng ký
    private void fragmentDangKy(){
        bt_DangKy = (Button) findViewById(R.id.bt_DangKy);
        bt_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragmentDangKy();
            }
        });
    }
    //Replace fragment đăng ký
    public void replaceFragmentDangKy() {
        fragmentDangKy fragment = new fragmentDangKy();
        fragment.setCallBackFragment(this);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    //add controler
    private void addControler() {
        init_ListCaNhan();
    }

    //Hiện thị list
    public void init_ListCaNhan() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_CaNhan);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<list_Toi> arrayList = new ArrayList<>();
        arrayList.add(new list_Toi(R.drawable.donmua, "Đơn mua"));
        arrayList.add(new list_Toi(R.drawable.smartphone, "Đơn nạp thẻ và Dịch vụ"));
        arrayList.add(new list_Toi(R.drawable.like, "Đã thích"));
        arrayList.add(new list_Toi(R.drawable.clock, "Đã xem gần đây"));
        arrayList.add(new list_Toi(R.drawable.vi, "Ví shopee"));
        arrayList.add(new list_Toi(R.drawable.xu, "Shopee xu"));
        arrayList.add(new list_Toi(R.drawable.danhgia, "Đánh gái của tôi"));
        arrayList.add(new list_Toi(R.drawable.voucher, "Ví Voucher"));
        arrayList.add(new list_Toi(R.drawable.taikhoan, "Thiết lập tài khoản"));
        arrayList.add(new list_Toi(R.drawable.trogiup, "Trung tâm trợ giúp"));
        arrayList.add(new list_Toi(R.drawable.trochuyen, "Trò Chuyện Với Shopee"));

        AdapterListToi adapter = new AdapterListToi(arrayList, getApplicationContext(), R.layout.row_canhan);
        recyclerView.setAdapter(adapter);

    }



    @Override
    public void changeFragment() {
        replaceFragmentDangKy();
    }

    @Override
    public void changeFragmentDangNhap() {
        replaceFragmentDangNhap();
    }



}