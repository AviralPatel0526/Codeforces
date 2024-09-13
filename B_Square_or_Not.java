import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_Square_or_Not
 */
public class B_Square_or_Not {

    // GCD Method
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
    // LCM Method
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    
    static FastReader in = new FastReader();
    // input of int array
    static int[] ai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        return arr;
    }
    
    // input of long array
    static long[] al(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextLong();
        return arr;
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            String s = in.next();
            int sqrt = (int) Math.sqrt(n);

            if (sqrt * sqrt == n) { 
                int r = sqrt;
                int c = sqrt;
                char[][] ch = new char[r][c];

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        int idx = (i * c) + j;  // Corrected index calculation
                        ch[i][j] = s.charAt(idx);
                    }
                }

                boolean flag = true;

                // Check the first row for all '1's
                for (int i = 0; i < c; i++) {
                    if (ch[0][i] != '1') {
                        flag = false;
                        break;
                    }
                }

                // Check the last row for all '1's
                for (int i = 0; i < c; i++) {
                    if (ch[r - 1][i] != '1') {
                        flag = false;
                        break;
                    }
                }

                // Check the first and last columns of the interior rows for '1's and the rest for '0's
                for (int i = 1; i < r - 1; i++) {
                    if (ch[i][0] != '1' || ch[i][c - 1] != '1') {
                        flag = false;
                        break;
                    }

                    for (int j = 1; j < c - 1; j++) {
                        if (ch[i][j] != '0') {
                            flag = false;
                            break;
                        }
                    }

                    if (!flag) {
                        break;
                    }
                }

                if (flag) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            } else {
                System.out.println("No");
            }
        }
    }
}