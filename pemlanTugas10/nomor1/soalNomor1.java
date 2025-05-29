package nomor1;

import data.DataPemain;
import model.PemainFutsal;
import java.util.*;

public class soalNomor1 {
    // a. Sorting berdasarkan tinggi badan
    public static void sortTinggi() {
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();

        // Ambil tinggi badan pemain saja
        List<Integer> tinggiBadanList = new ArrayList<>();
        for (PemainFutsal pemain : semuaPemain) {
            tinggiBadanList.add(pemain.getTinggiBadan());
        }

        // Urutkan secara ascending (menaik)
        List<Integer> sortTinggiAscending = new ArrayList<>(tinggiBadanList);
        Collections.sort(sortTinggiAscending);

        // Urutkan secara descending (menurun)
        List<Integer> sortTinggiDescending = new ArrayList<>(tinggiBadanList);
        sortTinggiDescending.sort(Collections.reverseOrder());
    }

    // b. Sorting berdasarkan berat badan
    public static void sortBerat() {
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();

        // Ambil berat badan pemain saja
        List<Integer> beratBadanList = new ArrayList<>();
        for (PemainFutsal pemain : semuaPemain) {
            beratBadanList.add(pemain.getBeratBadan());
        }

        // Urutkan secara ascending (menaik)
        List<Integer> sortBeratAscending = new ArrayList<>(beratBadanList);
        Collections.sort(sortBeratAscending);

        // Urutkan secara descending (menurun)
        List<Integer> sortBeratDescending = new ArrayList<>(beratBadanList);
        sortBeratDescending.sort(Collections.reverseOrder());
    }

    // c. Nilai maksimum dan minimum tinggi & berat badan per tim
    public static void nilaiMinMax() {
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();

        // Memisahkan pemain berdasarkan timnya
        List<PemainFutsal> timA = new ArrayList<>();
        List<PemainFutsal> timB = new ArrayList<>();
        for (PemainFutsal pemain : semuaPemain) {
            if (pemain.getTim().equals("A")) {
                timA.add(pemain);
            } else if (pemain.getTim().equals("B")) {
                timB.add(pemain);
            }
        }

        // Mencari nilai min dan max
        Comparator<PemainFutsal> cmpTinggi = Comparator.comparingInt(PemainFutsal::getTinggiBadan);
        Comparator<PemainFutsal> cmpBerat = Comparator.comparingInt(PemainFutsal::getBeratBadan);

        // Tim A
        PemainFutsal minTinggiA = Collections.min(timA, cmpTinggi);
        PemainFutsal maxTinggiA = Collections.max(timA, cmpTinggi);
        PemainFutsal minTinggiB = Collections.min(timB, cmpTinggi);
        PemainFutsal maxTinggiB = Collections.max(timB, cmpTinggi);

        // Tim B
        PemainFutsal minBeratA = Collections.min(timA, cmpBerat);
        PemainFutsal maxBeratA = Collections.max(timA, cmpBerat);
        PemainFutsal minBeratB = Collections.min(timB, cmpBerat);
        PemainFutsal maxBeratB = Collections.max(timB, cmpBerat);

    }

    // d. Copy seluruh anggota Tim B ke Tim C yang baru dibentuk
    public static void main() {
        List<PemainFutsal> semuaPemain = DataPemain.getSemuaPemain();

        List<PemainFutsal> timC = new ArrayList<>();

        for (PemainFutsal pemain : semuaPemain) {
            if (pemain.getTim().equals("B")) {
                PemainFutsal pemainBaru = new PemainFutsal(pemain.getNoPemain(), pemain.getTinggiBadan(),
                        pemain.getBeratBadan(), "C");
                timC.add(pemainBaru);
            }
        }
    }
}

// tidur