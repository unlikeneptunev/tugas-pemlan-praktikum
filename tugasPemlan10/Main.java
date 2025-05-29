import data.DataPemain;
import model.PemainFutsal;
import nomor1.soalNomor1;
import nomor2.soalNomor2;
import java.util.*;

public class Main {
    private static final String SEPARATOR = "=".repeat(60);
    private static final String LINE = "-".repeat(60);
    
    public static void main(String[] args) {
        printHeader();
        
        // Tampilkan data lengkap pemain
        tampilkanDataPemain();
        
        // Panggil method sorting dari soalNomor1
        System.out.println("HASIL SORTING DATA");
        System.out.println(LINE);
        System.out.println("Sorting tinggi badan selesai dijalankan");
        soalNomor1.sortTinggi();
        
        System.out.println("Sorting berat badan selesai dijalankan");
        soalNomor1.sortBerat();
        System.out.println();
        
        // Panggil method min-max dari soalNomor1
        System.out.println("STATISTIK MIN-MAX PER TIM");
        System.out.println(LINE);
        System.out.println("Analisis min-max selesai dijalankan");
        soalNomor1.nilaiMinMax();
        System.out.println();
        
        // Panggil method copy Tim B ke Tim C
        System.out.println("TIM C (COPY DARI TIM B)");
        System.out.println(LINE);
        System.out.println("Tim C berhasil dibentuk dari Tim B");
        soalNomor1.main();
        System.out.println();
        
        // Panggil method dari soalNomor2
        System.out.println("ANALISIS LANJUTAN (SOAL NOMOR 2)");
        System.out.println(LINE);
        
        System.out.println("Pemisahan Tim A dan Tim B:");
        pisahTimModified(); // Panggil method modified karena ada error
        System.out.println();
        
        System.out.println("Pencarian Tinggi Badan di Tim B:");
        soalNomor2.cariTinggiTimB();
        System.out.println();
        
        System.out.println("Pencarian Berat Badan di Tim A:");
        soalNomor2.cariBeratTimA();
        System.out.println();
        
        System.out.println("Pengecekan Duplikat Tinggi/Berat antar Tim:");
        soalNomor2.cekDuplikatTinggiBerat();
        System.out.println();
        
        printFooter();
    }
    
    private static void printHeader() {
        System.out.println(SEPARATOR);
        System.out.println("            SISTEM MANAJEMEN DATA PEMAIN FUTSAL");
        System.out.println(SEPARATOR);
        System.out.println();
    }
    
    private static void printFooter() {
        System.out.println(SEPARATOR);
        System.out.println("                    ANALISIS SELESAI");
        System.out.println(SEPARATOR);
    }
    
    private static void tampilkanDataPemain() {
        System.out.println("DATA SELURUH PEMAIN");
        System.out.println(LINE);
        
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();
        
        System.out.println("TIM A:");
        for (PemainFutsal pemain : semuaPemain) {
            if (pemain.getTim().equals("A")) {
                System.out.printf("   No.%2d | Tinggi: %3d cm | Berat: %2d kg%n", 
                    pemain.getNoPemain(), pemain.getTinggiBadan(), pemain.getBeratBadan());
            }
        }
        
        System.out.println("TIM B:");
        for (PemainFutsal pemain : semuaPemain) {
            if (pemain.getTim().equals("B")) {
                System.out.printf("   No.%2d | Tinggi: %3d cm | Berat: %2d kg%n", 
                    pemain.getNoPemain(), pemain.getTinggiBadan(), pemain.getBeratBadan());
            }
        }
        System.out.println();
    }
    
    // Method untuk mengganti soalNomor2.pisahTim() yang error
    private static void pisahTimModified() {
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();
        List<PemainFutsal> timA = new ArrayList<>();
        List<PemainFutsal> timB = new ArrayList<>();
        
        for (PemainFutsal pemain : semuaPemain) {
            if (pemain.getTim().equals("A")) {
                timA.add(pemain);
            } else if (pemain.getTim().equals("B")) {
                timB.add(pemain);
            }
        }
        
        System.out.println("Tim A:");
        for (PemainFutsal p : timA) {
            System.out.println("  - No." + p.getNoPemain() + " | Tinggi: " + p.getTinggiBadan() + " cm | Berat: " + p.getBeratBadan() + " kg");
        }
        
        System.out.println("Tim B:");
        for (PemainFutsal p : timB) {
            System.out.println("  - No." + p.getNoPemain() + " | Tinggi: " + p.getTinggiBadan() + " cm | Berat: " + p.getBeratBadan() + " kg");
        }
    }
}