public class Sum {
    int elemen;
    double keuntungan[][], total[];

    Sum(int perusahaan, int bulan) {
        this.elemen = bulan;
        this.keuntungan = new double[perusahaan][bulan];
        this.total = new double[perusahaan];
    }

    double totalBF(double arr[], int noPerusahaan) {
        for (int i = 0; i < elemen; i++) {
            total[noPerusahaan] = total[noPerusahaan] + arr[i];
        }
        return total[noPerusahaan];
    }

    double totalDC(double arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else if (l < r) {
            int mid = (l + r) / 2;
            double lsum = totalDC(arr, l, mid);
            double rsum = totalDC(arr, mid + 1, r);
            return lsum + rsum;
        }
        return 0;
    }
}