import java.io.*;
import java.util.Scanner;

public class ManajemenBuku {
    private File dataBuku;
    Scanner sc = new Scanner(System.in);

    public ManajemenBuku() {
        dataBuku = new File("Data Buku.txt");
        // Pastikan file ada, jika tidak ada maka buat file baru
        try {
            if (!dataBuku.exists()) {
                dataBuku.createNewFile();
                System.out.println("File data buku baru telah dibuat.");
            }
        } catch (IOException e) {
            System.out.println("Error saat membuat file data: " + e.getMessage());
        }
    }

    // Method untuk menambahkan buku ke file 'Data Buku.txt'
    public void tambahBuku() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║              TAMBAH BUKU              ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        
        int jumlahBuku = 0;
        boolean inputValid = false;
        
        // Validasi input jumlah buku
        while (!inputValid) {
            try {
                System.out.print("Mau tambah berapa buku? ");
                jumlahBuku = sc.nextInt();
                if (jumlahBuku > 0) {
                    inputValid = true;
                } else {
                    System.out.println("Jumlah buku harus lebih dari 0!");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                sc.nextLine(); // Membersihkan buffer input
            }
        }
        sc.nextLine(); // Membersihkan buffer setelah input jumlahBuku

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(dataBuku, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);

            for (int i = 0; i < jumlahBuku; i++) {
                System.out.println("\nData untuk buku ke-" + (i + 1) + ":");
                System.out.println("-----------------------------");

                System.out.print("Judul: ");
                String judul = sc.nextLine().trim();
                
                // Validasi bahwa judul tidak kosong
                while (judul.isEmpty()) {
                    System.out.println("Judul tidak boleh kosong!");
                    System.out.print("Judul: ");
                    judul = sc.nextLine().trim();
                }

                System.out.print("Penulis: ");
                String penulis = sc.nextLine().trim();
                
                // Validasi bahwa penulis tidak kosong
                while (penulis.isEmpty()) {
                    System.out.println("Penulis tidak boleh kosong!");
                    System.out.print("Penulis: ");
                    penulis = sc.nextLine().trim();
                }

                int tahun = 0;
                boolean tahunValid = false;
                
                // Validasi input tahun 
                while (!tahunValid) {
                    try {
                        System.out.print("Tahun terbit: ");
                        tahun = sc.nextInt();
                        // Tahun tidak boleh berada di masa depan atau terlalu lama di masa lalu
                        if (tahun > 0 && tahun <= 2025) {
                            tahunValid = true;
                        } else {
                            System.out.println("Tahun terbit harus antara 1 dan 2025!");
                        }
                    } catch (Exception e) {
                        System.out.println("Input tidak valid! Masukkan angka untuk tahun.");
                        sc.nextLine(); // Membersihkan buffer input
                    }
                }
                sc.nextLine(); // Membersihkan buffer setelah input tahun

                // Menyimpan data buku dalam format: Judul, Penulis, Tahun Terbit
                String data = judul + ", " + penulis + ", " + tahun;
                if (isDuplikat(data)) {
                    System.out.println("\nBuku sudah terdaftar, tidak ditambahkan!");
                } else {
                    printWriter.println(data);
                    System.out.println("\nData buku berhasil ditambahkan!");
                }
            }
        } catch (IOException e) {
            System.out.println("Error saat menambahkan buku: " + e.getMessage());
        } finally {
            // Menutup semua resource dengan aman
            try {
                if (printWriter != null) printWriter.close();
                if (bufferedWriter != null) bufferedWriter.close();
                if (fileWriter != null) fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error saat menutup file: " + e.getMessage());
            }
        }
    }

    // Method untuk menampilkan daftar buku yang ada
    public void tampilkanDaftarBuku() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║              DAFTAR BUKU              ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        
        int pilihanTampil = 0;
        boolean inputValid = false;
        
        // Validasi input pilihan tampilan
        while (!inputValid) {
            try {
                System.out.println("Pilih menu tampilan: ");
                System.out.println("1. Judul saja");
                System.out.println("2. Judul, penulis dan tahun terbit");
                System.out.print("Pilihan: ");
                pilihanTampil = sc.nextInt();
                
                if (pilihanTampil == 1 || pilihanTampil == 2) {
                    inputValid = true;
                } else {
                    System.out.println("\nPilihan tidak valid! Pilih 1 atau 2.");
                }
            } catch (Exception e) {
                System.out.println("\nInput tidak valid! Masukkan angka 1 atau 2.");
                sc.nextLine(); // Membersihkan buffer input
            }
        }
        
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Cek apakah file ada dan tidak kosong
            if (!dataBuku.exists() || dataBuku.length() == 0) {
                System.out.println("\nDAFTAR BUKU PERPUSTAKAAN");
                System.out.println("==============================");
                System.out.println("Belum ada buku yang tersimpan.");
                return;
            }
            
            fileReader = new FileReader(dataBuku);
            bufferedReader = new BufferedReader(fileReader);
            String baris;
            int count = 0;

            System.out.println("\nDAFTAR BUKU PERPUSTAKAAN");
            System.out.println("==============================");

            while ((baris = bufferedReader.readLine()) != null) {
                // Hanya proses baris yang tidak kosong
                if (!baris.trim().isEmpty()) {
                    count++;
                    String[] data = baris.split(", ");
                    
                    // Penanganan jika format data tidak sesuai
                    if (data.length >= 3) {
                        try {
                            int tahun = Integer.parseInt(data[2]);
                            Buku buku = new Buku(data[0], data[1], tahun);

                            System.out.print(count + ". ");
                            if (pilihanTampil == 1) {
                                buku.tampilkanInfo(); // Hanya menampilkan judul buku
                            } else {
                                buku.tampilkanInfo(true); // Menampilkan secara lengkap
                            }
                            System.out.println(); // Tambahkan baris kosong untuk memisahkan buku
                        } catch (NumberFormatException e) {
                            System.out.println(count + ". ERROR: Format tahun tidak valid pada data: " + baris);
                        }
                    } else {
                        System.out.println(count + ". ERROR: Format data tidak lengkap: " + baris);
                    }
                }
            }
            
            // Jika tidak ada buku yang valid
            if (count == 0) {
                System.out.println("Belum ada buku yang tersimpan.");
            }
        } catch (IOException e) {
            System.out.println("Error saat membaca file: " + e.getMessage());
        } finally {
            // Menutup resource dengan aman
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
            } catch (IOException e) {
                System.out.println("Error saat menutup file: " + e.getMessage());
            }
        }
    }

    // Method untuk cek apakah buku yang diinput sudah ada di file
    public boolean isDuplikat(String dataBukuBaru) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        
        try {
            // Jika file belum ada, bukan duplikat
            if (!dataBuku.exists() || dataBuku.length() == 0) {
                return false;
            }
            
            fileReader = new FileReader(dataBuku);
            bufferedReader = new BufferedReader(fileReader);
            String baris;
            
            // Salin data yang akan dicek dan ubah ke lowercase untuk perbandingan
            String dataBaru = dataBukuBaru.trim().toLowerCase();
            
            while ((baris = bufferedReader.readLine()) != null) {
                // Bandingkan dengan mengubah string jadi huruf kecil dan trim spasi
                if (baris.trim().toLowerCase().equals(dataBaru)) {
                    return true; // Buku sudah ada
                }
            }
        } catch (IOException e) {
            System.out.println("Error saat cek duplikat: " + e.getMessage());
        } finally {
            // Menutup resource dengan aman
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
            } catch (IOException e) {
                System.out.println("Error saat menutup file: " + e.getMessage());
            }
        }
        return false; // Buku belum ada
    }
}
