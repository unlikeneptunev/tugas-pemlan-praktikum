package nomor4;

import java.io.File;

public class DeleteDirectory {

    public static void deleteDirectory(File dir) {
        // Memastikan direktori yang diberikan adalah direktori
        File[] files = dir.listFiles();
        // Jika direktori tidak kosong, hapus semua file dan subdirektori
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
        dir.delete();
    }

public static void main(String[] args) {
    // Menentukan direktori yang akan dihapus (ganti dengan direktori yang sesuai)
    File dir = new File("C:\\Users\\src\\Documents\\Kuliah\\SEMESTER 2\\Pemrograman Lanjut\\Tugas\\Praktikum_Bab10\\Operasi File\\src\\nomor4\\testDelete");
    if (dir.exists() && dir.isDirectory()) {
        // Menghapus direktori dan isinya
        deleteDirectory(dir);
        System.out.println("Direktori dan isinya telah dihapus.");
    } else {
        System.out.println("Direktori tidak ditemukan.");
    }
}

}
