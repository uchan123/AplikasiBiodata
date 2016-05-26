package com.example.user.biodata;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AlumniFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listAlumni;
    ListAlumniAdapter alumniAdapter;


    @Override
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_alumni);

        listAlumni = (ListView) findViewById(R.id.listAlumni);
        alumniAdapter = new ListAlumniAdapter(this, R.layout.layout_item_alumni, alumni);

        listAlumni.setAdapter(alumniAdapter);
    } on create untuk activity*/

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alumni, container, false);

        listAlumni = (ListView) view.findViewById(R.id.listAlumni);
        alumniAdapter = new ListAlumniAdapter(getActivity(), R.layout.layout_item_alumni);
        listAlumni.setAdapter(alumniAdapter);
        listAlumni.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        ((OnContentItemClickListener) getActivity()).onContentItemClick(position);
    }

    interface OnContentItemClickListener{
        void onContentItemClick(int pos);
    }
}

