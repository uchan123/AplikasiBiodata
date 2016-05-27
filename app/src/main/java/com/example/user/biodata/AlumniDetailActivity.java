package com.example.user.biodata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by user on 25/05/2016.
 */
public class AlumniDetailActivity extends AppCompatActivity {

    ImageView imgFoto;
    TextView txtName;
    TextView txtNim;
    TextView txtIpk;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Alumni");
        setUpView();
    }

    private void setUpView(){
        imgFoto = (ImageView) findViewById(R.id.img_foto);
        txtName = (TextView) findViewById(R.id.txtNama);
        txtNim = (TextView) findViewById(R.id.txtNpm);
        txtIpk = (TextView) findViewById(R.id.txtIPK);

        String npm = getIntent().getStringExtra("npm");

        DatabaseHelper db = new DatabaseHelper(this);
        Alumni alumni = db.getAlumni(npm);

        Picasso.with(this).load(alumni.getFoto()).into(imgFoto);

        txtName.setText(alumni.getNama());
        txtNim.setText(alumni.getNpm());
        txtIpk.setText(String.valueOf(alumni.getIpk()));
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item){
       switch (item.getItemId()){
           case android.R.id.home:
               finish();
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }
   }
}
