/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Scanner;

public class QuickUnionImproved {

    private int[] id;
    private int[] sz;

    private QuickUnionImproved(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i]
                    = id[id[i]];   //chaning the parent of i to point to the grand parent, thereby halving the path in reaching the ultimate final root node for the next iteration
            i = id[i];
        }
        return i;
    }

    private boolean connected(int p, int q) {
        int i = root(p);
        int j = root(q);
        return (i == j);

    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] = sz[j] + sz[i];
        }
        else {
            id[j] = i;
            sz[i] = sz[i] + sz[j];
        }

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuickUnionImproved QU = new QuickUnionImproved(10);
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

            System.out.println("Connected:" + QU.connected(p, q));

        }

    }
}
