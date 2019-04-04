package com.example.krishnalunch;

import android.content.Intent;
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

public class SignUp extends Authentification {

    Button CreateAccountButton;
    ImageView KrishnaLogo;
    TextView DirectToLogInText;
    ProgressBar progressBar;
    EditText EmailField;
    EditText PasswordField;
    EditText PasswordField2;

    private FirebaseAuth FireAuth;

    private static final String TAG = "SignUp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EmailField = findViewById(R.id.EmailTxtBox);
        PasswordField = findViewById(R.id.PasswordTxtBox);

        CreateAccountButton=(Button)findViewById(R.id.CreateAccountBtn);

        FireAuth = FirebaseAuth.getInstance();

        CreateAccountButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                createAccount(EmailField.getText().toString(), PasswordField.getText().toString());
                //sendEmailVerification();
                //progressBar = (ProgressBar)findViewById(R.id.SignUpProgress);
                //progressBar.setVisibility(View.VISIBLE);

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

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = FireAuth.getCurrentUser();
        //Update UI
    }

    private void createAccount(String email, String password) {
        if(!validateForm()) {
            return;
        }
        progressBar = findViewById(R.id.SignUpProgress);
        showProgressBar(progressBar);

        FireAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = FireAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Account Creation Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            //Update UI
                        } else {
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                        }

                       // hideProgessBar(progressBar);
                    }
                });
    }

  /*  private void sendEmailVerification() {
        final FirebaseUser user = FireAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this,
                                    "Verification email sent to " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUp.this,
                                    "Failed to send verification email.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
*/


    private boolean validateForm() {
        boolean valid = true;

        String email = EmailField.getText().toString();
        if(TextUtils.isEmpty(email)) {
            EmailField.setError("Email is Required");
            valid = false;
        } else {
            EmailField.setError(null);
        }
        EditText PasswordField = findViewById(R.id.PasswordTxtBox);
        EditText PasswordField2 = findViewById(R.id.ConfirmPasswordTxtBox);
        String password = PasswordField.getText().toString();

        if(TextUtils.isEmpty(password)) {
            PasswordField.setError("Password is Required");
            Toast.makeText(SignUp.this, "Password is Required.",
                    Toast.LENGTH_SHORT).show();
            valid = false;
        } else if(!(PasswordField.getText().toString().compareTo(PasswordField2.getText().toString()) == 0)) {
            PasswordField.setError("Passwords Must Match.");
            Toast.makeText(SignUp.this, "Passwords Must Match.",
                    Toast.LENGTH_SHORT).show();
            valid = false;
        } else if(PasswordField.getText().toString().length() < 6) {
            PasswordField.setError("Passwords Must Be At Least 6 Characters Long.");
            Toast.makeText(SignUp.this, "Passwords Must Be At Least 6 Characters Long.",
                    Toast.LENGTH_SHORT).show();
            valid = false;
        }

        else {
            PasswordField.setError(null);
        }
        return valid;
    }

}
