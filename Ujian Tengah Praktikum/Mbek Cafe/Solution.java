import java.util.Scanner;

public class Solution {
    private static final double HARGA_MANDI = 5000;
    private static final double HARGA_GROOMING = 7000;
    private static final double DISKON_GEMUK = 0.15;
    private static final double PAJAK = 0.05;

    private String namaKambing;
    private int berat;
    private String jenisPerawatan;

    public KambingJumboMbek(String nama, int berat, String jenis) {
        this.namaKambing = nama;
        this.berat = berat;
        this.jenisPerawatan = jenis;
    }

    private double hitungBiayaDasar() {
        if (jenisPerawatan.equalsIgnoreCase("mandi")) {
            return berat * HARGA_MANDI;
        } else if (jenisPerawatan.equalsIgnoreCase("grooming")) {
            return berat * HARGA_GROOMING;
        }
        
        return 0;
    }

    private double hitungDiskon() {
        if (berat > 20 && berat <= 50) {
            return hitungBiayaDasar() * DISKON_GEMUK;
        }
        
        return 0;
    }

    public static double hitungPajak(double subtotal) {
        return subtotal * PAJAK;
    }

    public void cetakNota() {
        double biayaDasar = hitungBiayaDasar();
        double diskon = hitungDiskon();
        double subtotal = biayaDasar - diskon;
        double pajak = hitungPajak(subtotal);
        double total = subtotal + pajak;

        System.out.println("============ NOTA KAMBING JUMBO ============");
        System.out.printf("Nama Kambing: %s\n", namaKambing);
        System.out.printf("Berat: %d kg\n", berat);
        System.out.printf("Jenis Perawatan: %s\n", jenisPerawatan);
        System.out.printf("Biaya Dasar: Rp %.1f\n", biayaDasar);
        System.out.printf("Diskon: Rp %.1f\n", diskon);
        System.out.printf("Subtotal: Rp %.1f\n", subtotal);
        System.out.printf("Pajak: Rp %.1f\n", pajak);
        System.out.printf("Total Biaya: Rp %.1f\n", (namaKambing.equalsIgnoreCase("Mbek") || namaKambing.equalsIgnoreCase("Mbeek") || namaKambing.equalsIgnoreCase("Mbeeek")) ? 0.0 : total);
        
            System.out.println("============================================");

        if (namaKambing.equalsIgnoreCase("Mbek") ||
            namaKambing.equalsIgnoreCase("Mbeek") ||
            namaKambing.equalsIgnoreCase("Mbeeek")) {
            
            System.out.println("Terima kasih, " + namaKambing + " ! Kambing Jumbo selalu gratis, ya!");
        } else {
            System.out.println("Terima kasih, " + namaKambing + " ! Nanti kambingmu kami kembalikan... atau jadi menu special");
        }
    }

    // DILARANG MENGEDIT KELAS MAIN
    // JIKA MENGEDIT NILAI = 0
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input nama kambing
        String nama = "";
        while (true) {
            nama = scanner.nextLine().trim();
            if (nama.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Mbek! Nama kambing harus pakai huruf, bukan angka!");
            }
        }

        // Input berat
        int berat = 0;
        while (true) {
            try {
                berat = Integer.parseInt(scanner.nextLine().trim());
                if (berat < 1) {
                    System.out.println("Kambing hantu? Masukkan berat yang valid, hooman!");
                } else if (berat > 50) {
                    System.out.println("Wah, ini kambing atau sapi?");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Berat tidak valid! Kambing kami bukan hologram!");
            }
        }

        // Input jenis perawatan
        String jenis = "";
        while (true) {
            jenis = scanner.nextLine().trim().toLowerCase();
            if (jenis.equals("mandi") || jenis.equals("grooming")) {
                break;
            } else {
                System.out.println("Pilih 'mandi' atau 'grooming'! Kambingmu mau jadi artis?");
            }
        }

        // Proses dan cetak nota
        KambingJumboMbek kambing = new KambingJumboMbek(nama, berat, jenis);
        kambing.cetakNota();
    }
}
    
