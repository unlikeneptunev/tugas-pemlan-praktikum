import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Manusia a = new Manusia("A", true, "111", true);
        System.out.println(a + "\n");

        MahasiswaFILKOM b = new MahasiswaFILKOM("165150300111100", 4.0, "B", "111", false, false);
        System.out.println(b + "\n");

        Pekerja c = new Pekerja("C", true, "111", true, 1000, LocalDate.of(2016, 3, 2), 3);
        c.setJumlahAnak(4);
        System.out.println(c + "\n");

        Manager d = new Manager("HRD", 1000, 2017, 1, 2, 3, "D", "111", true, true);
        System.out.println(d);
    }
}
