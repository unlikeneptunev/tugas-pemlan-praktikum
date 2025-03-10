public class Student {
    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average;
    // Menambahkan atribut statusAkhir (nilai default adalah false)
    private boolean statusAkhir;
    // Menambahkan atribut jumlahObjek untuk menghitung jumlah objek yang dibuat dari instansiasi
    public static int jumlahObjek;

    // Sebelumnya ("student") error karena nama constructor tidak sama persis dengan nama class ("Student")
    public Student() {
        name = "";
        address = "";
        age = 0;
        // Menambahkan jumlahObjek++ untuk increment jumlah objek yang dibuat
        jumlahObjek++;
    }

    public Student(String n, String a, int ag) {
        name = n;
        address = a;
        age = ag;
        // Menambahkan jumlahObjek++ untuk increment jumlah objek yang dibuat
        jumlahObjek++;
    }

    // Constructor baru dengan parameter nilai math, english, dan science
    public Student(int math, int english, int science) {
        mathGrade = math;
        englishGrade = english;
        scienceGrade = science;
        // Menambahkan jumlahObjek++ untuk increment jumlah objek yang dibuat
        jumlahObjek++;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAddress(String a) {
        address = a;
    }

    public void setAge(int ag) {
        age = ag;
    }

    public void setMath(int math) {
        mathGrade = math;
    }

    public void setEnglish(int english) {
        englishGrade = english;
    }

    public void setScience(int science) {
        scienceGrade = science;
    }

    private double getAverage() {
        // Mengubah variabel 'result' menjadi 'average' agar atribut 'average' tidak mubazir
        double result = 0;
        result = (mathGrade + scienceGrade + englishGrade) / 3;
        return result;
    }

    // Menambahkan method statusAkhir
    private boolean statusAkhir() {
        if (getAverage() >= 61) {
            statusAkhir = true;
        } else {
            statusAkhir = false;
        }
        return statusAkhir;
    }

    // Menambahkan method jumlahObjek untuk menghitung jumlah objek yang dibuat
    public static void jumlahObjek() {
        System.out.println("Total objek yang dibuat dari class Student: " + jumlahObjek);
    }

    public void displayMessage() {
        System.out.println("Siswa dengan nama " + name);
        System.out.println("beramalat di " + address);
        System.out.println("berumur " + age);
        // Sedikit modifikasi menggunakan printf untuk membulatkan 2 angka di belakang koma
        System.out.printf("mempunyai nilai rata rata %.2f\n", getAverage());
        // Menambahkan output statusAkhir
        System.out.println("Status kelulusan: " + (statusAkhir() ? "LOLOS" : "REMIDI"));
        // Menambahkan s.out kosong agar output lebih rapi
        System.out.println();
    }
}