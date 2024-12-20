import java.util.*;
import java.lang.*;
import java.io.*;
public class B_M_arrays {

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
            long m = in.nextLong();
            long[] a = al(n); // Assuming 'al' initializes an array of size 'n'
            HashMap<Long, Integer> map = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                a[i] = a[i] % m;
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(a[i])) {
                    map.put(a[i], map.get(a[i]) - 1);
                    if (map.get(a[i]) == 0) {
                        map.remove(a[i]);
                    }
                    long front = (m - a[i]) % m;
                    long back = (m - a[i]) % m;
                    while (map.containsKey(front)) {
                        map.put(front, map.get(front) - 1);
                        if (map.get(front) == 0) {
                            map.remove(front);
                        }
                        front = (m - front) % m; 
                    }
                    while (map.containsKey(back)) {
                        map.put(back, map.get(back) - 1);
                        if (map.get(back) == 0) {
                            map.remove(back);
                        }
                        back = (m - back) % m; 
                    }
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        
    }
}