public class dataMobil {
    String merk[] = { "BMW", "Ford", "Nissan", "Subaru", "Toyota", "Volkswagen" };
    String tipe[] = { "M2 Coupe", "Fiesta ST", "370Z", "BRZ", "Impreza WRX STI", "AE86 Trueno", "86/GT86", "Golf GTI" };
    int tahun[] = { 2016, 2014, 2009, 2014, 2013, 1986, 2014, 2014 };
    int topAcceleration[] = { 6816, 3921, 4360, 4058, 6255, 3700, 4180, 4180 };
    int topPower[] = { 728, 575, 657, 609, 703, 553, 609, 631 };

    int maxAcceleration(int arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else {
            int mid = (l + r) / 2;
            int left = maxAcceleration(arr, l, mid);
            int right = maxAcceleration(arr, mid + 1, r);

            int maksAcceleration;
            if (left > right) {
                maksAcceleration = left;
            } else {
                maksAcceleration = right;
            }
            return maksAcceleration;
        }
    }

    int minAcceleration(int arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        } else {
            int mid = (l + r) / 2;
            int left = minAcceleration(arr, l, mid);
            int right = minAcceleration(arr, mid + 1, r);

            int minAcceleration;
            if (left < right) {
                minAcceleration = left;
            } else {
                minAcceleration = right;
            }
            return minAcceleration;
        }
    }

    double rataPower() {
        double totalPower = 0;
        for (int i = 0; i < topPower.length; i++) {
            totalPower += topPower[i];
        }
        return totalPower / topPower.length;
    }
}