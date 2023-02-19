package mstopyra.egzamin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class WebActivity extends AppCompatActivity {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Bundle extras = getIntent().getExtras();
        String WebsiteURL = extras.getString("URL");

        //back
        Button back=(Button)findViewById(R.id.ButtonBackToMenu);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //webview
        WebView myWebView = findViewById(R.id.myWebView);
        //myWebView.loadUrl("https://developer.android.com/");
        myWebView.loadUrl(WebsiteURL);
        myWebView.getSettings().setJavaScriptEnabled(true);
        //Thread.sleep(5000);
        //back.setVisibility(View.GONE); //test for spinner
        myWebView.setWebViewClient(new WebViewClient());
    }
}
