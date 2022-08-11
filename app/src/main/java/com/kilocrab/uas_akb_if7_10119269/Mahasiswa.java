package com.kilocrab.uas_akb_if7_10119269;

//10119269, Zuhair Rasyid Wafi, IF7

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Mahasiswa extends AppCompatActivity {

    private FirebaseAuth mauth;
    private Button logout_btn;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);
        logout_btn=findViewById(R.id.logout_btn);
        mauth=FirebaseAuth.getInstance();
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        //PENTING
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_mahasiswa);

        //inisialisasi
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.nav_home:
                    startActivity(new Intent(getApplicationContext()
                            ,MainActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.nav_mahasiswa:
                    return true;
                case R.id.nav_about:
                    startActivity(new Intent(getApplicationContext()
                            , About.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Mahasiswa.this,Login.class));
    }

    public void onBackPressed(){
        Toast.makeText(Mahasiswa.this, "Please Click the Home Button", Toast.LENGTH_LONG).show();
    }

}