package KUIS2;

import java.util.Scanner;

public class MainBasket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleLinkedList sll = new SingleLinkedList();

        // data klasemen aktual
        sll.addLast(new Club("PRAWIRA HARUM BANDUNG", 30, 27, 3, 57));
        sll.addLast(new Club("SATRIA MUDA PERTAMINA JAKARTA",30, 27, 3, 57));
        sll.addLast(new Club("PELITA JAYA JAKARTA",30,27,3,57));
        sll.addLast(new Club("DEWA UNITED BANTEN", 30, 20, 10, 28));
        sll.addLast(new Club("Rajawali Medan",19, 8, 11, 27));
        sll.addLast(new Club("Prawira Harum Bandung", 15, 11, 4, 26));
        sll.addLast(new Club("RANS Simba Bogor", 17, 9, 8, 26));
        sll.addLast(new Club("Satria Muda Pertamina Jakarta", 16, 9, 7, 25));
        sll.addLast(new Club("Borneo Hornbills", 18, 6, 12, 24));
        sll.addLast(new Club("Amartha Hangtuah Jakarta",16, 6, 10, 22));
        sll.addLast(new Club("Satya Wacana Salatiga",17, 5, 12, 22));
        sll.addLast(new Club("Bima Perkasa Jogja", 17, 3, 14, 20));
        sll.addLast(new Club("Tangerang Hawks Basketball Club", 15, 4, 11, 18));
        sll.addLast(new Club("Pacific Caesar Surabaya",16, 1, 15, 17));

        while (true) {
            System.out.println("===========================");
            System.out.println("Klasemen Indonesian Basketball League");
            System.out.println("===========================");
            System.out.println("1. Tambahkan data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Cari data");
            System.out.println("4. Hapus data");
            System.out.println("5. Edit data yang sudah ada");
            System.out.println("0. Keluar");
            System.out.println("===========================");
            System.out.print("Pilih menu: ");
            int pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:
                    System.out.println("Nama Tim:");
                    String name = sc.nextLine();
                    System.out.println("Jumlah Match: ");
                    int match = sc.nextInt();
                    System.out.println("Jumlah Menang: ");
                    int win = sc.nextInt();
                    System.out.println("Jumlah kalah: ");
                    int lose = sc.nextInt();
                    System.out.println("Akumulasi poin: ");
                    int point = sc.nextInt();
                    Club club = new Club(name, match, win, lose, point);
                    sll.addLast(club);
                    break;

                case 2:
                    sll.print();
                    break;

                case 3:
                    System.out.println("Masukkan nama club yang ingin dicari: ");
                    String clubName = sc.nextLine();
                    sll.search(clubName);
                    break;

                case 4:
                    // System.out.println("Masukkan rank club yang ingin di hapus: ");
                    // String clubDelete = sc.nextLine();
                    // System.out.println("Club " + clubDelete + " telah di hapus");
                    sll.remove();
                    break;
                
                case 5:
                    // System.out.println("Pilih rank club yang ingin diedit: ");
                    sll.edit();

                    break;
                
                case 0:
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
            
        }
    }
}