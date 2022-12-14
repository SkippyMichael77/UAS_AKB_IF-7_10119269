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

public class Register extends AppCompatActivity {

    private FirebaseAuth mauth;
    private EditText email,password;
    private Button register_btn;
    private TextView login_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mauth=FirebaseAuth.getInstance();
        email=findViewById(R.id.reg_mail);
        password=findViewById(R.id.reg_password);
        register_btn=findViewById(R.id.register_btn);
        login_text=findViewById(R.id.login_text);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Registers();

            }
        });
        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });
    }

    private void Registers() {

        String user= email.getText().toString().trim();
        String pass= password.getText().toString().trim();
        if (user.isEmpty()){
            email.setError("Email tidak boleh kosong");

        }if (pass.isEmpty()){
            password.setError("Password tidak boleh kosong");
        }
        else{
            mauth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Register.this, "User registered successfully!", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(Register.this,MainActivity.class));

                    }
                    else
                    {
                        Toast.makeText(Register.this, "Registration Failed!!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
