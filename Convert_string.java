import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * Convert_string
 */
public class Convert_string {

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
            String s=in.next();
            int c0=0;
            int c1=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i) == '0'){
                    c0++;
                }else{
                    c1++;
                }
            }
            int cnt=0;
            for(int i=1;i<=n;i++){
                if(i < c0 && i < c1){
                    continue;
                }else{
                    boolean flag=false;
                    int a=i-c0;
                    int b=i-c1;
                    if(a >= 0){
                        if(a%2 == 0){
                            flag=true;
                        }
                    }
                    if(b >= 0){
                        if(b%2 == 0){
                            flag=true;
                        }
                    }
                    // System.out.println(i+" "+ b+ " " + b+ " " +flag);
                    if(flag){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}