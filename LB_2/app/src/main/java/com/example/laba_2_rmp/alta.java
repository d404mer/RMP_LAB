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

// Делаем текст кликабельным визуально
        textView.setClickable(true);
        textView.setFocusable(true);
// Опционально: добавляем эффект при нажатии
        textView.setBackgroundResource(android.R.drawable.list_selector_background);


        Button btnOpenTours = findViewById(R.id.button);

        btnOpenTours.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alta.this, scroll_alta.class);
                startActivity(intent);
            }
        });

        // обработка свайпов
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e1.getX() > e2.getX()) {
                    // -->
                    Intent intent = new Intent(alta.this, Ishgl.class);
                    startActivity(intent);
                }
                // <--
                else if (e1.getX() < e2.getX())
                {
                    Intent intent = new Intent(alta.this, cermat.class);
                    startActivity(intent);
                }
                return true;
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }
}