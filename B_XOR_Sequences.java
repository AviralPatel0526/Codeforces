import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_XOR_Sequences
 */
public class B_XOR_Sequences {

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
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            long x = in.nextLong();
            long y = in.nextLong();
            int c = 0;
            while (x >= 0 && y >= 0) {
                if ((x & 1) != (y & 1)) {
                    break;
                }
                x >>= 1; 
                y >>= 1; 
                c++;
            }
            
            out.println((long) Math.pow(2, c));
        }
        out.close();
    }
}