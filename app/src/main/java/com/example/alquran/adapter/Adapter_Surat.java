package com.example.alquran.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alquran.DetailSurat;
import com.example.alquran.R;
import com.example.alquran.model.ResponseSurat;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Harri Pratomo on 20/04/2020.
 * <p>
 * harrypratomo135@gmail.com
 */
public class Adapter_Surat extends RecyclerView.Adapter<Adapter_Surat.ViewHolder> {

    private Context context;
    private List<ResponseSurat> list;

    public Adapter_Surat(Context context, List<ResponseSurat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter_Surat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_surat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Surat.ViewHolder holder, int position) {
        ResponseSurat surat = list.get(position);
        holder.nameSurat.setText(surat.getNama());
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailSurat.class);
                intent.putExtra("nama_surat",surat.getNama());
                intent.putExtra("istilah_arab",surat.getAsma());
                intent.putExtra("arti",surat.getArti());
                intent.putExtra("jumlah_ayat",surat.getAyat());
                intent.putExtra("audio",surat.getAudio());
                intent.putExtra("keterangan",surat.getKeterangan());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameSurat;
        private RelativeLayout row;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameSurat = itemView.findViewById(R.id.name_surat);
            row = itemView.findViewById(R.id.rowLayout);
        }
    }
}
