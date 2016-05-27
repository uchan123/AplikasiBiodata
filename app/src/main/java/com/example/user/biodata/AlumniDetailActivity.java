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
    TextView txtTTL;
    TextView txtEmail;
    TextView txtTelp;
    TextView txtKeahlian;
    TextView txtProfesi;
    TextView txtPengalaman;
    TextView txtOrtu;
    TextView txtAlamat;
    TextView txtJudul;

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
        txtTTL = (TextView) findViewById(R.id.txtTTL);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtTelp = (TextView) findViewById(R.id.txtTelp);
        txtKeahlian = (TextView) findViewById(R.id.txtKeahlian);
        txtProfesi = (TextView) findViewById(R.id.txtProfesi);
        txtPengalaman = (TextView) findViewById(R.id.txtPengalaman);
        txtOrtu = (TextView) findViewById(R.id.txtOrtu);
        txtAlamat = (TextView) findViewById(R.id.txtAlamat);
        txtJudul = (TextView) findViewById(R.id.txtSkripsi);

        String npm = getIntent().getStringExtra("npm");

        DatabaseHelper db = new DatabaseHelper(this);
        Alumni alumni = db.getAlumni(npm);

        Picasso.with(this).load(alumni.getFoto()).into(imgFoto);

        txtName.setText(alumni.getNama());
        txtNim.setText(alumni.getNpm());
        txtIpk.setText(String.valueOf(alumni.getIpk()));
        txtTTL.setText(alumni.getTtl());
        txtEmail.setText(alumni.getEmail());
        txtTelp.setText(alumni.getTelp());
        txtKeahlian.setText(alumni.getKeahlian());
        txtProfesi.setText(alumni.getProfesi());
        txtPengalaman.setText(alumni.getPengalaman());
        txtOrtu.setText(alumni.getNama_ortu());
        txtAlamat.setText(alumni.getAlamat());
        txtJudul.setText(alumni.getJudul_skripsi());
        
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
