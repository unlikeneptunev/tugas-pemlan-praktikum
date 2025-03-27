import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pelanggan pelanggan1 = new Pelanggan("3891262145", "Roger Sumatra", "1234", 20000000);
        Pelanggan pelanggan2 = new Pelanggan("5601296774", "Agung Mandiri", "5678", 30000000);
        Pelanggan pelanggan3 = new Pelanggan("7424369420", "Rudi Knalpot", "9876", 50000000);

        while (true) {
            System.out.println("\n=== Sistem Transaksi Swalayan ===");
            System.out.print("Masukkan nomor pelanggan: ");
            String nomor = scanner.nextLine();
            Pelanggan pelanggan = null;

            if (pelanggan1.getNomorPelanggan().equals(nomor)) {
                pelanggan = pelanggan1;
            } else if (pelanggan2.getNomorPelanggan().equals(nomor)) {
                pelanggan = pelanggan2;
            } else if (pelanggan3.getNomorPelanggan().equals(nomor)) {
                pelanggan = pelanggan3;
            } else {
                System.out.println("Nomor pelanggan tidak ditemukan.");
                continue;
            }

            boolean autentikasiBerhasil = false;
            while (!autentikasiBerhasil && !pelanggan.isStatusBlokir()) {
                System.out.print("Masukkan PIN Anda: ");
                String pin = scanner.nextLine();
                autentikasiBerhasil = pelanggan.autentikasi(pin);
            }

            if (pelanggan.isStatusBlokir()) {
                System.out.println("Akun Anda terblokir. Silakan hubungi layanan pelanggan.");
                continue;
            }

            System.out.println("Selamat datang, " + pelanggan.getNama() + "!");
            System.out.println("Saldo Anda: " + String.format("%,.0f", pelanggan.getSaldo()));

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
                    System.out.print("Masukkan jumlah pembelian: ");
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
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
