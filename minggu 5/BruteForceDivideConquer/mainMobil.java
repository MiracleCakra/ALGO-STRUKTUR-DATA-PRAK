public class mainMobil {
    public static void main(String[] args) {

        dataMobil outputMobil = new dataMobil();
        System.out.println("============================================================");
        System.out.println("Mobil dengan top_acceleration tertinggi adalah "
                + outputMobil.maxAcceleration(outputMobil.topAcceleration, 0, outputMobil.topAcceleration.length - 1));
        System.out.println("Mobil dengan top_acceleration terendah adalah "
                + outputMobil.minAcceleration(outputMobil.topAcceleration, 0, outputMobil.topAcceleration.length - 1));
        System.out.println("Rata-rata top_power adalah " + outputMobil.rataPower());
    }
}
