package com.example.nishant.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.password);
    }

    public void save(View v){
        SharedPreferences sp = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", username.getText().toString());
        editor.putString("pass", pass.getText().toString());

        editor.commit();

        Toast.makeText(this, "Data was saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void next(View v){
        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, ActivityB.class);
        startActivity(i);
    }
}
