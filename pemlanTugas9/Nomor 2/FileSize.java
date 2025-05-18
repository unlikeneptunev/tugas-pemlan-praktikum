package nomor2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileSize {
    public static void main(String[] args) {
        // Menentukan path file (ganti dengan path yang sebenarnya)
        Path path = Paths.get("path\\to\\file\\testSize.txt"); 
        try {
            long fileSizeInBytes = Files.size(path);
            long fileSizeInKB = fileSizeInBytes / 1024;
            long fileSizeInMB = fileSizeInKB / 1024;
            System.out.println("Ukuran file dalam KB: " + fileSizeInKB + " KB");
            System.out.println("Ukuran file dalam MB: " + fileSizeInMB + " MB");
        } catch (IOException e) {
            System.err.println("File tidak ditemukan.");
        }
    }
}
