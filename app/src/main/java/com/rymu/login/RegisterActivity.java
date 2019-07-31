package com.rymu.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText username,userpassword,confirmpassword,useremail;
    Button regbutton;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findids();
        validate();
    }

    private boolean validate() {
        boolean result=false;
        String getname=username.getText().toString();
        String getnemail=useremail.getText().toString();
        String getpassword=userpassword.getText().toString();
        String getconfirmpassword=confirmpassword.getText().toString();
        if (getname.isEmpty()){
            Toast.makeText(this,"The username is empty",Toast.LENGTH_LONG).show();
        }else if (getnemail.isEmpty()){
            Toast.makeText(this,"The email is empty",Toast.LENGTH_SHORT).show();
        }else if (getpassword.isEmpty()){
            Toast.makeText(this, "the password is empty", Toast.LENGTH_SHORT).show();
        }else if (getconfirmpassword.isEmpty()){
            Toast.makeText(this, "confirm password is empty", Toast.LENGTH_SHORT).show();
        }else if (!getpassword.equals(confirmpassword)){
            Toast.makeText(this, "password mismatch", Toast.LENGTH_SHORT).show();

        }else {
            result=true;
        }
        return result;
    }

    private void findids() {
        username=(EditText)findViewById(R.id.etUsername);
        useremail=(EditText)findViewById(R.id.etUseremail);
        userpassword=(EditText)findViewById(R.id.etpass);
        confirmpassword=(EditText)findViewById(R.id.etConfirmpass);
        regbutton=(Button)findViewById(R.id.btnregister);

    }

    public void Movetologin(View view) {
        startActivity(new Intent(RegisterActivity.this,RegisterActivity.class));
    }

    public void RegisterUser(View view) {
        if (validate()){
            String reg_email=useremail.getText().toString().trim();
            String reg_password=userpassword.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(reg_email,reg_password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registration was successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    }else {
                        Toast.makeText(RegisterActivity.this, "Registration not successfull", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}


