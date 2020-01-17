package com.teknokrat.mobile2019_TI17A_17313027_nekopio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class Play_Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_);
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

                Intent intent = new Intent(Play_Activity.this, MainActivity.class);
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
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new MahasiswaAdapter(mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Play_Activity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Robert Downey Jr,", "Sebagai : Tony Stark", "Quotes : I am Iron Man"));
        mahasiswaArrayList.add(new Mahasiswa("Chris Hemsworth", "Sebagai : Thor", "Quotes : Brother, however I have wronged you, whatever I have done that has led you to do this, I am truly sorry. But these people are innocent: taking their lives will gain you nothing. So take mine, and end this"));
        mahasiswaArrayList.add(new Mahasiswa("Steve Rogers (Chris Evans)", "Sebagai : Captain America", "Quotes : Whatever happens tomorrow you must promise me one thing. That you will stay who you are. Not a perfect soldier, but a good man"));
        mahasiswaArrayList.add(new Mahasiswa("Paul Rudd", "Sebagai : Ant Man", "Quotes : Wait I didn’t steal anything! I was returning something I stole!"));
        mahasiswaArrayList.add(new Mahasiswa("Mark Ruffalo", "Sebagai : Hulk", "Quotes : You know, I know a few techniques that could help you manage that anger effectively"));
        mahasiswaArrayList.add(new Mahasiswa("Doctor Stephen Strange (Benedict Cumberbatch)", "Sebagai : Doctor Strange", "Quotes : Arrogance and fear still keep you from learning the simplest and most significant lesson of all"));
        mahasiswaArrayList.add(new Mahasiswa("Tom Holland", "Sebagai : Spider-Man", "Quotes : You need to stop carrying the weight of the world on your shoulders"));
        mahasiswaArrayList.add(new Mahasiswa("Chadwick Boseman", "Sebagai : Black Panther", "Quotes : Just because something works doesn’t mean it can’t be improved"));
        mahasiswaArrayList.add(new Mahasiswa("Josh Brolin", "Sebagai : Thanos", "Quotes : The entire time I knew Thanos, he only ever had one goal, to bring balance to the universe by wiping out half of all life. He used to kill people planet by planet, massacre by massacre"));
        mahasiswaArrayList.add(new Mahasiswa("Brie Larson", "Sebagai : Captain Marvel", "Quotes : I keep having these memories. Something in my past is the key to all of this"));
        mahasiswaArrayList.add(new Mahasiswa("Tom Hiddleston", "Sebagai : Loki", "Quotes : I never wanted the throne, I only ever wanted to be your equal!"));
        mahasiswaArrayList.add(new Mahasiswa("Agung Bambang Sadewo", "Sebagai : Pembuat Aplikasi Nekopio", "Quotes : manusia itu gak ngerti apa apa"));
    }
    }


