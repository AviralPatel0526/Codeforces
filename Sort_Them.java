import java.util.*;
import java.lang.*;
import java.io.*;
public class Sort_Them {

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
    public static int[][] dp;

    public static int solve(String s, int[] pos, int idx, char pre, String p) {
        if (idx == s.length()) {
            return 0;
        }

        // DP state already computed
        if (dp[idx][pre - 'a'] != -1) {
            return dp[idx][pre - 'a'];
        }

        int ans = (int) 1e9;

        // If we don't replace the current character
        if (s.charAt(idx) >= pre) {
            ans = solve(s, pos, idx + 1, s.charAt(idx), p);
        }

        // If we replace the current character
        char replacement = p.charAt(25 - pos[s.charAt(idx) - 'a']);
        if (replacement >= pre) {
            ans = Math.min(ans, 1 + solve(s, pos, idx + 1, replacement, p));
        }

        // Memoize result
        return dp[idx][pre - 'a'] = ans;
    }

    public static void main(String[] args) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            String p = in.next();

            int[] pos = new int[26];
            for (int i = 0; i < 26; i++) {
                pos[p.charAt(i) - 'a'] = i;
            }

            dp = new int[n][26];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            int ans = solve(s, pos, 0, 'a', p);
            if (ans >= (int) 1e9) ans = -1;
            System.out.println(ans);
        }

    }
    
}