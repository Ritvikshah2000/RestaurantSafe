package com.example.restaurantsafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoggedInMenu extends AppCompatActivity {
    private static boolean isPremiumUser = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_in_menu);
        Button helpBtn = (Button) findViewById(R.id.profile_btn);
        Button signOutBtn = (Button) findViewById(R.id.sign_out_btn);

//        btnPress(helpBtn, Profile.makeIntent(LoggedInMenu.this));
//        btnPress(signOutBtn, SignOut.makeIntent(LoggedInMenu.this));
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
}
