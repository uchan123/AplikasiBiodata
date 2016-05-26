package com.example.user.biodata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 21/05/2016.
 */
public class ListAlumniAdapter extends ArrayAdapter<Alumni>{

    Context context;
    int resource;

    public ListAlumniAdapter(Context context, int resource) {
        super(context, resource, AlumniSingle.i().all());

        this.context = context;
        this.resource = resource;
    }

    @Override
    public int getCount(){
        return AlumniSingle.i().count();
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

        vh.txtnpm.setText(AlumniSingle.i().get(position).getNpm());
        vh.txtnama.setText(AlumniSingle.i().get(position).getNama());

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

    }

}
