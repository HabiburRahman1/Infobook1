package com.example.habib.infobook;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private List<Profile_item>profile_items;
    private Context context;
    public ProfileAdapter(List<Profile_item> profile_items, Context context) {
        this.profile_items = profile_items;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_cardview,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Profile_item profile_item=profile_items.get(position);
        holder.name.setText(profile_item.getEmail());
        holder.id.setText(profile_item.getUid());
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,ChatwithAll.class);
                intent.putExtra("id", profile_item.getEmail());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return profile_items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView id;
        private Button message;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            name=(TextView) itemView.findViewById(R.id.name);
            id=(TextView)itemView.findViewById(R.id.id);
            message=(Button)itemView.findViewById(R.id.send_message);

        }
    }
}
