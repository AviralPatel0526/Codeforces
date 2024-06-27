import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * D_Manhattan_Circle
 */
public class D_Manhattan_Circle {

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
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[m];
            int max = 0;
            int posx = -1;
            for (int i = 0; i < n; i++) {
                String s = in.next();
                int c = 0;
                for (int j = 0; j < m; j++) {
                    char ch = s.charAt(j);
                    if (ch == '#') {
                        a[j]++;
                        c++;
                    }
                }
                if (c > max) {
                    max = c;
                    posx = i;
                }
            }
            int posy = -1;
            int max2 = 0;
            for (int i = 0; i < m; i++) {
                if (a[i] > max2) {
                    max2 = a[i];
                    posy = i;
                }
            }
            out.println((posx + 1) + " " + (posy + 1));
        }
        out.close();
    }
}