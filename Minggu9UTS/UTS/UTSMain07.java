package Minggu9UTS.UTS;

import java.util.Scanner;
public class UTSMain07 {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        UTS07 nilai[] = new UTS07[17];
        nilai[0]  = new UTS07(4);
        nilai[1]  = new UTS07(47);
        nilai[2]  = new UTS07(46);
        nilai[3]  = new UTS07(17);
        nilai[4]  = new UTS07(5);
        nilai[5]  = new UTS07(2);
        nilai[6]  = new UTS07(18);
        nilai[7]  = new UTS07(8);
        nilai[8]  = new UTS07(6);
        nilai[9]  = new UTS07(38);
        nilai[10] = new UTS07(33);
        nilai[11] = new UTS07(28);
        nilai[12] = new UTS07(21);
        nilai[13] = new UTS07(26);
        nilai[14] = new UTS07(43);
        nilai[15] = new UTS07(45);
        nilai[16] = new UTS07(13);

            
            // memanggil methode tampil
            UTS07.tampil(nilai);
            
    System.out.println("===================");
    System.out.println("     SEARCHING      ");
    System.out.println("===================");
            
            UTSSearching pencarian = new UTSSearching(nilai);

            System.out.print("Masukkan nilai yang dicari: ");
            int cari = input.nextInt();
            
            int ketemu = pencarian.FindBinarySearch(cari, 0, nilai.length - 1); 
            // pencarian adalah objeknya, `ketemu` adalah atribut yang dicari
            pencarian.TampilPosisi(cari, ketemu);

    System.out.println("=========================");
    System.out.println("    SORTING ASCENDING       ");
    System.out.println("=========================");

        // Sorting data
        pencarian.SortingAscending();
        pencarian.TampilNilai();

        System.out.print("Masukkan nilai yang akan dicari: ");
        cari = input.nextInt();
        ketemu = pencarian.FindSortingAscending(cari);
        pencarian.TampilPosisi(cari, ketemu);
    }
}
