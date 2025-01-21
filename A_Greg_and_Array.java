import java.util.*;
import java.lang.*;
import java.io.*;
public class A_Greg_and_Array {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        long a[] = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextLong();
        }
        long b[][] = new long[m + 1][3];
        for (int i = 1; i <= m; i++) {
            b[i][0] = in.nextLong();
            b[i][1] = in.nextLong();
            b[i][2] = in.nextLong();
        }
        long linesweep1[] = new long[m + 2];
        for (int i = 0; i < k; i++) {
            linesweep1[in.nextInt()]++;
            linesweep1[in.nextInt() + 1]--;
        }
        for (int i = 1; i < linesweep1.length; i++) {
            linesweep1[i] += linesweep1[i - 1];
        }
        long finalsweep[] = new long[n + 2];
        for (int i = 1; i <= m; i++) {
            finalsweep[(int) b[i][0]] += b[i][2] * linesweep1[i];
            if (b[i][1] + 1 <= n) {
                finalsweep[(int) (b[i][1] + 1)] -= b[i][2] * linesweep1[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            finalsweep[i] += finalsweep[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            finalsweep[i] += a[i];
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(finalsweep[i] + " ");
        }
        System.out.println();
    
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}