import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Scuza {

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
    static int ub(long max[],long x){
        int l=0;
        int h=max.length-1;
        int ans=max.length;
        while(l <= h){
            int mid=(l+h)/2;
            if(max[mid] > x){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            int q=in.nextInt();
            long a[]=al(n);
            long b[]=al(q);
            long pre[]=new long[n];
            long max[]=new long[n];
            max[0]=a[0];
            long m=a[0];
            pre[0]=a[0];
            for(int i=1;i<n;i++){
                pre[i]=pre[i-1]+a[i];
                m=Math.max(a[i],m);
                max[i]=m;
            }

            long ans[]=new long[q];
            for(int i=0;i<q;i++){
                int idx=ub(max, b[i])-1;
                if(idx == -1){
                    ans[i]=0;
                    continue;
                }
                ans[i]=pre[idx];
            }
            for(int i=0;i<q;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
}