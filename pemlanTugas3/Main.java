import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Instance untuk mengatur file buku
        ManajemenBuku manajemenBuku = new ManajemenBuku();

        int pilihan = 0;
        boolean lanjut = true;
        
        do {
            System.out.println("\n╔═══════════════════════════════════════╗");
            System.out.println("║      SISTEM MANAJEMEN PERPUSTAKAAN    ║");
            System.out.println("╠═══════════════════════════════════════╣");
            System.out.println("║  1. Tambah buku                       ║");
            System.out.println("║  2. Tampilkan daftar buku             ║");
            System.out.println("║  3. Keluar                            ║");
            System.out.println("╚═══════════════════════════════════════╝\n");
            
            try {
                System.out.print("Pilihan Anda: ");
                pilihan = sc.nextInt();

                switch (pilihan) {
                    case 1:
                        // Memanggil method tambahBuku di class ManajemenBuku
                        manajemenBuku.tambahBuku();
                        break;

                    case 2:
                        // Memanggil method tampilkanDaftarBuku di class ManajemenBuku
                        manajemenBuku.tampilkanDaftarBuku();
                        break;

                    case 3:
                        // Keluar dari program
                        lanjut = false;
                        System.out.println("\n╔═══════════════════════════════════════╗");
                        System.out.println("║     TERIMA KASIH TELAH MENGGUNAKAN    ║");
                        System.out.println("║      SISTEM MANAJEMEN PERPUSTAKAAN    ║");
                        System.out.println("╚═══════════════════════════════════════╝\n");
                        break;

                    default:
                        System.out.println("\nPilihan tidak valid! Pilih dari opsi 1 - 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInput tidak valid! Silakan masukkan angka.");
                sc.nextLine(); // Membersihkan buffer input
            }

        } while (lanjut);

        sc.close();
    }
}
