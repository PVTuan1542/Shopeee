package com.example.shopee.shopee_feed.posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopee.R;
import com.example.shopee.toi.fragment.Fragment_dangnhap;

import java.util.ArrayList;

public class AdapterPosts extends  RecyclerView.Adapter<AdapterPosts.ViewHolder> {

    ArrayList<post> posts;
    Context context;

    public AdapterPosts(ArrayList<post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.row_posts,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgLogo.setImageResource(posts.get(position).getLogo());
        holder.txtTenShop.setText(posts.get(position).getTenShop());
        holder.imgAnh.setImageResource(posts.get(position).getAnh());
        holder.txtLike.setText(posts.get(position).getLike()+"");
        holder.txtCmt.setText(posts.get(position).getCmt()+"");
        holder.txtView.setText(posts.get(position).getView()+"");

        //onclick item thì hiện fragment
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                Fragment_dangnhap fragment_dangnhap = new Fragment_dangnhap();
                activity.getFragmentManager().beginTransaction().replace(R.id.shopeeFeed,fragment_dangnhap).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTenShop,txtLike,txtCmt,txtView ;
        ImageView imgLogo,imgAnh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenShop = (TextView) itemView.findViewById(R.id.tenShop);
            imgLogo = (ImageView) itemView.findViewById(R.id.img_LoGo);
            imgAnh = (ImageView) itemView.findViewById(R.id.img_Anh);
            txtLike = (TextView) itemView.findViewById(R.id.text_Like);
            txtCmt = (TextView) itemView.findViewById(R.id.text_Cmt);
            txtView = (TextView) itemView.findViewById(R.id.text_View);
        }
    }

}
