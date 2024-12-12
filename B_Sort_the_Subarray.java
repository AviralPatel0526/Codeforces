import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Sort_the_Subarray {

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
            int a[]=ai(n);
            int b[]=ai(n);
            int s=0;
            int e=n-1;
            for(int i=0;i<n;i++){
                if(a[i] != b[i]){
                    s=i;
                    break;
                }
            }  
            for(int i=n-1;i>=0;i--){
                if(a[i]!=b[i]){
                    e=i;
                    break;
                }
            }
            // System.out.println(b[s]+" "+b[e]);
            for(int i=s;s>0;i--){
                if(b[i] < b[i-1]){
                    break;
                }
                s--;
            }
            for(int i=e;i<n-1;i++){
                if(b[i] > b[i+1]){
                    break;
                }
                e++;
            }
            System.out.println((s+1)+" "+(e+1));
        }
    }
}