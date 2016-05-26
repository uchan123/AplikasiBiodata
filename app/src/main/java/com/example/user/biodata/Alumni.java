package com.example.user.biodata;

/**
 * Created by user on 21/05/2016.
 */
public class Alumni {
    String npm;
    String nama;
    double ipk;
    String ttl;
    String email;
    String telp;
    String keahlian;
    String profesi;
    String pengalaman;
    String nama_ortu;
    String alamat;
    String judul_skripsi;
    boolean best;
    String foto;

    public Alumni(String npm, String nama, double ipk, String ttl, String email, String telp, String keahlian, String profesi, String pengalaman, String nama_ortu, String alamat, String judul_skripsi, boolean best) {
        this.npm = npm;
        this.nama = nama;
        this.ipk = ipk;
        this.ttl = ttl;
        this.email = email;
        this.telp = telp;
        this.keahlian = keahlian;
        this.profesi = profesi;
        this.pengalaman = pengalaman;
        this.nama_ortu = nama_ortu;
        this.alamat = alamat;
        this.judul_skripsi = judul_skripsi;
        this.best = best;
        this.foto = npm;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public String getProfesi() {
        return profesi;
    }

    public void setProfesi(String profesi) {
        this.profesi = profesi;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public String getNama_ortu() {
        return nama_ortu;
    }

    public void setNama_ortu(String nama_ortu) {
        this.nama_ortu = nama_ortu;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJudul_skripsi() {
        return judul_skripsi;
    }

    public void setJudul_skripsi(String judul_skripsi) {
        this.judul_skripsi = judul_skripsi;
    }

    public boolean isBest() {
        return best;
    }

    public void setBest(boolean best) {
        this.best = best;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}