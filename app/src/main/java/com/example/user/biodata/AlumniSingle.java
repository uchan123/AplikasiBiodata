package com.example.user.biodata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uchan on 26/05/2016.
 */
public class AlumniSingle {
    private static final AlumniSingle instance = new AlumniSingle();

    List<Alumni> alumnis = new ArrayList<Alumni>() {{
        add(new Alumni("aya", "13.11.1111", ""));
        add(new Alumni("ayi", "13.11.1112", ""));
        add(new Alumni("ayu", "13.11.1113", ""));
        add(new Alumni("ayo", "13.11.1114", ""));
    }};

    private AlumniSingle() {}

    public static AlumniSingle i() {
        return instance;
    }

    public List<Alumni> all() {
        return alumnis;
    }

    public Alumni get(int pos) {
        return alumnis.get(pos);
    }

    public void set(Alumni food) {
        alumnis.add(food);
    }

    public int count() {
        return alumnis.size();
    }

}
