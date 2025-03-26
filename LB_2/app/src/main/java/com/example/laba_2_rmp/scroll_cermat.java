package com.example.laba_2_rmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class scroll_cermat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scroll_cermat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView textView = findViewById(R.id.mainTextView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scroll_cermat.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView textView2 = findViewById(R.id.Gallery);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(scroll_cermat.this, Ishgl.class);
                startActivity(intent);
            }
        });

        // Настройка свайпов
        View mainView = findViewById(R.id.main);

        // справа, слева, снизу, сверху
        mainView.setOnTouchListener(new SwipeHandler(this, Ishgl.class, alta.class, MainActivity.class, scroll_cermat.class));
    }
}