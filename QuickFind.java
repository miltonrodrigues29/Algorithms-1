import java.util.Scanner;

public class QuickFind {

    private int id[];

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {

        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;


        }
    }

    public boolean Connected(int p, int q) {

        if (id[p] == id[q]) {
            return true;
        }
        else {
            return false;
        }


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        QuickFind QF = new QuickFind(10);
        for (int i = 0; i <= 2; i++) {
            System.out.println("Enter p");
            int p = sc.nextInt();
            System.out.println("Enter q");
            int q = sc.nextInt();
            QF.union(p, q);
        }

        System.out.println("Lets start connect op");
        for (int i = 0; i <= 2; i++) {
            System.out.println("Enter p");
            int p = sc.nextInt();
            System.out.println("Enter q");
            int q = sc.nextInt();

            System.out.println("Connected:" + QF.Connected(p, q));

        }


    }
}
