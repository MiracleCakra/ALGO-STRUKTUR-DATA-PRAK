package minggu14.tugaslat;

public class BinaryTreeMain07 {
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
        System.out.print("PreOrder Travesal     : ");
        bt.traversePreOrder(bt.root);
        System.out.println("");
        System.out.print("InOrder Travesal      : ");
        bt.traverseInOrder(bt.root);
        System.out.println("");
        System.out.print("PostOrder Travesal    : ");
        bt.traversePostOrder(bt.root);
        System.out.println("");
        System.out.println("Find Node : " + bt.find(5));
        System.out.println("Delete Node 8 ");
        bt.delete(8);
        System.out.println("");
        System.out.print("PreOrder Travesal           : ");
        bt.traversePreOrder(bt.root);
        System.out.println("");

        // implementasi method baru
        System.out.println("Nilai terkecil dalam tree   : " + bt.findMin());
        System.out.println("Nilai terbesar dalam tree   : " + bt.findMax());
        System.out.println("Leaf Node: ");
        bt.tampilLeaf(bt.root);
        System.out.println(" ");

        int hitungLeafNode = bt.tampilJumlahLeaf(bt.root);
        System.out.println("Total dari Leaf Node: " + hitungLeafNode);
    }
}
