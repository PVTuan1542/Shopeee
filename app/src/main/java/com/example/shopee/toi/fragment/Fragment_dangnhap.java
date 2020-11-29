package com.example.shopee.toi.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.shopee.R;
import com.example.shopee.Toi_Activity;

public class Fragment_dangnhap extends Fragment {

    TextView textView;
    ImageView imageView;
    Button bt_DangNhap;
    CallBackFragment callBackFragment;

    public Fragment_dangnhap() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frangment_dangnhap, container, false);

        //add controler
        addControler(view);

        return  view;

    }
    public void setCallBackFragment(CallBackFragment callBackFragment){
        this.callBackFragment = callBackFragment;
    }
    //add controler Layout
    private void addControler(View view){
        //Đăng nhập
        dangNhap(view);
        //Đăng ký
        dangKy(view);
        //back
        back(view);
    }
    //Nhấn đăng nhập nếu đúng về trang tôi
    private  void dangNhap(View view){
        bt_DangNhap = (Button) view.findViewById(R.id.bt_dangNhap);
        bt_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().remove(Fragment_dangnhap.this).commit();
            }
        });
    }
    //Nhấn back thì lùi
    private void back(View view){
        imageView = (ImageView) view.findViewById(R.id.ic_Back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStackImmediate();
                }
            }
        });
    }
    //Nhấn textview đăng ký thì đến trang đăng ký
    private void dangKy(View view){
        textView =(TextView) view.findViewById(R.id.tv_dangKy);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callBackFragment != null){
                    callBackFragment.changeFragment();
                }
            }
        });
    }

}

