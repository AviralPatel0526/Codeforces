import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Insane_Problem {

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
    
        while (t-- > 0) {
            long k = in.nextLong();
            long l1 = in.nextLong();
            long r1 = in.nextLong();
            long l2 = in.nextLong();
            long r2 = in.nextLong();

            long ans = 0;

            for (int i = 0; i <= 32; i++) { 
                long power = (long) Math.pow(k, i);
                if (power > r2) break; 

                long low = l1, high = r1, sm = -1;
                while (low <= high) {
                    long mid = (low + high) / 2;
                    if (mid * power >= l2 && mid * power <= r2) {
                        sm = mid; 
                        high = mid - 1; 
                    } else if (mid * power < l2) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                long l = l1, h = r1, z = -1;
                while (l <= h) {
                    long mid = (l + h) / 2;
                    if (mid * power <= r2) {
                        z = mid; 
                        l = mid + 1; 
                    } else {
                        h = mid - 1;
                    }
                }

                if (sm != -1 && z != -1 && z >= sm) {
                    ans += (z - sm + 1);
                }
            }

            System.out.println(ans);
        }
        
    }
}