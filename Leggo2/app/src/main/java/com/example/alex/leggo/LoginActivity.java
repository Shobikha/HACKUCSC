package com.example.alex.leggo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.pyze.android.Pyze;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    private Button register;
    private EditText email;
    private EditText pass;
    private Button login;

    private ProgressDialog loading;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Pyze.initialize(getApplication());
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            Intent myEvent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(myEvent);
        }

        register = (Button)(findViewById(R.id.signup));
        email = (EditText)(findViewById(R.id.emailText));
        pass = (EditText)(findViewById(R.id.passText));
        login = (Button)(findViewById(R.id.signin));

        register.setOnClickListener(this);
        login.setOnClickListener(this);

        loading = new ProgressDialog(this);

    }
    @Override
    public void onClick(View view){
        if(view == register){
            //go to enrollUser() activity;
            finish();
            Intent event = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(event);
        }

        if(view == login){
            logInUser();
        }
    }


    private void logInUser(){
        //We need to first check if we the user typed everyhting in and there is no blank
        String userEmail = email.getText().toString().trim();
        String userPass = pass.getText().toString().trim();

        if(TextUtils.isEmpty(userEmail)){
            //Trow an error in andriod we call it toast
            Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPass)){
            Toast.makeText(this, "Please enter your password!", Toast.LENGTH_SHORT).show();
            return;
        }


        //If the user enters the email and password show that you are registering
        loading.setMessage("Loging In...");
        loading.show();

        firebaseAuth.signInWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                loading.dismiss();
                if(task.isSuccessful()){ //log in successful then go to the main menu
                    finish();
                    Intent myEvent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myEvent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid Email or Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
