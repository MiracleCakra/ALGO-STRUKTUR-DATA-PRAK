package KUIS2;


import java.util.Scanner;

public class SingleLinkedList {
    Node head, tail;

    boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }
    }
    void print(){
        if (!isEmpty()) {
            Node tmp = head;
            System.out.println("Standings: ");
            System.out.println("====================");
            System.out.printf("| %-4s | %-32s | %-7s | %-7s | %-7s | %-7s |\n", "Rank", "Tim", "Game", "Menang", "Kalah", "Poin");
            int i = 1;
            while(tmp != null){
                System.out.printf("| %-4s | %-32s | %-7s | %-7s | %-7s | %-7s |\n", i, tmp.data.namaCLub, tmp.data.jmlMatch, tmp.data.jmlMenang, tmp.data.jmlKalah, tmp.data.point);
                tmp = tmp.next;
                i++;
            }
            System.out.println("");
        }else{
            System.out.println("Linked List Kosong");
        }
    }
    
    void addLast (Club input){
        Node ndInput = new Node(input, null);
        if (!isEmpty()) {
            tail.next = ndInput;
            tail = ndInput;
        }else{
            head = ndInput;
            tail = ndInput;
        }
        sort();
    }
    void removeFirst(){
        if (isEmpty()) {
            System.out.println("Linked list masing kosong, tidak dapat dihapus");
        }else if (head == tail) {
            head = tail = null;
            
        }else{
            head = head.next;
        }
    }
    void removeLast(){
        if (isEmpty()) {
            System.out.println("Linked list masih kosong, tidak dapat dihapus");

        }else{
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp.next;
        }
    }
    void remove (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan rank club yang ingin di hapus: ");
        int rank = sc.nextInt();
        if (isEmpty()) {
            System.out.println("Linked list masih kosong, tidak dapat dihapus");

        }else{
            Node temp = head;
            int i=1;
            while (temp !=null) {
                if (rank==1 && temp == head) {
                    System.out.println("Club " + temp.data.namaCLub + " telah di hapus");
                    removeFirst();
                    break;
                }else if (i+1==rank) {
                    System.out.println("Club " + temp.next.data.namaCLub + " telah di hapus");
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
                i++;
            }
        }
    }
    public void search(String namaClub){
        Node temp = head;
        int i = 1;
        while(temp != null){
            if (temp.data.namaCLub.equalsIgnoreCase(namaClub)) {
                System.out.printf("| %-4s | %-32s | %-7s | %-7s | %-7s | %-7s |\n", "Rank", "Tim", "Game", "Menang", "Kalah", "Poin");
                System.out.printf("| %-4s | %-32s | %-7s | %-7s | %-7s | %-7s |\n", i, temp.data.namaCLub, temp.data.jmlMatch, temp.data.jmlMenang, temp.data.jmlKalah, temp.data.point);
                break;
            }
            temp = temp.next;
            i++;
        }
    }
    public void sort(){
        Node temp = head;
        while (temp != null) {
            Node temp2 = temp.next;
            while (temp2 != null) {
                if (temp.data.point < temp2.data.point) {
                    Club temp3 = temp.data;
                    temp.data = temp2.data;
                    temp2.data = temp3;
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
    }
    public void edit(){
        System.out.println("Masukkan rank club yang ingin di edit datanya: ");
        Scanner sc = new Scanner(System.in);
        int rank = sc.nextInt();
        
        Node temp = head;
        int i=1;
        while (temp !=null) {
            if (rank==1 && temp == head) {
                System.out.print("Masukkan data jumlah game: ");
                temp.data.jmlMatch = sc.nextInt();
                System.out.print("Masukkan data jumlah menang: ");
                temp.data.jmlMenang = sc.nextInt();
                System.out.print("Masukkan data jumlah kalah: ");
                temp.data.jmlKalah = sc.nextInt();
                System.out.print("Masukkan data akumulasi poin: ");
                temp.data.point = sc.nextInt();
                break;
            }else if (i+1==rank) {
                System.out.print("Masukkan data jumlah game: ");
                temp.data.jmlMatch = sc.nextInt();
                System.out.print("Masukkan data jumlah menang: ");
                temp.data.jmlMenang = sc.nextInt();
                System.out.print("Masukkan data jumlah kalah: ");
                temp.data.jmlKalah = sc.nextInt();
                System.out.print("Masukkan data akumulasi poin: ");
                temp.data.point = sc.nextInt();
                break;
            }
            temp = temp.next;
            i++;
            
        }
        sort();
        
    }
    
    
}
