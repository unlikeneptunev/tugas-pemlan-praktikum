package nomor3;

import java.io.File;

public class ListFile {

    public static void main(String[] args) {
        try {
            File directory = new File("C:\\Users\\src\\Documents\\Kuliah\\SEMESTER 2\\Pemrograman Lanjut\\Tugas\\Praktikum_Bab10\\Operasi File\\src\\nomor3\\tes-list-file");
            File[] files = directory.listFiles();

            System.out.println("Daftar file yang ada di direktori: ");

            // Menampilkan daftar file
            int i = 0;
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println((i + 1) + ". " + file.getName());
                    i++;
                }
            }
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
