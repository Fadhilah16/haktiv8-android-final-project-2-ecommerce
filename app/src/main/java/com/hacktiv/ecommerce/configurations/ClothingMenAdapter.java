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
import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.activities.ClothingProductActivity;
import com.hacktiv.ecommerce.activities.clothing_product.MenBottomwearCategoryActivity;
import com.hacktiv.ecommerce.activities.clothing_product.MenFormalCategoryActivity;
import com.hacktiv.ecommerce.activities.clothing_product.MenShoesCategoryActivity;
import com.hacktiv.ecommerce.activities.clothing_product.MenTshirtCategoryActivity;


import java.util.ArrayList;
import java.util.List;

public class
ClothingMenAdapter extends RecyclerView.Adapter<ClothingMenAdapter.ViewHolder> {

    List<String> title, image;
    Context context;


    public ClothingMenAdapter(Context context, List<String> title, List<String> image) {
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
        int position1 = position;
        holder.categories.setText(String.valueOf(title.get(position)));
        holder.gridImage.setImageResource(Integer.parseInt(image.get(position)));

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Intent intent;
                switch (position1) {
                    case 0:
                        intent = new Intent(view.getContext(), MenTshirtCategoryActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(view.getContext(), MenFormalCategoryActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(view.getContext(), MenBottomwearCategoryActivity.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(view.getContext(), MenShoesCategoryActivity.class);
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
    }


}
