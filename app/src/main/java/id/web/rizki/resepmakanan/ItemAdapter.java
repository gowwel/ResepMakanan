package id.web.rizki.resepmakanan;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RN on 10/2/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    Context context;
    String judul[],deskripsi[],bahan[],pembuatan[];
    int img[];

    public ItemAdapter(Context context, String j[],String d[], String b[], String p[], int img_[]) {
        this.context = context;
        this.judul = j;
        this.deskripsi = d;
        this.bahan = b;
        this.pembuatan = p;
        this.img = img_;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_resepmakanan,null);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, final int position) {
        holder.textJudul.setText(judul[position]);
        holder.textDeskripsi.setText(deskripsi[position]);
        holder.img_item.setImageResource(img[position]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),DetailItem.class);
                i.putExtra("id_img", img[position]);
                i.putExtra("id_judul", judul[position]);
                i.putExtra("id_deskripsi", deskripsi[position]);
                i.putExtra("id_bahan", bahan[position]);
                i.putExtra("id_pembuatan", pembuatan[position]);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return judul.length;
    }

    class ItemHolder extends RecyclerView.ViewHolder{

        /*
        Class ini digunakan untuk mengambil data sebuah variabel untuk object dengan id tertentu
         */

        //Deklarasi Variabel
        CardView cardView;
        ImageView img_item;
        TextView textJudul, textDeskripsi;

        public ItemHolder(View v) {
            super(v);

            img_item = (ImageView) v.findViewById(R.id.img_makanan);
            textJudul = (TextView) v.findViewById(R.id.text_judul);
            textDeskripsi = (TextView) v.findViewById(R.id.text_deskripsi);
            cardView = (CardView) v.findViewById(R.id.cardItem);
        }
    }

}
