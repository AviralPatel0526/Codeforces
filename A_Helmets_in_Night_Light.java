import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Helmets_in_Night_Light
 */
public class A_Helmets_in_Night_Light {

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
        Pair(long x,long y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            long p = in.nextLong();
            long a[] = al(n);
            long b[] = al(n);
            ArrayList<Pair> list = new ArrayList<>();
            list.add(new Pair(-1, p));
            for (int i = 0; i < n; i++) {
                list.add(new Pair(a[i], b[i]));
            }
            long cnt = 1;
            long sum = p;
            Collections.sort(list, (p1, p2) -> p1.y == p2.y ? Long.compare(p1.x, p2.x) : Long.compare(p1.y, p2.y));
            for (int i = 0; i < list.size(); i++) {
                Pair curr = list.get(i);
                if (curr.x == -1) {
                    sum += (n - cnt) * curr.y;
                    break;
                } else {
                    if (cnt + curr.x >= n) {
                        sum += (n - cnt) * curr.y;
                        break;
                    } else {
                        sum += curr.x * curr.y;
                        cnt += curr.x;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}