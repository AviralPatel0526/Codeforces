import java.util.*;
import java.lang.*;
import java.io.*;
public class D_Districts_Connection {

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
    static class Pair {
        int idx;
        long x;
        Pair(int idx,long x){
            this.idx=idx;
            this.x=x;
        }
        
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            long a[]=al(n);
            int e1=0;
            int e2=-1;
            for(int i=0;i<n;i++){
                if(a[i] != a[0]){
                    e2=i;
                    break;
                }
            }
            if(e2 == -1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                System.out.println(1+" "+(e2+1));
                for(int i=0;i<n;i++){
                    if(i == e1 || i == e2) continue;
                    if(a[i] != a[e1]){
                        System.out.println(1+" "+(i+1));
                    }else if(a[i] != a[e2]){
                        System.out.println((e2+1)+" "+(i+1));
                    }
                }
            }
        }
    }
}