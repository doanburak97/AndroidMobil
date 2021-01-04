package com.doanburak.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level1Activity extends AppCompatActivity {

    TextView textViewScore;
    TextView textViewTimeCounter;
    int score;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    Handler handler;
    Runnable runnable;

    ImageView[] imageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize (başlatma)
        textViewScore = findViewById(R.id.textViewScore);
        textViewTimeCounter = findViewById(R.id.textViewTimeCounter);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[] {imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};

        hideImages();

        score = 0;

        new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long l) {
                textViewTimeCounter.setText("Time : " + l / 1000);
            }

            @Override
            public void onFinish() {
                textViewTimeCounter.setText("Time Off");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                info();
            }
        }.start();
    }

    public void increaseScore(View view){

        //her tıkladıgımızda score 1 arttır
        score++;

        textViewScore.setText("Score : " + score);

    }

    public void hideImages(){

        handler = new Handler();

        runnable = new Runnable() {

            @Override
            public void run() {

                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,750);

            }
        };

        handler.post(runnable);

    }

    public void info(){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Game is over!");
        alert.setMessage("Score: " + score);
        alert.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //restart
                //içinde bulunduğu activity çalıştırılır
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //exit game
                Intent intent = new Intent(Level1Activity.this,LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });

        alert.show();
    }
}