import java.util.Scanner;

public class DPknapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of Objects: ");
        int n = sc.nextInt();
        
        int[] p = new int[n];
        int[] w = new int[n];
        System.out.println("Enter profits of the objects:");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println("Enter weights of the objects:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        System.out.print("Enter Knapsack capacity: ");
        int m = sc.nextInt();
        knapsack(m, w, p, n);
        sc.close();
    }
    public static void knapsack(int m, int[] w, int[] p, int n) {
        int[][] k = new int[n + 1][m + 1];

        // Filling DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    k[i][j] = Math.max(k[i - 1][j], k[i - 1][j - w[i - 1]] + p[i - 1]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }
        System.out.println("Selected items:");
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (k[i][j] == k[i - 1][j]) {
                System.out.println("Item " + i + " -> Not Included");
                i--;
            } else {
                System.out.println("Item " + i + " -> Included");
                j -= w[i - 1];
                i--;
            }
        }
        System.out.println("Maximum Profit: " + k[n][m]);
    }
}

