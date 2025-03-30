//package StaticModifier;  // Menambahkan "package" karena saya menggunakan folder yang berbeda dari Konstanta Final

public class Aritmatika {
    public void hitungPenjumlahan(int a, int b) {
        hitungPerkalian(a, b); // Soal nomor 4
        int nilai = a + b;
        System.out.println("nilai penjumlahan adalah : " + nilai);
    }

    public static void hitungPerkalian(int a, int b) {
        // hitungPenjumlahan(a, b); // Soal nomor 5 [error kareana method ini static]
        int nilai = a * b;
        System.out.println("nilai perkalian adalah : " + nilai);
    }

    public static void hitungPengurangan(int a, int b) {
        int nilai = a - b;
        System.out.println("nilai pengurangan adalah : " + nilai);
    }

    // Soal nomor 6
    public double hitungPembagian(String nil, String nil2) {
        double nilai = Double.parseDouble(nil) / Double.parseDouble(nil2);
        return nilai;
    }
}
