import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Manusia (umum)
        System.out.println("===== MANUSIA =====");

        // Laki-laki menikah
        Manusia manusia1 = new Manusia("Adit", true, "111", true);
        System.out.println(manusia1);
        System.out.println();

        // Perempuan menikah
        Manusia manusia2 = new Manusia("Lena", false, "112", true);
        System.out.println(manusia2);
        System.out.println();

        // Belum menikah
        Manusia manusia3 = new Manusia("Rehan", true, "113", false);
        System.out.println(manusia3);
        System.out.println();

        // Mahasiswa FILKOM
        System.out.println("===== MAHASISWA FILKOM =====");

        // IPK < 3
        MahasiswaFILKOM mahasiswa1 = new MahasiswaFILKOM("245150200111001", 2.9, "Umar", "114", true, false);
        System.out.println(mahasiswa1);
        System.out.println();

        // IPK 3 - 3.5
        MahasiswaFILKOM mahasiswa2 = new MahasiswaFILKOM("225150300111002", 3.4, "Elaina", "115", false, false);
        System.out.println(mahasiswa2);
        System.out.println();

        // IPK 3.5 - 4
        MahasiswaFILKOM mahasiswa3 = new MahasiswaFILKOM("215150400111003", 3.9, "Yuki", "116", false, false);
        System.out.println(mahasiswa3);
        System.out.println();

        // Pekerja
        System.out.println("===== PEKERJA =====");

        // 2 tahun kerja, 2 anak
        Pekerja pekerja1 = new Pekerja("Negus", true, "117", true, 1000, LocalDate.now().minusYears(2), 2);
        System.out.println(pekerja1);
        System.out.println();

        // 9 tahun kerja, tidak punya anak
        Pekerja pekerja2 = new Pekerja("Hubert", true, "118", true, 1000, LocalDate.now().minusYears(9), 0);
        System.out.println(pekerja2);
        System.out.println();

        // 20 tahun kerja, anak 10
        Pekerja pekerja3 = new Pekerja("Asteroid Destroyer", true, "119", true, 1000, LocalDate.now().minusYears(20), 10);
        System.out.println(pekerja3);
        System.out.println();

        // Managere
        System.out.println("===== MANAGER =====");

        // Manager, 15 tahun kerja, gaji $7500
        Manager manager = new Manager("CISO", 7500, LocalDate.now().getYear() - 15, 1, 1, 3, "Dwi Funk See", "120", true, true);
        System.out.println(manager);
    }
}
