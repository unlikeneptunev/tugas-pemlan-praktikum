public class KueMain {
    public static void main(String[] args) {
        Kue[] daftarKue = new Kue[20];
        
        // 10 kue pesanan, harga dan berat random
        for (int i = 0; i < 10; i++) {
            double randomHarga = 50000 + Math.random() * 100000;    // Harga: 50.000 - 150.000
            double randomBerat = 1.5 + Math.random() * 1.5;           // Berat: 1.5 - 3
            daftarKue[i] = new KuePesanan("Kue Pesanan ke-" + (i + 1), randomHarga, randomBerat);
        }
        
        // 10 kue jadi, harga random dan jumlah random antara 1 - 20
        for (int i = 10; i < 20; i++) {
            double randomHarga = 50000 + Math.random() * 100000;    // Harga: 50.000 - 150.000
            int randomJumlah = (int)(Math.random() * 20) + 1;       // Jumlah: 1 - 20 kue
            daftarKue[i] = new KueJadi("Kue Jadi ke-" + (i - 9), randomHarga, randomJumlah);
        }
        
        // Menampilkan seluruh daftar kue
        System.out.println("========== DAFTAR KUE ==========\n");
        for (int i = 0; i < daftarKue.length; i++) {
            System.out.println("------- Kue ke-" + (i + 1) + " -------");
            System.out.printf("%s%n", daftarKue[i].toString());
            System.out.printf("Harga akhir: Rp%.0f%n", daftarKue[i].hitungHarga());
            System.out.println("---------------------------\n");
        }
        System.out.println("==============================");
    }
}
