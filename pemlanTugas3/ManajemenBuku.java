import java.io.*;
import java.util.Scanner;

public class ManajemenBuku {
    private File dataBuku;
    Scanner sc = new Scanner(System.in);

    public ManajemenBuku() {
        dataBuku = new File("Data Buku.txt");
    }

    // Method untuk menambahkan buku ke file 'Data Buku.txt'
    public void tambahBuku() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║              TAMBAH BUKU              ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        System.out.print("Mau tambah berapa buku? ");
        int jumlahBuku = sc.nextInt();
        sc.nextLine();

        try {
            FileWriter fileWriter = new FileWriter(dataBuku, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            for (int i = 0; i < jumlahBuku; i++) {
                System.out.println("\nData untuk buku ke-" + (i + 1) + ":");
                System.out.println("-----------------------------");

                System.out.print("Judul: ");
                String judul = sc.nextLine();

                System.out.print("Penulis: ");
                String penulis = sc.nextLine();

                System.out.print("Tahun terbit: ");
                int tahun = sc.nextInt();
                sc.nextLine();

                // Menyimpan data buku dalam format: Judul, Penulis, Tahun Terbit
                String data = judul + ", " + penulis + ", " + tahun;
                if (isDuplikat(data)) {
                    System.out.println("\nBuku sudah terdaftar, tidak ditambahkan!");
                } else {
                    printWriter.println(data);
                    System.out.println("\nData buku berhasil ditambahkan!");
                }
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error saat menambahkan buku: " + e.getMessage());
        }
    }

    // Method untuk menampilkan daftar buku yang ada
    public void tampilkanDaftarBuku() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║              DAFTAR BUKU              ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        System.out.println("Pilih menu tampilan: ");
        System.out.println("1. Judul saja");
        System.out.println("2. Judul, penulis dan tahun terbit");
        System.out.print("Pilihan: ");
        int pilihanTampil = sc.nextInt();

        try {
            FileReader fileReader = new FileReader(dataBuku);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String baris;
            int count = 0;

            System.out.println("\nDAFTAR BUKU PERPUSTAKAAN");
            System.out.println("==============================");

            while ((baris = bufferedReader.readLine()) != null) {
                count++;
                String[] data = baris.split(", ");
                Buku buku = new Buku(data[0], data[1], Integer.parseInt(data[2]));

                System.out.print(count + ". ");
                switch (pilihanTampil) {
                    case 1:
                        buku.tampilkanInfo(); // Hanya menampilkan judul buku
                        break;
                    case 2:
                        buku.tampilkanInfo(true); // Menampilkan secara lengkap
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Hanya menampikan judul.");
                        buku.tampilkanInfo();
                        break;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error saat membaca file: " + e.getMessage());
        }
    }

    // Method untuk cek apakah buku yang diinput sudah ada di file
    public boolean isDuplikat(String dataBukuBaru) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dataBuku));
            String baris;
            while ((baris = bufferedReader.readLine()) != null) {
                // Membandingkan dengan mengubah kedua string jadi huruf kecil dan trim spasi
                if (baris.trim().toLowerCase().equals(dataBukuBaru.trim().toLowerCase())) {
                    bufferedReader.close();
                    return true; // Buku sudah ada
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error saat cek duplikat: " + e.getMessage());
        }
        return false; // Buku belum ada
    }
}
