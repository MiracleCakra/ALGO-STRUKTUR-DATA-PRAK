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
