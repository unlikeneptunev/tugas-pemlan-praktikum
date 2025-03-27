import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instansiasi objek pelanggan untuk 5 orang
        Pelanggan pelanggan1 = new Pelanggan("3891262145", "Roger Sumatra", "1234", 20000000);
        Pelanggan pelanggan2 = new Pelanggan("5601296774", "Agung Mandiri", "5678", 30000000);
        Pelanggan pelanggan3 = new Pelanggan("7424369420", "Rizal Ekonomi", "9876", 50000000);
        Pelanggan pelanggan4 = new Pelanggan("3842345678", "Rico Racing Mandalika", "1357", 10000000);
        Pelanggan pelanggan5 = new Pelanggan("5609876543", "Windah Batubara", "2468", 15000000);

        // Menampilkan informasi pelanggan dengan meminta input nomor dan PIN pelanggan
        while (true) {
            System.out.println("\n=== Login ke Sistem Swalayan Tiny ===");
            System.out.print("Masukkan nomor pelanggan: ");
            String nomor = scanner.nextLine();
            Pelanggan pelanggan = null;

            // Mengecek apakah pelanggan terdaftar di sistem
            if (pelanggan1.getNomorPelanggan().equals(nomor)) {
                pelanggan = pelanggan1;
            } else if (pelanggan2.getNomorPelanggan().equals(nomor)) {
                pelanggan = pelanggan2;
            } else if (pelanggan3.getNomorPelanggan().equals(nomor)) {
                pelanggan = pelanggan3;
            } else if (pelanggan4.getNomorPelanggan().equals(nomor)) {
                pelanggan = pelanggan4;
            } else if (pelanggan5.getNomorPelanggan().equals(nomor)) {
                pelanggan = pelanggan5;
            } else {
                System.out.println("Nomor pelanggan tidak ditemukan.");
                continue;
            }

            // Autentikasi PIN pelanggan
            boolean autentikasiBerhasil = false;
            while (!autentikasiBerhasil && !pelanggan.isStatusBlokir()) {
                System.out.print("Masukkan PIN Anda: ");
                String pin = scanner.nextLine();
                autentikasiBerhasil = pelanggan.autentikasi(pin);
            }

            // Jika akun terblokir, tampilkan pesan dan lanjutkan ke iterasi berikutnya
            if (pelanggan.isStatusBlokir()) {
                System.out.println("Akun Anda sudah terblokir. ");
                continue;
            }

            System.out.println("Selamat datang di Tiny, " + pelanggan.getNama() + "!");
            System.out.println("Saldo Anda saat ini: " + String.format("%,.0f", pelanggan.getSaldo()));

            TransaksiPelanggan transaksi = new TransaksiPelanggan(pelanggan);

            System.out.println("Pilih transaksi:");
            System.out.println("1. Pembelian");
            System.out.println("2. Top-up");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nominal pembelian (Rp): ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();
                    transaksi.beli(jumlah, pelanggan.getPin());
                    break;
                case 2:
                    System.out.print("Masukkan jumlah top-up: ");
                    double jumlahTopUp = scanner.nextInt();
                    scanner.nextLine();
                    transaksi.topUp(jumlahTopUp, pelanggan.getPin());
                    break;
                case 3:
                    System.out.println("Terima kasih telah mengunjungi Tiny!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
