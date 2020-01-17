package com.teknokrat.mobile2019_TI17A_17313027_nekopio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.net.Proxy.Type.HTTP;


public class About_Activity extends AppCompatActivity {

    private Button btnBack, buttonwa, buttontelp, buttonmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_);
        btnBack = (Button)findViewById(R.id.back);

        final TextView tvData1 = (TextView) findViewById(R.id.textView2);

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








        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent intent = new Intent(About_Activity.this, MainActivity.class);
                intent.putExtra("data1", tvData1.getText().toString());



                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */
                //ambil data emailuntuk bundle

                //slesai bundle

                startActivity(intent);


            }
        });
        buttonwa = (Button)findViewById(R.id.btnwa);
        buttonwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:" + "6281272724378");
                Intent u = new Intent(Intent.ACTION_SENDTO, uri);
                u.setPackage("com.whatsapp");
                startActivity(u);
            }
        });
        buttonwa = (Button)findViewById(R.id.btnwa);
        buttonwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:" + "6281272724378");
                Intent u = new Intent(Intent.ACTION_SENDTO, uri);
                u.setPackage("com.whatsapp");
                startActivity(u);
            }
        });
        buttontelp = (Button)findViewById(R.id.btntelp);
        buttontelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:" + "+6281272724378");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });
        buttonmail = (Button)findViewById(R.id.btnmail);
        buttonmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", "nipox99@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_EMAIL,"");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"");
                startActivityForResult(emailIntent, 1);
            }
        });

    }
}
