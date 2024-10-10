import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Triangle_Count_Easy
 */
public class Triangle_Count_Easy {

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
    static class Pair{
        long x;
        long y;
        Pair(long x, long y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            long a[] = al(n);
            Arrays.sort(a);
            ArrayList<Pair> list = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                long p = a[i];
                long q = a[i + 1];
                list.add(new Pair(q - p + 1, q + p - 1));
            }
            Collections.sort(list, (p1, p2) -> Long.compare(p1.x, p2.x));
            long ans = 0;
            long st = list.get(0).x;
            long en = list.get(0).y;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).x <= en) {
                    en = Math.max(en, list.get(i).y);
                } else {
                    ans += en - st + 1;
                    st = list.get(i).x;
                    en = list.get(i).y;
                }
            }
            ans += en - st + 1;  // Add this to account for the last range
            System.out.println(ans);
        }
    }
    
}