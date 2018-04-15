package com.example.avjindersinghsekhon.minimaltodo.SumUp.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.sumup.payment.domain.model.receipt.Product;
import com.example.avjindersinghsekhon.minimaltodo.R;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private List<Product> mData;

    public ProductsAdapter(List<Product> products) {
        mData = products;
    }

    public void setData(List<Product> mData) {
        this.mData = mData;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        final Product product = mData.get(position);

        holder.name.setText(product.getName());
        holder.price.setText(String.valueOf(product.getPrice()));
        holder.quantity.setText(String.valueOf(product.getQuantity()));
        holder.totalPrice.setText(String.valueOf(product.getTotalPrice()));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView price;
        TextView totalPrice;
        TextView quantity;

        public ProductViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_value);
            price = itemView.findViewById(R.id.price_value);
            totalPrice = itemView.findViewById(R.id.total_price_value);
            quantity = itemView.findViewById(R.id.quantity_value);
        }
    }
}
