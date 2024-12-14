import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Vika_and_the_Bridge {

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
    static boolean f(HashMap<Integer, ArrayList<Integer>> map, int mid, int n) {
        for (Integer key : map.keySet()) {
            ArrayList<Integer> temp = map.get(key);
    
            int cnt = 0;
            boolean flag = true;
            temp.add(n+1);
            for (int i = 0; i < temp.size(); i++) { 
                int maxg;
                if(i == 0){
                    maxg=temp.get(i);
                }else{
                    maxg= temp.get(i) - temp.get(i - 1);
                }

    
                if (maxg > mid) {
                    if (cnt == 0) {
                        int newg = (maxg + 1) / 2;
                        if (newg > mid) {
                            flag = false;
                            break;
                        }
                        cnt++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
    
            if (flag) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = ai(n);
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(a[i], key -> new ArrayList<>()).add(i+1);
            }
    
            int l = 0;
            int h = n+1;
            int ans = 0;
    
            while (l <= h) {
                int mid = (l + h) / 2;
                if (f(map, mid, n)) {
                    ans = mid;
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
    
            System.out.println(ans-1);
        }
    }
    
    
}