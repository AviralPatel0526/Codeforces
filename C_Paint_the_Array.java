import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Paint_the_Array {

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
            long a[] = al(n);
        
            long mino = 0;
            long mine = 0;
        
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    mine = gcd(mine,a[i]);
                } else {
                    mino = gcd(mino, a[i]);
                }
            }
        
            boolean flage = true;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    if (a[i] % mine != 0) {
                        flage = false;
                        break;
                    }
                } else {
                    if (a[i] % mine == 0) {
                        flage = false;
                        break;
                    }
                }
            }
        
            boolean flago = true;
            for (int i = 0; i < n; i++) {
                if (i % 2 != 0) {
                    if (a[i] % mino != 0) {
                        flago = false;
                        break;
                    }
                } else {
                    if (a[i] % mino == 0) {
                        flago = false;
                        break;
                    }
                }
            }
        
            if (flage) {
                System.out.println(mine);
            } else if (flago) {
                System.out.println(mino);
            } else {
                System.out.println(0);
            }
        }
        
    }
}