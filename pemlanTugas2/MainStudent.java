import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        System.out.println("<<< Template Data Siswa Sebelum Input User >>>");
        System.out.println("===================");
        Student anna = new Student();
        anna.setName("Anna");
        anna.setAddress("Malang");
        anna.setAge(20);
        anna.setMath(100);
        anna.setEnglish(89);
        anna.setScience(80);
        anna.displayMessage();

        Student chris = new Student("Chris", "Kediri", 21);
        chris.setMath(75);
        chris.setEnglish(60);
        chris.setScience(90);
        chris.displayMessage();

        Student fadil = new Student(45, 60, 55);
        fadil.setName("Fadil");
        fadil.setAddress("Ngawi");
        fadil.setAge(19);
        fadil.displayMessage();

        // siswa dengan nama anna dirubah informasi alamat dan umurnya melalui constructor
        // Sebelumnya ("student") error karena nama constructor tidak sama persis dengan nama class ("Student")
        anna = new Student("anna", "Batu", 18);
        // Nilai Anna akan menjadi 0 karena tidak di-set ulang
        anna.displayMessage();  

        // siswa dengan nama chris dirubah informasi alamat dan umurnya melalui method
        chris.setAddress("Surabaya");
        chris.setAge(22);
        chris.displayMessage();

        /* Mulai kode interaktif dengan meminta input dari user */
        // Membuat objek in dari class Scanner untuk kode interaktif
        Scanner in = new Scanner(System.in);
        System.out.println("<<< Data Siswa dari Input User >>>");
        System.out.println("===================");

        // Meminta jumlah siswa yang akan diinput
        System.out.print("Masukkan jumlah siswa: ");
        int jumlahSiswa = in.nextInt();
        in.nextLine();

        // Membuat array dari objek array dari class Student
        Student[] students = new Student[jumlahSiswa];

        // Input data untuk setiap siswa
        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("\nData Siswa ke-" + (i + 1));
            System.out.println("==================");

            // Membuat objek Student baru
            students[i] = new Student();

            System.out.print("Nama: ");
            students[i].setName(in.nextLine());

            System.out.print("Alamat: ");
            students[i].setAddress(in.nextLine());

            System.out.print("Umur: ");
            students[i].setAge(in.nextInt());

            System.out.print("Nilai Matematika: ");
            students[i].setMath(in.nextInt());

            System.out.print("Nilai Bahasa Inggris: ");
            students[i].setEnglish(in.nextInt());

            System.out.print("Nilai IPA: ");
            students[i].setScience(in.nextInt());
            in.nextLine();
        }

        // Menampilkan data semua siswa yang telah diinput
        System.out.println("\nData Seluruh Siswa:");
        System.out.println("===================");
        for (int i = 0; i < jumlahSiswa; i++) {
            students[i].displayMessage();
        }

        // Menampilkan jumlah objek yang telah dibuat
        Student.jumlahObjek();

        in.close();
    }
}
