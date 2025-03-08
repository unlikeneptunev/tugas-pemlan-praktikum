public class Mobil {
    private String noPlat;
    private String warna;
    private String manufaktur;
    private double kecepatan;
    // menambahkan atribut waktu dalam format detik
    private double waktu;
    // menambahkan atribut waktu dalam format jam
    private double waktuJam;

    public void setNoPlat(String s) {
        noPlat = s;
    }

    public void setWarna(String s) {
        warna = s;
    }

    public void setManufaktur(String s) {
        manufaktur = s;
    }

    public void setKecepatan(double i) {
        kecepatan = i;
        // Memanggil method rubahKecepatan
        kecepatan = rubahKecepatan();
    }

    // Buat method rubahSekon untuk mengubah jam ke detik (soal no. 5) -> hanya bisa diakses oleh class Mobil
    private double rubahSekon(double jam) {
        // 1 jam = 3600 detik
        return jam * 3600;
    }

    // Buat method setWaktu dengan parameter double (soal no. 4)
    public void setWaktu(double jam) {
        // Menyimpan waktu dalam format jam
        waktuJam = jam;
        // Memanggil method rubahSekon
        waktu = rubahSekon(jam);
    }

    // Buat method rubahKecepatan untuk mengubah kecepatan dari km/jam ke m/s (soal no. 6) -> hanya bisa diakses oleh class Mobil
    private double rubahKecepatan() {
        // km/h ke m/s = kecepatan * 5/18
        return kecepatan * 5 / 18;
    }

    // Buat method hitungJarak untuk menghitung jarak 
    private double hitungJarak() {
        // jarak = kecepatan * waktu
        return kecepatan * waktu;
    }

    // Buat method rubahJarak untuk mengubah jarak dari m ke km
    private double rubahJarak() {
        // 1000 m = 1 km 
        return hitungJarak() / 1000;
    }

    public void displayMessage() {
        System.out.println("Mobil anda adalah bermerek " + manufaktur);
        System.out.println("mempunyai nomor plat " + noPlat);
        System.out.println("serta memililki warna " + warna);
        // Mengubah output kecepatan menjadi 2 angka di belakang koma (m/s)
        System.out.printf("dan mampu menempuh kecepatan %.2f m/s\n", kecepatan);
        // Menampilkan waktu berkendara dalam jam dan detik
        System.out.printf("dengan waktu berkendara yaitu selama %.2f jam (%.0f detik)\n", waktuJam, waktu);
        // Mengubah output jarak menjadi 2 angka di belakang koma
        System.out.printf("maka jarak yang ditempuh adalah %.2f kilometer\n", rubahJarak());
    }
}