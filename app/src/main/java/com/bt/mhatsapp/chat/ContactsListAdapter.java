package com.bt.mhatsapp.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bt.mhatsapp.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ViewHolder> {

    private Context context;
    private List<ContactDataModel> rvContactsList;


    public ContactsListAdapter(Context context, List<ContactDataModel> rvContactsList) {
        this.context = context;
        this.rvContactsList = rvContactsList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.contact_item_view, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        holder.tvContactname.setText(rvContactsList.get(position).getContactName());
        holder.tvContactMobile.setText(rvContactsList.get(position).getContactMobile());
        Glide.with(context)
                .load("https://homepages.cae.wisc.edu/~ece533/images/lena.png")
                .circleCrop()
                .into(holder.tvContactImage);
    }


    @Override
    public int getItemCount() {
        return rvContactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContactname;
        private TextView tvContactMobile;
        private ImageView tvContactImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContactname = itemView.findViewById(R.id.contact_name);
            tvContactMobile = itemView.findViewById(R.id.contact_mobile);
            tvContactImage = itemView.findViewById(R.id.contact_image);
        }
    }
}
