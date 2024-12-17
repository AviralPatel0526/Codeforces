import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Pleasant_Pairs {

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
            ArrayList<Pair> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                long num=in.nextLong();
                list.add(new Pair(i+1, num));
            }
            Collections.sort(list,(p1,p2)->Long.compare(p1.x,p2.x));
            int cnt=0;
            for(int i=0;i<n-1;i++){
                long fn=list.get(i).x;
                int idx1=list.get(i).idx;
                for(int j=i+1;j<n;j++){
                    long sn=list.get(j).x;
                    int idx2=list.get(j).idx;
                    if(fn*sn >= 2*n){
                        break;
                    }
                    if(fn*sn == idx1+idx2){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}