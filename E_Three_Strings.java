import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Three_Strings {

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
    static int f(int i, int j, String a, String b, String c, int[][] dp) {
        if (i + j == c.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int match = Integer.MAX_VALUE;
        int notMatch = Integer.MAX_VALUE;
    
        if (i < a.length() && a.charAt(i) == c.charAt(i + j)) {
            match = f(i + 1, j, a, b, c, dp);
        } else if (i < a.length()) {
            notMatch = 1 + f(i + 1, j, a, b, c, dp);
        }
    
        if (j < b.length() && b.charAt(j) == c.charAt(i + j)) {
            match = Math.min(match, f(i, j + 1, a, b, c, dp));
        } else if (j < b.length()) {
            notMatch = Math.min(notMatch, 1 + f(i, j + 1, a, b, c, dp));
        }
    
        return dp[i][j] = Math.min(match, notMatch);
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
        while (t != 0) {
            t--;
            String a = in.next();
            String b = in.next();
            String c = in.next();
            int[][] dp = new int[a.length() + 1][b.length() + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            System.out.println(f(0, 0, a, b, c, dp));
        }
    }
    
}