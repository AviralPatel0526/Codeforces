import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Mirror_Grid {

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
    static ArrayList<String> spiral(char ch[][], int n) {
        int sr = 0, sc = 0, er = n - 1, ec = n - 1;
        ArrayList<String> temp = new ArrayList<>();
        while (sr <= er && sc <= ec) {
            StringBuilder sb = new StringBuilder();
            for (int i = sc; i <= ec; i++) sb.append(ch[sr][i]);
            sr++;
            for (int i = sr; i <= er; i++) sb.append(ch[i][ec]);
            ec--;
            if (sr <= er) {
                for (int i = ec; i >= sc; i--) sb.append(ch[er][i]);
                er--;
            }
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) sb.append(ch[i][sc]);
                sc++;
            }
            temp.add(sb.toString());
        }
        return temp;
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            char[][] ch = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = in.next();
                for (int j = 0; j < n; j++) ch[i][j] = s.charAt(j);
            }
            ArrayList<String> list = spiral(ch, n);
            int ans = 0;
            int jump = n - 1;
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (s.length() >= 4) {
                    for (int j = 0; j < jump; j++) {
                        int cnt0 = 0;
                        if (s.charAt(j) == '0') cnt0++;
                        if (s.charAt(j + jump) == '0') cnt0++;
                        if (s.charAt(j + 2 * jump) == '0') cnt0++;
                        if (s.charAt(j + 3 * jump) == '0') cnt0++;
                        ans += Math.min(cnt0, 4 - cnt0);
                    }
                }
                jump-=2;
            }
            System.out.println(ans);
        }
    }
    
    
}