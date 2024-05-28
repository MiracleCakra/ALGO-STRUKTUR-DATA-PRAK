# JOBSHEET XIV TREE

Nama    : Cakra Wangsa M.A.W

Kelas   : TI_1H

Absen   : 07

NIM     : 2341720032

### 13.1 Tujuan Praktikum

Setelah melakukan praktikum ini, mahasiswa mampu:

1. memahami model Tree khususnya Binary Tree.
2. membuat dan mendeklarasikan struktur algoritma Binary Tree.
3. menerapkan dan mengimplementasikan algoritma Binary Tree dalam kasus Binary Search Tree.

### 13.2 Kegiatan Praktikum 1

### Implementasi Binary Search Tree menggunakan Linked List (45 Menit)

#### 13.2.1 Percobaan 1

##### Class pada kode program

```java
package minggu14.prak1;

public class Node07 {
    int data;
    Node07 left;
    Node07 right;

    public Node07(){

    }

    public Node07(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
```

```java
package minggu14.prak1;

public class BinaryTree07 {
    Node07 root;

    public BinaryTree07(){
        root = null;
    }


    boolean isEmpty() {
        return root == null;
    }

    void add(int data) {
        if (isEmpty()) {
            root = new Node07(data);
        } else {
            Node07 current = root;
            while (true) {
                if (data < current.data) {
                    if (current.left == null) {
                        current.left = new Node07(data);
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (data > current.data) {
                    if (current.right == null) {
                        current.right = new Node07(data);
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    // Data already exists
                    break;
                }
            }
        }
    }

    boolean find (int data){
        Node07 current = root;
        while (current != null) {
            if (current.data == data) {
                return true;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    void taversePreOrder(Node07 node){
        if (node != null) {
            System.out.print(" " + node.data);
            taversePreOrder(node.left);
            taversePreOrder(node.right);
        }
    }

    void taversePostOrder(Node07 node) {
        if (node != null) {
            taversePostOrder(node.left);
            taversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    void taverseInOrder(Node07 node){
        if (node != null) {
            taverseInOrder(node.left);
            System.out.print(" " + node.data);
            taverseInOrder(node.right);
        }
    }

    Node07 getSuccessor(Node07 del){
        Node07 successor = del.right;
        Node07 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete (int data){
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        //find node (current) that will be deleted
        Node07 parent = root;
        Node07 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.data == data) {
                break;
            } else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (data > current.data) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        //deletion
        if (current == null) {
            System.out.println("Couldn't find data!");
            return;
        } else {
            //if there is no child, simply delete it
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {//if there is 1 child (right)
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }                
            } else if (current.right == null) {//if there is 1 child (left)
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {//if rhere is 2 childs
                Node07 successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }
}
```

##### Main pada kode program

```java
package minggu14.prak1;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree07 bt = new BinaryTree07();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(10);
        bt.add(15);
        System.out.print("PreOrder Traversal : ");
        bt.taversePreOrder(bt.root);
        System.out.println("");
        System.out.print("inOrder Traversal : ");
        bt.taverseInOrder(bt.root);
        System.out.println("");
        System.out.print("PostOrder Traversal : ");
        bt.taversePostOrder(bt.root);
        System.out.println("");
        System.out.println("Find Node : " + bt.find(5));
        System.out.println("Delete Node 8");
        bt.delete(8);
        System.out.println("");
        System.out.print("PreOrder Traversal : ");
        bt.taversePreOrder(bt.root);
        System.out.println("");
    }
}
```

### 13.2.2 Pertanyaan Percobaan

1. Mengapa dalam binary search tree proses pencarian data bisa lebih efektif dilakukan dibanding binary tree biasa?

    Jawab: Dalam binary search tree, proses pencarian data lebih efektif dibandingkan binary tree biasa karena sifat terurut, pembagian ruang pencarian, kompleksitas waktu rata-rata O(log n), dan tidak perlu menelusuri seluruh node. 

2. Untuk apakah di class Node, kegunaan dari atribut left dan right?

    Jawab: pada atribut left dan right yang ada dalam class Node berfungsi untuk menunjuk pada anak kiri dan anak kanan dalam Node tersebut

3. a. Untuk apakah kegunaan dari atribut root di dalam class          BinaryTree?

    Jawab: Atribut root di dalam kelas BinaryTree07 digunakan untuk menyimpan referensi (alamat) ke node akar (root) dari pohon biner. Node akar (root) adalah node paling atas dalam struktur pohon biner, dan semua node lainnya berakar dari node ini.

   b. Ketika objek tree pertama kali dibuat, apakah nilai dari root?

    Jawab: Ketika pada objek tree pertama kali dibuat, nilai pada root bernilai null, yang berarti bahwa pohon tersebut masih kosong dan belum memiliki node apapun.

4. Ketika tree masih kosong, dan akan ditambahkan sebuah node baru, proses apa yang akan terjadi?

    Jawab: Ketika tree masih kosong, dan akan ditambahkan sebuah node baru maka yang terjadi adalah node baru tersebut akan menjadi root dari tree. bisa terjadi dikarenakan pada root adalah null, sehingga pada node baru akan diinisialisasi dan ditetapkan sebagai root.

5. Perhatikan method add(), di dalamnya terdapat baris program seperti di bawah ini. Jelaskan
secara detil untuk apa baris program tersebut?

    ```java
    if(data<current.data){
    if(current.left!=null){
    current = current.left;
    }else{
    current.left = new Node(data);
    break;
        }
    }
    ```

    Jawab: potongan kode program diatas berfungsi untuk menempatkan node baru dengan nilai data pada posisi yang tepat dalam Binary Search Tree, dengan cara membandingkan nilainya dengan nilai node saat ini (current) dan melanjutkan pencarian ke sisi kiri jika data lebih kecil. Ketika ditemukan posisi yang tepat (tidak ada anak di sisi kiri), maka node baru akan dibuat dan dihubungkan sebagai anak di sisi kiri dari node saat ini.
    Proses ini akan diulang secara rekursif pada subtree kiri (jika data lebih kecil dari node saat ini) atau subtree kanan (jika data lebih besar dari node saat ini) sampai ditemukan posisi yang tepat untuk menempatkan node baru, yaitu semua node di sisi kiri lebih kecil dari node induk, dan semua node di sisi kanan lebih besar dari node induk.


### 13.3 Kegiatan Praktikum 2

### Implementasi binary tree dengan array (45 Menit)

### 13.3.1 Tahapan Percobaan

##### Class pada kode program

```java
package minggu14.prak2;

public class BinaryTreeArray07 {
    int[] data;
    int idxLast;

    public BinaryTreeArray07(){
        data = new int[10];
    }

    void populateData(int data[], int idxLast){
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart){
        if (idxStart <= idxLast) {
            traverseInOrder(2*idxStart+1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2*idxStart+2);
        }
    }
}
```

##### Main pada kode program

```java
package minggu14.prak2;

public class BinaryTreeArrayMain07{
    public static void main(String[] args) {
        BinaryTreeArray07 bta = new BinaryTreeArray07();
        int[] data = {6,4,8,3,5,7,9,0,0,0};
        int idxLast = 6;
        bta.populateData(data, idxLast);
        System.out.print("\nInOrder traversal:");
        bta.traverseInOrder(0);
        System.out.println("\n");
    }
}
```

### 13.3.2 Pertanyaan Percobaan

1. Apakah kegunaan dari atribut data dan idxLast yang ada di class BinaryTreeArray?

    Jawab: data adalah array yang menyimpan nilai-nilai node dalam representasi array dari binary tree.
    idxLast adalah indeks terakhir dalam array data yang memiliki nilai (node terakhir dalam binary tree).

    Kombinasi dari data dan idxLast memungkinkan implementasi binary tree menggunakan representasi array dan melakukan operasi seperti traversal atau manipulasi pada binary tree tersebut dengan efisien.

2. Apakah kegunaan dari method populateData()?

    Jawab:  metode populateData() berfungsi untuk menyediakan mekanisme agar nilai-nilai node dalam binary tree yang direpresentasikan dalam bentuk array dapat diinisialisasi atau diisi ke dalam objek BinaryTreeArray07. Metode ini memungkinkan kita untuk memasukkan data dari luar ke dalam objek BinaryTreeArray07 sebelum melakukan operasi lain seperti traversal atau manipulasi pada binary tree tersebut.

3. Apakah kegunaan dari method traverseInOrder()?

    Jawab: metode traverseInOrder() berfungsi untuk melakukan traversal in-order pada binary tree yang direpresentasikan dalam bentuk array dengan cara mengunjungi semua node di subtree kiri secara rekursif, kemudian mencetak nilai node saat ini, dan terakhir mengunjungi semua node di subtree kanan secara rekursif.

4. Jika suatu node binary tree disimpan dalam array indeks 2, maka di indeks berapakah posisi
left child dan right child masing-masing?

    Jawab: Left child pada node yang tersimpan dalam indeks i pada array terletak pada indeks 2*i + 1.
    Right child dari node yang tersimpan dalam indeks i pada array terletak pada indeks 2*i + 2.

    jika node berada pada indeks 2:

    Left child: 2*2 + 1 = 5
    Right child: 2*2 + 2 = 6

5. Apa kegunaan statement int idxLast = 6 pada praktikum 2 percobaan nomor 4?

    Jawab: kegunaan statement int idxLast = 6, berfungsi untuk menentukan indeks terakhir yang berada pada elemen yang valid pada array data. Dan pada Binary Tree diimplementasikan menggunakan array.


### 13.4 Tugas Praktikum

Waktu pengerjaan: 90 menit

1. Buat method di dalam class BinaryTree yang akan menambahkan node dengan cara rekursif.

    Jawab:

2. Buat method di dalam class BinaryTree untuk menampilkan nilai paling kecil dan yang paling besar yang ada di dalam tree.
    
    Jawab:

3. Buat method di dalam class BinaryTree untuk menampilkan data yang ada di leaf.

    Jawab:

4. Buat method di dalam class BinaryTree untuk menampilkan berapa jumlah leaf yang ada di dalam tree.

    Jawab:

5. Modifikasi class BinaryTreeArray, dan tambahkan :
• method add(int data) untuk memasukan data ke dalam tree
• method traversePreOrder() dan traversePostOrder()

    Jawab: