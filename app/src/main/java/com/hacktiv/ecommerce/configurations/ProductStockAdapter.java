package com.hacktiv.ecommerce.configurations;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hacktiv.ecommerce.R;
import com.hacktiv.ecommerce.activities.AddStockActivity;
import com.hacktiv.ecommerce.models.Product;
import com.hacktiv.ecommerce.models.ProductType;

import java.util.List;

public class ProductStockAdapter extends RecyclerView.Adapter<ProductStockAdapter.ViewHolder> {

    List<Product> list;
    Context context;

    public ProductStockAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_stock_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = list.get(position);
        holder.type.setText(product.getType());

        holder.code.setText(product.getCode());
        holder.productName.setText(product.getName());
        holder.category.setText(product.getCategory());
        holder.stock.setText(product.getStock().toString());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("type_code",product.getTypeCode());
                data.putString("product_name", product.getName());
                data.putString("stock", product.getStock().toString());
                data.putString("code", product.getCode());
                Intent i = new Intent(context, AddStockActivity.class);
                i.putExtras(data);

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView type, code, productName, category, stock;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            code = itemView.findViewById(R.id.code);
            productName = itemView.findViewById(R.id.productName);
            category = itemView.findViewById(R.id.category);
            stock = itemView.findViewById(R.id.stock);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
