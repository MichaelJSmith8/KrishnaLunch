package com.example.krishnalunch;

import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends Authentification {

    ImageView KrishnaLogo;
    TextView DirectToSignUpText;
    Button LogInButton;
    EditText EmailField;
    EditText PasswordField;

    FirebaseAuth fireAuth;
    private static final String TAG = "LogIn";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        fireAuth = FirebaseAuth.getInstance();
        KrishnaLogo=(ImageView)findViewById(R.id.KrishnaLogo);
        ProgressBar progressBar = findViewById(R.id.LogInProgress);

        KrishnaLogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogInSignUpActivity.class);
                startActivity(intent);
            }
        });

        LogInButton = (Button)findViewById(R.id.LogInBtn);
        EmailField = (EditText)findViewById(R.id.EmailTxtBox);
        PasswordField = (EditText)findViewById(R.id.PasswordTxtBox);
        LogInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                signIn(EmailField.getText().toString(), PasswordField.getText().toString());
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

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = fireAuth.getCurrentUser();
        //updateUI?
    }

    private void signIn(String email, String password) {
        if(!validateForm()) {
            return;
        }
        final ProgressBar progressBar = findViewById(R.id.LogInProgress);
        showProgressBar(progressBar);

        fireAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = fireAuth.getCurrentUser();
                            Toast.makeText(LogIn.this, "Log In Successful.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                            startActivity(intent);
                            //updateUI
                        } else {
                            Toast.makeText(LogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            hideProgessBar(progressBar);
                            //UpdateUI
                        }

                        if(!task.isSuccessful()) {
                            //Show failed text view
                            Log.w(TAG, "signInWithEmail:failure", task.getException());

                        }
                        //hideProgessBar(progressBar);
                    }
                });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = EmailField.getText().toString();
        if(TextUtils.isEmpty(email)) {
            EmailField.setError("Email is Required");
            valid = false;
        } else {
            EmailField.setError(null);
        }

        String password = PasswordField.getText().toString();
        if(TextUtils.isEmpty(password)) {
            PasswordField.setError("Password is Required");
            valid = false;
        } else {
            PasswordField.setError(null);
        }
        return valid;
    }

    private void updateUI(FirebaseUser user) {

    }


}
