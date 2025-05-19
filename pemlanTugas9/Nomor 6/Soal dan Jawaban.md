**SOAL**<br>
Apa yang akan terjadi jika kita mencoba untuk membaca isi dari suatu file tetapi
file tersebut tidak ada dan kita tidak melakukan pengecekan lebih dulu?

**JAWABAN**<br>
Jika tidak dicek terlebih dahulu, output akan menampilkan exception, lebih tepatnya adalah `FileNotFoundException`. Berikut adalah keluarannya secara lengkap.<br>
```
Exception in thread "main" java.io.FileNotFoundException: file-gaib.exe (The system cannot find the file specified)
        at java.base/java.io.FileInputStream.open0(Native Method)
        at java.base/java.io.FileInputStream.open(FileInputStream.java:185)
        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:139)
        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:109)
        at java.base/java.io.FileReader.<init>(FileReader.java:60)
        at nomor6.testing.main(testing.java:8)
```
Exception di atas dihasilkan dari kode berikut.
```
package nomor6;

import java.io.FileReader;
import java.io.IOException;

public class testing {
    public static void main(String[] args) throws IOException {
        // File tidak dicek dan langsung coba dibaca
        FileReader fileRead = new FileReader("file-gaib.exe"); 
        int karakter;
        while ((karakter = fileRead.read()) != -1) {
            System.out.print((char) karakter);
        }
        fileRead.close();
    }
}
```
Oleh karena itu, sebaiknya kita menggunakan blok `try-catch` untuk 'menangkap' exception (error) tersebut agar lebih mudah untuk dibaca dan dipahami oleh pengguna. Berikut adalah contohnya.<br>
```
package nomor6;

import java.io.*;

public class testing {
    public static void main(String[] args) {
        // File akan dicek, jika tidak ada maka akan menjalankan kode di dalam catch dan menampilkan pesan
        // "File tidak ditemukan."
        try {
            FileReader fileRead = new FileReader("file-gaib.exe");
            int karakter;
            while ((karakter = fileRead.read()) != -1) {
                System.out.print((char) karakter);
            }
            fileRead.close();
        } catch (Exception e) {
            System.err.println("File tidak ditemukan.");
        }
    }
}
```

