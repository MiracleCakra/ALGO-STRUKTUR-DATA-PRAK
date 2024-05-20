package KUIS2;

import java.util.Scanner;

public class MainBasket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleLinkedList sll = new SingleLinkedList();

        // DATA KLASEMEN IBL 2023
        sll.addLast(new Club("PRAWIRA HARUM BANDUNG", 30, 27, 3, 57));
        sll.addLast(new Club("SATRIA MUDA PERTAMINA JAKARTA",30, 27, 3, 57));
        sll.addLast(new Club("PELITA JAYA JAKARTA",30,27,3,57));
        sll.addLast(new Club("DEWA UNITED BANTEN", 30, 20, 10, 50));
        sll.addLast(new Club("RANS PIK BASKETBAL CLUB",30, 19, 11, 49));
        sll.addLast(new Club("BIMA PERKASA JOGJA", 30, 18, 12, 48));
        sll.addLast(new Club("BALI UNITED BASKETBALL", 30, 15, 15, 45));
        sll.addLast(new Club("BUMI BORNEO BASKETBALL PONTIANAK", 30, 15, 15, 45));
        sll.addLast(new Club("TANGERANG HAWKS BASKETBALL", 29, 13, 16, 42));
        sll.addLast(new Club("INDONESIA PATRIOTS",30, 12, 18, 42));
        sll.addLast(new Club("AMARTHA HANGTUAH JAKARTA",30, 12, 18, 42));
        sll.addLast(new Club("EVOS THUNDER BOGOR", 30, 11, 19, 41));
        sll.addLast(new Club("WEST BANDITS SOLO", 30, 8, 22, 38));
        sll.addLast(new Club("MOUNTAIN GOLD TIMIKA",30, 6, 24, 36));
        sll.addLast(new Club("ELANG PACIFIC CAESAR SURABAYA",30, 6, 24, 36));
        sll.addLast(new Club("SATYA WACANA SALATIGA",30, 4, 26, 34));

        while (true) {
            System.out.println("=======================================");
            System.out.println("Klasemen Indonesian Basketball League");
            System.out.println("=======================================");
            System.out.println("1. Tampilkan data klasemen Tim Basket");
            System.out.println("2. Tambahkan data Tim Basket"); 
            System.out.println("3. Cari data Tim Basket");
            System.out.println("4. Edit data tim yang sudah ada");
            System.out.println("5. Keluar");
            System.out.println("=======================================");
            System.out.print("Pilih menu: ");
            int pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {

                case 1:
                    sll.print();
                    break;

                case 2:
                    System.out.println("Nama Club Tim:");
                    String name = sc.nextLine();
                    System.out.println("Jumlah Pertandingan: ");
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

                case 3:
                    System.out.println("Masukkan nama club yang ingin dicari: ");
                    String clubName = sc.nextLine();
                    sll.search(clubName);
                    break;
                
                case 4:
                    System.out.println("Pilih rank club yang ingin diedit: ");
                    sll.edit();
                    break;
                
                case 5:
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
            
        }
    }
}