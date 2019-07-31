package com.rymu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEmailaddress,mpassword;
    Button mbuttonlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmailaddress=(EditText)findViewById(R.id.etemail);
        mpassword=(EditText)findViewById(R.id.etpass);
        mbuttonlogin=(Button)findViewById(R.id.btnlogin);

        validate();
    }

    private boolean validate() {
        boolean result=false;
        String getmEmail=mEmailaddress.getText().toString();
        String getmpass=mpassword.getText().toString();

        if (getmEmail.isEmpty()){
            Toast.makeText(this, "Email is valid", Toast.LENGTH_SHORT).show();
        }else if (getmpass.isEmpty()){
            Toast.makeText(this, "password empty", Toast.LENGTH_SHORT).show();
        }else {
            result=true;
        }
        return result;
    }

    public void Movetoregistration(View view) {
        startActivity(new Intent(MainActivity.this,RegisterActivity.class));
    }

    public void LoginUser(View view) {
        validate();
    }
}

