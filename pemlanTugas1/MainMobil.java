import java.util.Scanner;

public class MainMobil {
    public static void main(String[] args) {
        // Membuat objek sc dari class Scanner untuk menerima input dari user
        Scanner in = new Scanner(System.in);

        // instan objek bernama m1
        Mobil m1 = new Mobil();
        System.out.println("=== Masukkan Data Mobil 1 ===");
        System.out.print("Masukkan kecepatan mobil 1 (km/j): ");
        // Menerima inputan kecepatan dari user
        m1.setKecepatan(in.nextInt());
        // Clear buffer agar s.out manufaktur tidak terlewat
        in.nextLine();

        System.out.print("Masukkan manufaktur mobil 1: ");
        // Menerima inutan manufaktur dari user
        m1.setManufaktur(in.nextLine());

        System.out.print("Masukkan nomor plat mobil 1: ");
        // Menerima inpuran nomor plat dari user
        m1.setNoPlat(in.nextLine());

        System.out.print("Masukkan warna mobil 1: ");
        // Menerima inpuran warna mobil dari user
        m1.setWarna(in.nextLine());

        System.out.print("Masukkan waktu tempuh mobil 1 (jam): ");
        // Menerima inputan waktu tempuh dari user
        m1.setWaktu(in.nextDouble());

        System.out.println("=== Data Mobil 1 ===");
        m1.displayMessage();
        System.out.println("================\n");

        // instan objek baru bernama m2
        Mobil m2 = new Mobil();
        System.out.println("=== Masukkan Data Mobil 2 ===");
        System.out.print("Masukkan kecepatan mobil 2 (km/j): ");
        // Menerima inputan kecepatan dari user
        m2.setKecepatan(in.nextInt());
        // Clear buffer agar s.out manufaktur tidak terlewat
        in.nextLine();

        System.out.print("Masukkan manufaktur mobil 2: ");
        // Menerima inputan manufaktur dari user
        m2.setManufaktur(in.nextLine());

        System.out.print("Masukkan nomor plat mobil 2: ");
        // Menerima inputan nomor plat dari user
        m2.setNoPlat(in.nextLine());

        System.out.print("Masukkan warna mobil 2: ");
        // Menerima inputan warna mobil dari user
        m2.setWarna(in.nextLine());

        System.out.print("Masukkan waktu tempuh mobil 2 (jam): ");
        // Menerima inputan waktu tempuh dari user
        m2.setWaktu(in.nextDouble());

        System.out.println("=== Data Mobil 2 ===");
        m2.displayMessage();
        System.out.println("================\n");

        // merubah warna dari objek m1
        System.out.println("mobil pada objek m1 di rubah menjadi warna hijau");
        m1.setWarna("Hijau");
        // menampilkan hasil perubahan
        m1.displayMessage();
        System.out.println();

        // Menutup objek in untuk mencegah memory leak
        in.close();
    }
}
