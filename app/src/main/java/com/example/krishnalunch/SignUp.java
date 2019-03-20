package com.example.krishnalunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    Button CreateAccountButton;
    ImageView KrishnaLogo;
    TextView DirectToLogInText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        CreateAccountButton=(Button)findViewById(R.id.CreateAccountBtn);

        CreateAccountButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Account Creation Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        KrishnaLogo=(ImageView)findViewById(R.id.KrishnaLogo);

        KrishnaLogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogInSignUpActivity.class);
                startActivity(intent);
            }
        });

        DirectToLogInText = (TextView)findViewById(R.id.LogInInfoTxt);
        String message = "Already have an account? <u>Log-In</u>";
        //String link = "<font color = '#'>Sign Up</font>";
        DirectToLogInText.setText(Html.fromHtml(message));
        DirectToLogInText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogIn.class);
                startActivity(intent);
            }
        });

    }
}
