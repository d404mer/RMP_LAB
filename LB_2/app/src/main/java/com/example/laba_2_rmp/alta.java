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

public class alta extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView textView2 = findViewById(R.id.Gallery);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alta.this, Ishgl.class);
                startActivity(intent);
            }
        });


        TextView textView = findViewById(R.id.mainTextView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действия при нажатии
                Intent intent = new Intent(alta.this, MainActivity.class);
                startActivity(intent);
            }
        });


        Button btnOpenTours = findViewById(R.id.button);

        btnOpenTours.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alta.this, scroll_alta.class);
                startActivity(intent);
            }
        });

        // Настройка свайпов
        View mainView = findViewById(R.id.main);
        // слева, справа, снизу, сверху
        mainView.setOnTouchListener(new SwipeHandler(this, cermat.class, Ishgl.class, MainActivity.class, scroll_alta.class));
        // findViewById(R.id.main).setOnTouchListener(new SwipeHandler(this, Ishgl.class, alta.class, scroll_alta.class, MainActivity.class));

    }
}
