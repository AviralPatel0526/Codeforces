import java.util.*;
import java.lang.*;
import java.io.*;
public class D_Find_the_Different_Ones {

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
            int[] a = ai(n);
            int q = in.nextInt();
            int[] prev = new int[n];
            prev[0] = -1;
        
            // Build the prev array
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    prev[i] = prev[i - 1];
                } else {
                    prev[i] = i - 1;
                }
            }
        
            // Process queries
            for (int i = 0; i < q; i++) {
                int l = in.nextInt() - 1;
                int h = in.nextInt() - 1;
        
                if (prev[l] == prev[h]) {
                    System.out.println("-1 -1");
                } else {
                    int low = l;
                    int high = h;
                    int ans = h;
        
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (prev[mid] > prev[l]) {
                            ans = mid;
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    System.out.println((l + 1) + " " + (ans + 1));
                }
            }
            System.out.println();
        }
        
    }
}