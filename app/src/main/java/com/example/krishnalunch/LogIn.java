package com.example.krishnalunch;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    ImageView KrishnaLogo;
    TextView DirectToSignUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        KrishnaLogo=(ImageView)findViewById(R.id.KrishnaLogo);

        KrishnaLogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogInSignUpActivity.class);
                startActivity(intent);
            }
        });

        DirectToSignUpText = (TextView)findViewById(R.id.SignUpInfoTxt);
        String message = "Don't have an account? <u>Sign Up</u>";
        //String link = "<font color = '#'>Sign Up</font>";
        DirectToSignUpText.setText(Html.fromHtml(message));
        DirectToSignUpText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }
        });

    }
}
