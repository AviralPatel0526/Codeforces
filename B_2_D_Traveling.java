import java.util.*;
import java.lang.*;
import java.io.*;
public class B_2_D_Traveling {

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
            int n=in.nextInt();
            int k=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();
            long x[][]=new long[n][2];
            for(int i=0;i<n;i++){
                x[i][0]=in.nextLong();
                x[i][1]=in.nextLong();
            }
            if(a <= k && b <= k){
                System.out.println(0);
            }else{
                long min=Math.abs(x[a-1][0]-x[b-1][0])+Math.abs(x[a-1][1]-x[b-1][1]);
                if(a <= k){
                    for(int i=0;i<k;i++){
                        min=Math.min(min,Math.abs(x[i][0]-x[b-1][0])+Math.abs(x[i][1]-x[b-1][1]));
                    }
                }else if(b <= k){
                    for(int i=0;i<k;i++){
                        min=Math.min(min,Math.abs(x[a-1][0]-x[i][0])+Math.abs(x[a-1][1]-x[i][1]));
                    }
                }else{
                    long mina=10000000000l;
                    for(int i=0;i<k;i++){
                        mina=Math.min(mina,Math.abs(x[i][0]-x[a-1][0])+Math.abs(x[i][1]-x[a-1][1]));
                    }
                    Long minb=10000000000l;
                    for(int i=0;i<k;i++){
                        minb=Math.min(minb,Math.abs(x[i][0]-x[b-1][0])+Math.abs(x[i][1]-x[b-1][1]));
                    }
                    
                    min=Math.min(min,mina+minb);
                }

                System.out.println(min);
            }
        }
    }
}