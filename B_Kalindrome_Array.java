import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Kalindrome_Array {

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
            int s=0;
            int e=n-1;
            int rem1=-1;
            int rem2=-1;
            while(s < e){
                if(a[s] != a[e]){
                    rem1=a[s];
                    rem2=a[e];
                    break;
                }
                s++;
                e--;
            }
            if(rem1 == -1){
                System.out.println("YES");
                continue;
            }
            boolean flag1=true;
            boolean flag2=true;
            int s1=0;
            int e1=n-1;
            while(s1 < e1){
                if(a[s1] == rem1){
                    s1++;
                    continue;
                }
                if(a[e1] == rem1){
                    e1--;
                    continue;
                }
                if(a[s1] != a[e1]){
                    flag1=false;
                    break;
                }
                s1++;
                e1--;

            }
            int s2=0;
            int e2=n-1;
            while(s2 < e2){
                if(a[s2] == rem2){
                    s2++;
                    continue;
                }
                if(a[e2] == rem2){
                    e2--;
                    continue;
                }
                if(a[s2] != a[e2]){
                    flag2=false;
                    break;
                }
                s2++;
                e2--;
            }
            if(flag1 || flag2){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}