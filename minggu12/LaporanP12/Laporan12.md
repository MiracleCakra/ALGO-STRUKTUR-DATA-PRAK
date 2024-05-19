# JOBSHEET XII DOUBLE LINKED LIST

Nama    : Cakra Wangsa M.A.W

Kelas   : TI_1H

Absen   : 07

NIM     : 2341720032

### 12.1 Tujuan Praktikum

Setelah melakukan praktikum ini, mahasiswa mampu:

1. memahami algoritma double linked lists;

2. membuat dan mendeklarasikan struktur algoritma double linked lists;

3. menerapkan algoritma double linked lists dalam beberapa study case.

### 12.2 Kegiatan Praktikum 1

Waktu : 90 Menit

### 12.2.1 Percobaan 1

##### Class pada kode program (Node)

```java
package minggu12.doublelinkedlists;

public class Node {
    int data;
    Node prev, next;

    Node (Node prev, int data, Node next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
```

##### Class pada kode program (DoubleLinkedLists)

```java
package minggu12.doublelinkedlists;

public class DoubleLinkedLists {
    
    Node head;
    int size;

public DoubleLinkedLists() {
    head = null;
    size = 0;
    }

public boolean isEmpty() {
    return head == null;
    }

public void addFirst (int item) {
    if(isEmpty()) {
        head = new Node (null, item, null);
    } else {
        Node newNode = new Node (null, item, head);
        head.prev = newNode;
        head = newNode;
    }
    size++;
    }

public void addlast (int item) {
    if(isEmpty()) {
        addFirst(item);
    } else {
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        Node newNode = new Node (current, item, null);
        current.next = newNode;
        size++;
        }
    }

public void add (int item, int index) throws Exception {
    if(isEmpty()) {
        addFirst(item);
    } else if(index < 0 || index > size) {
        throw new Exception("Nilai indeks diluar batas");
    }else{
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
    if (current.prev == null) {
        Node newNode = new Node (null, item, current);
        current.prev = newNode;
        head = newNode;
    }else{
        Node newNode = new Node (current.prev, item, current);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
            }
       
        }
        size++;
    }

public int size() {
    return size;
    }

public void clear() {
    head = null;
    size = 0;
    }

public void print() {
    if(!isEmpty()) {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println("\nberhasil diisi");
    } else {
        System.out.println("Linked List Kosong");
        }
    }
}
```

##### Main pada kode program

```java
package minggu12.doublelinkedlists;

public class DoubleLinkedListsMain {

public static void main(String[] args) throws Exception {
     DoubleLinkedLists dll = new DoubleLinkedLists();
     dll.print();
     System.out.println("Size  : " + dll.size());
     System.out.println("=============================================");
     dll.addFirst(3);
     dll.addlast(4);
     dll.addFirst(7);
     dll.print();
     System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.add (40, 1);
     dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
     dll.clear();
     dll.print();
    System.out.println("Size  : " + dll.size());

    }
}
```

### 12.2.2 Verifikasi Hasil Percobaan
Verifikasi hasil kompilasi kode program Anda dengan gambar berikut ini.

![alt text](image.png)

Output pada kode program

<img src = "perco1.png">

#### 12.2.3 Pertanyaan Percobaan

1. Jelaskan perbedaan antara single linked list dengan double linked lists!

    Jawab:
    
    Single Linked List:
    - Setiap node (elemen) dalam Single Linked List hanya memiliki satu pointer yang menunjuk ke node berikutnya dalam urutan tersebut.
    - Untuk mengakses suatu node, Anda harus memulai dari node pertama (head) dan menelusuri satu per satu hingga mencapai node yang diinginkan.
    - Tidak ada pointer yang menunjuk ke node sebelumnya, sehingga untuk mengakses node sebelumnya, Anda harus menelusuri kembali dari awal.
    - Operasi seperti menambahkan atau menghapus node di akhir lebih mudah, tetapi untuk menambahkan atau menghapus di tengah-tengah membutuhkan waktu yang lebih lama karena harus menelusuri satu per satu dari awal.

    Double Linked List:
    - Setiap node dalam Double Linked List memiliki dua pointer, satu menunjuk ke node berikutnya dan satu lagi menunjuk ke node sebelumnya.
    - Dengan adanya pointer ke node sebelumnya, operasi penambahan atau penghapusan node di tengah-tengah menjadi lebih mudah dan cepat karena Anda dapat mengakses node sebelum dan sesudahnya secara langsung.
    - Untuk mengakses suatu node, Anda dapat memulai dari node pertama (head) atau node terakhir (tail), bergantung pada kebutuhan.
    - Membutuhkan lebih banyak memori karena setiap node memiliki dua pointer.

    Secara umum, Single Linked List lebih hemat memori, tetapi Double Linked List lebih efisien dalam operasi penambahan atau penghapusan di tengah-tengah karena kemudahan akses ke node sebelum dan sesudahnya. 

2. Perhatikan class Node, di dalamnya terdapat atribut next dan prev. Untuk apakah atribut tersebut?

    Jawab: pada class Node terdapat atribut next dan prev berfungsi untuk memberitahu bahwa class tersebut merupakan bagian dari struktur data linked list dengan artian pada node sebelumnya yaitu (prev) dan pada node selanjutnya yaitu next.

3. Perhatikan konstruktor pada class DoubleLinkedLists. Apa kegunaan inisialisasi atribut head dan size seperti pada gambar berikut ini?

    ![alt text](image-1.png)

    Jawab: kegunaan pada inisialisasi atribut head pada class DoubleLinkedList adalah untuk menginisialisasi atribut pada head menjadi null dan size menjadi 0 dan memiliki beberapa kegunaan. Yaitu inisialisasi linked list kosong, memudahkan untuk menambahkan pada node pertama, dan untuk menghindari kesalahan pada referensi.

4. Pada method addFirst(), kenapa dalam pembuatan object dari konstruktor class Node prev dianggap sama dengan null?
Node newNode = new Node(null, item, head);

    Jawab: Pada pembuatan objek dari sebuah konstruktor class Node, Prev dianggap sama dengan null yang dimana dipanggil pada newNode, dikarenakan kita ingin membuat node baru sebagai node pertama dalam linked list

5. Perhatikan pada method addFirst(). Apakah arti statement head.prev = newNode ?

    Jawab: Dengan menggunakan statement head.prev = newNode, kita dapat mengubah atribut prev node head menjadi referensi ke node baru yang baru dibuat.

6. Perhatikan isi method addLast(), apa arti dari pembuatan object Node dengan mengisikan parameter prev dengan current, dan next dengan null?
Node newNode = new Node(current, item, null);

    Jawab: Kita menggunakan daftar terhubung, yang disimpan dalam variabel saat ini, untuk menghubungkan node baru ke node terakhir. Dan juga mengatur atribut next menjadi null untuk menunjukkan bahwa node baru ini akan menjadi node terakhir.

7. Pada method add(), terdapat potongan kode program sebagai berikut:

    ![alt text](image-2.png)

    jawab: Jika pada current.prev bernilai null, maka berarti current adalah node pertama dalam daftar yang terhubung, dan ketika current.prev bernilai null, kita ingin menambahkan node baru sebagai node pertama dalam daftar yang terhubung. Untuk melakukan ini, kita membuat objek baru dari class Node dengan parameter konstruktor null, item, dan current.

jelaskan maksud dari bagian yang ditandai dengan kotak kuning.

### 12.3 Kegiatan Praktikum 2

Waktu : 60 Menit

### 12.3.1 Tahapan Percobaan

Pada praktikum 2 ini akan dibuat beberapa method untuk menghapus isi LinkedLists pada class DoubleLinkedLists. Penghapusan dilakukan dalam tiga cara di bagian paling depan, paling belakang, dan sesuai indeks yang ditentukan pada linkedLists.

##### Class pada kode program (Node)

```java
package minggu12.doublelinkedlists;

public class Node {
    int data;
    Node prev, next;

    Node (Node prev, int data, Node next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
```

##### Class pada kode program (DuobleLinkedList)

```java
package minggu12.doublelinkedlists;

public class DoubleLinkedLists {
    
    Node head;
    int size;

public DoubleLinkedLists() {
    head = null;
    size = 0;
    }

public boolean isEmpty() {
    return head == null;
    }

public void addFirst (int item) {
    if(isEmpty()) {
        head = new Node (null, item, null);
    } else {
        Node newNode = new Node (null, item, head);
        head.prev = newNode;
        head = newNode;
    }
    size++;
    }

public void addlast (int item) {
    if(isEmpty()) {
        addFirst(item);
    } else {
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        Node newNode = new Node (current, item, null);
        current.next = newNode;
        size++;
        }
    }

public void add (int item, int index) throws Exception {
    if(isEmpty()) {
        addFirst(item);
    } else if(index < 0 || index > size) {
        throw new Exception("Nilai indeks diluar batas");
    }else{
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
    if (current.prev == null) {
        Node newNode = new Node (null, item, current);
        current.prev = newNode;
        head = newNode;
    }else{
        Node newNode = new Node (current.prev, item, current);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
            }
       
        }
        size++;
    }

public int size() {
    return size;
    }

public void clear() {
    head = null;
    size = 0;
    }

public void print() {
    if(!isEmpty()) {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println("\nberhasil diisi");
    } else {
        System.out.println("Linked List Kosong");
        }
    }

    // Penambahan praktikum percobaan 2
public void removeFirst() throws Exception {
    if (isEmpty()) {
        throw new Exception("Linked List masih kosong, tidak dapat dihapus");
    } else if (size == 1) {
        removeLast();
    } else {
        head = head.next;
        head.prev = null;
        size--;
        }
    }

public void removeLast() throws Exception {
    if (isEmpty()) {
        throw new Exception ("Linked List masih kosong, tidak dapat dihapus");
    } else if (head.next == null) {
        head = null;
        size--;
        return;
    }

    Node current = head;
    while (current.next.next != null) {
        current = current.next;
    }
    current.next = null;
    size--;
    }

public void removeAt(int index) throws Exception {
    if (isEmpty() || index >= size) {
        throw new Exception("Nilai indeks diluar batas");
    } else if (index == 0) {
        removeFirst();
    } else {
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        if (current.next == null) {
            current.prev.next= null;
        } else if (current.prev == null) {
            current = current.next;
            current.prev=null;
            head = current;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        }
    }
}
```

##### Main pada kode program (DoubleLinkedListMain)

```java
package minggu12.doublelinkedlists;

public class DoubleLinkedListsMain {

public static void main(String[] args) throws Exception {
     DoubleLinkedLists dll = new DoubleLinkedLists();
     dll.print();
     System.out.println("Size  : " + dll.size());
     System.out.println("=============================================");
     dll.addFirst(3);
     dll.addlast(4);
     dll.addFirst(7);
     dll.print();
     System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.add (40, 1);
     dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
     dll.clear();
     dll.print();
    System.out.println("Size  : " + dll.size());
    //penambahan praktikum percobaan 2 
    dll.addlast(50);
    dll.addlast(40);
    dll.addlast(10);
    dll.addlast(20);
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.removeFirst();
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.removeLast();
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.removeAt(1);
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    }
}
```

### 12.3.2 Verifikasi Hasil Percobaan

Verifikasi hasil kompilasi kode program Anda dengan gambar berikut ini.

![alt text](image-3.png)

##### Output pada kode program

<img src = "perco2.png">

### 12.3.3 Pertanyaan Percobaan

1. Apakah maksud statement berikut pada method removeFirst()?
head = head.next;
head.prev = null;

    Jawab: pada statement head = head.next; dan head.prev = null;, yang berfungsi untuk menghapus node pertama pada linked list. dan pada method removeFirst(), berfungsi untuk memeriksa apakah linked list masih kosong atau hanya memiliki satu node. Apabila linked list masih kosong, maka akan melempar exception. Dan apabila linked list hanya memiliki satu node, maka akan memanggil method removeLast() untuk menghapus node tersebut.

2. Bagaimana cara mendeteksi posisi data ada pada bagian akhir pada method removeLast()?

    jawab: 

    1. Membuat variabel penunjuk (pointer) yang mengarah ke node terakhir. 
    yang dimana dapat membuat variabel penunjuk seperti lastNode yang akan menunjuk ke node terakhir dalam linked list. Pada awalnya, lastNode akan menunjuk ke null (atau None dalam Python) jika linked list masih kosong.

    2. Menelusuri linked list hingga menemukan node terakhir
    dan akan menelusuri linked list dari node head (kepala) hingga menemukan node yang tidak memiliki node selanjutnya (next pointer bernilai null atau None). Maka Node ini akan menjadi node terakhir dalam linked list.

    3. Memeriksa apakah lastNode tidak null atau None
    Jika lastNode tidak null atau None, artinya linked list tidak kosong, dan bisa dapat melanjutkan proses penghapusan node terakhir.

    4. Menghapus node terakhir
    Untuk menghapus node terakhir, kita perlu mengubah pointer next dari node sebelumnya menjadi null atau None. Jika linked list hanya memiliki satu node, maka kita mengatur node head menjadi null atau None.

3. Jelaskan alasan potongan kode program di bawah ini tidak cocok untuk perintah remove!

    ![alt text](image-4.png)

    Jawab: Dalam potongan kode ini, head.next berguna untuk menghubungkan node setelah node yang akan dihapus; namun, tmp.next tidak diatur menjadi null, sehingga masih ada referensi pada node yang akan dihapus dari daftar yang terhubung. Selain itu, sebelum menghapus node, pastikan bahwa atribut prev dari node setelah node yang dihapus juga diperbarui dengan benar.

4. Jelaskan fungsi kode program berikut ini pada fungsi remove!

    ![alt text](image-5.png)

    Jawab: fungsi kode program tersebut pada fungsi remove adalah berguna untuk menghapus node current pada linked list.

### 12.4 Kegiatan Praktikum 3

Waktu : 50 Menit

### 12.4.1 Tahapan Percobaan
Pada praktikum 3 ini dilakukan uji coba untuk mengambil data pada linked list dalam 3 kondisi, yaitu mengambil data paling awal, paling akhir dan data pada indeks tertentu dalam linked list. Method mengambil data dinamakan dengan get. Ada 3 method get yang dibuat pada praktikum ini sesuai dengan diagram class DoubleLinkedLists.

##### Class pada kode program (Node)

```java
package minggu12.doublelinkedlists;

public class Node {
    int data;
    Node prev, next;

    Node (Node prev, int data, Node next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
```

##### Class pada kode program (DoubleLinkedLists)

```java
package minggu12.doublelinkedlists;

public class DoubleLinkedLists {
    
    Node head;
    int size;

public DoubleLinkedLists() {
    head = null;
    size = 0;
    }

public boolean isEmpty() {
    return head == null;
    }

public void addFirst (int item) {
    if(isEmpty()) {
        head = new Node (null, item, null);
    } else {
        Node newNode = new Node (null, item, head);
        head.prev = newNode;
        head = newNode;
    }
    size++;
    }

public void addlast (int item) {
    if(isEmpty()) {
        addFirst(item);
    } else {
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        Node newNode = new Node (current, item, null);
        current.next = newNode;
        size++;
        }
    }

public void add (int item, int index) throws Exception {
    if(isEmpty()) {
        addFirst(item);
    } else if(index < 0 || index > size) {
        throw new Exception("Nilai indeks diluar batas");
    }else{
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
    if (current.prev == null) {
        Node newNode = new Node (null, item, current);
        current.prev = newNode;
        head = newNode;
    }else{
        Node newNode = new Node (current.prev, item, current);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
            }
       
        }
        size++;
    }

public int size() {
    return size;
    }

public void clear() {
    head = null;
    size = 0;
    }

public void print() {
    if(!isEmpty()) {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println("\nberhasil diisi");
    } else {
        System.out.println("Linked List Kosong");
        }
    }

    // Penambahan praktikum percobaan 2
public void removeFirst() throws Exception {
    if (isEmpty()) {
        throw new Exception("Linked List masih kosong, tidak dapat dihapus");
    } else if (size == 1) {
        removeLast();
    } else {
        head = head.next;
        head.prev = null;
        size--;
        }
    }

public void removeLast() throws Exception {
    if (isEmpty()) {
        throw new Exception ("Linked List masih kosong, tidak dapat dihapus");
    } else if (head.next == null) {
        head = null;
        size--;
        return;
    }

    Node current = head;
    while (current.next.next != null) {
        current = current.next;
    }
    current.next = null;
    size--;
    }

public void removeAt(int index) throws Exception {
    if (isEmpty() || index >= size) {
        throw new Exception("Nilai indeks diluar batas");
    } else if (index == 0) {
        removeFirst();
    } else {
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        if (current.next == null) {
            current.prev.next= null;
        } else if (current.prev == null) {
            current = current.next;
            current.prev=null;
            head = current;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        }
    }

    // Penambahan praktikum percobaan 3

    // method getfirst
    public int getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception ("Linked List Kosong");
        } else {
            return head.data;
        }
    }
    // method getlast
    public int getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception ("Linked List Kosong");
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    // method getindex
    public int get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception ("Nilai indeks diluar batas");
        } 
            Node tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp.data;
        
    }
}
```

##### Main pada kode program (DoubleLinkedListsMain)

```java
package minggu12.doublelinkedlists;

public class DoubleLinkedListsMain {

public static void main(String[] args) throws Exception {
     DoubleLinkedLists dll = new DoubleLinkedLists();
     dll.print();
     System.out.println("Size  : " + dll.size());
     System.out.println("=============================================");
     dll.addFirst(3);
     dll.addlast(4);
     dll.addFirst(7);
     dll.print();
     System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.add (40, 1);
     dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
     dll.clear();
     dll.print();
    System.out.println("Size  : " + dll.size());
    //penambahan praktikum percobaan 2 
    dll.addlast(50);
    dll.addlast(40);
    dll.addlast(10);
    dll.addlast(20);
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.removeFirst();
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.removeLast();
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.removeAt(1);
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    //penambahan praktikum percobaan 3
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.addFirst(3);
    dll.addlast(4);
    dll.addFirst(7);
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    dll.add (40, 1);
    dll.print();
    System.out.println("Size  : " + dll.size());
    System.out.println("=============================================");
    System.out.println("Data awal pada Linked Lists adalah: " + dll.getFirst());
    System.out.println("Data akhir pada Linked Lists adalah: " + dll.getLast());
    System.out.println("Data indeks ke-1 pada Linked Lists adalah: " + dll.get(1));
    System.out.println("=============================================");
    }   
}
```

### 12.4.2 Verifikasi Hasil Percobaan
Verifikasi hasil kompilasi kode program Anda dengan gambar berikut ini.

![alt text](image-6.png)

Output pada kode program

<img src = "perco3.png">

### 12.4.3 Pertanyaan Percobaan

1. Jelaskan method size() pada class DoubleLinkedLists!

    Jawab: method size() pada class DoubleLinkedLists berfungsi untuk pengembalian jumlah elemen / size yang ada pada linkedlists

2. Jelaskan cara mengatur indeks pada double linked lists supaya dapat dimulai dari indeks ke- 1!

    Jawab: cara mengatur indeks supaya mulai dari 1 adalah melakukan perubahan pada method get, yang dimana ada perubahan pada kode program 

    ```java
    public int get(int index) throws Exception {
    if (isEmpty() || index > size || index < 1) {
        throw new Exception("Nilai indeks diluar batas");
    }
    Node tmp = head;
    for (int i = 1; i <= index; i++) {
        tmp = tmp.next;
    }
    return tmp.data;
    }
    ``` 

3. Jelaskan perbedaan karakteristik fungsi Add pada Double Linked Lists dan Single Linked Lists!

    Jawab: 

Single Linked List:
1. Pada Single Linked List, setiap node hanya memiliki satu pointer yang menunjuk ke node berikutnya.

2. pada saat menambahkan node baru di akhir daftar, diperlukan penelusuran dari node head hingga mencapai node terakhir. Karena tidak ada pointer yang menunjuk ke node sebelumnya, proses ini membutuhkan waktu O(n), di mana n adalah jumlah node dalam daftar.

3. pada saat menambahkan node baru di awal daftar, cukup mengubah pointer `next` dari node baru agar menunjuk ke node head saat ini, dan mengubah node head menjadi node baru.

Double Linked List:

1. Pada Double Linked List, setiap node memiliki dua pointer, yaitu pointer yang menunjuk ke node sebelumnya dan pointer yang menunjuk ke node berikutnya.

2. pada saat menambahkan node baru di akhir daftar, tidak diperlukan penelusuran dari node head. Dan cukup mengubah pointer `next` dari node terakhir agar menunjuk ke node baru, dan mengubah pointer `prev` dari node baru agar menunjuk ke node terakhir sebelumnya. Proses ini membutuhkan waktu O(1) karena akses langsung ke node terakhir.

3. Pada saat menambahkan node baru di awal daftar, cukup mengubah pointer `next` dari node baru agar menunjuk ke node head saat ini, mengubah pointer `prev` dari node head saat ini agar menunjuk ke node baru, dan mengubah node head menjadi node baru.

4. Pada Double Linked List, penambahan node baru di awal atau akhir daftar membutuhkan waktu O(1) karena adanya akses langsung ke node head dan node tail.



4. Jelaskan perbedaan logika dari kedua kode program di bawah ini!

    ![alt text](image-7.png)

    ![alt text](image-8.png)

    Jawab: 

    a.  Kode program pertama memanfaatkan variabel size untuk memeriksa apakah struktur data Double Linked Lists dalam keadaan kosong atau tidak. Pemeriksaan dilakukan dengan memeriksa apakah nilai variabel size sama dengan 0, yang mengindikasikan bahwa Double Linked Lists tidak memiliki elemen di dalamnya, sehingga dikembalikan nilai true yang menandakan Double Linked Lists dalam keadaan kosong. Sebaliknya, jika nilai variabel size tidak sama dengan 0, maka dikembalikan nilai false yang mengindikasikan bahwa Double Linked Lists tidak dalam keadaan kosong dan memiliki setidaknya satu elemen di dalamnya.

    b. Kode program kedua menggunakan variabel head untuk menentukan apakah struktur data Single Linked Lists dalam keadaan kosong atau tidak. Pemeriksaan dilakukan dengan mengevaluasi apakah nilai variabel head sama dengan null, yang menjadi indikator bahwa Single Linked Lists tidak memiliki elemen di dalamnya, sehingga dikembalikan nilai true yang menandakan Single Linked Lists dalam keadaan kosong. Namun, jika nilai variabel head tidak sama dengan null, maka dikembalikan nilai false yang mengindikasikan bahwa Single Linked Lists tidak dalam keadaan kosong dan memiliki setidaknya satu elemen di dalamnya.

### 12.5 Tugas Praktikum

Waktu : 100 Menit

1. Buat program antrian vaksinasi menggunakan queue berbasis double linked list sesuai ilustrasi dan menu di bawah ini! (counter jumlah antrian tersisa di menu cetak(3) dan data orang yang telah divaksinasi di menu Hapus Data(2) harus ada)
Contoh Ilustrasi Program
Menu Awal dan Penambahan Data

![alt text](image-9.png) 

![alt text](image-10.png)

Cetak Data (Komponen di area merah harus ada)

![alt text](image-12.png)

Hapus Data (Komponen di area merah harus ada)

![alt text](image-13.png)

##### Class pada kode program

```java
package minggu12.tugasno1;

public class Node07 {
    String data;
    Node07 next;
    Node07 prev;
    
    Node07(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
```

```java
package minggu12.tugasno1;

public class Queue {
    
    Node07 front, rear;

    Queue() {
        this.front = this.rear = null;
    }

    void enqueue(String data) {
        Node07 newNode = new Node07(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        System.out.println(data + " telah ditambahkan ke dalam antrian.");
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong, tidak ada yang dapat dihapus.");
            return;
        }
        System.out.println(front.data + " telah selesai divaksinasi.");
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
    }

    void print() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        Node07 temp = front;
        int noAntrian = 1;
        System.out.println("| No Antrian | Nama          |");
        System.out.println("|------------|---------------|");
        while (temp != null) {
            System.out.printf("| %-10d | %-13s |\n", noAntrian++, temp.data);
            temp = temp.next;
        }
        System.out.println("Tersisa " + (noAntrian - 1) + " antrian.");
    }

    boolean isEmpty() {
        return front == null;
    }
}
```

##### Main pada kode program

```java
package minggu12.tugasno1;

import java.util.Scanner;

public class VaksinasiMain07 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        int pilih;
        String nama;
        
        do {
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("PENGANTRI VAKSIN EKSTRAVAGANZA");
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("\n1. Tambah data penerima vaksin");
            System.out.println("2. Hapus data pengantri vaksin");
            System.out.println("3. Daftar penerima vaksin");
            System.out.println("4. Keluar");
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.print("Pilihan: ");
            pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Masukkan Data Penerima Vaksin");
                    System.out.println("-----------------------------");
                    System.out.println("Nomor Antrian: ");
                    scanner.nextLine();
                    System.out.println("Nama Penerima: ");
                    nama = scanner.nextLine();
                    queue.enqueue(nama);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.print();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilih != 4);
        scanner.close();
    }
}
```

##### Output pada kode program

2.Buatlah program daftar film yang terdiri dari id, judul dan rating menggunakan double linked lists, bentuk program memiliki fitur pencarian melalui ID Film dan pengurutan Rating secara descending. Class Film wajib diimplementasikan dalam soal ini.
##### Contoh Ilustrasi Program
Menu Awal dan Penambahan Data

![alt text](image-14.png) 

![alt text](image-15.png) 

![alt text](image-16.png) 

![alt text](image-17.png)

Cetak Data

![alt text](image-18.png)

Pencarian Data

![alt text](image-19.png)

##### Class pada kode program

```java
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
```

```java
package minggu12.tugasno2;

class DoubleLinkedList {
 
    private Film head, tail;

    public void tambahAwal(int id, String judul, double rating) {
        Film newFilm = new Film(id, judul, rating);
        if (head == null) {
            head = tail = newFilm;
        } else {
            newFilm.next = head;
            head.prev = newFilm;
            head = newFilm;
        }
    }

    public void tambahAkhir(int id, String judul, double rating) {
        Film newFilm = new Film(id, judul, rating);
        if (tail == null) {
            head = tail = newFilm;
        } else {
            tail.next = newFilm;
            newFilm.prev = tail;
            tail = newFilm;
        }
    }

    public void tambahPadaIndex(int index, int id, String judul, double rating) {
        if (index <= 0) {
            tambahAwal(id, judul, rating);
            return;
        }
        
        Film newFilm = new Film(id, judul, rating);
        Film current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                break;
            }
            current = current.next;
        }

        if (current == null || current.next == null) {
            tambahAkhir(id, judul, rating);
        } else {
            newFilm.next = current.next;
            newFilm.prev = current;
            current.next.prev = newFilm;
            current.next = newFilm;
        }
    }

    public void hapusPertama() {
        if (head != null) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public void hapusTerakhir() {
        if (tail != null) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public void hapusPadaIndex(int index) {
        if (index <= 0) {
            hapusPertama();
            return;
        }

        Film current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return;
            }
            current = current.next;
        }

        if (current == null || current.prev == null) {
            hapusTerakhir();
        } else {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }

    public void cetak() {
        Film current = head;
        while (current != null) {
            System.out.println("ID: " + current.id + ", Judul: " + current.judul + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public Film cariID(int id) {
        Film current = head;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void urutRatingDesc() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            Film current = head;
            while (current.next != null) {
                if (current.rating < current.next.rating) {
                    double tempRating = current.rating;
                    current.rating = current.next.rating;
                    current.next.rating = tempRating;

                    int tempId = current.id;
                    current.id = current.next.id;
                    current.next.id = tempId;

                    String tempJudul = current.judul;
                    current.judul = current.next.judul;
                    current.next.judul = tempJudul;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
```

##### Main pada kode program

```java
package minggu12.tugasno2;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList dll = new DoubleLinkedList();
        int choice, id, index;
        String judul;
        double rating;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film-DESC");
            System.out.println("10. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahAwal(id, judul, rating);
                    break;
                case 2:
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahAkhir(id, judul, rating);
                    break;
                case 3:
                    System.out.print("Masukkan Index: ");
                    index = scanner.nextInt();
                    System.out.print("Masukkan ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // flush scanner
                    System.out.print("Masukkan Judul: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan Rating: ");
                    rating = scanner.nextDouble();
                    dll.tambahPadaIndex(index, id, judul, rating);
                    break;
                case 4:
                    dll.hapusPertama();
                    break;
                case 5:
                    dll.hapusTerakhir();
                    break;
                case 6:
                    System.out.print("Masukkan Index untuk dihapus: ");
                    index = scanner.nextInt();
                    dll.hapusPadaIndex(index);
                    break;
                case 7:
                    dll.cetak();
                    break;
                case 8:
                    System.out.print("Masukkan ID Film yang dicari: ");
                    id = scanner.nextInt();
                    Film foundFilm = dll.cariID(id);
                    if (foundFilm != null) {
                        System.out.println("Film ditemukan: ID: " + foundFilm.id + ", Judul: " + foundFilm.judul + ", Rating: " + foundFilm.rating);
                    } else {
                        System.out.println("Film dengan ID tersebut tidak ditemukan.");
                    }
                    break;
                case 9:
                    dll.urutRatingDesc();
                    break;
                case 10:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 10);
        scanner.close();
    }
}
```

##### Output pada kode program