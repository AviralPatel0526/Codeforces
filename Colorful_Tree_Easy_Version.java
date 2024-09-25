import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Colorful_Tree_Easy_Version
 */
public class Colorful_Tree_Easy_Version {

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
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            
            for (int i = 0; i < n-1; i++) {
                int src = in.nextInt();
                int des = in.nextInt();
                
                map.computeIfAbsent(src, k -> new ArrayList<>()).add(des);
                map.computeIfAbsent(des, k -> new ArrayList<>()).add(src);
            }
            
            int ans = 0;
            for (Integer key : map.keySet()) {
                if (map.get(key).size() >= 2) {
                    ans += 2;
                } else {
                    ans += 3;
                }
            }
            System.out.println(ans);
        }
    }
    
}