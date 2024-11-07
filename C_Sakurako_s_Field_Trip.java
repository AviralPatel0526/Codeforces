import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * C_Sakurako_s_Field_Trip
 */
public class C_Sakurako_s_Field_Trip {

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
            int a[] = ai(n);
            int b[] = new int[n];
            int k = 0;
        
            // Reverse array a into b
            for (int i = n - 1; i >= 0; i--) {
                b[k++] = a[i];
            }
        
            // Process array a to swap elements and form the target state
            for (int i = 1; i < n - 1; i++) {
                if (a[i] == a[i - 1]) {
                    int idx = n - (i + 1);
                    if (a[idx] != a[i - 1] && a[idx] != a[i + 1]) {
                        // Perform the swap
                        int temp = a[idx];
                        a[idx] = a[i];
                        a[i] = temp;
                        break; // Exit after one swap
                    }
                }
            }
            System.out.println(Arrays.toString(a));
        
            // Count adjacent equal pairs in array a
            int cnt = 0;
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    cnt++;
                }
            }
        
            // Count adjacent equal pairs in array b
            int cnt2 = 0;
            for (int i = 1; i < n; i++) {
                if (b[i] == b[i - 1]) {
                    cnt2++;
                }
            }
        
            // Output the minimum count of adjacent pairs
            System.out.println(Math.min(cnt, cnt2));
        }
        
        
    }
}