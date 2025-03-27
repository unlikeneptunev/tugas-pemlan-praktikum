public class Pelanggan {
    private double saldo;
    private String nomorPelanggan;
    private String nama;
    private String pin;
    private int percobaanLogin;
    private boolean statusBlokir;

    // Constructor dengan parameter untuk inisialisasi atribut
    public Pelanggan(String nomorPelanggan, String nama, String pin, int saldo) {
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.pin = pin;
        this.saldo = saldo;
        this.percobaanLogin = 0;
        this.statusBlokir = false;
    }

    // Method untuk autentikasi PIN yang dimasukkan
    public boolean autentikasi(String inputPin) {
        if (statusBlokir) {
            System.out.println("Akun terblokir. Tidak dapat melakukan transaksi.");
            return false;
        }

        if (this.pin.equals(inputPin)) {
            this.percobaanLogin = 0;
            return true;
        } else {
            this.percobaanLogin++;
            if (this.percobaanLogin == 3) {
                this.statusBlokir = true;
                System.out.println("Akun terblokir setelah 3 kali salah memasukkan PIN.");
            } else {
                System.out.println("PIN salah. Sisa percobaan: " + (3 - this.percobaanLogin));
            }
            return false;
        }
    }

    // Method untuk mendapatkan tipe pelanggan berdasarkan dua digit pertama dari nomorPelanggan
    public String getTipePelanggan() {
        String duaDigitPertama = nomorPelanggan.substring(0, 2);
        switch (duaDigitPertama) {
            case "38":
                return "Silver";
            case "56":
                return "Gold";
            case "74":
                return "Platinum";
            default:
                return "Tidak dikenali.";
        }
    }

    // Method untuk mendapatkan cashback berdasarkan tipe pelanggan dan jumlah pembelian
    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo Anda tidak mencukupi untuk melakukan transaksi.");
        }
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public boolean isStatusBlokir() {
        return statusBlokir;
    }

    public String getPin() {
        return pin;
    }
}
