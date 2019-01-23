package id.go.pajak.sikkamobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.go.pajak.sikkamobile.R;

public class TapActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap);

        buttonLogin = (Button)findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonLogin) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
