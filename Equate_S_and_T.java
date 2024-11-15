import java.util.*;
import java.lang.*;
import java.io.*;
public class Equate_S_and_T {

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
            int m = in.nextInt();
            String s = in.next();
            String s1 = in.next();
            
            if (s.equals(s1)) {
                System.out.println("YES");
                continue;
            }
            
            int cntb = 0;
            int cnta=0;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(ch == 'a'){
                    break;
                }
                cntb++;
            }
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(ch == 'a'){
                    cnta++;
                }
            }
            for (int i = 0; i < m; i++) {
                char ch = s1.charAt(i);
                if(ch == 'a'){
                    break;
                }
                cntb--;
            }
            for (int i = 0; i < m; i++) {
                char ch = s1.charAt(i);
                if(ch == 'a'){
                    cnta--;
                }
            }
            if(cnta == 0 && cntb == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    
}