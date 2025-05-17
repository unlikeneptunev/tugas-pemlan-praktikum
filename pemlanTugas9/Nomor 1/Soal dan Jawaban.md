**SOAL**<br>
Jalankan kode `TulisFile1.java` beberapa kali dan amati yang terjadi pada file yang ditulis. Kemudian, Pada baris 13, ubah parameter false menjadi true. Kemudian jalankan kode tersebut beberapa kali dan amati yang terjadi pada file yang ditulis.
<br><br>
**JAWABAN**<br>
Jika parameter kedua yaitu `append` bernilai `false`, ketika sebelum di-run sudah ada isi di dalam `test.txt` kemudian di-run kembali, maka isi yang sebelumnya akan di-overwrite dengan input yang baru.
<br><br>
Sebaliknya, jika `append` bernilai `true` maka, isi sebelumnya tidak akan di-overwrite, tetapi akan ditulis langsung di sebelahnya.
<br>
- Contoh ketika `append` bernilai `false`
```
package nomor1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TulisFile1 {
    public static void main(String[] args) {
        var keyboard = new Scanner(System.in);
        System.out.print("Masukkan teks yang akan disimpan: ");
        var text = keyboard.nextLine();
        try (var writer = new FileWriter("test.txt", false)) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println("Gagal menulis ke file");
        }
    }
}
```
Maka, ketika di-run dan kita masukkan "Ayam", maka di `test.txt` akan muncul `Ayam`. Setelah di-run lagi dan kita masukkan "Sapi", `Ayam` akan hilang dan akan tergantikan oleh `Sapi`. 
<br>
- Contoh ketika `append` bernilai `true`
```
package nomor1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TulisFile1 {
    public static void main(String[] args) {
        var keyboard = new Scanner(System.in);
        System.out.print("Masukkan teks yang akan disimpan: ");
        var text = keyboard.nextLine();
        try (var writer = new FileWriter("test.txt", true)) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println("Gagal menulis ke file");
        }
    }
}
```
Maka, ketika di-run dan kita masukkan "Kambing", maka di `test.txt` akan muncul `Kambing`. Setelah di-run lagi dan kita masukkan "Bebek", `Kambing` tidak akan hilang tetapi akan ditambahkan tepat di samping `Kambing` tanpa spasi dan menjadi `KambingBebek`. 

Dokumentasi resmi:
[Java `FileWriter` Class](https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html)
