package mstopyra.egzamin;

//package jp.android;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;

public class ImgViewerActivity extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView tv=new TextView(this);
        tv.setText("Second activity");
        setContentView(R.layout.activity_img);
        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Value1");
        String value2 = extras.getString("Value2");
        Toast.makeText(getApplicationContext(),"Value 1: "+ value1 +
                "\nValue 2: " + value2, LENGTH_LONG).show();
        Button button1=(Button)findViewById(R.id.Button01);
        button1.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
