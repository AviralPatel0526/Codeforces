import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * A_Array_Elimination
 */
public class A_Array_Elimination {

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
    static class FastWriter {
        private final BufferedWriter bw;
    
        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
    
        public void print(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
        }
    
        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }
    
        public void close() throws IOException {
            bw.close();
        }
    }
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            int a[]=new int[n];
            long bit[]=new long[31];
            for(int i=0;i<n;i++){
                a[i]=in.nextInt();
                for(int j=30;j>=0;j--){
                    if(((1<<j)&a[i])!=0){
                        bit[j]++;
                    }
                }
            }
            long hcf=0;
            for (long num:bit){
                if(num!=0){
                    hcf=num;
                    break;
                }
            }
            for(long num:bit){
                if(num!=0)
                hcf=gcd(num, hcf);
            }
            if(hcf == 0){
                for(int i=1;i<=n;i++){
                    out.print(i+" ");
                }
                out.println("");
            }else{
                for(int i=1;i<=hcf;i++){
                    if(hcf%i == 0){
                        out.print(i+" ");
                    }
                }
                out.println("");
                
                    
            }
        }
        out.close();
    }
}