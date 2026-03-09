/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t1_prak_pbo;

/**
 *
 * @author IKHWANUL HASANI
 */
public class TiketEkonomi extends Tiket {

    public TiketEkonomi(String kodeTiket, Jadwal jadwal, double hargaDasar)
            throws DataTiketInvalidException {
        super(kodeTiket, jadwal, hargaDasar);
    }

    @Override
    public double hitungHarga() {
        return getHargaDasar();
    }
}
