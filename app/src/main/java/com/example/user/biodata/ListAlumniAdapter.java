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
    List<Alumni> alumni;

    public ListAlumniAdapter(Context context, int resource, List<Alumni> alumni) {
        super(context, resource, alumni);

        this.alumni = alumni;
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(null==convertView){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_alumni,parent, false);
        }

        ViewHolder vh = new ViewHolder();
        vh.imgFoto = (ImageView) convertView.findViewById(R.id.imgfoto);
        vh.txtnama = (TextView) convertView.findViewById(R.id.id_nama);
        vh.txtnpm = (TextView) convertView.findViewById(R.id.id_nim);

        vh.txtnpm.setText(alumni.get(position).getNpm());
        vh.txtnama.setText(alumni.get(position).getNama());

        convertView.setTag(vh);

        return convertView;
    }

    @Override
    public int getCount() {
        return alumni.size();
    }

    class ViewHolder {
        ImageView imgFoto;
        TextView txtnama;
        TextView txtnpm;

    }

}
