package com.teknokrat.mobile2019_TI17A_17313027_nekopio;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity_Login extends AppCompatActivity {
    Button btn_daftar,btn_masuk;
    EditText email_et,password_et;
    String email_txt,password_txt;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener fStateListener;

    private static final String TAG = Activity_Login.class.getSimpleName();


    RelativeLayout rellay1, rellay2;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
        btn_daftar = findViewById(R.id.btn_daftar);
        email_et    = findViewById(R.id.emailET);
        password_et = findViewById(R.id.passwordET);
        mAuth = FirebaseAuth.getInstance();
        btn_masuk = findViewById(R.id.btn_masuk);
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_txt = email_et.getText().toString();
                password_txt = password_et.getText().toString();
                if (TextUtils.isEmpty(email_txt)) {
                    Toast.makeText(getApplicationContext(), "Masukan Email !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password_txt)) {
                    Toast.makeText(getApplicationContext(), "Masukan Password !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email_txt, password_txt)
                        .addOnCompleteListener(Activity_Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {



                                    // Login sukses, masuk ke Main Activity
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(Activity_Login.this, MainActivity.class);

                                    //bundle
                                    Bundle bundle = new Bundle();
                                    bundle.putString("data1", email_et.getText().toString());
                                    intent.putExtras(bundle);


                                    intent.putExtra("data1", email_et.getText().toString());
                                    //bundle


                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Jika Login gagal, memberikan pesan
                                    Toast.makeText(Activity_Login.this, "Proses Login gagal : " +  task.getException(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
        //Click listerner, kalau tombol btn_daftar di klik. Membuka activity register
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Login.this, Activity_Register.class));
                finish();
            }
        });
    }}
