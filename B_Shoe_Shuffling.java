import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_Shoe_Shuffling
 */
public class B_Shoe_Shuffling {

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
        int i;
        int a;
        Pair(int i,int a){
            this.i=i;
            this.a=a;
        }
    }
        
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            HashMap<Integer, Deque<Integer>> map = new HashMap<>();
            int n = in.nextInt();
            int a[] = new int[n];
            
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                a[i] = num;
                if (map.containsKey(num)) {
                    map.get(num).addLast(i);
                } else {
                    Deque<Integer> deque = new ArrayDeque<>();
                    deque.addLast(i);
                    map.put(num, deque);
                }
            }
            boolean flag=true;
            for(Integer key: map.keySet()){
                if(map.get(key).size() == 1){
                    flag=false;
                    break;
                }else{
                    int k=map.get(key).pollFirst();
                    map.get(key).addLast(k);
                }
            }
            if(flag){

                int res[] = new int[n];
                for (int i = 0; i < n; i++) {
                    if (map.get(a[i]).isEmpty()) {
                        map.remove(a[i]);
                    }
                    res[i] = map.get(a[i]).pollFirst()+1;
                    System.out.print(res[i]+" ");
                }
                System.out.println();
            }else{
                System.out.println(-1);
            }
        }
    }
}