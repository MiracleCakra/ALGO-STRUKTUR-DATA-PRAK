package minggu15.prak1;

public class Node07 {
    int data;
    Node07 prev, next;
    int jarak;

    Node07 (Node07 prev, int data,int jarak, Node07 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
        this.jarak = jarak;
    }
}

