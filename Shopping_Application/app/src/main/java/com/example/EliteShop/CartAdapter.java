package com.example.EliteShop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    Context context;
    ArrayList<ItemClass> cartArrayList;

    public CartAdapter(Context context, ArrayList<ItemClass> cartArrayList){
        this.context = context;
        this.cartArrayList=cartArrayList;
    }

    @Override
    public int getCount() {
        return cartArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.cart_list_menu, parent, false);
        }

        ItemClass item = cartArrayList.get(position);
        ImageView itemImage = view.findViewById(R.id.cartItemImage);
        TextView itemName = view.findViewById(R.id.cartItemName);
        TextView itemDec = view.findViewById(R.id.cartItemDec);
        TextView itemPrice = view.findViewById(R.id.cartItemPrice);

        itemImage.setImageResource(item.image);
        itemName.setText(item.itemName);
        itemDec.setText(item.itemDisc);
        itemPrice.setText("Rs."+ item.price);
        return view;
    }
}
