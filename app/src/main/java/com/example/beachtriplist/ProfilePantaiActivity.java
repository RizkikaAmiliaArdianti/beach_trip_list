package com.example.beachtriplist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.beachtriplist.Model.Pantai;

public class ProfilePantaiActivity extends AppCompatActivity {

    Pantai pantai;
    TextView txJudul,txJenis,txAsal,txDeskripsi;
    ImageView ivFotoPantai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_pantai);
        Intent intent = getIntent();
        pantai = (Pantai) intent.getSerializableExtra(DaftarPantaiActivity.PANTAI_TERPILIH);
        inisialisasiView();
        tampilkanProfil(pantai);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoPantai = findViewById(R.id.gambarpantai);
    }


    private void tampilkanProfil(Pantai pantai) {
        Log.d("Profil","Menampilkan "+pantai.getJenis());
        txJudul.setText(pantai.getJenis());
        txJenis.setText(pantai.getNama());
        txAsal.setText(pantai.getAsal());
        txDeskripsi.setText(pantai.getDeskripsi());
        ivFotoPantai.setImageDrawable(this.getDrawable(pantai.getDrawableRes()));
    }




}