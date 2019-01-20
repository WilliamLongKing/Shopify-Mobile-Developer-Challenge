package com.kingapps.shopifymobiledeveloperchallenge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ProductsRecyclerViewAdapter.ProductViewHolder> {

    private Context context;
    private ArrayList<Product> productList;

    public ProductsRecyclerViewAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.collection_list_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct = productList.get(position);
        String imageUrl = currentProduct.getImage().getSrc();
        String productName = currentProduct.getTitle();
        String collectionName = currentProduct.getTags();
        List<Variant> variantList = currentProduct.getVariants();
        int inventory = 0;
        for(Variant variant: variantList) {
            inventory += variant.getInventoryQuantity();
        }

        holder.productName.setText(productName);
        holder.collectionName.setText(collectionName);
        holder.inventory.setText(Integer.toString(inventory));
        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView productName;
        public TextView collectionName;
        public TextView inventory;
        public Button button;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            productName = itemView.findViewById(R.id.productName);
            collectionName = itemView.findViewById(R.id.collectionName);
            inventory = itemView.findViewById(R.id.inventory);
            button = itemView.findViewById(R.id.button);
        }
    }
}
