package id.go.pajak.sikkamobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import id.go.pajak.sikkamobile.R;
import id.go.pajak.sikkamobile.helper.PicassoCircleTransformation;

public class ProfileActivity extends AppCompatActivity {
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Picasso.with(getApplicationContext()).load("http://edukasi.pajak.go.id/ws/assets/images/users/addin.jpg")
                .error(R.drawable.ic_user)
                .transform(new PicassoCircleTransformation())
                .into((ImageView) findViewById(R.id.picassoImageView));

        back = (ImageView) findViewById(R.id.back_img);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
    }
}
