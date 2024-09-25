import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Maximize_Hamming_Distance
 */
public class Maximize_Hamming_Distance {

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
            int m = in.nextInt();
            char a[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s=in.next();
                for(int j=0;j<s.length();j++){
                    a[i][j]=s.charAt(j);
                }
            }
            
            int ans = 0;
            for (int i = 0; i < m; i++) {
                int cnt0 = 0;
                int cnt1 = 0;
                int cntq = 0;
                for (int j = 0; j < n; j++) {
                    if (a[j][i] == '0') {
                        cnt0++;
                    }
                    if (a[j][i] == '1') {
                        cnt1++;
                    }
                    if (a[j][i] == '?') {
                        cntq++;
                    }
                }
                ans += Math.min(cnt0, cnt1) * (Math.max(cnt0, cnt1) + cntq);
            }
            System.out.println(ans);
        }
        
    }
}