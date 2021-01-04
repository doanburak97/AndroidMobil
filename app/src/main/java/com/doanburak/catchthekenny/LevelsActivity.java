package com.doanburak.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LevelsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
    }

    public void level1(View view){
        Intent intent1 = new Intent(LevelsActivity.this, Level1Activity.class);
        startActivity(intent1);
    }

    public void level2(View view){
        Intent intent2 = new Intent(LevelsActivity.this, Level2Activity.class);
        startActivity(intent2);
    }

    public void level3(View view){
        Intent intent3 = new Intent(LevelsActivity.this, Level1Activity.class);
        startActivity(intent3);
    }

    public void level4(View view){
        Intent intent4 = new Intent(LevelsActivity.this, Level1Activity.class);
        startActivity(intent4);
    }

    public void level5(View view){
        Intent intent5 = new Intent(LevelsActivity.this, Level1Activity.class);
        startActivity(intent5);
    }

    public void level6(View view){
        Intent intent6 = new Intent(LevelsActivity.this, Level1Activity.class);
        startActivity(intent6);
    }

    public void level7(View view){
        Intent intent7 = new Intent(LevelsActivity.this, Level1Activity.class);
        startActivity(intent7);
    }

    public void level8(View view){
        Intent intent8 = new Intent(LevelsActivity.this, Level1Activity.class);
        startActivity(intent8);
    }

    public void level9(View view){
        Intent intent9 = new Intent(LevelsActivity.this, Level1Activity.class);
        startActivity(intent9);
    }



}