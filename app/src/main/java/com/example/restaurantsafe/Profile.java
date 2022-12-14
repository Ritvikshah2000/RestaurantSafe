package com.example.restaurantsafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button profileBtn = (Button) findViewById(R.id.save_btn);

        btnPress(profileBtn, LoggedInMenu.makeIntent(Profile.this));
    }

    private void btnPress(Button button, final Intent intent) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Profile Changes Saved!" , Toast.LENGTH_SHORT ).show();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, Profile.class);
    }

}
