import java.util.*;
import java.lang.*;
import java.io.*;
public class B_250_Thousand_Tons_of_TNT {

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
            long a[] = al(n); // Assuming this is your array input method
            long pre[] = new long[n];
            pre[0] = a[0];
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + a[i];
            }
            long gmax = Long.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    long max = Long.MIN_VALUE;
                    long min = Long.MAX_VALUE; // Corrected to Long.MAX_VALUE for proper min calculation
                    for (int j = i - 1; j < n; j += i) {
                        if (j == i - 1) {
                            max = Math.max(max, pre[j]);
                            min = Math.min(min, pre[j]);
                        } else {
                            max = Math.max(max, pre[j] - pre[j - i]);
                            min = Math.min(min, pre[j] - pre[j - i]);
                        }
                    }
                    gmax = Math.max(gmax, max - min);
                }
            }
            System.out.println(gmax);
        }
        
    }
}