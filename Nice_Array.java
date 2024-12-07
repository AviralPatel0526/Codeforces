import java.util.*;
import java.lang.*;
import java.io.*;
public class Nice_Array {

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
            long k=in.nextLong();
            long a[]=al(n);
            long sp=0;
            long sn=0;
            long cntp=0;
            long cntn=0;
            for(int i=0;i<n;i++){
                if(a[i] >= 0){
                    if(a[i]%k != 0){
                        cntp++;
                    }
                    sp+=a[i]/k;
                }else{
                    if(a[i]%k != 0){
                        cntn++;
                    }
                    sn+=a[i]/k;
                }
            }
            if(Math.abs(sp) == Math.abs(sn)){
                System.out.println("YES");
            }else{
                long diff=Math.abs(sp-Math.abs(sn));
                if(Math.abs(sp) > Math.abs(sn)){
                    if(cntn >= diff){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }else{
                    if(cntp >= diff){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }
        }
    }
}