import java.util.*;
import java.lang.*;
import java.io.*;
public class Reverse_and_Alternate {

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
    static boolean check(int start, int end, char[] copy) {
        for (int i = start + 1; i <= end; i++) {
            if (copy[i] == copy[i - 1]) {
                end = i-1;
                break;
            }
        }
        while (start < end) {
            char temp = copy[start];
            copy[start] = copy[end];
            copy[end] = temp;
            start++;
            end--;
        }
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == copy[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            char[] ch = s.toCharArray();
            boolean flag = true;

            for (int i = 1; i < n; i++) {
                if (ch[i] == ch[i - 1]) {
                    char[] copy1 = s.toCharArray();
                    char[] copy2 = s.toCharArray();

                    if (check(0, i - 1, copy1) || check(i, n - 1, copy2)) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                    break;
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }
}