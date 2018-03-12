package com.example.habib.infobook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Habib on 8/29/17.
 */

public class Post_Adapter extends RecyclerView.Adapter<Post_Adapter.ViewHolder> {
    private List<Post_item> post_items;
    private Context context;
    public Post_Adapter(List<Post_item> post_items, Context context) {
        this.post_items = post_items;
        this.context = context;
    }
    @Override
    public Post_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_cardview,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(Post_Adapter.ViewHolder holder, final int position) {
        final Post_item post_item=post_items.get(position);
        holder.post.setText(post_item.getPost());
        holder.comment.setText(post_item.getComment());

    }
    @Override
    public int getItemCount() {
        return post_items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView post;
        private ImageView image;
        private TextView comment;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            image=(ImageView)itemView.findViewById(R.id.post_image) ;
            post=(TextView) itemView.findViewById(R.id.post_view);
            comment=(TextView)itemView.findViewById(R.id.commentshow);

        }
    }
}
