package com.example.alex.leggo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText firstName;
    private EditText lastName;
    private EditText userAge;
    private EditText userAdd;
    private EditText newEmail;
    private EditText newPass;
    private Button regUser;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        prog = new ProgressDialog(this);
        firstName = (EditText)findViewById(R.id.fname);
        lastName = (EditText)findViewById(R.id.lname);
        userAge = (EditText)findViewById(R.id.age);
        userAdd = (EditText)findViewById(R.id.address);
        newEmail = (EditText)findViewById(R.id.emailText);
        newPass = (EditText)findViewById(R.id.passText);

        regUser = (Button)findViewById(R.id.signup);


    }

    @Override
    public void onClick(View view){
        if(view == regUser){
            //go to enrollUser() activity;
            enrollUser();
        }
    }

    private void enrollUser(){
        String nameFirst = firstName.getText().toString().trim();
        String nameLast = lastName.getText().toString().trim();
        String add = userAdd.getText().toString().trim();
        String Age = userAge.getText().toString().trim();
        String userEmail = newEmail.getText().toString().trim();
        String userPass = newPass.getText().toString().trim();

        if(TextUtils.isEmpty(nameFirst)){
            //Trow an error in andriod we call it toast
            Toast.makeText(this, "Please enter your first name!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(nameLast)){
            Toast.makeText(this, "Please enter your last name!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(add)){
            //Trow an error in andriod we call it toast
            Toast.makeText(this, "Please enter your address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Age)){
            Toast.makeText(this, "Please enter your age!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            //Trow an error in andriod we call it toast
            Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPass)){
            Toast.makeText(this, "Please enter your password!", Toast.LENGTH_SHORT).show();
            return;
        }

        prog.setMessage("Registering...");
        prog.show();


        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //display a successful message
                    Toast.makeText(SignUpActivity.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Registration Failed. Try Again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
