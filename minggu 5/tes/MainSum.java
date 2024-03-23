import java.util.Scanner;

public class MainSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta, Misal 5,9)");
        System.out.println("Masukkan banyaknya perusahaan : ");
        int perusahaan = sc.nextInt();
        System.out.print("Masukkan jumlah bulan : ");
        int bulan = sc.nextInt();

        Sum sm = new Sum(perusahaan, bulan);
        System.out.println("============================================================");
        for (int i = 0; i < perusahaan; i++) {
            for (int j = 0; j < sm.elemen; j++) {
                System.out.print("Masukkan keuntungan perusahaan ke - " + (i + 1) + " bulan ke - " + (j + 1) + " : ");
                sm.keuntungan[i][j] = sc.nextDouble();
            }
        }

        System.out.println("============================================================");
        System.out.println("Algoritma Brute Force");
        for (int k = 0; k < perusahaan; k++) {
            System.out.println(
                    "Total keuntungan perusahaan " + (k + 1) + " selama " + sm.elemen + " bulan adalah = "
                            + sm.totalBF(sm.keuntungan[k], k));
        }

        System.out.println("============================================================");
        System.out.println("Algoritma Divide Conquer");
        for (int i = 0; i < perusahaan; i++) {
            System.out.println("Total keuntungan perusahaan " + (i + 1) + " selama " + sm.elemen + " bulan adalah = "
                    + sm.totalDC(sm.keuntungan[i], 0, sm.elemen - 1));
        }
    }
}