package com.example.user.biodata;

/**
 * Created by user on 21/05/2016.
 */
public class Alumni {
    String nama;
    String npm;
    String foto;

    public Alumni(String nama, String npm, String foto) {
        this.nama = nama;
        this.npm = npm;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
