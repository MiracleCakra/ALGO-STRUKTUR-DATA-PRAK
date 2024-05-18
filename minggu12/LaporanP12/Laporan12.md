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