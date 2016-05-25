package com.example.user.biodata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListAlumniActivity extends AppCompatActivity {

    ListView listAlumni;
    ListAlumniAdapter alumniAdapter;
    List<Alumni> alumni = new ArrayList<Alumni>() {{
        add(new Alumni("aya","13.11.1111", ""));
        add(new Alumni("aya","13.11.1111", ""));
        add(new Alumni("aya","13.11.1111", ""));
        add(new Alumni("aya","13.11.1111", ""));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alumni);

        listAlumni = (ListView) findViewById(R.id.listAlumni);
        alumniAdapter = new ListAlumniAdapter(this, R.layout.layout_item_alumni, alumni);

        listAlumni.setAdapter(alumniAdapter);
    }
}
