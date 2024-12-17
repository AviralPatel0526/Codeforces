import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class C_Stable_Groups {

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
        int n = in.nextInt();
        long k = in.nextLong();
        long x = in.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);

        ArrayList<Long> gp = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] > x) {
                gp.add(a[i] - a[i - 1]);
            }
        }

        if (k == 0) {
            System.out.println(gp.size() + 1);
        } else {
            Collections.sort(gp);
            long tg = gp.size();
            for (int i = 0; i < gp.size(); i++) {
                long gap = gp.get(i);
                long sub = (gap + x - 1) / x - 1; // Avoids floating-point math
                if (k >= sub) {
                    k -= sub;
                    tg--;
                } else {
                    break;
                }
            }
            System.out.println(tg + 1);
     
        }
        
        
        
    }
}