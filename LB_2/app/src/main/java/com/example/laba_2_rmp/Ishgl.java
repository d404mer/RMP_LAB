package com.example.laba_2_rmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ishgl extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ishgl);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Настройка свайпов
        View mainView = findViewById(R.id.main);
        mainView.setOnTouchListener(new SwipeHandler(this, alta.class, cermat.class));
        findViewById(R.id.main).setOnTouchListener(new SwipeHandler(this, alta.class, cermat.class));

        Button btnOpenTours = findViewById(R.id.button);
        btnOpenTours.setOnClickListener(v -> {
            Intent intent = new Intent(Ishgl.this, scrll_ishgli.class);
            startActivity(intent);
        });

        TextView mainTextView = findViewById(R.id.mainTextView);
        mainTextView.setOnClickListener(v -> {
            Intent intent = new Intent(Ishgl.this, MainActivity.class);
            startActivity(intent);
        });

        TextView gallery = findViewById(R.id.Gallery);
        gallery.setOnClickListener(v -> {
            Intent intent = new Intent(Ishgl.this, alta.class);
            startActivity(intent);
        });
    }


}
