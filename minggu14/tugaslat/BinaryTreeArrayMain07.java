package minggu14.tugaslat;

public class BinaryTreeArrayMain07 {

    public static void main(String[] args) {
        BinaryTreeArray07 bta = new BinaryTreeArray07();

        int[] data = { 6, 4, 8, 3, 5, 7, 9, 0, 0, 0 };
        int idxLast = 6;
        bta.populateData(data, idxLast);
        System.out.print("InOrder Travesal      : ");
        bta.traverseInOrder(0);
        System.out.print("\n");

        // implementasi new methods
        System.out.print("PreOrder Traversal    : ");
        bta.traversePreOrder(0);
        System.out.println(" ");
        System.out.print("PostOrder Traversal   : ");
        bta.traversePostOrder(0);
        System.out.println(" ");
    }
}
