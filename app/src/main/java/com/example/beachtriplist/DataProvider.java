package com.example.beachtriplist;

import android.content.Context;

import com.example.beachtriplist.Model.Klu;
import com.example.beachtriplist.Model.Loteng;
import com.example.beachtriplist.Model.Lotim;
import com.example.beachtriplist.Model.Pantai;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Pantai> pantais = new ArrayList<>();

    private static List<Lotim> initDataLotim(Context ctx) {
        List<Lotim> lotims = new ArrayList<>();
        lotims.add(new Lotim("Pantai Kura-Kura", "Desa Ekas Buana, Kecamatan Jerowaru",
                "Keunikan dari pantai ini yaitu letaknya yang tersembunyi diapit oleh dua bukit yang tinggi menjulang", R.drawable.pantai_kura_kura));
        lotims.add(new Lotim("Pantai Surga", "Desa Ekas, Kecamatan Jerowaru",
                "Daya tarik pantai surga pasir keemasan dan air laut yang jernih, pemandangan perbukitan yang eksotis, ", R.drawable.pantai_surga));
        lotims.add(new Lotim("Pantai Pink", "Desa Sekaroh, Kecamatan Jerowaru",
                "Pantai ini merupakan salah satu dari tujuh pantai didunia yang memiliki pasir pantai berwarna pink", R.drawable.pantai_pink));

        return lotims;
    }

    private static List<Loteng> initDataLoteng(Context ctx) {
        List<Loteng> lotengs = new ArrayList<>();
        lotengs.add(new Loteng("Pantai Selong Belanak", "Kecamatan Praya Barat",
                "pantai ini populer untuk berenang dan berselancar, dengan pasir putih, air jernih serta penyewaan kursi berjemur.", R.drawable.pantai_selong_belanak));
        lotengs.add(new Loteng("Panati Semeti", "Desa Mekarsari, Kecamatan Pujut",
                "Keunikan pantai Lombok yang satu ini ialah dengan keberadaan dari batu karang yang memanjang dan bertumpuk sehingga membentuk tebing-tebing.", R.drawable.pantai_semeti));
        lotengs.add(new Loteng("Pantai Tanjung Aan", "Desa Pengembur, Pujut,",
                "Pemandangan dari atas bukit ini keren abis, di atasnya kamu bisa melihat hamparan pesisir pantai Aan yang cantik.", R.drawable.pantai_tanjung_aan));
        return lotengs;
    }

    private static List<Klu> initDataKlu(Context ctx) {
        List<Klu> klus = new ArrayList<>();
        klus.add(new Klu("Pantai Gili Trawangan", "Desa Gili Indah, Lombok Utara",
                "emiliki pantai dengan pasir putih yang indah, terumbu karang yang masih alami, serta biota laut yang cantik.", R.drawable.pantai_gili_trawangan));
        klus.add(new Klu("Pantai Kecinan", " jln. Raya Senggigi, Malaka, Pemenang",
                "Anjing jenis khusus yang awa", R.drawable.pantai_kecinan));
        klus.add(new Klu("Pantai Senggigi", "Jl. Raya Senggigi km 6-7, Kecamatan Batu Layar",
                "menyajikan pemandangan pantai yang indah nan mempesona, warna air autnya hijau kebiru-biruan dan memiliki pemandangan bawah laut", R.drawable.pantai_senggigi));
        return klus;
    }




    private static void initAllPantais(Context ctx) {
        pantais.addAll(initDataLotim(ctx));
        pantais.addAll(initDataLoteng(ctx));
        pantais.addAll(initDataKlu(ctx));
    }

    public static List<Pantai> getAllPantai(Context ctx) {
        if (pantais.size() == 0) {
            initAllPantais(ctx);
        }
        return  pantais;
    }

    public static List<Pantai> getPantaisByTipe(Context ctx, String jenis) {
        List<Pantai> pantaisByType = new ArrayList<>();
        if (pantais.size() == 0) {
            initAllPantais(ctx);
        }
        for (Pantai h : pantais) {
            if (h.getJenis().equals(jenis)) {
                pantaisByType.add(h);
            }
        }
        return pantaisByType;
    }

}