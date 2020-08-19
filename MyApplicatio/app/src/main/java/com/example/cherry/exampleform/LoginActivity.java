package com.example.cherry.exampleform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText uid,upass;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uid = findViewById(R.id.uid);
        upass = findViewById(R.id.upass);
        preferences = getSharedPreferences("Data",MODE_PRIVATE);
      /*  if ((preferences.getString("mail",null)!=null) & (preferences.getString("pass",null)!=null)){
            startActivity(new Intent(this,MainActivity.class));
        }*/
    }

    public void login(View view) {
        String id = uid.getText().toString();
        String pass = upass.getText().toString();
        String m = preferences.getString("mail",null);
        if (id.equals(m) &
                pass.equals(preferences.getString("pass",null))){
            startActivity(new Intent(this,MainActivity.class));
            Toast.makeText(this, "Successfully logged in",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Invalid Credentials",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
    }
}