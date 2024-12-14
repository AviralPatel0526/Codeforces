import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class B_Playing_in_a_Casino {

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
            long a[][] = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = in.nextLong();
                }
            }
            ArrayList<ArrayList<Long>> list = new ArrayList<>();
            long pre[] = new long[m];
            for (int i = 0; i < m; i++) {
                ArrayList<Long> temp = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    temp.add(a[j][i]);
                }
                Collections.sort(temp);
                list.add(new ArrayList<>(temp));    
            }
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Long> temp = list.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    pre[i] += temp.get(j); 
                }
            }
            long ans = 0;
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Long> temp = list.get(i);
                long sum = pre[i];
                for (int j = 0; j < temp.size(); j++) {
                    ans += sum - temp.get(j) * (temp.size() - j);
                    sum -= temp.get(j); 
                }
            }
            System.out.println(ans);
        }
        
    }        
}