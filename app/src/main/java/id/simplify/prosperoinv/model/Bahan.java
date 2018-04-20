package id.simplify.prosperoinv.model;

import java.sql.Time;

public class Bahan {
    String namabarang;
    String vendorbarang;
    String jumlahbarang;
    Time lastupdate;
    String pengupdate;
    //qoyum
    public Bahan() {}
    public Bahan(String namabarang, String vendorbarang, String jumlahbarang, Time lastupdate, String pengupdate) {
        this.namabarang = namabarang;
        this.vendorbarang = vendorbarang;
        this.jumlahbarang = jumlahbarang;
        this.lastupdate = lastupdate;
        this.pengupdate = pengupdate;
    }


    public String getNamabarang() {
        return namabarang;
    }

    public String getVendorbarang() {
        return vendorbarang;
    }

    public String getJumlahbarang() {
        return jumlahbarang;
    }

    public Time getLastupdate() {
        return lastupdate;
    }

    public String getPengupdate() {
        return pengupdate;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public void setVendorbarang(String vendorbarang) {
        this.vendorbarang = vendorbarang;
    }

    public void setJumlahbarang(String jumlahbarang) {
        this.jumlahbarang = jumlahbarang;
    }

    public void setLastupdate(Time lastupdate) {
        this.lastupdate = lastupdate;
    }

    public void setPengupdate(String pengupdate) {
        this.pengupdate = pengupdate;
    }
}
