package com.example.krishnalunch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public abstract class Authentification extends AppCompatActivity {
    @VisibleForTesting
    public ProgressBar progressBar;

    public void showProgressBar(ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgessBar(ProgressBar progressBar) {
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void hideKeyboard(View view) {
        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        //hideProgessBar(progressBar);
    }






/*View.OnClickListener {

    private FirebaseAuth mAuth; //declare instance of FirebaseAuth

    private EditText loginEmail;
    private EditText loginPassword;
    private EditText signUpEmail;
    private EditText signUpPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void createNewAccount(String email, String password) {
        //check for valid form
        if(!validateForm()) {
            return;
        }

        //showProgressDialog();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            //User successfully signed up, update UI
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else {
                            //Sign up failed, display error
                            //Failed Message
                            updateUI(null);
                        }
                        //hideProgressDialog();
                    }
                });
    }

    public void signIn(String email, String password) {
        //check for valid form
        if(!validateForm()) {
            return;
        }

        //showProgressDialog();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }
                else {
                    //Failed message
                    updateUI(null);
                }

                if(!task.isSuccessful()) {
                    // mStatusTextView.setText(R.string.auth_failed);
                }
                //hideProgressDialog();
            }
        });
    }

    public void signOut() {
        mAuth.signOut();
        //updateUI(null)
    }

    private void sendEmailVerification() {

    }

    private boolean validateForm() {
        boolean valid = true;
        return valid;

    }

    private void updateUI(FirebaseUser user) {

    }

    @Override
    public void onClick(View v) {

    }
*/
}
