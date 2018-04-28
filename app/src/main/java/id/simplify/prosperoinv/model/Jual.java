package id.simplify.prosperoinv.model;

public class Jual {
    String nojual;
    String namabarang;
    String jumlah;
    String pengupdate;
    String pemesan;
    String alamat;

    public Jual(){

    }

    public Jual(String nojual, String namabarang, String jumlah, String pengupdate, String pemesan, String alamat) {
        this.nojual = nojual;
        this.namabarang = namabarang;
        this.jumlah = jumlah;
        this.pengupdate = pengupdate;
        this.pemesan = pemesan;
        this.alamat = alamat;
    }

    public String getPemesan() {
        return pemesan;
    }

    public void setPemesan(String pemesan) {
        this.pemesan = pemesan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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
