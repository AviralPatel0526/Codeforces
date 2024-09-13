import java.util.*;
import java.lang.*;
import java.io.*;

public class B_Index_and_Maximum_Value {

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

    // Manual lower bound (first occurrence >= l)
    private static int findLowerBound(long[] a, long l) {
        int left = 0, right = a.length - 1;
        int result = a.length; // Default to a.length if no such element is found

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= l) {
                result = mid; // Record the potential result and move left to find the first occurrence
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result; // Lower bound index (first occurrence >= l)
    }

    // Manual upper bound (last occurrence <= r)
    private static int findUpperBound(long[] a, long r) {
        int left = 0, right = a.length - 1;
        int result = -1; // Default to -1 if no such element is found

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] <= r) {
                result = mid; // Record the potential result and move right to find the last occurrence
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result; // Upper bound index (last occurrence <= r)
    }

    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            long[] a = new long[n];
            long sum = 0;
            long pre[]=new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
                

            Arrays.sort(a);
            long max=a[n-1];
            for (int i = 0; i < m; i++) {
                char ch =in.next().charAt(0);
                long l =in.nextInt(); 
                long r =in.nextInt();
                if(r >= max && l <= max){
                    if(ch == '+'){
                        max++;
                    }else{
                        max--;
                    }
                }
                System.out.print(max+" ");
            }
            System.out.println();
        }
    }
}
