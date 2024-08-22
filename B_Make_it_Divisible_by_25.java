import java.util.*;

import javax.print.attribute.HashAttributeSet;

import java.lang.*;
import java.io.*;
/**
 * B_Make_it_Divisible_by_25
 */
public class B_Make_it_Divisible_by_25 {

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
            long n = in.nextLong();
            int dig = (int) Math.log10(n) + 1;
            long a[] = new long[dig];
            long copy = n;
            int k = dig - 1;
            while (copy > 0) {
                a[k] = copy % 10;
                copy = copy / 10;
                k--; 
            }
            
            int cnt0 = Integer.MAX_VALUE;
            int cnt5 = Integer.MAX_VALUE;
        
            // Check for "00" or "50"
            for (int i = dig - 1; i >= 0; i--) {
                if (a[i] == 0) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (a[j] == 0 || a[j] == 5) {
                            cnt0 = Math.min(cnt0, dig - j - 2);
                            break;
                        }
                    }
                }
                if (a[i] == 5) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (a[j] == 2 || a[j] == 7) {
                            cnt5 = Math.min(cnt5, dig - j - 2);
                            break;
                        }
                    }
                }
            }
        
            int result = Math.min(cnt0, cnt5);
            System.out.println(result == Integer.MAX_VALUE ? dig : result);
        }
        
    }
}