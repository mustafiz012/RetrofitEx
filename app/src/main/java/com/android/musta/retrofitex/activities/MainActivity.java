package com.android.musta.retrofitex.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.musta.retrofitex.Controller;
import com.android.musta.retrofitex.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(v -> {
            Controller controller = new Controller();
            controller.start();
        });
    }
}
