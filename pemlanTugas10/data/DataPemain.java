// Class untuk menyimpan data-data pemain 

package data;

import model.PemainFutsal;
import java.util.ArrayList;
import java.util.List;

public class DataPemain {
    public static List<PemainFutsal> getSemuaPemain() {
        List<PemainFutsal> semuaPemain = new ArrayList<>();

        // Data pemain di Tim A
        int[][] dataTimA = {
                { 1, 168, 50 }, { 2, 170, 60 }, { 3, 165, 56 }, { 4, 168, 55 }, { 5, 172, 60 }, { 6, 170, 70 },
                { 7, 169, 66 }, { 8, 165, 56 }, { 9, 171, 72 }, { 10, 166, 56 }
        };
        for (int[] data : dataTimA) {
            semuaPemain.add(new PemainFutsal(data[0], data[1], data[2], "A"));
        }

        // Data pemain di Tim B
        int[][] dataTimB = {
                { 1, 170, 66 }, { 2, 167, 60 }, { 3, 165, 59 }, { 4, 166, 58 }, { 5, 168, 58 }, { 6, 175, 71 },
                { 7, 172, 68 }, { 8, 171, 68 }, { 9, 168, 65 }, { 10, 169, 60 }
        };
        for (int[] data : dataTimB) {
            semuaPemain.add(new PemainFutsal(data[0], data[1], data[2], "B"));
        }
        return semuaPemain;
    }
}