import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jenisKelamin, String nik, boolean menikah,
                   double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public double getGaji() {
        return gaji;
    }

    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public double getBonus() {
        long lamaBekerja = ChronoUnit.YEARS.between(tahunMasuk, LocalDate.now());
        if (lamaBekerja <= 5) {
            return gaji * 0.05;
        } else if (lamaBekerja <= 10) {
            return gaji * 0.10;
        } else {
            return gaji * 0.15;
        }
    }

    @Override
    public double getPendapatan() {
        return super.getTunjangan() + gaji + getBonus() + (jumlahAnak * 20);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "tahun masuk : " + tahunMasuk.getDayOfMonth() + " " + tahunMasuk.getMonthValue() + " " + tahunMasuk.getYear() + "\n" +
               "jumlah anak : " + jumlahAnak + "\n" +
               "gaji    : " + gaji;
    }

    public void setJumlahAnak(int i) {
        this.jumlahAnak = i;
    }
}
