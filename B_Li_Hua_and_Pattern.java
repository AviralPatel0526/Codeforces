import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Li_Hua_and_Pattern {

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
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=in.nextInt();
                }
            }
            if(n == 1){
                System.out.println("YES");
                continue;
            }
            int l=0;
            int h=n-1;
            while(l < h){
                int e=n-1;
                for(int i=0;i<n;i++){
                    if(a[l][i] != a[h][e]){
                        k--;
                    }
                    e--;
                }
                l++;
                h--;
            }
            if(n%2 != 0){
                int m=n/2;
                int low=0;
                int high=n-1;
                while(low < high){
                    if(a[m][low] != a[m][high]){
                        k--;
                    }
                    low++;
                    high--;
                }
            }
            if(k < 0){
                System.out.println("NO");
            }else{
                if(k%2 == 0){
                    System.out.println("YES");
                }else{
                    if(n%2 != 0){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }
        }
    }
}