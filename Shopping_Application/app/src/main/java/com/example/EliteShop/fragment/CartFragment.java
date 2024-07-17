package com.example.EliteShop.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.EliteShop.CartAdapter;
import com.example.EliteShop.CartDatabase;
import com.example.EliteShop.HomeDatabase;
import com.example.EliteShop.ItemClass;
import com.example.EliteShop.R;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    View view;
    ArrayList<ItemClass> cartArrayList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        cartArrayList = new ArrayList<>();
        ListView listView = view.findViewById(R.id.listView);
        TextView textItemDesc = view.findViewById(R.id.textItemDesc);
        Button pleaseOrderButton = view.findViewById(R.id.pleaseOrderButton);

        CartDatabase cartDatabase = new CartDatabase(getContext().getApplicationContext());
        cartArrayList = cartDatabase.getAllDataUser();
        if (cartArrayList.size()==0){
            textItemDesc.setText("Cart is Empty");
        }
        CartAdapter cartAdapter = new CartAdapter(getActivity().getApplicationContext(), cartArrayList);
        HomeDatabase homeDatabase = new HomeDatabase(getActivity().getApplicationContext());

        listView.setAdapter(cartAdapter);

        pleaseOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ItemClass> cartArrayList = new ArrayList<>();
                cartArrayList = cartDatabase.getAllDataUser();
                for (int i = 0; i < cartArrayList.size(); i++) {
                    ItemClass itemClass = cartArrayList.get(i);
                    homeDatabase.updateIsCart(itemClass.itemName,itemClass.isCart,R.color.cart_image_red);
                }
                Toast.makeText(getActivity().getApplicationContext(), "Your order has successfully placed",Toast.LENGTH_SHORT).show();
                cartDatabase.clear();
                getParentFragmentManager().beginTransaction().detach(CartFragment.this).commit();
                getParentFragmentManager().beginTransaction().attach(CartFragment.this).commit();
            }
        });
        return view;
    }
}