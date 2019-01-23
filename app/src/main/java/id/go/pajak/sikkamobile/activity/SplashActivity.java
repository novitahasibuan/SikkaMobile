package id.go.pajak.sikkamobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.go.pajak.sikkamobile.R;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{
    TextView selanjutnya;
    ImageView lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        selanjutnya = (TextView) findViewById(R.id.next_text);
        lanjut = (ImageView) findViewById(R.id.next_logo);
        selanjutnya.setOnClickListener(this);
        lanjut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == selanjutnya) {
            startActivity(new Intent(this, TapActivity.class));
        } else if (v == lanjut) {
            startActivity(new Intent(this, TapActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
