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
