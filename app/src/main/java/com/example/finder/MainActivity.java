package com.example.finder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button btnFind, btnFinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar= findViewById(R.id.pgsBar);
        btnFind= findViewById(R.id.btnFind);
        btnFinder= findViewById(R.id.btnFinder);

        btnFind.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            new Hilo1().start();
        });


        btnFinder.setOnClickListener(view -> {

            progressBar.setVisibility(View.VISIBLE);
            new Hilo1().start();
        });

    }

    class Hilo1 extends Thread{

        @Override

        public void run(){
            try {
                Thread.sleep(10000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Cargando", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}