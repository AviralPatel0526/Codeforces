import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Interview {

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
            int a[] = ai(n);
            int pre[]=new int[n];
            pre[0]=a[0];
            for(int i=1;i<n;i++){
                pre[i]=pre[i-1]+a[i];
            }
            int s = 0;
            int e = n - 1;
            int ans = 0;
        
            while (s <= e) {
                int mid = (s + e) / 2;
                StringBuilder temp = new StringBuilder("? ");
                temp.append(mid - s + 1);
                for (int i = s + 1; i <= mid + 1; i++) {
                    temp.append(" ").append(i);
                }
                System.out.println(temp);
                System.out.flush();
                int w = in.nextInt();
                int des=pre[mid];
                if(s!=0){
                    des-=pre[s-1];
                }
                if (w == des) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                    ans = mid;
                }
            }
            System.out.println("! "+(ans + 1));
            System.out.flush();
        }
        
    }
}