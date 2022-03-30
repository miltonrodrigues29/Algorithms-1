/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Scanner;

public class QuickUnion {

    private int[] id;

    private QuickUnion(int n) {

        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

    }

    private int root(int i) {

        while (i != id[i]) i = id[i];  //pointing to parent node until there is no parent node
        return i;//return the parent  node

    }

    private void union(int p, int q) {

        int i = root(p);
        int j = root(q);
        id[i] = j;


    }

    private boolean Connected(int p, int q) {
        int i = root(p);
        int j = root(q);
        return (i == j);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuickUnion QU = new QuickUnion(10);
        for (int i = 0; i <= 2; i++) {
            System.out.println("Enter p");
            int p = sc.nextInt();
            System.out.println("Enter q");
            int q = sc.nextInt();
            QU.union(p, q);
        }

        System.out.println("Lets check the connection status");
        for (int i = 0; i <= 2; i++) {
            System.out.println("Enter p");
            int p = sc.nextInt();
            System.out.println("Enter q");
            int q = sc.nextInt();

            System.out.println("Connected:" + QU.Connected(p, q));

        }
    }
}
