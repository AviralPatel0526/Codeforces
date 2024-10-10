import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * C_1_Adjust_The_Presentation_Easy_Version
 */
public class C_1_Adjust_The_Presentation_Easy_Version {

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
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            int[] a = ai(n);
            int[] b = ai(m);
            
            // Using HashSet to track unique elements from `b`
            HashSet<Integer> set = new HashSet<>();
            List<Integer> arr = new ArrayList<>();
            
            // Add unique elements from `b` to `arr`
            for (int i = 0; i < m; i++) {
                if (!set.contains(b[i])) {
                    set.add(b[i]);
                    arr.add(b[i]);
                }
            }
            
            // Compare the arrays directly using ArrayList and the original `a` array
            boolean flag = true;
            for (int i = 0; i < arr.size(); i++) {
                if (a[i] != arr.get(i)) {
                    flag = false;
                    break;
                }
            }
            
            // Output the result
            if (flag) {
                System.out.println("YA");
            } else {
                System.out.println("TIDAK");
            }
        }
    }
    
    
}