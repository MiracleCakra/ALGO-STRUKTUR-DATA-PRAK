package Minggu9UTS.UTS;

public class UTSSearching {

    // instance array nilai dari object UTS07 agar dapat diakses
    public UTS07 [] nilai;

    public UTSSearching(UTS07[] nilai) {
        this.nilai = nilai;
    }

    // Binary Search
    public int FindBinarySearch (int cari, int left, int right) {
        
        int mid;
        mid = (right + left) / 2;
        if (right >= left) {
            if (cari == nilai[mid].nilai) {
                return (mid);
            } else if (nilai[mid].nilai < cari) {
                return FindBinarySearch(cari, left, mid - 1);
            } else {
                return FindBinarySearch(cari, mid + 1, right);
            }   
        }
        return -1;
        }

    // menampilkan posisi yang sudah dirubah
    public void TampilPosisi (int x, int pos) {
        if (pos!= -1) {
            System.out.println("data : " +x+ " ditemukan pada indeks ke- " +pos);
        } else {
            System.out.println("data " +x+ " tidak ditemukan");
        }
    }

/////////////////////////////////////

    // Methode SelectionSort
    void  SortingAscending() {
        for (int i=0; i < nilai.length-1 ; i++) {
            int idxMin = i; 
    
            for (int j=i+1; j < nilai.length ; j++) {
                if (nilai[j].nilai < nilai[idxMin].nilai) {
                    idxMin = j;
                }
            }
            UTS07 tmp = nilai[idxMin];
            nilai[idxMin] = nilai[i];
            nilai[i] = tmp;
            } 

    }

        // FindSortingAscending
        public int FindSortingAscending (int cari) {
                int left = 0;
                int right = nilai.length - 1;
        
                while (left <= right) {
                    int mid = left + (right - left) / 2;
        
                    if (nilai[mid].nilai == cari)
                        return mid;
        
                    if (nilai[mid].nilai < cari)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
        
                return -1; // Return -1 jika data tidak ditemukan
            }
        

    public void TampilNilai() {
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Nilai indeks ke-" + i + ": " + nilai[i].nilai);
        }
    }
}