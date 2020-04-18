package com.andy_mitchell.mastermind.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.andy_mitchell.mastermind.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playGame(View view) {
        startActivity(new Intent(MainActivity.this, GameActivity.class));
    }

    public void showTutorial(View view) {
        startActivity(new Intent(MainActivity.this, TutorialActivity.class));
    }
}
