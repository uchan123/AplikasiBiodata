package com.example.user.biodata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 25/05/2016.
 */
public class AlumniDetailActivity extends AppCompatActivity {

    ImageView imgFoto;
    TextView txtName;
    TextView txtNim;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpView();
    }

    private void setUpView(){
        imgFoto = (ImageView) findViewById(R.id.img_foto);
        txtName = (TextView) findViewById(R.id.txtnama);
        txtNim = (TextView) findViewById(R.id.txtnpm);

        int pos = getIntent().getIntExtra("pos", 0);

        Alumni alumni = AlumniSingle.i().get(pos);

        txtName.setText(alumni.getNama());
        txtNim.setText(alumni.getNpm());
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
