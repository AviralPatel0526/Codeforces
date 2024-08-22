import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * C_Classy_Numbers
 */
public class C_Classy_Numbers {

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
    static ArrayList<Long> res = new ArrayList<>();

    static void f(int pos, int cnt, long curr) {
        if (pos == 18) {
            res.add(curr);
            return;
        }
        f(pos + 1, cnt, curr * 10);
        if (cnt < 3) {
            for (int i = 1; i <= 9; i++) {
                f(pos + 1, cnt + 1, curr * 10 + i);
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        f(0, 0, 0);
        res.add(1000000000000000000L);
        Collections.sort(res);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long l = in.nextLong();
            long r = in.nextLong();
            int count = upperBound(res, r) - lowerBound(res, l);
            System.out.println(count);
        }
    }

    // Method to find the lower bound index
    static int lowerBound(ArrayList<Long> arr, long key) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Method to find the upper bound index
    static int upperBound(ArrayList<Long> arr, long key) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}