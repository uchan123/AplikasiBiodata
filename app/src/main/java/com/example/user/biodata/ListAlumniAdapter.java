package com.example.user.biodata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by user on 21/05/2016.
 */
public class ListAlumniAdapter extends ArrayAdapter<Alumni>{

    Context context;
    int resource;
    List<Alumni>alumnis;

    public ListAlumniAdapter(Context context, int resource, List<Alumni>alumnis) {
        super(context, resource, alumnis);

        this.context = context;
        this.resource = resource;
        this.alumnis = alumnis;
    }

    @Override
    public int getCount(){
        return alumnis.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView){
            convertView = LayoutInflater.from(context).inflate(resource,parent, false);
        }

        ViewHolder vh = new ViewHolder();
        vh.imgFoto = (ImageView) convertView.findViewById(R.id.imgfoto);
        vh.txtnama = (TextView) convertView.findViewById(R.id.txtnama);
        vh.txtnpm = (TextView) convertView.findViewById(R.id.txtnpm);
        vh.txtkeahlian = (TextView) convertView.findViewById(R.id.id_keahlian);

        vh.txtnpm.setText(alumnis.get(position).getNpm());
        vh.txtnama.setText(alumnis.get(position).getNama());
        vh.txtkeahlian.setText(alumnis.get(position).getKeahlian());

        Picasso.with(context).load(alumnis.get(position).getFoto()).into(vh.imgFoto);
        //System.out.println(alumnis.get(position).getFoto());

        return convertView;
    }
    /*
    @Override
    public int getCount() {
        return alumni.size();
    }*/

    class ViewHolder {
        ImageView imgFoto;
        TextView txtnama;
        TextView txtnpm;
        TextView txtkeahlian;

    }

}
