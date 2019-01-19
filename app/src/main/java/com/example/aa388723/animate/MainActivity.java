package com.example.aa388723.animate;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ball1, ball2, ball3, ballZoom;
    int flag = -1,counter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ball1 = (ImageView)findViewById(R.id.ball1);
        ball2 = (ImageView)findViewById(R.id.ball2);
//        ball2.setVisibility(View.INVISIBLE);
        ball3 = (ImageView)findViewById(R.id.ball3);
//        ball3.setVisibility(View.INVISIBLE);
        ballZoom = (ImageView)findViewById(R.id.ballZoom);

//        animate(ball1);

        final Handler handler = new Handler();
        final Runnable run = new Runnable() {
            @Override
            public void run() {
//                animate(ball1);
                if(flag == -1){
                    ballZoom.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);

                    if(counter == 1){
                        counter = 2;
                        animate(ball1);
                    }else if(counter == 2){
                        counter = 3;
                        animate(ball2);
                    }else if(counter == 3){
                        counter = 1;
                        animate(ball3);
                    }

                    flag = 1;
                }else{
                    ballZoom.animate().scaleX(1f).scaleY(1f).setDuration(1000);
                    flag = -1;
                }

                handler.postDelayed(this, 510);
            }
        };

        handler.post(run);


    }

    public void animate(final ImageView ball){

//        TranslateAnimation animation = new TranslateAnimation(
//                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 500f,
//                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
//        animation.setDuration(1000);
//        animation.setFillAfter(true);
//        ball.startAnimation(animation);
//
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                ball.animate().translationXBy(500f).scaleX(0.5f).scaleY(0.5f).setDuration(1000);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });

        ball.animate().translationXBy(500f).setDuration(1500);
        new CountDownTimer(1500,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
//                ball.animate().translationXBy(-1000f).scaleX(1f).scaleY(1f).setDuration(0);
                ball.animate().translationXBy(500f).scaleX(0.5f).scaleY(0.5f).setDuration(1500);
//                            ball1.animate().x(37.5f).setDuration(0);
            }
        }.start();

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                ball.animate().translationXBy(-1000f).scaleX(1f).scaleY(1f).setDuration(0);
            }
        }.start();


    }
}
