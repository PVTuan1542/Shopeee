package com.example.shopee.toi.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.shopee.R;

public class fragmentDangKy extends Fragment {

    Button bt_DangKy;
    ImageView imageView;

    CallBackFragment callBackFragment;

    public fragmentDangKy() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dangky,container,false);

        //add controler
        addControler(view);
        return view;
    }
    //add controler Layout
    private void addControler(View view){
        //back
        back(view);
        //Đăng ký
        dangKy(view);

    }
    public void setCallBackFragment(CallBackFragment callBackFragment){
        this.callBackFragment = callBackFragment;
    }
    //Nhấn back thì lùi
    private void back(View view){
        imageView = (ImageView) view.findViewById(R.id.back_DangKy);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStackImmediate();
                }
            }
        });
    }
    //Nhấn đăng ký thì đến trang đăng nhập
    private void dangKy(View view){
        bt_DangKy = (Button) view.findViewById(R.id.bt_dangKy);
        bt_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callBackFragment != null){
                    callBackFragment.changeFragmentDangNhap();
                }
            }
        });
    }

}
