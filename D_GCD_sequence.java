import java.util.*;
import java.io.*;

public class D_GCD_sequence {
    static final int N = 200005;
    static int n;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] c = new int[N];

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static boolean check(int x) {
        int t = 0;

        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            c[++t] = a[i];
        }

        int last = 1;
        for (int i = 1; i < n - 1; i++) {
            int y = gcd(c[i], c[i + 1]);
            if (y < last) return false;
            last = y;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 1; i < n; i++) {
                b[i] = gcd(a[i], a[i + 1]);
            }

            int x = -1;

            for (int i = 1; i < n - 1; i++) {
                if (b[i] > b[i + 1]) {
                    x = i;
                    break;
                }
            }

            if (x == -1) {
                System.out.println("YES");
            } else if (check(x) || check(x + 1) || check(x + 2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
