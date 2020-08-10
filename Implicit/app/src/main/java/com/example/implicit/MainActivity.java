package com.example.implicit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.tex1);
    }

    public void dail(View view) {
        String s=editText.getText().toString();
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+s));
        startActivity(i);
    }

    public void share(View view) {
        String s=editText.getText().toString();
        ShareCompat.IntentBuilder.from(this)  //place
                .setType("text")  //type of data
                .setChooserTitle("select one app")
                .setText(s)    //share data
                .startChooser();   //open chooser

    }

    public void openwhatsapp(View view) {
        Intent i=getPackageManager().
                getLaunchIntentForPackage("com.whatsapp");
        startActivity(i);
    }
}
