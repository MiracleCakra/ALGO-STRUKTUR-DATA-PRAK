package minggu8.program;

import java.util.Scanner;
public class PostFixmain07 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String P, Q;

        System.out.println("Masukkan ekspresi matematika (infix): ");
        Q = sc.nextLine();
        Q = Q.trim();
        Q = Q + ")";

        int total = Q.length();
        PostFix07 post = new PostFix07(total);
        P = post.konversi(Q);
        System.out.println("Postfix: " + P);
    }
}
