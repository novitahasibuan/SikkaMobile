package id.go.pajak.sikkamobile.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import id.go.pajak.sikkamobile.model.Presensi;
import id.go.pajak.sikkamobile.R;
/**
 * Created by TTKI on 19-Jul-17.
 */

public class PresensiAdapter extends RecyclerView.Adapter<PresensiAdapter.PresensiViewHolder> {
    private Context mContext;
    private List<Presensi> presensiList;

    public class PresensiViewHolder extends RecyclerView.ViewHolder {
        public TextView hari, jam_masuk, jam_keluar, keterangan;

        public PresensiViewHolder(View view) {
            super(view);
            hari = (TextView) view.findViewById(R.id.tanggal);
            jam_masuk = (TextView) view.findViewById(R.id.jammasuk);
            jam_keluar = (TextView) view.findViewById(R.id.jamkeluar);
            keterangan = (TextView) view.findViewById(R.id.ket);
        }

    }

    public PresensiAdapter(Context mContext, List<Presensi> presensiList) {
        this.mContext = mContext;
        this.presensiList = presensiList;
    }

    @Override
    public PresensiViewHolder onCreateViewHolder(ViewGroup paren, int viewType) {
        View itemview = LayoutInflater.from(paren.getContext())
                .inflate(R.layout.presensi_card, paren, false);
        return new PresensiViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final PresensiViewHolder holder, final int position) {
        final Presensi presensi = presensiList.get(position);
        holder.hari.setText(presensi.getHari());
        holder.jam_masuk.setText(presensi.getJam_masuk());
        holder.jam_keluar.setText(presensi.getJam_keluar());
        holder.keterangan.setText(presensi.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return presensiList.size();
    }
}
