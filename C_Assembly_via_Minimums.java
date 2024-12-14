import java.util.*;
import java.lang.*;
import java.io.*;

public class C_Assembly_via_Minimums {

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
            int s = (n * (n - 1)) / 2;
            long[] a = al(s);
            Map<Long, Integer> map = new TreeMap<>();
            for (int i = 0; i < s; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
            long[] ans = new long[n];
            int k = n - 1;
            for (long key : map.keySet()) {
                int fre = map.get(key);
                while (fre > 0) {
                    ans[k] = key;
                    fre -= k;
                    k--;
                }
            }
            long max=Long.MIN_VALUE;
            for(int i=0;i<s;i++){
                max=Math.max(max,a[i]);
            }
            ans[0]=max;
            for (long i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
