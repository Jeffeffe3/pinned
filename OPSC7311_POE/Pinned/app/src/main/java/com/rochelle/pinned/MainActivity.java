package com.rochelle.pinned;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView lblEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblEmail = findViewById(R.id.lblEmailAddress);


        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("userdetails",0);

        lblEmail.setText(sharedPreferences.getString("email","0"));
    }

}