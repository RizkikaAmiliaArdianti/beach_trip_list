package com.example.beachtriplist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnLotim,btnLoteng,btnKlu;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnLotim = findViewById(R.id.btn_lotim);
        btnLoteng = findViewById(R.id.btn_loteng);
        btnKlu = findViewById(R.id.btn_klu);
        btnLotim.setOnClickListener(view -> bukaGaleri("Lotim"));
        btnLoteng.setOnClickListener(view -> bukaGaleri("Loteng"));
        btnKlu.setOnClickListener(view -> bukaGaleri("Klu"));
    }

    private void bukaGaleri(String jenisPantai) {
        Log.d("MAIN","Buka activity Lotim");
        Intent intent = new Intent(this, DaftarPantaiActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisPantai);
        startActivity(intent);
    }

public void bukabiodata( View view){
    Intent intent = new Intent(MainActivity.this, profil_activity.class);
    startActivity(intent);
}
}