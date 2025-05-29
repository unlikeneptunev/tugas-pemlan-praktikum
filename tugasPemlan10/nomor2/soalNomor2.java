package nomor2;

import data.DataPemain;
import model.PemainFutsal;
import java.util.*;

public class soalNomor2 {
    // a. Implementasikan ArrayList untuk menyimpan data tim A dan tim B dalam
    // bentuk ArrayList terpisah.
    public static void pisahTim() {
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
            System.out.println("  - " + p.getNama() + " | Tinggi: " + p.getTinggiBadan() + " cm | Berat: " + p.getBeratBadan() + " kg");
        }
        System.out.println("Tim B:");
        for (PemainFutsal p : timB) {
            System.out.println("  - " + p.getNama() + " | Tinggi: " + p.getTinggiBadan() + " cm | Berat: " + p.getBeratBadan() + " kg");
        }
    }

    // b. Dari data tim B, dicari jumlah pemain yang mempunyai tinggi badan 168 cm
    // dan 160 cm.
    public static void cariTinggiTimB() {
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();
        List<Integer> tinggiTimB = new ArrayList<>();
        for (PemainFutsal pemain : semuaPemain) {
            if (pemain.getTim().equals("B")) {
                tinggiTimB.add(pemain.getTinggiBadan());
            }
        }
        Collections.sort(tinggiTimB);

        int[] cariTinggi = { 168, 160 };
        for (int tinggi : cariTinggi) {
            int jumlah = countOccurrences(tinggiTimB, tinggi);
            System.out.println("Jumlah pemain Tim B dengan tinggi " + tinggi + " cm: " + jumlah);
        }
    }

    // c. Dari data tim A, dicari jumlah pemain yang mempunyai berat badan 56 kg dan
    // 53 kg.
    public static void cariBeratTimA() {
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();
        List<Integer> beratTimA = new ArrayList<>();
        for (PemainFutsal pemain : semuaPemain) {
            if (pemain.getTim().equals("A")) {
                beratTimA.add(pemain.getBeratBadan());
            }
        }
        Collections.sort(beratTimA);

        int[] cariBerat = { 56, 53 };
        for (int berat : cariBerat) {
            int jumlah = countOccurrences(beratTimA, berat);
            System.out.println("Jumlah pemain Tim A dengan berat " + berat + " kg: " + jumlah);
        }
    }

    // d. Ingin diketahui apakah pemain di Tim A ada yang mempunyai tinggi badan
    // atau berat badan yang sama dengan pemain di Tim B?
    public static void cekDuplikatTinggiBerat() {
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();
        List<Integer> tinggiA = new ArrayList<>();
        List<Integer> beratA = new ArrayList<>();
        List<Integer> tinggiB = new ArrayList<>();
        List<Integer> beratB = new ArrayList<>();

        for (PemainFutsal pemain : semuaPemain) {
            if (pemain.getTim().equals("A")) {
                tinggiA.add(pemain.getTinggiBadan());
                beratA.add(pemain.getBeratBadan());
            } else if (pemain.getTim().equals("B")) {
                tinggiB.add(pemain.getTinggiBadan());
                beratB.add(pemain.getBeratBadan());
            }
        }
        Collections.sort(tinggiB);
        Collections.sort(beratB);

        boolean adaTinggiSama = false;
        for (int t : tinggiA) {
            if (Collections.binarySearch(tinggiB, t) >= 0) {
                adaTinggiSama = true;
                break;
            }
        }
        boolean adaBeratSama = false;
        for (int b : beratA) {
            if (Collections.binarySearch(beratB, b) >= 0) {
                adaBeratSama = true;
                break;
            }
        }
        if (adaTinggiSama && adaBeratSama) {
            System.out.println("Ada pemain Tim A yang memiliki tinggi DAN berat badan sama dengan pemain Tim B.");
        } else if (adaTinggiSama) {
            System.out.println("Ada pemain Tim A yang memiliki tinggi badan sama dengan pemain Tim B.");
        } else if (adaBeratSama) {
            System.out.println("Ada pemain Tim A yang memiliki berat badan sama dengan pemain Tim B.");
        } else {
            System.out.println("Tidak ada pemain Tim A yang memiliki tinggi atau berat badan sama dengan pemain Tim B.");
        }
    }

    // Helper: menghitung jumlah kemunculan value pada list (binary search)
    private static int countOccurrences(List<Integer> sortedList, int value) {
        int first = firstIndex(sortedList, value);
        if (first == -1)
            return 0;
        int last = lastIndex(sortedList, value);
        return last - first + 1;
    }

    private static int firstIndex(List<Integer> sortedList, int value) {
        int low = 0, high = sortedList.size() - 1, result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedList.get(mid) == value) {
                result = mid;
                high = mid - 1;
            } else if (sortedList.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int lastIndex(List<Integer> sortedList, int value) {
        int low = 0, high = sortedList.size() - 1, result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedList.get(mid) == value) {
                result = mid;
                low = mid + 1;
            } else if (sortedList.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}