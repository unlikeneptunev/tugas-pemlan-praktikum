public class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }
    
    // Versi 1: Hanya menampilkan judul buku
    public void tampilkanInfo() {
        System.out.println("Judul buku: " + this.judul);
    }

    // Versi 2: Menampilkan judul, penulis dan tahun terbit dari buku
    public void tampilkanInfo(boolean detail) {
        if (detail) {
            System.out.println("Judul buku: " + this.judul);
            System.out.println("Nama penulis: " + this.penulis);
            System.out.println("Tahun terbit: " + this.tahunTerbit);
        } else {
            tampilkanInfo();
        }
    }
}
