import java.util.*;
import java.lang.*;
import java.io.*;
public class G_1_Subsequence_Addition_Easy_Version {

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
    static int[][] dp;

    static int f(int i, int idx, int sum, int[] a) {
        if (sum > a[idx]) return 0; // Early termination
        if (i == idx) {
            return sum == a[idx] ? 1 : 0;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
    
        int pick = 0;
        if (sum + a[i] <= a[idx]) {
            pick = f(i + 1, idx, sum + a[i], a);
            if (pick == 1) return dp[i][sum] = 1;
        }
    
        int skip = f(i + 1, idx, sum, a);
        if (skip == 1) return dp[i][sum] = 1;
    
        return dp[i][sum] = 0;
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = ai(n);
            Arrays.sort(a);
    
            if (a[0] != 1) {
                System.out.println("NO");
                continue;
            }
    
            int maxTarget = a[n - 1];
            dp = new int[n][maxTarget + 1];
    
            boolean flag = true;
            for (int i = 1; i < n; i++) {
               
    
                if (f(0, i, 0, a) != 1) {
                    flag = false;
                    break;
                }
            }
    
            System.out.println(flag ? "YES" : "NO");
        }
    }
    
}
