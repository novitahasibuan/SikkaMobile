package id.go.pajak.sikkamobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import id.go.pajak.sikkamobile.R;
import id.go.pajak.sikkamobile.adapter.PresensiAdapter;
import id.go.pajak.sikkamobile.model.Presensi;

public class PresensiActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PresensiAdapter adapter;
    private List<Presensi> presensiList;
    private ImageView back;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presensi);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);

        presensiList = new ArrayList<>();
        adapter = new PresensiAdapter(this, presensiList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        back = (ImageView) findViewById(R.id.back_img);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PresensiActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItem();
            }
        });
        preparePresensi();
    }

    private void preparePresensi() {

        Presensi p = new Presensi("15 Juni 2017", "07:30:00", "14:00:00", "TL1, PSW1");
        presensiList.add(p);

        p = new Presensi("16 Juni 2017", "07:35:00", "14:10:00", "TL2, PSW2");
        presensiList.add(p);

        p = new Presensi("17 Juni 2017", "07:40:00", "14:15:00", "TL3, PSW3");
        presensiList.add(p);

        p = new Presensi("18 Juni 2017", "07:45:00", "14:20:00", "TL4, PSW4");
        presensiList.add(p);

        adapter.notifyDataSetChanged();
    }

    private void refreshItem() {
        int count = 0;
        if (adapter != null) {
            count = adapter.getItemCount();
            if (count == 4) {

            } else preparePresensi();
        }
        onItemsLoadComplete();
    }

    private void onItemsLoadComplete() {
        adapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);

    }
}
