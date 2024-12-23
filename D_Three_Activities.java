import java.util.*;
import java.lang.*;
import java.io.*;
public class D_Three_Activities {

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
        int x;
        int idx;
        Pair(int x,int idx){
            this.x=x;
            this.idx=idx;
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            int a[]=ai(n);
            int b[]=ai(n);
            int c[]=ai(n);
            ArrayList<Pair> lista=new ArrayList<>();
            ArrayList<Pair> listb=new ArrayList<>();
            ArrayList<Pair> listc=new ArrayList<>();
            for(int i=0;i<n;i++){
                lista.add(new Pair(a[i], i));
                listb.add(new Pair(b[i], i));
                listc.add(new Pair(c[i], i));
            }
            Collections.sort(lista,(p1,p2)->p2.x-p1.x);
            Collections.sort(listb,(p1,p2)->p2.x-p1.x);
            Collections.sort(listc,(p1,p2)->p2.x-p1.x);
            int max=Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(listb.get(j).idx != lista.get(i).idx){
                        for(int k=0;k<3;k++){
                            if(listc.get(k).idx != lista.get(i).idx && listc.get(k).idx != listb.get(j).idx){
                                max=Math.max(max,lista.get(i).x+listb.get(j).x+listc.get(k).x);
                            }
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}