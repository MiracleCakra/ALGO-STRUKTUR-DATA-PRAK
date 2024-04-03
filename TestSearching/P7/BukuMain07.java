package TestSearching.P7;

import java.util.Scanner;

public class BukuMain07 {
  
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        PencarianBuku07 data = new PencarianBuku07();
        int jumBuku = 5;

        for (int i = 0; i < jumBuku; i++) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Masukkan data Buku secara Urut dari KodeBuku Terkecil : ");
            System.out.println("----------------------------------------------------------");
            System.out.print("Kode Buku \t: ");
            String kodeBuku = s1.nextLine();
            System.out.print("Judul Buku \t: ");
            String judulBuku = s1.nextLine();
            System.out.print("Tahun Terbit \t: ");
            int tahunTerbit = s.nextInt();
            System.out.print("Pengarang \t: ");
            String pengarang = s1.nextLine();
            System.out.print("Stock \t\t: ");
            int stock = s.nextInt();

            Buku07 m = new Buku07(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Data Keseluruhan Buku : ");
        data.tampil();

        int pilihan = 0;
        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("Menu Pilihan : ");
            System.out.println("----------------------------------------------------------");
            System.out.println("1. Cari Data Buku Berdasarkan Kode Buku");
            System.out.println("2. Cari Data Buku Berdasarkan Judul Buku");
            System.out.println("3. Exit");
            System.out.print("Pilihan: ");
            pilihan = s.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Pencarian Data : ");
                    System.out.println("Masukkan kode buku yang dicari: ");
                    System.out.print("Kode Buku : ");
                    int cari = s.nextInt();
                    System.out.println("Menggunakan sequential Search");
                    int posisi = data.FindSeqSearchbyKodeBuku(cari);
                    data.TampilposisiByKodeBuku(cari, posisi);
                    data.TampilDataByKodeBuku(cari, posisi);

                    Buku07 dataBuku = data.FindBuku(cari);
                    if (dataBuku != null) {
                        dataBuku.tampilDataBuku();
                    } else {
                        System.out.println("Buku dengan kode " + cari + " tidak ditemukan.");
                    }

                    System.out.println("=========================================================");
                    System.out.println("Menggunakan binary search");
                    data.bubbleSortKodeBuku();
                    posisi = data.FindBinarySearchByKodeBuku(cari, 0, jumBuku - 1);
                    data.TampilposisiByKodeBuku(cari, posisi);
                    data.TampilDataByKodeBuku(cari, posisi);
                    break;

                case 2:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Pencarian Data : ");
                    System.out.println("Masukkan judul buku yang dicari: ");
                    System.out.print("Judul Buku : ");
                    String cariJudul = s1.nextLine();
                    System.out.println();

                    System.out.println("Menggunakan sequential Search");
                    int posisiJudul = data.findSeqSearchByJudulBuku(cariJudul);
                    data.TampilPosisiByJudulBuku(cariJudul, posisiJudul);

                    System.out.println("=========================================================");
                    System.out.println("Menggunakan binary search");
                    data.insertionSortJudulBuku();
                    posisiJudul = data.findBinarySearchByJudulBuku(cariJudul);
                    data.TampilPosisiByJudulBuku(cariJudul, posisiJudul);
                    data.TampilDataByJudulBuku(cariJudul, posisiJudul);
                    break;

                case 3:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("EXIT");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (pilihan != 3);
    }

}
