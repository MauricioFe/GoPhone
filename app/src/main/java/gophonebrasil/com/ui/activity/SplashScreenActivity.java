package gophonebrasil.com.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import gophonebrasil.com.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mostraSplash();
    }

    private void mostraSplash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostraLogin();
            }

        },2000);
    }

    private void mostraLogin() {
        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);

        startActivity(intent);
        finish();
    }
}