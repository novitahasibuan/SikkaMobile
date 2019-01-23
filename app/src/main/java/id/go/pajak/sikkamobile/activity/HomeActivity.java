package id.go.pajak.sikkamobile.activity;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.go.pajak.sikkamobile.R;
import id.go.pajak.sikkamobile.adapter.MenusAdapter;
import id.go.pajak.sikkamobile.helper.PicassoCircleTransformation;
import id.go.pajak.sikkamobile.model.Menu;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MenusAdapter adapter;
    private List<Menu> menuList;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Picasso.with(getApplicationContext()).load("http://edukasi.pajak.go.id/ws/assets/images/users/addin.jpg")
                .error(R.drawable.ic_user)
                .transform(new PicassoCircleTransformation())
                .into((ImageView) findViewById(R.id.picassoImageView));

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Welcome Kim Taeyeon", Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        menuList = new ArrayList<>();
        adapter = new MenusAdapter(this, menuList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareMenus();
    }

    private void prepareMenus() {
        int[] covers = new int[]{
                R.drawable.iconprofile,
                R.drawable.cuti,
                R.drawable.absensi,
                R.drawable.logout,};

        Menu m = new Menu("Profile", covers[0]);
        menuList.add(m);

        m = new Menu("Cuti", covers[1]);
        menuList.add(m);

        m = new Menu("Presensi", covers[2]);
        menuList.add(m);

        m = new Menu("Logout", covers[3]);
        menuList.add(m);

        adapter.notifyDataSetChanged();
    }
}
