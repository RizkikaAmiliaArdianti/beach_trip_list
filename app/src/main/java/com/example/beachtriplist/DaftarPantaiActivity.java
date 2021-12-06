package com.example.beachtriplist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.example.beachtriplist.Model.Pantai;

public class DaftarPantaiActivity extends AppCompatActivity {
    public final static String PANTAI_TERPILIH ="pantai_obj_key";
    List<Pantai> pantais;
    ListView listView;
    String jenisPantai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pantai);
        Intent intent = getIntent();
        jenisPantai = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar);
        txJudul.setText("DAFTAR PANTAI di  "+jenisPantai.toUpperCase());
        pantais = DataProvider.getPantaisByTipe(this,jenisPantai);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_pantai);
        DaftarPantaiAdapter adapter = new DaftarPantaiAdapter(this,pantais);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Pantai terpilih = pantais.get(position);
            bukaProfilePantai(terpilih);
        }
    };

    private void bukaProfilePantai(Pantai pantaiTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, ProfilePantaiActivity.class);
        intent.putExtra(PANTAI_TERPILIH, pantaiTerpilih);
        startActivity(intent);
    }


}
