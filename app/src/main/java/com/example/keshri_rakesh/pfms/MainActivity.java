package com.example.keshri_rakesh.pfms;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1=(ImageView)findViewById(R.id.iv1);

        android.support.v7.app.ActionBar ac=getSupportActionBar();
        ac.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Animation alpha=new AlphaAnimation(1.0f,0.0f);
        alpha.setDuration(3000);
        iv1.setAnimation(alpha);

        final Intent i=new Intent(this,Login.class);
        Thread t=new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(1800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }


            }
        };
        t.start();
    }
}
