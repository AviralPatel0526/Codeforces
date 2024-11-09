import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Divan_and_a_New_Project {

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
        long y;
        Pair(int x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
        
        while (t != 0) {
            t--;
            int n = in.nextInt();
            ArrayList<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair(i, in.nextLong()));
            }
            Collections.sort(list, (p1, p2) -> Long.compare(p2.y, p1.y));
            long diff = 0;
            long ans = 0;
            int pos = (n + 1) / 2;
            long res[] = new long[n + 1];
            int k1 = 1;
            int k2 = 1;
            
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    diff++;
                }
                if (i % 2 == 0) {
                    res[list.get(i).x + 1] = pos - k1;
                    k1++;
                } else {
                    res[list.get(i).x + 1] = pos + k2;
                    k2++;
                }
                ans += diff * list.get(i).y * 2;
            }
    
            res[0] = pos;
            System.out.println(ans);
            for (long i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
}