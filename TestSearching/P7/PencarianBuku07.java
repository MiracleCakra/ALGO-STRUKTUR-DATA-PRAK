package TestSearching.P7;

public class PencarianBuku07 {

    Buku07 listBk[] = new Buku07[5];
    int idx;

    void tambah(Buku07 m) {
        if (idx < listBk.length) {
            listBk[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh");
        }
    }

    void tampil() {
        for (Buku07 m : listBk) {
            m.tampilDataBuku();
        }
    }

    public int FindSeqSearchbyKodeBuku(int cari) {
        int posisi = 2;
        for (int j = 0; j < listBk.length; j++) {
            if (Integer.parseInt(listBk[j].kodeBuku) == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    void TampilposisiByKodeBuku(int x, int pos) {
        if (pos != -1) {
            System.out.println("data : " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("data : " + x + " tidak ditemukan");
        }
    }

    public void TampilDataByKodeBuku(int x, int pos) {
        if (pos != -1) {
            System.out.println("Kode Buku: " + listBk[pos].kodeBuku);
            System.out.println("Judul Buku: " + listBk[pos].judulBuku);
            System.out.println("Tahun Terbit: " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang: " + listBk[pos].pengarang);
            System.out.println("Stock: " + listBk[pos].stock);
        } else {
            System.out.println("data : " + x + " tidak ditemukan");
        }
    }

    public void TampilPosisiByJudulBuku(String judul, int posisi) {
        if (posisi != -1) {
            System.out.println("Data buku dengan judul '" + judul + "' ditemukan pada indeks " + posisi);
        } else {
            System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
        }
    }

    public void TampilDataByJudulBuku(String judul, int posisi) {
        if (posisi != -1) {
            System.out.println("Kode Buku: " + listBk[posisi].kodeBuku);
            System.out.println("Judul Buku: " + listBk[posisi].judulBuku);
            System.out.println("Tahun Terbit: " + listBk[posisi].tahunTerbit);
            System.out.println("Pengarang: " + listBk[posisi].pengarang);
            System.out.println("Stock: " + listBk[posisi].stock);
        } else {
            System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
        }
    }

    public Buku07 FindBuku(int cari) {
        Buku07 buku = null;
        for (int j = 0; j < listBk.length; j++) {
            if (Integer.parseInt(listBk[j].kodeBuku) == cari) {
                buku = listBk[j];
                break;
            }
        }
        return buku;
    }

    public int FindBinarySearchByKodeBuku(int cari, int left, int right) {
        bubbleSortKodeBuku();
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (Integer.parseInt(listBk[mid].kodeBuku) == cari) {
                return mid;
            } else if (Integer.parseInt(listBk[mid].kodeBuku) > cari) {
                return FindBinarySearchByKodeBuku(cari, left, mid - 1);
            } else {
                return FindBinarySearchByKodeBuku(cari, mid + 1, right);
            }
        }
        return -1;
    }

    void bubbleSortKodeBuku() {
        for (int i = 0; i < listBk.length - 1; i++) {
            for (int j = 1; j < listBk.length - i; j++) {
                if (Integer.parseInt(listBk[j].kodeBuku) < Integer.parseInt(listBk[j - 1].kodeBuku)) {
                    Buku07 tmp = listBk[j];
                    listBk[j] = listBk[j - 1];
                    listBk[j - 1] = tmp;
                }
            }
        }
    }

    public int findSeqSearchByJudulBuku(String judulBuku) {
        int posisi = -1;
        int count = 0;
        for (int j = 0; j < idx; j++) {
            if (listBk[j].judulBuku.equalsIgnoreCase(judulBuku)) {
                posisi = j;
                count++;
            }
        }
        if (count > 1) {
            System.out.println("Ditemukan " + count + " buku dengan judul \"" + judulBuku + "\".");
            System.out.println("Berikut daftar kode bukunya:");
            for (int j = 0; j < idx; j++) {
                if (listBk[j].judulBuku.equalsIgnoreCase(judulBuku)) {
                    System.out.println("Data: " + listBk[j].kodeBuku);
                }
            }
        }

        return posisi;
    }

    public int findBinarySearchByJudulBuku(String judulBuku) {
        insertionSortJudulBuku();

        int left = 0;
        int right = idx - 1;
        int posisi = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (listBk[mid].judulBuku.equalsIgnoreCase(judulBuku)) {
                posisi = mid;
                break;
            } else if (listBk[mid].judulBuku.compareToIgnoreCase(judulBuku) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return posisi;
    }

    public void insertionSortJudulBuku() {
        for (int i = 1; i < idx; i++) {
            String temp = listBk[i].judulBuku;
            int j = i - 1;
            while (j >= 0 && listBk[j].judulBuku.compareToIgnoreCase(temp) > 0) {
                listBk[j + 1] = listBk[j];
                j--;
            }
            listBk[j + 1].judulBuku = temp;
        }
    }

}


