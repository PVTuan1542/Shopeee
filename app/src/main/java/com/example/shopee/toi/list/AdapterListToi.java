package com.example.shopee.toi.list;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopee.R;

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

        //onclick item thì hiện fragment
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



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
