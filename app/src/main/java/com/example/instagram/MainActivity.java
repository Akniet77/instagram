package com.example.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instagram.home.HomeFragment;
import com.example.instagram.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentContainerView fragmentContainerView;


    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_bottom_nav);
        fragmentContainerView = findViewById(R.id.main_container);



        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    openFragment(new HomeFragment());
                    break;

                case R.id.menu_search:
                    openFragment(new SearchFragment());
                    break;


                case R.id.menu_gallery:
                    openFragment(new GalleryFragment());
                    break;
                case R.id.menu_like:
                    openFragment(new LikeFragment());
                    break;

                case R.id.menu_profile:
                    openFragment(new ProfileFragment());
                    break;


            }
            return true;
        });
    }
    private void openFragment(Fragment fragment){
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.main_container, fragment )
                .commit();
    }
}