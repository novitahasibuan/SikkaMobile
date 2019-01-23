package id.go.pajak.sikkamobile.model;

/**
 * Created by TTKI on 19-Jul-17.
 */

public class Presensi {
    private String hari, jam_masuk, jam_keluar, keterangan;

    public Presensi() {
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam_masuk() {
        return jam_masuk;
    }

    public void setJam_masuk(String jam_masuk) {
        this.jam_masuk = jam_masuk;
    }

    public String getJam_keluar() {
        return jam_keluar;
    }

    public void setJam_keluar(String jam_keluar) {
        this.jam_keluar = jam_keluar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Presensi(String hari, String jam_masuk, String jam_keluar, String keterangan) {
        this.hari = hari;
        this.jam_masuk = jam_masuk;
        this.jam_keluar = jam_keluar;
        this.keterangan = keterangan;

    }
}
