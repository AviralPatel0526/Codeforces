
import java.util.*;

public class Overwrite {
    static int[] ai(int n, Scanner in) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a[] = ai(n, in);
            int b[] = ai(m, in);

            if (m == 1) {
                // Special case when m == 1
                for (int i = 0; i < n; i++) {
                    if (a[i] > b[0]) {
                        a[i] = b[0];
                    }
                }
                for (int i : a) {
                    System.out.print(i + " ");
                }
                System.out.println();
                continue;
            }

            // Find minimum element in b[] and its position
            int min = Integer.MAX_VALUE, posmin = -1;
            for (int i = 0; i < m; i++) {
                if (b[i] < min) {
                    min = b[i];
                    posmin = i;
                }
            }

            // Rotate b[] so that min value is at the start
            int newb[] = new int[m];
            int k = 0;
            for (int i = posmin; i < m; i++) {
                newb[k++] = b[i];
            }
            for (int i = 0; i < posmin; i++) {
                newb[k++] = b[i];
            }

            // Find the first index in a[] that needs replacing
            int pos = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] > newb[0]) {
                    pos = i;
                    break;
                }
            }

            if (pos != -1 && pos + m - 1 < n) {
                // If we can replace a contiguous segment
                int j = pos;
                while (j + m - 1 < n) {
                    a[j++] = newb[0];
                }
                for (int i = 1; i < m; i++) {
                    if (j < n) {
                        a[j++] = newb[i];
                    }
                }
            } else {
                // Edge case handling for replacing last m elements
                int z = 0;
                for (int i = n - m; i < n; i++) {
                    if (a[i] != newb[z]) {
                        if (a[i] > newb[z]) {
                            int y = 0;
                            for (int u = n - m; u < n; u++) {
                                a[u] = newb[y++];
                            }
                        }
                        break;
                    }
                    z++;
                }
            }

            // Print the modified array
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
