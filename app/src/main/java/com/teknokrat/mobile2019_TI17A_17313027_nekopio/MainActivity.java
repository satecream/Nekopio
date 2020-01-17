package com.teknokrat.mobile2019_TI17A_17313027_nekopio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button logout, about, play, maps;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvData1 = (TextView) findViewById(R.id.textView2);



        //ambil data emailuntuk bundle
        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            tvData1.setText(bundle.getString("data1"));

        }else{
            /**
             * Apabila Bundle tidak ada, ambil dari Intent
             */
            tvData1.setText(getIntent().getStringExtra("data1"));

        }
        //slesai bundle



        // Pengambilan data, apakah ada yang login.
        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.back);
        final FirebaseUser user = mAuth.getCurrentUser();
        //Pengecekan, jika tidak ada login. Di arahkan ke Login activity.
        if (user == null) {
            startActivity(new Intent(MainActivity.this, Activity_Login.class));
            finish();
        }
        logout = findViewById(R.id.back);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Logout user dan alihkan ke form login.
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, Activity_Login.class));
                finish();
            }
        });
        //
        about = findViewById(R.id.btnabout);
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent i = new Intent(MainActivity.this, About_Activity.class);
                i.putExtra("data1", tvData1.getText().toString());



                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */

                startActivity(i);

            }
        });
        play = findViewById(R.id.btnplay);
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent i = new Intent(MainActivity.this, Play_Activity.class);
                i.putExtra("data1", tvData1.getText().toString());



                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */

                startActivity(i);

            }
        });
        maps = findViewById(R.id.btnmaps);
        maps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                i.putExtra("data1", tvData1.getText().toString());



                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */

                startActivity(i);

            }
        });
    }}
