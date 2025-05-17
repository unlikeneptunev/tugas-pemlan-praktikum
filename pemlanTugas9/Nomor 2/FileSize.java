package nomor2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileSize {
    public static void main(String[] args) {
        Path path = Paths.get("path\\to\\file\\testSize.txt"); // Ganti dengan path yang sebenarnya
        try {
            long fileSizeInBytes = Files.size(path);
            long fileSizeInKB = fileSizeInBytes / 1024;
            long fileSizeInMB = fileSizeInKB / 1024;
            System.out.println("Ukuran file: " + fileSizeInKB + " KB");
            System.out.println("Ukuran file: " + fileSizeInMB + " MB");
        } catch (IOException e) {
            System.err.println("File tidak ditemukan.");
        }
    }
}
