import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Stack;

public class B_Stone_Age_Problem {

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
        int q = in.nextInt();
        long a[] = al(n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        
        Stack<Long> st = new Stack<>();
        HashMap<Integer, Long> map = new HashMap<>();
        
        for (int i = 0; i < q; i++) {
            int choice = in.nextInt();
            if (choice == 1) {
                int idx = in.nextInt();
                long x = in.nextLong();
                
                if (st.size() != 0 && !map.containsKey(idx-1)) {
                    sum = sum - st.peek() + x;
                } else {
                    sum = sum - a[idx - 1] + x;
                }
                a[idx - 1] = x;
                
                map.put(idx-1, x); 
            } else {
                long x = in.nextLong();
                st.push(x);
                sum = x * n;
                map.clear();
            }
            
            // Print the updated sum after each query
            System.out.println(sum);
        }
    }
    
}