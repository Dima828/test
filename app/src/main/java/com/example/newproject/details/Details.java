package com.example.newproject.details;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.newproject.R;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    private MyAdapter adapter;
    private ViewPager viewPager;
    private ArrayList<MyModel> modelArrayList;

    private Button thirdBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        viewPager = findViewById(R.id.ViewPager);
        thirdBtn = findViewById(R.id.ThirdBtn);

        viewPager.setOffscreenPageLimit(6);

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

        loadCard();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadCard() {
        modelArrayList = new ArrayList<>();

        modelArrayList.add(new MyModel(0, R.drawable.botinok_1));
        modelArrayList.add(new MyModel(1, R.drawable.botinok_1));
        modelArrayList.add(new MyModel(2, R.drawable.botinok_2));
        modelArrayList.add(new MyModel(3, R.drawable.botinok_1));
        modelArrayList.add(new MyModel(4, R.drawable.botinok_1));
        modelArrayList.add(new MyModel(5, R.drawable.botinok_1));

        adapter = new MyAdapter(this, modelArrayList);

        viewPager.setAdapter(adapter);
    }
}