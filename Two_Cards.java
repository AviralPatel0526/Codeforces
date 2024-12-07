import java.util.*;
import java.lang.*;
import java.io.*;
public class Two_Cards {

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
    static class Pair {
        int x;
        int y;
    
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
        while (t != 0) {
            t--;
            int n = in.nextInt();
            int a[] = ai(n);
            int b[] = ai(n);
            ArrayList<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair(a[i], b[i]));
            }
            
            Collections.sort(list, (p1, p2) -> Integer.compare(p2.x, p1.x)); // Sort descending by `x`
    
            if (Math.max(list.get(0).x, list.get(0).y) > Math.max(list.get(1).x, list.get(1).y)) {
                System.out.println("Yes");
                continue;
            }
    
            int bob = Math.max(list.get(0).x, list.get(0).y);
            boolean found = false;
    
            for (int i = 1; i < n; i++) {
                if (Math.max(list.get(i).x, list.get(i).y) > bob) {
                    System.out.println("Yes");
                    found = true;
                    break;
                }
            }
    
            if (!found) {
                System.out.println("No");
            }
        }
    }
    
}