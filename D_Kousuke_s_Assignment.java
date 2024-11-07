import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * D_Kousuke_s_Assignment
 */
public class D_Kousuke_s_Assignment {

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
    public static int countMaxNonOverlappingZeroSumSubarrays(int[] a) {
        TreeMap<Long, Integer> prefixSumMap = new TreeMap<>();
        
        long sum = 0; 
        int count = 0; 
        int lastEnd = -1; 
        
        prefixSumMap.put(0L, -1);

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            
            if (prefixSumMap.containsKey(sum)) {
                int prevIndex = prefixSumMap.get(sum);
                if (prevIndex >= lastEnd) {
                    count++; 
                    lastEnd = i; 
                }
            }
            
            prefixSumMap.put(sum, i);
        }
        
        return count;
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            int a[]=ai(n);
            System.out.println(countMaxNonOverlappingZeroSumSubarrays(a));

        }
    }
}