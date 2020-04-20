package com.example.alquran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailSurat extends AppCompatActivity {
    private TextView txtName, txtArab, txtjumlah_ayat, txt_audio, txtArti, txtKeterangan;
    private String name, arab, jumlah, audio, arti, keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surat);
        init();
    }

    private void init() {
        txtName = findViewById(R.id.nameSurat);
        txtArab = findViewById(R.id.txtArab);
        txtjumlah_ayat = findViewById(R.id.jumlahSurat);
        txtArti = findViewById(R.id.artiSurat);
        txt_audio = findViewById(R.id.audio);
        txtKeterangan = findViewById(R.id.txtDesc);
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        name = getIntent().getStringExtra("nama_surat");
        arab = getIntent().getStringExtra("istilah_arab");
        jumlah = getIntent().getStringExtra("jumlah_ayat");
        audio = getIntent().getStringExtra("audio");
        arti = getIntent().getStringExtra("arti");
        keterangan = getIntent().getStringExtra("keterangan");

        txtName.setText(name);
        txtArab.setText(arab);
        txtjumlah_ayat.setText(jumlah);
        txt_audio.setText(audio);
        txtArti.setText(arti);
        txtKeterangan.setText(keterangan);
    }
}
