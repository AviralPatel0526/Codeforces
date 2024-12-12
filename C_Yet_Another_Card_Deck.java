import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Yet_Another_Card_Deck {

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
        
            int n=in.nextInt();
            int q=in.nextInt();
            int a[]=ai(n);
            int b[]=ai(q);
            int idx[]=new int[51];
            for(int i=n-1;i>=0;i--){
                idx[a[i]]=i+1;
            }
            int ans[]=new int[q];
            for(int i=0;i<q;i++){
                int pos=idx[b[i]];
                ans[i]=pos;
                for(int j=1;j<51;j++){
                    if(idx[j] < pos){
                        idx[j]++;
                    }
                }
                idx[b[i]]=1;
            }
            for(int i=0;i<q;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
    }
}