package id.simplify.prosperoinv.model;

import java.sql.Time;

public class Barang {
    String namabrg;
    String jumlahbarang;
    Time lastupdate;
    String pengupdate;

    public Barang(){

    }

    public Barang(String namabrg, String jumlahbarang, Time lastupdate, String pengupdate) {
        this.namabrg = namabrg;
        this.jumlahbarang = jumlahbarang;
        this.lastupdate = lastupdate;
        this.pengupdate = pengupdate;
    }

    public String getNamabrg() {
        return namabrg;
    }

    public void setNamabrg(String namabrg) {
        this.namabrg = namabrg;
    }

    public String getJumlahbarang() {
        return jumlahbarang;
    }

    public void setJumlahbarang(String jumlahbarang) {
        this.jumlahbarang = jumlahbarang;
    }

    public Time getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Time lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getPengupdate() {
        return pengupdate;
    }

    public void setPengupdate(String pengupdate) {
        this.pengupdate = pengupdate;
    }
}
