![image](https://github.com/user-attachments/assets/ad9da8a4-5b2a-4ad3-b559-afa0c80e4a6b)<br>
Kafe Kambing Jumbo membutuhkan sistem untuk menghitung biaya perawatan kambing. Setiap kambing bisa memilih layanan Mandi Kambing (Rp 5.000/kg) atau Grooming Kambing (Rp 7.000/kg). 
Jika berat kambing lebih dari 20 kg, kambing akan mendapatkan diskon 15% dari biaya dasar (karena kambing gemuk itu lucu!). Selain itu, ada pajak 5% dari total biaya setelah diskon.

**Catatan Khusus**

1. List Item

* Kambing bernama Mbek, Mbeek, Mbeeek selalu gratis, karena dia adalah orang dalam 🤫!
* Jika berat kambing 0 kg, muncul pesan: "Kambing hantu? Masukkan berat yang valid, hooman!"

**Input Format**

* Nama Kambing (String): Jika input bukan string, tampilkan: "Mbek! Nama kambing harus pakai huruf, bukan angka!" dan ulangi input.
* Berat Kambing (int ≥ 1): Jika input < 1 atau bukan angka, tampilkan: "Kambing hantu? Masukkan berat yang valid, hooman!" dan ulangi.
* Jenis Perawatan (String): Pilihan 'mandi' atau 'grooming'. Jika salah, tampilkan: "Pilih 'mandi' atau 'grooming'! Kambingmu mau jadi artis?" dan ulangi.

**Constraints**

* Nama hanya dapat terdiri dari huruf ASCII.
* Berat maksimal kambing adalah 50 kg.

**Output Format**

* Print sesuai format struk
* Jika Kambing bernama Mbek, Mbeek, Mbeeek maka output "Terima kasih, {nama kambing}! Kambing Jumbo selalu gratis, ya!"
* Jika tidak maka output "Terima kasih, {nama kambing}! Nanti kambingmu kami kembalikan... atau jadi menu special"

**Sample Input 0**
```
Mbek
10
mandi
```
**Sample Output 0**
```
============ NOTA KAMBING JUMBO ============
Nama Kambing: Mbek
Berat: 10 kg
Jenis Perawatan: mandi
Biaya Dasar: Rp 50000.0
Diskon: Rp 0.0
Subtotal: Rp 50000.0
Pajak: Rp 2500.0
Total Biaya: Rp 0.0
============================================
Terima kasih, Mbek ! Kambing Jumbo selalu gratis, ya!
```
**Sample Input 1**
```
Kambing
25
grooming
```
**Sample Output 1**
```
============ NOTA KAMBING JUMBO ============
Nama Kambing: Kambing
Berat: 25 kg
Jenis Perawatan: grooming
Biaya Dasar: Rp 175000.0
Diskon: Rp 26250.0
Subtotal: Rp 148750.0
Pajak: Rp 7437.5
Total Biaya: Rp 156187.5
============================================
Terima kasih, Kambing ! Nanti kambingmu kami kembalikan... atau jadi menu special
```
