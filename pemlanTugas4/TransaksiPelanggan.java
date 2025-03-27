public class TransaksiPelanggan {
    private Pelanggan pelanggan;
    private static final double MINIMAL_SALDO = 10000;

    public TransaksiPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    // Method untuk melakukan pembelian (pilihan 1)
    public void beli(int jumlah, String pin) {
        if (!pelanggan.autentikasi(pin)) {
            System.out.println("PIN salah!");
            return;
        }
        if (pelanggan.isStatusBlokir()) {
            System.out.println("Akun Anda telah diblokir. Tidak dapat melakukan transaksi.");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("Nominal pembelian harus lebih dari 0!");
            return;
        }
        if (jumlah > pelanggan.getSaldo()) {
            System.out.println("Saldo Anda tidak mencukupi untuk melakukan transaksi.");
            return;
        }
        
        double cashback = hitungCashback(jumlah);
        double totalSetelahCashback = jumlah - cashback;
        
        if (pelanggan.getSaldo() - totalSetelahCashback < MINIMAL_SALDO) {
            System.out.println("Transaksi gagal. Saldo minimal yang harus tersisa adalah Rp" + MINIMAL_SALDO);
            return;
        }
        pelanggan.setSaldo(pelanggan.getSaldo() - totalSetelahCashback);
        System.out.println("Pembelian berhasil!");
        System.out.println("Cashback: Rp" + cashback);
        System.out.println("Saldo tersisa: Rp" + pelanggan.getSaldo());
    }

    // Method untuk melakukan top-up (pilihan 2)
    public void topUp(double jumlahTopUp, String pin) {
        if (!pelanggan.autentikasi(pin)) {
            System.out.println("PIN salah!");
            return;
        }
        if (pelanggan.isStatusBlokir()) {
            System.out.println("Akun Anda telah diblokir. Tidak dapat melakukan top-up.");
            return;
        }
        pelanggan.setSaldo(pelanggan.getSaldo() + jumlahTopUp);
        System.out.println("Top-up berhasil! Saldo sekarang: Rp" + String.format("%,.0f", pelanggan.getSaldo()));
    }

    // Method untuk menghitung cashback berdasarkan tipe pelanggan dan jumlah pembelian
    private double hitungCashback(int jumlah) {
        String tipePelanggan = pelanggan.getTipePelanggan();
        double cashback = 0;
        // Tipe Silver (cashback 5% untuk pembelian > 1.000.000)
        if (tipePelanggan.equals("Silver") && jumlah > 1000000) {
            cashback = jumlah * 0.05;
        // Tipe Gold (cashback 7% untuk pembelian > 1.000.000 dan 2% untuk pembelian <= 1.000.000)
        } else if (tipePelanggan.equals("Gold")) {
            cashback = jumlah > 1000000 ? jumlah * 0.07 : jumlah * 0.02;
        // Tipe Platinum (cashback 10% untuk pembelian > 1.000.000 dan 5% untuk pembelian <= 1.000.000)
        } else if (tipePelanggan.equals("Platinum")) {
            cashback = jumlah > 1000000 ? jumlah * 0.10 : jumlah * 0.05;
        }
        return cashback;
    }
}
