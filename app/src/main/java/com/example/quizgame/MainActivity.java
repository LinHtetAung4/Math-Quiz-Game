package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private TextView left;
    private Button login;
    private int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.idname);
        password = (EditText) findViewById(R.id.idtext);
        left = (TextView) findViewById(R.id.idresult);
        login = (Button) findViewById(R.id.idlogin);

        left.setText("No of attempt remaining :5");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate(String entername, String enterpassword) {
        if (entername.equals("Lin") && enterpassword.equals("Lin1234")) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            count--;
            left.setText("No of attemped:" + String.valueOf(count));
            if (count == 0) {
                login.setEnabled(false);
            }
        }
    }
}