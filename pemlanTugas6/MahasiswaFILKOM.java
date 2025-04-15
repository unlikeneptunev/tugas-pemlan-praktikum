public class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String nim, double ipk, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, jenisKelamin, nik, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    public String getNim() {
        return nim;
    }

    public double getIpk() {
        return ipk;
    }

    public String getStatus() {
        String angkatan = "20" + nim.substring(0, 2);
        char kodeProdi = nim.charAt(6);
        String prodi;
        switch (kodeProdi) {
            case '2':
                prodi = "Teknik Informatika";
                break;
            case '3':
                prodi = "Teknik Komputer";
                break;
            case '4':
                prodi = "Sistem Informasi";
                break;
            case '6':
                prodi = "Pendidikan Teknologi Informasi";
                break;
            case '7':
                prodi = "Teknologi Informasi";
                break;
            default:
                prodi = "Prodi tidak diketahui. ";
                break;
        }
        return prodi + ", " + angkatan;
    }

    public double getBeasiswa() {
        if (ipk >= 3.0 && ipk <= 3.5) {
            return 50;
        } else if (ipk > 3.5 && ipk <= 4.0) {
            return 75;
        } else {
            return 0;
        }
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getBeasiswa();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "nim    : " + nim + "\n" +
                "ipk    : " + ipk + "\n" +
                "status : " + getStatus();
    }
}