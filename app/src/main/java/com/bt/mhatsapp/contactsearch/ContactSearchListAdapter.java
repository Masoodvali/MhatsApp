package com.bt.mhatsapp.contactsearch;

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

public class ContactSearchListAdapter extends RecyclerView.Adapter<ContactSearchListAdapter.MyViewHolder> {
    private Context context;
    private List<ContactSearchDataModel> contactSearchDataModelList;

    ContactSearchListAdapter(Context context, List<ContactSearchDataModel> contactSearchDataModelList) {
        this.context = context;
        this.contactSearchDataModelList = contactSearchDataModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listItem = layoutInflater.inflate(R.layout.contact_search_list_item, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvContactname.setText(contactSearchDataModelList.get(position).getContactName());
        holder.tvContactMobile.setText(contactSearchDataModelList.get(position).getContactMobile());
        Glide.with(context)
                .load("https://homepages.cae.wisc.edu/~ece533/images/lena.png")
                .circleCrop()
                .into(holder.tvContactImage);

    }


    @Override
    public int getItemCount() {
        return contactSearchDataModelList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContactname;
        private TextView tvContactMobile;
        private ImageView tvContactImage;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContactname = itemView.findViewById(R.id.contact_name);
            tvContactMobile = itemView.findViewById(R.id.contact_mobile);
            tvContactImage = itemView.findViewById(R.id.contact_image);
        }
    }
}
