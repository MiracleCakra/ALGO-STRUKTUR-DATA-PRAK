package Minggu9UTS.UTS;

public class UTS07 {
    

    int nilai;

    public UTS07(int nilai){
        this.nilai = nilai;
    }

    // Methode untuk menampilkan data array
    public static void tampil(UTS07[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nilai indeks ke-" + i + ": " + arr[i].nilai);
        }
    }

}
