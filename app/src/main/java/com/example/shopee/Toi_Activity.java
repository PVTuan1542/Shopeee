package com.example.shopee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.shopee.toi.list.AdapterListToi;
import com.example.shopee.toi.list.list_Toi;

import java.util.ArrayList;

public class Toi_Activity extends AppCompatActivity  {

    Button bt_DangNhap,bt_DangKy;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toi);
        //add controler
        addControler();
        //


    }

    //add controler
    private void addControler() {
        bt_DangKy = (Button) findViewById(R.id.bt_DangKy);
        bt_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goDangKy();

            }
        });
        bt_DangNhap = (Button) findViewById(R.id.bt_dangNhap);
        bt_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goDangNhap();
            }
        });

        init_ListCaNhan();
    }

    //go to activity dăng nhập
    private void goDangNhap(){
        Intent intent = new Intent(Toi_Activity.this,dangnhap.class);
        startActivity(intent);
    }
    //go to activity dăng ký
    private void goDangKy(){
        Intent intent = new Intent(Toi_Activity.this,dangky_activity.class);
        startActivity(intent);
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
    public  void setAnh(int value){
        imageView = (ImageView) findViewById(R.id.img_account);
        imageView.setImageResource(value);
    }


}