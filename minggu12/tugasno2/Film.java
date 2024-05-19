package minggu12.tugasno2;

class Film {
int id;
String judul;
double rating;
Film prev, next;

    Film(int id, String judul, double rating) {
        this.id = id;
        this.judul = judul;
        this.rating = rating;
    }
}
