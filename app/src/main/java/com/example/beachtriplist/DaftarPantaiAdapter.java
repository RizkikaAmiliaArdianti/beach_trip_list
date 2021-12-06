package com.example.beachtriplist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import com.example.beachtriplist.Model.Pantai;

public class DaftarPantaiAdapter extends ArrayAdapter<Pantai> {

    Context context;

    public DaftarPantaiAdapter(Context context, List<Pantai> pantais) {
        super(context, R.layout.row_daftar_pantai, pantais);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textJenis;
        TextView textAsal;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pantai pantai = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_pantai, parent, false);
            viewHolder.textJenis =  convertView.findViewById(R.id.row_text_jenis);
            viewHolder.textAsal = (TextView) convertView.findViewById(R.id.row_text_asal);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_pantai);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textJenis.setText(pantai.getNama());
        viewHolder.textAsal.setText(pantai.getAsal());
        viewHolder.gambar.setImageDrawable(context.getDrawable(pantai.getDrawableRes()));
        return convertView;
    }

}