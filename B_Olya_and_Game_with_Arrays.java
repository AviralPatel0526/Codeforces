import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_Olya_and_Game_with_Arrays
 */
public class B_Olya_and_Game_with_Arrays {

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
        long a;
        long b;

        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            ArrayList<Pair> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                long[] a = new long[m];
                long min1 = Long.MAX_VALUE;
                int pos = -1;

                for (int j = 0; j < m; j++) {
                    a[j] = in.nextLong();
                    if (a[j] < min1) {
                        min1 = a[j];
                        pos = j;
                    }
                }

                long min2 = Long.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    if (a[j] < min2 && j != pos) {
                        min2 = a[j];
                    }
                }

                list.add(new Pair(min1, min2));
                // System.out.println(list.get(i).a+ "------" + list.get(i).b);
            }

            Collections.sort(list, (p1, p2) -> Long.compare(p2.b, p1.b));

            long sum = 0;
            long min = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                Pair curr = list.get(i);
                min = Math.min(curr.a, min);
                if (i == n - 1) {
                    sum += min;
                } else {
                    sum += curr.b;
                }
            }

            System.out.println(sum);
        }
    }
}