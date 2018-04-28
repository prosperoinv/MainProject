package id.simplify.prosperoinv.model;

public class Jual {
    String nojual;
    String namabarang;
    String jumlah;
    String pengupdate;

    public Jual(){

    }

    public Jual(String nojual, String namabarang, String jumlah, String pengupdate) {
        this.nojual = nojual;
        this.namabarang = namabarang;
        this.jumlah = jumlah;
        this.pengupdate = pengupdate;
    }
    public String getNojual() {
        return nojual;
    }

    public void setNojual(String nojual) {
        this.nojual = nojual;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getPengupdate() {
        return pengupdate;
    }

    public void setPengupdate(String pengupdate) {
        this.pengupdate = pengupdate;
    }




}
