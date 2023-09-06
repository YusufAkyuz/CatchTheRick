package com.example.catchtherick;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catchtherick.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    TextView timeText;
    TextView scoreText;
    int number;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    ImageView [] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        timeText = binding.timeText;
        scoreText = binding.scoreText;
        number = 0;

        imageView1 = binding.imageView1;
        imageView2 = binding.imageView2;
        imageView3 = binding.imageView3;
        imageView4 = binding.imageView4;
        imageView5 = binding.imageView5;
        imageView6 = binding.imageView6;
        imageView7 = binding.imageView7;
        imageView8 = binding.imageView8;
        imageView9 = binding.imageView9;

        imageArray =new ImageView[] {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};
        hideImages();


        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time: " + (millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                timeText.setText("Tİme Off");
                handler.removeCallbacks(runnable);


                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restrat Game");
                alert.setMessage("Are you sure restrat the game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent =getIntent();
                        finish();
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        }.start();

    }



}