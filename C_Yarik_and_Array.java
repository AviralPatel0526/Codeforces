import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Yarik_and_Array {

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
            int ans=0;
            int sum=0;
            int allneg=Integer.MIN_VALUE;
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(a[i] > 0){
                    flag=false;
                }
                allneg=Math.max(a[i],allneg);
            }
            if(flag){
                System.out.println(allneg);
                continue;
            }
            for(int i=0;i<n;i++){
                sum+=a[i];
                if(i > 0){
                    if(Math.abs(a[i]%2) == Math.abs(a[i-1]%2)){
                        sum=a[i];
                    }
                } 
                if(sum < 0){
                    sum=0;
                }
                ans=Math.max(ans,sum);
            }
            System.out.println(ans);
        }
    }
}