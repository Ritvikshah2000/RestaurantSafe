package com.example.restaurantsafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AskUs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ask_us);

       Button submitBtn = (Button) findViewById(R.id.submit_btn);

       btnPress(submitBtn, LoggedInMenu.makeIntent(AskUs.this));
    }

    private void btnPress(Button button, final Intent intent) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Question Submitted!" , Toast.LENGTH_SHORT ).show();
            }
        });
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, AskUs.class);
    }
}
