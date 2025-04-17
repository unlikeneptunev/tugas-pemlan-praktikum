public class Manusia {
    private String nama;
    private boolean jenisKelamin; // true = laki-laki, false = perempuan
    private String nik;
    private boolean menikah;

    public Manusia(String nama, boolean jenisKelamin, String nik, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.menikah = menikah;
    }

    public String getNama() {
        return nama;
    }

    public boolean getJenisKelamin() {
        return jenisKelamin;
    }

    public String getNik() {
        return nik;
    }

    public boolean isMenikah() {
        return menikah;
    }

    public double getTunjangan() {
        if (menikah) {
            return jenisKelamin ? 25 : 20;
        }
        return 15;
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    @Override
    public String toString() {
        String jenisKelaminStr = jenisKelamin ? "Laki-laki" : "Perempuan";
        return "nama   : " + nama + "\n" +
               "nik    : " + nik + "\n" +
               "jenisKelamin : " + jenisKelaminStr + "\n" +
               "pendapatan : " + getPendapatan();
    }
}
