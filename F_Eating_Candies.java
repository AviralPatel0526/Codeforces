import java.util.*;
import java.lang.*;
import java.io.*;
public class F_Eating_Candies {

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
            int pre[]=new int[n];
            int suff[]=new int[n];
            pre[0]=a[0];
            for(int i=1;i<n;i++){
                pre[i]=pre[i-1]+a[i];
            }
            suff[n-1]=a[n-1];
            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(a[n-1],n-1);
            for(int i=n-2;i>=0;i--){
                suff[i]=suff[i+1]+a[i];
                map.put(suff[i],i);
            }
            int ans=0;
            for(int i=0;i<n;i++){
                if(map.containsKey(pre[i])){
                    if(map.get(pre[i]) > i){
                        ans=Math.max(ans, i+1+(n-map.get(pre[i])));
                    }
                }
            }
            System.out.println(ans);
        }
    }
}