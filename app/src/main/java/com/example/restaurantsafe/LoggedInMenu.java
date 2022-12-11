package com.example.restaurantsafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class LoggedInMenu extends AppCompatActivity {
    private static boolean isPremiumUser = false;

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_in_menu);
        Button signOutBtn = (Button) findViewById(R.id.sign_out_btn);
        Button profileBtn = (Button) findViewById(R.id.profile_btn);

        int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4, R.drawable.slide5, R.drawable.slide6};

        v_flipper = findViewById(R.id.v_flipper);

        for (int image: images){
            flipperImages(image);
        }

        btnPress(profileBtn, Profile.makeIntent(LoggedInMenu.this));
        btnPress(signOutBtn, SignOut.makeIntent(LoggedInMenu.this));
    }

    private void btnPress(Button button, final Intent intent) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, LoggedInMenu.class);
    }

    public static void setIsPremiumUser(boolean isPremiumUser) {
        LoggedInMenu.isPremiumUser = isPremiumUser;
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(2000); //2 sec
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
}
