import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Collecting_Game {

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
        long x;
        int idx;
        Pair(long x, int idx) {
            this.x = x;
            this.idx = idx;
        }
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            long a[] = al(n);
            ArrayList<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair(a[i], i));
            }
            Collections.sort(list, (p1, p2) -> Long.compare(p1.x, p2.x));
            long pre[] = new long[n];
            pre[0] = list.get(0).x;
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] + list.get(i).x;
            }
            int ans[] = new int[n];
            ans[n-1]=n-1;
            for(int i=n-2;i>=0;i--){
                if(pre[i] >= list.get(i+1).x){
                    ans[i]=ans[i+1];
                }else{
                    ans[i]=i;
                }
            }
            int res[]=new int[n];
            for(int i=0;i<n;i++){
                res[list.get(i).idx]=ans[i];
            }
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
    

    
}