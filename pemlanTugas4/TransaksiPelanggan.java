public class TransaksiPelanggan {
    private Pelanggan pelanggan;
    private static final double MINIMAL_SALDO = 10000;

    public TransaksiPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    // Method untuk melakukan pembelian (pilihan 1)
    public void beli(int jumlah, String pin) {
        // Validasi PIN yang dimasukkan
        if (!pelanggan.autentikasi(pin)) {
            System.out.println("PIN salah!");
            return;
        }

        // Validasi status akun
        if (pelanggan.isStatusBlokir()) {
            System.out.println("Akun Anda telah diblokir. Tidak dapat melakukan transaksi.");
            return;
        }

        // Validasi nominal pembelian
        if (jumlah <= 0) {
            System.out.println("Nominal pembelian harus lebih dari 0!");
            return;
        }

        // Validasi saldo
        if (jumlah > pelanggan.getSaldo()) {
            System.out.println("Saldo Anda tidak mencukupi untuk melakukan transaksi.");
            return;
        }
        
        // Hitung cashback
        double cashback = hitungCashback(jumlah);
        double totalSetelahCashback = jumlah - cashback;
        
        // Validasi saldo minimal (Rp10.000)
        if (pelanggan.getSaldo() - totalSetelahCashback < MINIMAL_SALDO) {
            System.out.println("Transaksi gagal. Saldo minimal yang harus tersisa adalah Rp" + String.format("%,.0f", MINIMAL_SALDO));
            return;
        }

        // Lakukan transaksi pembelian
        pelanggan.setSaldo(pelanggan.getSaldo() - totalSetelahCashback);
        System.out.println("Pembelian berhasil!");
        System.out.println("Cashback: Rp" + String.format("%,.0f", cashback));
        System.out.println("Saldo tersisa: Rp" + String.format("%,.0f", pelanggan.getSaldo()));
    }

    // Method untuk melakukan top-up (pilihan 2)
    public void topUp(double jumlahTopUp, String pin) {
        // Validasi PIN
        if (!pelanggan.autentikasi(pin)) {
            System.out.println("PIN salah!");
            return;
        }

        // Validasi status blokir akun
        if (pelanggan.isStatusBlokir()) {
            System.out.println("Akun Anda telah diblokir. Tidak dapat melakukan top-up.");
            return;
        }

        // Validasi jumlah top-up
        if (jumlahTopUp <= 0) {
            System.out.println("Jumlah top-up harus lebih dari 0!");
            return;
        }

        // Lakukan top-up
        pelanggan.setSaldo(pelanggan.getSaldo() + jumlahTopUp);
        System.out.println("Top-up berhasil!");
        System.out.println("Saldo sekarang: Rp" + String.format("%,.0f", pelanggan.getSaldo()));
    }

    // Method untuk menghitung cashback berdasarkan tipe pelanggan dan jumlah pembelian
    private double hitungCashback(int jumlah) {
        String tipePelanggan = pelanggan.getTipePelanggan();
        double cashback = 0;
        
        // Perhitungan cashback berdasarkan tipe pelanggan
        switch (tipePelanggan) {
            case "Silver":
                cashback = jumlah > 1000000 ? jumlah * 0.05 : 0;
                break;
            case "Gold":
                cashback = jumlah > 1000000 ? jumlah * 0.07 : jumlah * 0.02;
                break;
            case "Platinum":
                cashback = jumlah > 1000000 ? jumlah * 0.10 : jumlah * 0.05;
                break;
        }
        
        return cashback;
    }
}
