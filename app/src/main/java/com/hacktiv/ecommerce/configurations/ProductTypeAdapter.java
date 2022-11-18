package com.hacktiv.ecommerce.configurations;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.models.ProductType;


import java.util.List;

public class ProductTypeAdapter extends RecyclerView.Adapter<ProductTypeAdapter.ViewHolder> {

    List<ProductType> list;
    Context context;


    public ProductTypeAdapter(Context context, List<ProductType> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_card_view_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductType productType = list.get(position);
        holder.categories.setText(productType.getName());
        Glide.with(context)
                .load(productType.getImg())
                .centerCrop()
                .into(holder.gridImage);
//        holder.categories.setText(categories.get(position));
//        holder.gridImage.setImageResource(images.get(position));
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent;
//                intent = new Intent(context, category_activity.class);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categories;
        ImageView gridImage;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categories = itemView.findViewById(R.id.textView);
            gridImage = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }


}
