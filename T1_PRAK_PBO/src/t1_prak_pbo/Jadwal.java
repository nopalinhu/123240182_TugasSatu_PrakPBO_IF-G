/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t1_prak_pbo;

/**
 *
 * @author IKHWANUL HASANI
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Jadwal {

    private LocalDate tanggal;
    private LocalTime waktu;
    private String tujuan;

    public Jadwal(LocalDate tanggal, LocalTime waktu, String tujuan) {
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tujuan = tujuan;
    }

    public String getDetailJadwal() {

        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("HH:mm");

        return tanggal.format(formatTanggal) + " "
                + waktu.format(formatWaktu)
                + " - Tujuan: " + tujuan;
    }
}
