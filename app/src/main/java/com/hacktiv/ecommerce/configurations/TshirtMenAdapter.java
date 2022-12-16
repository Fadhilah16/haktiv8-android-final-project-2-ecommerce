package com.hacktiv.ecommerce.configurations;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.Target;
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.activities.ClothingProductActivity;
import com.hacktiv.ecommerce.activities.clothing_product.detail_product.MenShirt1Activity;
import com.hacktiv.ecommerce.activities.clothing_product.detail_product.MenShirt2Activity;
import com.hacktiv.ecommerce.activities.clothing_product.detail_product.MenShirt3Activity;


import java.util.ArrayList;
import java.util.List;

public class
TshirtMenAdapter extends RecyclerView.Adapter<TshirtMenAdapter.ViewHolder> {

    List<String> title, image;
    Context context;


    public TshirtMenAdapter(Context context, List<String> title, List<String> image) {
        this.context = context;
        this.title = title;
        this.image = image;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_card_view_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int currentPosition = position;
        holder.categories.setText(String.valueOf(title.get(position)));
        holder.gridImage.setImageResource(Integer.parseInt(image.get(position)));
//        Glide.with(context)
//                .load(image.get(position))
//                .error(R.drawable.ic_launcher_background)
//                .centerCrop()
//                .into(holder.gridImage);

//        R/equestManager requestManager = Glide.with(context);
//        RequestBuilder requestBuilder = requestManager.load(image)

//        holder.categories.setText(categories.get(position));
//        holder.gridImage.setImageResource(images.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Intent intent;
                switch (currentPosition) {
                    case 0:
                        intent = new Intent(view.getContext(), MenShirt1Activity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(view.getContext(), MenShirt2Activity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(view.getContext(), MenShirt3Activity.class);
                        context.startActivity(intent);
                        break;
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return title.size();
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
            context = itemView.getContext();
        }

//        @Override
//        public void onClick(View view) {
//
//            final Intent intent;
//            switch (getAdapterPosition()) {
//                case 0:
//                    intent = new Intent(context, ClothingProductActivity.class);
//                    context.startActivity(intent);
//                    break;
//
//                case 1:
//                    intent = new Intent(context, ClothingProductActivity.class);
//                    break;
//
//                default:
//                    intent = new Intent(context, ClothingProductActivity.class);
//                    break;
//            }
//            context.startActivity(intent);
//        }
    }


}
