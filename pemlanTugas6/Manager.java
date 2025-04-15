import java.time.LocalDate;

public class Manager extends Pekerja {
    private String departemen;

    public Manager(String departemen, double gaji, int tahun, int bulan, int tanggal,
                   int jumlahAnak, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, jenisKelamin, nik, menikah, gaji,
              LocalDate.of(tahun, bulan, tanggal), jumlahAnak);
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return departemen;
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + (0.10 * getGaji());
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "departemen : " + departemen;
    }
}
