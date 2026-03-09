/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t1_prak_pbo;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author IKHWANUL HASANI
 */
public class T1_PRAK_PBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Tiket> daftarTiket = new ArrayList<>();

        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("HH:mm");

        boolean lanjut = true;
        int nomorTiket = 1;

        System.out.println("=== TERMINAL LOOP OOP TIX ===");

        while (lanjut && daftarTiket.size() < 100) {

            try {

                System.out.println("\n--- Input Tiket ke-" + nomorTiket + " ---");

                System.out.print("Kode Booking (Awali 'TIX') : ");
                String kode = input.nextLine();

                System.out.print("Tanggal (DD/MM/YYYY)       : ");
                LocalDate tanggal = LocalDate.parse(input.nextLine(), formatTanggal);

                System.out.print("Waktu Keberangkatan        : ");
                LocalTime waktu = LocalTime.parse(input.nextLine(), formatWaktu);

                System.out.print("Stasiun Tujuan             : ");
                String tujuan = input.nextLine();

                System.out.print("Harga Dasar (Rp)           : ");
                double harga = input.nextDouble();

                System.out.print("Kelas (1=Eko, 2=Eks, 3=Lux): ");
                int kelas = input.nextInt();
                input.nextLine();

                Jadwal jadwal = new Jadwal(tanggal, waktu, tujuan);

                Tiket tiket = null;

                if (kelas == 1)
                    tiket = new TiketEkonomi(kode, jadwal, harga);
                else if (kelas == 2)
                    tiket = new TiketEksekutif(kode, jadwal, harga);
                else if (kelas == 3)
                    tiket = new TiketLuxury(kode, jadwal, harga);

                daftarTiket.add(tiket);

                System.out.println("[INFO] Tiket Berhasil Diterbitkan.");
                nomorTiket++;

            } catch (DataTiketInvalidException e) {

                System.out.println("[DITOLAK] " + e.getMessage());
                input.nextLine();

            } catch (Exception e) {

                System.out.println("[ERROR SYSTEM] Input harga/kelas harus berupa angka.");
                input.nextLine();
            }

            System.out.print("\nCetak Tiket Lain? (y/n) : ");
            String jawab = input.nextLine();

            if (jawab.equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }

        System.out.println("\n===============================================");
        System.out.println("             REKAPITULASI TIKET");
        System.out.println("===============================================\n");

        if (daftarTiket.isEmpty()) {

            System.out.println("Belum ada tiket yang diterbitkan.");

        } else {

            for (Tiket t : daftarTiket) {

                System.out.println("Kode Booking : " + t.getKodeTiket());
                System.out.println("Jadwal       : " + t.getJadwal().getDetailJadwal());
                System.out.printf("Total Harga  : Rp %.2f\n", t.hitungHarga());
                System.out.println("-----------------------------------------------");
            }
        }

        System.out.println("Sesi loket diakhiri.");
    }
    
}
