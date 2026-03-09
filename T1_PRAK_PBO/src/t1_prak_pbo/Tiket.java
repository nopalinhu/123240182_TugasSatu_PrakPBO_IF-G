/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t1_prak_pbo;

/**
 *
 * @author IKHWANUL HASANI
 */
public abstract class Tiket {

    private String kodeTiket;
    private Jadwal jadwal;
    private double hargaDasar;

    public Tiket(String kodeTiket, Jadwal jadwal, double hargaDasar)
            throws DataTiketInvalidException {

        if (hargaDasar <= 0) {
            throw new DataTiketInvalidException("Harga dasar tidak boleh <= 0");
        }

        if (!kodeTiket.startsWith("TIX")) {
            throw new DataTiketInvalidException("Kode tiket harus diawali TIX");
        }

        this.kodeTiket = kodeTiket;
        this.jadwal = jadwal;
        this.hargaDasar = hargaDasar;
    }

    public String getKodeTiket() {
        return kodeTiket;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }

    public abstract double hitungHarga();
}
