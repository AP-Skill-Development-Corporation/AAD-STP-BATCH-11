package omcap.co.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView text;
Button count;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text_view);
        count=findViewById(R.id.bt_count);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                text.setText(""+i);


            }
        });
    }


    public void ontoast(View view) {

        Toast.makeText(this,"value of textview is : "+i,Toast.LENGTH_LONG).show();

    }
}