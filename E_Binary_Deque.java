import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Binary_Deque {

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
    static int f(int a[], int sum, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Base case: To handle subarrays starting from index 0
        int cursum = 0;
        int maxLen = 0; // Length of the largest subarray with the given sum
    
        for (int i = 0; i < n; i++) {
            cursum += a[i];
    
            // Check if we've seen a cumulative sum such that cursum - sum == previous_cursum
            if (map.containsKey(cursum - sum)) {
                maxLen = Math.max(maxLen, i - map.get(cursum - sum));
            }
    
            // Add the current cumulative sum to the map if not already present
            map.putIfAbsent(cursum, i);
        }
    
        return maxLen; // Largest subarray length with sum == `sum`
    }
    

    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            int sum=in.nextInt();
            int a[]=ai(n);
            int cnt=0;
            for(int i=0;i<n;i++){
                if(a[i] == 1){
                    cnt++;
                }
            }
            if(cnt < sum){
                System.out.println(-1);
                continue;
            }
            int ans=f(a,sum,n);
            System.out.println(n-ans);
        }
    }
}