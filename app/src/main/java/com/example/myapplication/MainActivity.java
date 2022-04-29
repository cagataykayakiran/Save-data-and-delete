package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.example.myapplication" , Context.MODE_PRIVATE);
        int savedage = sharedPreferences.getInt("savedage", 0);
        textView.setText("Your age: " +savedage);


    }

    public void save (View view) {

        if (!editText.getText().toString().matches("")) {
            int userage = Integer.parseInt(editText.getText().toString());

            textView.setText("Your age: " + userage);

            sharedPreferences.edit().putInt("savedage" , userage).apply();
        }

    }

    public void delete (View view) {
        int savedata = sharedPreferences.getInt("savedage" , 0);

        if (savedata != 0) {
            sharedPreferences.edit().remove("savedage").apply();
            textView.setText("Your age: ");
        }

    }

}