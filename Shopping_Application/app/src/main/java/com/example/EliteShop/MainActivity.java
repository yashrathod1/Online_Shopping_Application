package com.example.EliteShop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.example.EliteShop.fragment.AccountInformationFragment;
import com.example.EliteShop.fragment.CartFragment;
import com.example.EliteShop.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView toolbarText;
    View fragment;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbarText = findViewById(R.id.toolbarText);
        fragment = findViewById(R.id.fragment);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));
        SharedPreferences sharedPreferences= getSharedPreferences("userDetails",0);


        View headerView = navigationView.getHeaderView(0);
        TextView profileName = headerView.findViewById(R.id.profileName);
        TextView profileEmail = headerView.findViewById(R.id.profileEmail);

        profileName.setText(sharedPreferences.getString("name","").toString());
        profileEmail.setText(sharedPreferences.getString("email","").toString());

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, new HomeFragment()).commit();
        toolbarText.setText("Home");



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.homeMenu) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
                    toolbarText.setText("Home");
                    // Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId() == R.id.accountInformation) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new AccountInformationFragment()).commit();
                    toolbarText.setText("Account Information");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId() == R.id.cartMenu){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new CartFragment()).commit();
                    toolbarText.setText("Cart");
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (item.getItemId() == R.id.signOutMenu){
                    signOut();
                }
                return true;
            }
        });
    }
    public void signOut() {
        SharedPreferences sharedPreferences = getSharedPreferences("userDetails", 0);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putBoolean("isLogin", false);
        sharedPreferencesEditor.apply();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}