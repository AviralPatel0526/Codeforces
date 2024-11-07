import java.util.*;
import java.lang.*;
import java.io.*;
public class D_I_Love_1543 {

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
    
    public static ArrayList<String> spiralLayers(char[][] matrix) {
        ArrayList<String> layers = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) return layers;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            StringBuilder layer = new StringBuilder();

            for (int i = left; i <= right; i++) {
                layer.append(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                layer.append(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    layer.append(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    layer.append(matrix[i][left]);
                }
                left++;
            }

            layers.add(layer.toString());
        }

        return layers;
    }
    public static int count1543Cyclic(String str) {
        int count = 0;
        String target = "1543";
        
        String cyclicStr = str + str.substring(0, target.length() - 1);

        for (int i = 0; i <= cyclicStr.length() - target.length(); i++) {
            if (cyclicStr.substring(i, i + target.length()).equals(target)) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] a = new char[n][m];
            for (int i = 0; i < n; i++) {
                String line = in.next(); 
                for (int j = 0; j < m; j++) {
                    a[i][j] = line.charAt(j);  // 
                }
            }
            ArrayList<String> list=spiralLayers(a);
            int cnt=0;
            for(int i=0;i<list.size();i++){
                String s=list.get(i);
                cnt+=count1543Cyclic(s);
            }
            System.out.println(cnt);
        }
        
    }
}