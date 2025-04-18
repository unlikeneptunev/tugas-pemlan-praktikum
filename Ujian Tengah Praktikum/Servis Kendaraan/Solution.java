import java.util.*;

class Kendaraan {
    private String merk;
    private int tahun;
    private String plat;
    private int jarakTempuh;
    protected static int totalKendaraan = 0;
    public static final int BATAS_SERVIS = 10000;

    public Kendaraan(String merk, int tahun, String plat, int jarakTempuh) {
        this.merk = merk;
        this.tahun = tahun;
        this.plat = plat;
        this.jarakTempuh = jarakTempuh;
        totalKendaraan++;
    }

    // Getter
    public String getMerk() { return merk; }
    public int getTahun() { return tahun; }
    public String getPlat() { return plat; }
    public int getJarakTempuh() { return jarakTempuh; }

    public int butuhServisUsia() {
        return 2025 - tahun;
    }

    public boolean butuhServis() {
        return jarakTempuh >= BATAS_SERVIS;
    }

    public int butuhServisBiayaServis() {
        return 0; // akan dioverride
    }

    public void tampilkanInfoServis() {
        // akan dioverride
    }
}

class Mobil extends Kendaraan {
    public Mobil(String merk, int tahun, String plat, int jarakTempuh) {
        super(merk, tahun, plat, jarakTempuh);
    }

    @Override
    public int butuhServisBiayaServis() {
        return 500_000 + (butuhServisUsia() * 100_000);
    }

    @Override
    public void tampilkanInfoServis() {
        System.out.println(String.format("[MOBIL] %s - %d - %s - Usia: %d tahun - Jarak: %d km - Biaya Servis: Rp%d",
            getMerk(), getTahun(), getPlat(), butuhServisUsia(), getJarakTempuh(), butuhServisBiayaServis()));
    }
}

class Motor extends Kendaraan {
    public Motor(String merk, int tahun, String plat, int jarakTempuh) {
        super(merk, tahun, plat, jarakTempuh);
    }

    @Override
    public int butuhServisBiayaServis() {
        return 200_000 + (butuhServisUsia() * 50_000);
    }

    @Override
    public void tampilkanInfoServis() {
        System.out.println(String.format("[MOTOR] %s - %d - %s - Usia: %d tahun - Jarak: %d km - Biaya Servis: Rp%d",
            getMerk(), getTahun(), getPlat(), butuhServisUsia(), getJarakTempuh(), butuhServisBiayaServis()));
    }
}

class Garasi {
    private List<Kendaraan> kendaraanList = new ArrayList<>();

    public void tambahKendaraan(Kendaraan k) {
        kendaraanList.add(k);
    }

    public void tampilkanKendaraanButuhServis() {
        System.out.println("== Kendaraan yang Butuh Servis ==");
        int butuhServis = 0;
        for (Kendaraan k : kendaraanList) {
            if (k.butuhServis()) {
                k.tampilkanInfoServis();
                butuhServis++;
            }
        }
        
        System.out.println("Total kendaraan butuh servis: " + butuhServis);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Garasi garasi = new Garasi();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(" ");
            String tipe = data[0];
            String merk = data[1];
            int tahun = Integer.parseInt(data[2]);
            String plat = data[3];
            int jarak = Integer.parseInt(data[4]);

            Kendaraan k;
            if (tipe.equalsIgnoreCase("Mobil")) {
                k = new Mobil(merk, tahun, plat, jarak);
            } else {
                k = new Motor(merk, tahun, plat, jarak);
            }
            
            garasi.tambahKendaraan(k);
        }

        garasi.tampilkanKendaraanButuhServis();
    }
}
