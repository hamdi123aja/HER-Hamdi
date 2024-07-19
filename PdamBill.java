/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HER;

/**
 *
 * @author hamdi
 * 
 */
import java.util.Scanner;

public class PdamBill {
    private String kodePembayaran;
    private String namaPelanggan;
    private String jenisPelanggan;
    private String tanggal;
    private int meterBulanIni;
    private int meterBulanLalu;
    private int totalBayar;

    public PdamBill(String kodePembayaran, String namaPelanggan, String jenisPelanggan, String tanggal, int meterBulanIni, int meterBulanLalu) {
        this.kodePembayaran = kodePembayaran;
        this.namaPelanggan = namaPelanggan;
        this.jenisPelanggan = jenisPelanggan;
        this.tanggal = tanggal;
        this.meterBulanIni = meterBulanIni;
        this.meterBulanLalu = meterBulanLalu;
        this.totalBayar = 0;
    }

    public int hitungMeterPakai() {
        return meterBulanLalu - meterBulanIni;
    }

    public void hitungTotalBayar() {
        int meterPakai = hitungMeterPakai();
        int biaya = 0;

        switch (jenisPelanggan.toUpperCase()) {
            case "GOLD":
                if (meterPakai <= 10) {
                    biaya = meterPakai * 5000;
                } else if (meterPakai <= 20) {
                    biaya = (10 * 5000) + ((meterPakai - 10) * 10000);
                } else {
                    biaya = (10 * 5000) + (10 * 10000) + ((meterPakai - 20) * 20000);
                }
                break;
            case "SILVER":
                if (meterPakai <= 10) {
                    biaya = meterPakai * 4000;
                } else if (meterPakai <= 20) {
                    biaya = (10 * 4000) + ((meterPakai - 10) * 8000);
                } else {
                    biaya = (10 * 4000) + (10 * 8000) + ((meterPakai - 20) * 10000);
                }
                break;
            case "UMUM":
                if (meterPakai <= 10) {
                    biaya = meterPakai * 2000;
                } else if (meterPakai <= 20) {
                    biaya = (10 * 2000) + ((meterPakai - 10) * 3000);
                } else {
                    biaya = (10 * 2000) + (10 * 3000) + ((meterPakai - 20) * 5000);
                }
                break;
            default:
                throw new IllegalArgumentException("Jenis pelanggan tidak dikenal: " + jenisPelanggan);
        }

        totalBayar = biaya;
    }

    public void tampilkanTagihan() {
        hitungTotalBayar();
        System.out.println("Kode Pembayaran: " + kodePembayaran);
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Jenis Pelanggan: " + jenisPelanggan);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Meter Bulan Ini: " + meterBulanIni);
        System.out.println("Meter Bulan Lalu: " + meterBulanLalu);
        System.out.println("Total Bayar: " + totalBayar);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Kode Pembayaran: ");
        String kodePembayaran = scanner.nextLine();

        System.out.print("Masukkan Nama Pelanggan: ");
        String namaPelanggan = scanner.nextLine();

        System.out.print("Masukkan Jenis Pelanggan (GOLD/SILVER/UMUM): ");
        String jenisPelanggan = scanner.nextLine();

        System.out.print("Masukkan Tanggal (YYYY-MM-DD): ");
        String tanggal = scanner.nextLine();

        System.out.print("Masukkan Meter Bulan Ini: ");
        int meterBulanIni = scanner.nextInt();

        System.out.print("Masukkan Meter Bulan Lalu: ");
        int meterBulanLalu = scanner.nextInt();

        PdamBill tagihan = new PdamBill(kodePembayaran, namaPelanggan, jenisPelanggan, tanggal, meterBulanIni, meterBulanLalu);
        tagihan.tampilkanTagihan();

        scanner.close();
    }
}
