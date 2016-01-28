package com.example.nishant.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {

    public static final String DEFAULT ="N/A";
    TextView userNameDisplay, passDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        userNameDisplay = (TextView) findViewById(R.id.username_display);
        passDisplay = (TextView) findViewById(R.id.pass_display);
    }

    public void load(View v){
        SharedPreferences sp = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sp.getString("name",DEFAULT);
        String pass = sp.getString("pass",DEFAULT);

        if(name.equals(DEFAULT) || pass.equals(DEFAULT) )
        {
            Toast.makeText(this, "No data was found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_SHORT).show();
            userNameDisplay.setText(name);
            passDisplay.setText(pass);
        }
    }

    public void previous(View v){
        Toast.makeText(this, "Previous", Toast.LENGTH_SHORT).show();
        Intent activity_a = new Intent(this, MainActivity.class);
        startActivity(activity_a);
    }
}
