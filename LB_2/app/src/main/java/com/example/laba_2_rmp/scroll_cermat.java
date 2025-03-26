package com.example.laba_2_rmp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
        //View mainView = findViewById(R.id.scroll_main);

        // справа, слева, снизу, сверху
        //mainView.setOnTouchListener(new SwipeHandler(this, Ishgl.class, alta.class, MainActivity.class, scroll_cermat.class));


        // Настройка свайпов
        View scrollView = findViewById(R.id.scroll_main);

        // Обработчик свайпов
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            private float startY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startY = event.getY();
                        break;

                    case MotionEvent.ACTION_UP:
                        float endY = event.getY();
                        float deltaY = startY - endY;

                        // Проверка свайпа вверх
                        if (deltaY < -100) {
                            // Обрабатываем свайп вниз
                            Intent intent = new Intent(scroll_cermat.this, cermat.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                            return true;
                        }
                        break;
                }
                return false;
            }
        });


        Button btnOpenTours = findViewById(R.id.button);
        btnOpenTours.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://github.com/d404mer/RMP_LAB"));
                startActivity(myWebLink);
            }
        });
    }
}