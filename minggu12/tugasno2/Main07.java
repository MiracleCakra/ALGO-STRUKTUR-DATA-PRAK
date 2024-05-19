package minggu12.tugasno2;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList dll = new DoubleLinkedList();
        int choice, id, index;
        String judul;
        double rating;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film-DESC");
            System.out.println("10. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahAwal(id, judul, rating);
                    break;
                case 2:
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahAkhir(id, judul, rating);
                    break;
                case 3:
                    System.out.print("Masukkan Index: ");
                    index = scanner.nextInt();
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahPadaIndex(index, id, judul, rating);
                    break;
                case 4:
                    dll.hapusPertama();
                    break;
                case 5:
                    dll.hapusTerakhir();
                    break;
                case 6:
                    System.out.print("Masukkan Index untuk dihapus: ");
                    index = scanner.nextInt();
                    dll.hapusPadaIndex(index);
                    break;
                case 7:
                    dll.cetak();
                    break;
                case 8:
                    System.out.print("Masukkan ID Film yang dicari: ");
                    id = scanner.nextInt();
                    Film foundFilm = dll.cariID(id);
                    if (foundFilm != null) {
                        System.out.println("Film ditemukan: ID: " + foundFilm.id + ", Judul: " + foundFilm.judul + ", Rating: " + foundFilm.rating);
                    } else {
                        System.out.println("Film dengan ID tersebut tidak ditemukan.");
                    }
                    break;
                case 9:
                    dll.urutRatingDesc();
                    break;
                case 10:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 10);
        scanner.close();
    }
}