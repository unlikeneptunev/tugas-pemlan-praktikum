// class untuk deklarasi variabel yang diperlukan

package model;

public class PemainFutsal {
    private final int noPemain;
    private final int tinggiBadan;
    private final int beratBadan;
    private final String tim;

    public PemainFutsal(int noPemain, int tinggiBadan, int beratBadan, String tim) {
        this.noPemain = noPemain;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.tim = tim;
    }

    // Method getter
    public int getNoPemain() {
        return noPemain;
    }

    public int getTinggiBadan() {
        return tinggiBadan;
    }

    public int getBeratBadan() {
        return beratBadan;
    }

    public String getTim() {
        return tim;
    }

    // Method toString() untuk menampilkan info pemain
    @Override
    public String toString() {
        return "Tim: " + tim + " Pemain nomor " + noPemain + ": " + "Tinggi badan: " + tinggiBadan + " cm, "
                + "Berat badan: " + beratBadan + " kg";
    }

    public String getNama() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNama'");
    }
}