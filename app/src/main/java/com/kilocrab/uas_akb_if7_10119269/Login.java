package com.kilocrab.uas_akb_if7_10119269;

//10119269, Zuhair Rasyid Wafi, IF7

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth mauth;
    private EditText mail,password;
    private Button login_btn;
    private TextView reg_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mauth=FirebaseAuth.getInstance();
        mail=findViewById(R.id.login_mail);
        password=findViewById(R.id.login_password);
        login_btn=findViewById(R.id.login_btn);
        reg_text=findViewById(R.id.register_text);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        reg_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));

            }
        });
    }

    private void login() {
        String user= mail.getText().toString().trim();
        String pass= password.getText().toString().trim();
        if (user.isEmpty()){
            mail.setError("Email tidak boleh kosong");

        }if (pass.isEmpty()){
            password.setError("Password tidak boleh kosong");
        }
        else
        {
            mauth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful())
                    {
                        Toast.makeText(Login.this, "Login Successfully..", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this,MainActivity.class));


                    }
                    else
                    {
                        Toast.makeText(Login.this, "Login Failed!!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void onBackPressed(){
        Toast.makeText(Login.this, "Please Click the Home Button", Toast.LENGTH_LONG).show();
    }
}
