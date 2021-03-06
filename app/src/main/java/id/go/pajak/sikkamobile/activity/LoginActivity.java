package id.go.pajak.sikkamobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.go.pajak.sikkamobile.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)findViewById(R.id.logbtnLogin);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == loginButton) {
            startActivity(new Intent(this, HomeActivity.class));
        }
    }
}
