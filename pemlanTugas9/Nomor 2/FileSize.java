package nomor2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSize {

    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\src\\Documents\\Kuliah\\SEMESTER 2\\Pemrograman Lanjut\\Tugas\\Praktikum_Bab10\\Operasi File\\src\\nomor2\\testSize.txt");
        try {
            long fileSizeInBytes = Files.size(path);
            // 1 KB = 1024 Bytes
            long fileSizeInKB = fileSizeInBytes / 1024;
            // 1 MB = 1024 KB
            long fileSizeInMB = fileSizeInKB / 1024;
            System.out.println("Ukuran file dalam KB: " + fileSizeInKB + " KB");
            System.out.println("Ukuran file dalam MB: " + fileSizeInMB + " MB");
        } catch (IOException e) {
            System.err.println("File tidak ditemukan.");
        }
    }
}
