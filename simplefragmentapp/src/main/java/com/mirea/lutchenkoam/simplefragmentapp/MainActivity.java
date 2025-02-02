package com.mirea.lutchenkoam.simplefragmentapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    Fragment fragment1, fragment2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fragment1 = new FirstFragment();
        fragment2 = new SecondFragment();
    }

    public void onClick(View view){
        fragmentManager = getSupportFragmentManager();
        if (view.getId() == R.id.btnFirstFragment)
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment1).commit();
        else if (view.getId() == R.id.btnSecondFragment)
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment2).commit();
    }
}