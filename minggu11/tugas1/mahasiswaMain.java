package minggu11.tugas1;

public class mahasiswaMain {
    public static void main(String[] args) {
        SingleLinkList sll = new SingleLinkList();

        sll.addFirst(111, "Anton");
        sll.addLast(112, "Prita");
        sll.addLast(113, "Yusuf");
        sll.addLast(114, "Doni");
        sll.addLast(115, "Sari");
        sll.print();
    }
}
