package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText)findViewById(R.id.editUsername);
        etPassword = (EditText)findViewById(R.id.editPassword);

        buttonLogin = (Button)findViewById(R.id.btnLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Entered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, viewUser.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
