package com.example.shopee.toi.list;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopee.R;
import com.example.shopee.shopee_feed.AdapterOfListMenu;
import com.example.shopee.shopee_feed.List_Menu;
import com.example.shopee.toi.fragment.Fragment_dangnhap;
import com.example.shopee.toi.fragment.fragmentDangKy;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterListToi extends  RecyclerView.Adapter<AdapterListToi.ViewHolder>  {

    ArrayList<list_Toi> list_menus;
    Context context;
    int row_layout;
    int row_index=-1;

    public AdapterListToi(ArrayList<list_Toi> list_menus, Context context,int row_layout) {
        this.list_menus = list_menus;
        this.context = context;
        this.row_layout = row_layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(row_layout,parent,false);
        final ViewHolder viewHolder = new ViewHolder(itemView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Test click" + String.valueOf(viewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtTen.setText(list_menus.get(position).getTen());
        holder.imgHinh.setImageResource(list_menus.get(position).getAnh());
//        //set màu cho item view
//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                row_index = position;
//                notifyDataSetChanged();
//            }
//        });
//        if(row_index == position){
//            holder.txtTen.setTextColor(Color.RED);
//        }else{
//            holder.txtTen.setTextColor(Color.BLACK);
//        }

        //onclick item thì hiện fragment
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                FragmentManager fragmentManager = activity.getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//                Fragment_dangnhap fragment_dangnhap = new Fragment_dangnhap();
//                activity.getFragmentManager().beginTransaction().replace(R.id.container,fragment_dangnhap).addToBackStack(null).commit();

                Fragment_dangnhap fragment_dangnhap = new Fragment_dangnhap();

                Bundle bundle = new Bundle();
                list_Toi hocSinh = new list_Toi(list_menus.get(position).getAnh(),list_menus.get(position).getTen());

                bundle.putSerializable("list", (Serializable) hocSinh);


                //bundle.putString("test",list_menus.get(position).getTen());
                //bundle.putInt("anh",list_menus.get(position).getAnh());
                fragment_dangnhap.setArguments(bundle);

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.container, fragment_dangnhap);
                fragmentTransaction.commit();



            }
        });

    }

    @Override
    public int getItemCount() {
        return list_menus.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTen ;
        ImageView imgHinh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTen = (TextView) itemView.findViewById(R.id.tv_ten);
            imgHinh = (ImageView) itemView.findViewById(R.id.img);
        }
    }


}
