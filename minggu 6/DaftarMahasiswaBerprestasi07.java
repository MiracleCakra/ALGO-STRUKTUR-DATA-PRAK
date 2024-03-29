public class DaftarMahasiswaBerprestasi07 {
    mahasiswa[] listMhs = new mahasiswa[5];
    int idx;

    void tambah(mahasiswa m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!!");
        }
    }

    void tampil() {
        for (mahasiswa m : listMhs) {
            m.tampil();
            System.out.println("------------------------------");
        }
    }

    void bubbleSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            for (int j = 1; j < listMhs.length - i; j++) {
                if (listMhs[j].IPK > listMhs[j - 1].IPK) { // descending
                    // proses swap atau pertukaran
                    mahasiswa temp = listMhs[j];
                    listMhs[j] = listMhs[j - 1];
                    listMhs[j - 1] = temp;
                }
            }
        }
    }

    void selectionSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < listMhs.length; j++) {
                if (listMhs[j].IPK < listMhs[idxMin].IPK) { // ascending
                    idxMin = j;
                }
            }
            // swap
            mahasiswa temp = listMhs[i];
            listMhs[i] = listMhs[idxMin];
            listMhs[idxMin] = temp;
        }
    }

        void insertionSort() {
        for (int i = 1; i < listMhs.length; i++) {
            mahasiswa temp = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j - 1].umur > temp.umur) {
                listMhs[j] = listMhs[j - 1];
                j--;
            }
            listMhs[j] = temp;
        }
    }
}
