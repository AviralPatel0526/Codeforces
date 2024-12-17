import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Prinzessin_der_Verurteilung {

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
            String s = in.next();
            String temp = "abcdefghijklmnopqrstuvwxyz";
            ArrayList<String> list = new ArrayList<>();
            
            // Generate all single-character strings
            for (int i = 0; i < 26; i++) {
                list.add("" + temp.charAt(i));
            }
            
            // Generate all two-character strings
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (list.size() >= 1000) break;
                    String x = "" + temp.charAt(i) + temp.charAt(j);
                    list.add(x);
                }
            }
            
            // Generate all three-character strings
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    for (int k = 0; k < 26; k++) {
                        if (list.size() >= 1000) break;
                        String x = "" + temp.charAt(i) + temp.charAt(j) + temp.charAt(k);
                        list.add(x);
                    }
                    if (list.size() >= 1000) break;
                }
                if (list.size() >= 1000) break;
            }
            
            // Find the first string not present in 's'
            int pos = 0;
            for (int i = 0; i < list.size(); i++) {
                if (!s.contains(list.get(i))) {
                    pos = i;
                    break;
                }
            }
            System.out.println(list.get(pos));
        }
        
    }
}