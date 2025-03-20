import java.io.*;
import java.util.Scanner;

public class ManajemenBuku {
    private File dataBuku;
    Scanner sc = new Scanner(System.in);

    public ManajemenBuku() {
        dataBuku = new File("src/dataBuku.txt"); // Mengarah ke file di folder src
        try {
            if (!dataBuku.exists()) {
                dataBuku.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error saat membuat file data: " + e.getMessage());
        }
    }

    public void tambahBuku() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║              TAMBAH BUKU              ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        
        int jumlahBuku = 0;
        boolean inputValid = false;
        
        while (!inputValid) {
            try {
                System.out.print("Mau tambah berapa buku? ");
                jumlahBuku = sc.nextInt();
                if (jumlahBuku >= 0) {
                    inputValid = true;
                    if (jumlahBuku == 0) {
                        System.out.println("Tidak jadi menambahkan buku.");
                        System.out.println("Kembali ke menu awal.");
                        return;
                    }
                } else {
                    System.out.println("Jumlah buku tidak boleh negatif!");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka.");
                sc.nextLine();
            }
        }
        sc.nextLine();

        try (FileWriter fileWriter = new FileWriter(dataBuku, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            for (int i = 0; i < jumlahBuku; i++) {
                System.out.println("\nData untuk buku ke-" + (i + 1) + ":");
                System.out.println("-----------------------------");

                String judul = getValidStringInput("Judul: ");
                String penulis = getValidStringInput("Penulis: ");
                int tahun = getValidTahun();
                
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
        }
    }

    public void tampilkanDaftarBuku() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║              DAFTAR BUKU              ║");
        System.out.println("╚═══════════════════════════════════════╝\n");
        
        int pilihanTampil = getPilihanTampil();
        
        try (FileReader fileReader = new FileReader(dataBuku);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            if (!dataBuku.exists() || dataBuku.length() == 0) {
                printEmptyBookList();
                return;
            }
            
            String baris;
            int count = 0;

            System.out.println("\nDAFTAR BUKU PERPUSTAKAAN");
            System.out.println("==============================");

            while ((baris = bufferedReader.readLine()) != null) {
                if (!baris.trim().isEmpty()) {
                    count++;
                    String[] data = baris.split(", ");
                    
                    if (data.length >= 3) {
                        try {
                            int tahun = Integer.parseInt(data[2]);
                            Buku buku = new Buku(data[0], data[1], tahun);

                            System.out.print(count + ". ");
                            if (pilihanTampil == 1) {
                                buku.tampilkanInfo();
                            } else {
                                buku.tampilkanInfo(true);
                            }
                            System.out.println();
                        } catch (NumberFormatException e) {
                            System.out.println(count + ". ERROR: Format tahun tidak valid pada data: " + baris);
                        }
                    } else {
                        System.out.println(count + ". ERROR: Format data tidak lengkap: " + baris);
                    }
                }
            }
            
            if (count == 0) {
                printEmptyBookList();
            }
        } catch (IOException e) {
            System.out.println("Error saat membaca file: " + e.getMessage());
        }
    }

    public boolean isDuplikat(String dataBukuBaru) {
        try (FileReader fileReader = new FileReader(dataBuku);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            if (!dataBuku.exists() || dataBuku.length() == 0) {
                return false;
            }
            
            String baris;
            String dataBaru = dataBukuBaru.trim().toLowerCase();
            
            while ((baris = bufferedReader.readLine()) != null) {
                if (baris.trim().toLowerCase().equals(dataBaru)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error saat cek duplikat: " + e.getMessage());
        }
        return false;
    }
    
    private String getValidStringInput(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(prompt.replace(": ", "") + " tidak boleh kosong!");
            }
        } while (input.isEmpty());
        return input;
    }
    
    private int getValidTahun() {
        int tahun = 0;
        boolean tahunValid = false;
        
        while (!tahunValid) {
            try {
                System.out.print("Tahun terbit: ");
                tahun = sc.nextInt();
                if (tahun > 0 && tahun <= 2025) {
                    tahunValid = true;
                } else {
                    System.out.println("Tahun terbit harus antara 1 dan 2025!");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid! Masukkan angka untuk tahun.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return tahun;
    }
    
    private int getPilihanTampil() {
        int pilihanTampil = 0;
        boolean inputValid = false;
        
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
                sc.nextLine();
            }
        }
        return pilihanTampil;
    }
    
    private void printEmptyBookList() {
        System.out.println("\nDAFTAR BUKU PERPUSTAKAAN");
        System.out.println("==============================");
        System.out.println("Belum ada buku yang tersimpan.");
    }
}
