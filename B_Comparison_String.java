import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_Comparison_String
 */
public class B_Comparison_String {

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
    
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            String s=in.next();
            int c=1;
            int mx=0;
            for(int i=0;i<n-1;i++){
                if(s.charAt(i)!=s.charAt(i+1)){
                    mx=Math.max(c,mx);
                    c=1;
                }else{
                    c++;
                }
            }
            mx=Math.max(mx,c);
            out.println(mx+1);
        }
        out.close();
    }
}