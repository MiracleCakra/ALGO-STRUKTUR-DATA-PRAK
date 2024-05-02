package minggu8.program;

import java.util.Scanner;

public class Gudang07 {
    
    Barang07[] tumpukan;
    int size;
    int top;

    public Gudang07(int kapasitas) {
        size = kapasitas;
        tumpukan = new Barang07[size];
        top = -1;
    }

    public boolean cekKosong() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cekPenuh() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahBarang(Barang07 brg) {
        if (!cekPenuh()) {
            top++;
            tumpukan[top] = brg;
            System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
        } else {
            System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
        }
    }

    public Barang07 ambilBarang() {
        if (!cekKosong()) {
            Barang07 delete = tumpukan[top];
            top--;
            System.out.println("Barang " + delete.nama + " diambil dari Gudang");
            System.out.println("Kode unik dalam biner: " + konversiDesimalkeBiner(delete.kode));
            return delete;
        } else {
            System.out.println("Gagal! Tumpukan barang di Gudang masih kosong");
            return null;
        }
    }

    public Barang07 lihatBarangTeratas() {
        if (!cekKosong()) {
            Barang07 barangTeratas = tumpukan[top];
            System.out.println("Barang teratas " + barangTeratas.nama);
            return barangTeratas;
        } else {
            System.out.println("Tumpukan barang kosong");
            return null;
        }
    }

    public void tampilkanBarang() {
        if (!cekKosong()) {
            System.out.println("Rincian tumpukan barang di Gudang:");
            for (int i = top; i >= 0; i--) {
                System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama,
                        tumpukan[i].kategori);
            }
        } else {
            System.out.println("Tumpukan barang kosong");
        }
    }

    /// baru
    public Barang07 lihatBarangTerbawah(){
        if (!cekKosong()) {
            Barang07 barangTerbawah = tumpukan[0];
            System.out.println("Barang terbawah: " + barangTerbawah.nama);
            return barangTerbawah;
        } else {
            System.out.println("Tumpukan barang kosong.");
            return null;
        }
    }

    public void cariBarang(Scanner scanner) {
    System.out.println("Pilih metode pencarian:");
    System.out.println("1. Berdasarkan kode barang");
    System.out.println("2. Berdasarkan nama barang");
    System.out.print("Masukkan pilihan: ");
    int pilihan = scanner.nextInt();
    scanner.nextLine();

    switch (pilihan) {
        case 1:
            System.out.print("Masukkan kode barang: ");
            int kodeCari = scanner.nextInt();
            scanner.nextLine();
            boolean ditemukanKode = false;
            for (int i = 0; i <= top; i++) {
                if (tumpukan[i].kode == kodeCari) {
                    System.out.println("Barang ditemukan: " + tumpukan[i].nama + " (Kode: " + tumpukan[i].kode + ")");
                    ditemukanKode = true;
                    break;
                }
            }
            if (!ditemukanKode) {
                System.out.println("Barang dengan kode " + kodeCari + " tidak ditemukan.");
            }
            break;
        case 2:
            System.out.print("Masukkan nama barang: ");
            String namaCari = scanner.nextLine();
            boolean ditemukanNama = false;
            for (int i = 0; i <= top; i++) {
                if (tumpukan[i].nama.equalsIgnoreCase(namaCari)) {
                    System.out.println("Barang ditemukan: " + tumpukan[i].nama + " (Kode: " + tumpukan[i].kode + ")");
                    ditemukanNama = true;
                    break;
                }
            }
            if (!ditemukanNama) {
                System.out.println("Barang dengan nama " + namaCari + " tidak ditemukan.");
            }
            break;
        default:
            System.out.println("Pilihan tidak valid.");
            break;
    }
}

    public String konversiDesimalkeBiner(int kode) {
        StackKonversi07 stack = new StackKonversi07();
        while (kode != 0) {
            int sisa = kode % 2;
            stack.push(sisa);
            kode = kode / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }
        return biner;
    }

}