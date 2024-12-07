import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Cardboard_for_Pictures {

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
    static long check(long[] a, long mid, long c) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            long totalSize = a[i] + 2 * mid;
            sum += totalSize * totalSize;
            if (sum > c) return sum;
        }
        return sum;
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long c = in.nextLong();
            long[] a = al(n);
            long l = 1, h = 1000000000, ans = -1;
            while (l <= h) {
                long mid = (l + h) / 2;
                if (check(a, mid, c) == c) {
                    ans = mid;
                    break;
                } else if (check(a, mid, c) > c) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
    
}