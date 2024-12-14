import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Dora_and_Search {

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
            int curmin=1;
            int curmax=n;
            int i=0;
            int j=n-1;
            boolean flag=false;
            while(i < j){
                if(a[i] == curmin){
                    i++;
                    curmin++;
                }else if(a[i] == curmax){
                    i++;
                    curmax--;
                }
                if(a[j] == curmin){
                    j--;
                    curmin++;
                }else if(a[j] == curmax){
                    j--;
                    curmax--;
                }
                if((a[i] != curmax && a[i] != curmin) && (a[j] != curmax && a[j] != curmin)){
                    flag=true;
                    break;
                }
            }
            if(flag){
                System.out.println((i+1)+" "+(j+1));
            }else{
                System.out.println(-1);
            }
        }
    }
}