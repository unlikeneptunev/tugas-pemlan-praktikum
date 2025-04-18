Sebuah garasi ingin membuat sistem yang bisa memantau kendaraan yang perlu diservis. Setiap kendaraan memiliki atribut dasar seperti:

* Merk Kendaraan <br>
* Tahun pembuatan (untuk menghitung usia kendaraan) <br>
* Plat <br>
* Jarak tempuh (dalam kilometer) <br>
* Batasan servis setiap 10000 km <br>

Tujuan sistem:

* Tambahkan kendaraan ke garasi. <br>
* Deteksi kendaraan yang butuh servis (logika: jika jarak tempuh >= 10.000 km). <br>
* Hitung estimasi biaya servis, dengan ketentuan :<br>
  * Mobil: 500 ribu + (usia * 100 ribu)
  * Motor: 200 ribu + (usia * 50 ribu) <br>
  
Tampilkan laporan kendaraan yang butuh servis, lengkap dengan biaya servisnya.

**Input Format**

* Baris pertama adalah jumlah kendaraan n (1 ≤ n ≤ 100).
* Setiap baris selanjutnya adalah informasi kendaraan dengan format:
Tipe_Mobil/ Motor (string) - Merek (string) - Tahun (integer) - Plat Nomor (string) - Jarak Tempuh (integer)

**Constraints**

Constraints untuk Input:
* Jumlah Kendaraan (n)
  * 1 ≤ n ≤ 100
* Tahun Pembuatan Kendaraan (tahun)
  * 1900 ≤ tahun ≤ 2025
* Jarak Tempuh Kendaraan (jarakTempuh)
  * 0 ≤ jarakTempuh ≤ 50000
* Format Plat Nomor
  * Plat nomor kendaraan adalah string yang dapat terdiri dari huruf dan angka, dengan panjang 5 hingga 10 karakter.
* Tipe Kendaraan
  * Tipe kendaraan hanya dapat berupa salah satu dari dua nilai: Mobil atau Motor.

**Output Format**

Daftar kendaraan yang butuh servis ditampilkan sesuai format:

== Kendaraan yang Butuh Servis ==

[MOBIL] Merek - Tahun - Plat Nomor - Usia: X tahun - Jarak: Y km - Biaya Servis: RpZ

Total kendaraan butuh servis: N
